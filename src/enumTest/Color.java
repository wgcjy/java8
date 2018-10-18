package enumTest;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-15 14:00
 **/
public enum  Color {

    READ("0"),
    GREEN("1"),
    BLANK("2"),
    YELLOW("3");


    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
