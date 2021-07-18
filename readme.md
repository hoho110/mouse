# 录制/回放实验仓
基于[JVM-Sandbox](https://github.com/alibaba/JVM-Sandbox)
及[jvm-sandbox-repeater](https://github.com/alibaba/jvm-sandbox-repeater)
##Agent配置
###step0 安装 sandbox 和插件到应用服务器
- 下载并安装sandbox和repeater
>curl -s http://sandbox-ecological.oss-cn-hangzhou.aliyuncs.com/install-repeater.sh | sh
- 安装输出
> ======  begin to install sandbox and repeater module       ====== \
> ======  step 0 begin to download sandbox package           ====== \
> ======  step 1 begin to download repeater module package   ====== \
> ======                 install finished                    ======
- 具体安装位置查看上述脚本内容


###step1 修改配置
- 修改repeater的cfg/repeater-config.json文件
```json
  {
  "degrade": false,
  "exceptionThreshold": 1000,
  "httpEntrancePatterns": [
    "^/user.*$"
  ],
  "javaEntranceBehaviors": [
  ],
  "javaSubInvokeBehaviors": [{
    "classPattern": "com.kuaishou.qa.example.mouse.controller.UserController",
    "includeSubClasses": false,
    "methodPatterns": [
      "getRandomNum"
    ]
  }
  ],
  "pluginIdentities": [
    "http",
    "java-subInvoke",
    "mybatis"
  ],
  "repeatIdentities": [
    "java",
    "http",
    "mybatis"
  ],
  "sampleRate": 10000,
  "useTtl": false
}
```

- 修改repeater的cfg/repeater.properties文件,本地测试使用
> 是否开启脱机工作模式 \
> repeat.standalone.mode=true


###step2 启动
- 启动sandbox
>   ./sandbox.sh -p 目标进程号
- 查案repeater日志
>   tail -f ~/logs/sandbox/repeater/repeater.log

###step3 录制/回放
- 调用接口自动录制
- 查看repeater日志查找traceID
- 根据traceID回放,增加Repeat-TraceId-X字段（字段或者header里面添加）
> http://localhost:8080/user/findById?id=1&Repeat-TraceId-X=127000000001162641339043110001ed
###step4 录制数据
- 本地模式存储在sandbox-module/repeater-data/record目录下，数据格式待进一步校验


##repeater console
###console功能说明
- 存储和下发配置项
- 存储和下发录制和回放结果
- 录制和回放节点心跳注册中心

###console配置
新建mysql数据库及初始化sql，配置启动

###连接console配置
- 修改repeater.properties文件
```properties
# 录制消息投递地址
broadcaster.record.url=http://127.0.0.1:8001/facade/api/record/save

# 回放结果投递地址
broadcaster.repeat.url=http://127.0.0.1:8001/facade/api/repeat/save

# 回放消息取数据地址
repeat.record.url=http://127.0.0.1:8001/facade/api/record/%s/%s

# 配置文件拉取地址
repeat.config.url=http://127.0.0.1:8001/facade/api/config/%s/%s

# 心跳上报配置
repeat.heartbeat.url=http://127.0.0.1:8001/module/report.json

# 是否开启脱机工作模式
repeat.standalone.mode=false

# 是否开启spring advice拦截
repeat.spring.advice.switch=false;
```

- 被监听线程启动增加JVM系统参数
> app.name 应用名 app.env 环境名
>  -Dapp.name=mouse -Dapp.env=test