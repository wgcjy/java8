package reflect;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/16 0016 0:08
 */

/**
 * @Author:zhouxuan
 * @create:2018-01-16-0:08
 **/
public class Person {
    private String name;
    private String passWord;
    private Integer age;

    public Person() {
    }

    public Person(String name, String passWord, Integer age) {
        this.name = name;
        this.passWord = passWord;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}
