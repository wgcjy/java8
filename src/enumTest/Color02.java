package enumTest;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-15 14:00
 **/
public enum Color02 {

    READ("红色","0"),
    GREEN("绿色","1"),
    BLANK("白色","2"),
    YELLOW("黄色","3");


    private String name, value;
    Color02(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
