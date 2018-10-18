package secret;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-19 11:29
 **/
public class Test01 {
    public static void main(String[] args) {
        try {
            System.out.println("147369qw".length());
            System.out.println(DesUtil.encrypt("zhouxuan","147369qw"));
            System.out.println(DesUtil.decrypt("zhouxuan","147369qw"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
