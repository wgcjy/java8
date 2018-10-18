package java.org.way.exmple.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by way on 2017/12/21.
 */
public class Base64Tester {

    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64
                .getEncoder()
                .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );

        final String decoded = new String(
                Base64.getDecoder().decode( encoded ),
                StandardCharsets.UTF_8 );
        System.out.println( decoded );

    }
}
