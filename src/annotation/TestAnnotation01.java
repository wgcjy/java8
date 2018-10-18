package annotation;

/**
 * class_name: TestAnnotation01
 * describe: TODO
 * author: zhouxuan
 * creat_date: 2018/1/15 0015
 * creat_time: 23:06
 **/
public class TestAnnotation01 {
    public static void main(String[] args) {

    }
}

@MyAnnotation(value = {"a", "b", "c"}, required = false)
class Student {
    private String userName;
    private String passWord;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
