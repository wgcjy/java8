package obj;

import java.math.BigDecimal;

public class Person {
    private Integer userId;
    private String userName;
    private String sex;
    private String passWord;
    private Integer age;
    private BigDecimal sal;

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Person() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public Person(Integer userId, String userName, String sex, String passWord, Integer age, BigDecimal sal) {

        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.passWord = passWord;
        this.age = age;
        this.sal = sal;
    }
}
