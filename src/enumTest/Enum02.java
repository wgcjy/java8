package enumTest;

/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/15 0015 22:44
 */
public enum Enum02 {
    SPRING("spring", "春暖花开"),
    SUMMER("summer", "夏日炎炎"),
    AUTUMN("autumn", "秋高气爽"),
    WINTER("winter", "白雪皑皑");

    //最好将成员变量定义为final类，只能在构造方法初始化时赋值一次
    private final String seasonName;
    private final String seasonDesc;

    Enum02(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
