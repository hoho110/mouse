package com.kuaishou.qa.example.mouse.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.id
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.name
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    private String name;

    /**
     * 随机数
     */
    private int randomNum;


    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.id
     *
     * @return the value of User.id
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.id
     *
     * @param id the value for User.id
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.name
     *
     * @return the value of User.name
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.name
     *
     * @param name the value for User.name
     *
     * @mbggenerated Fri Jul 16 11:52:26 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


}