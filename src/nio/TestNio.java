package nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Admin on 2017/6/22 0022.
 */
public class TestNio {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Admin\\Desktop\\mytest.txt");
        byte[] bytes = Files.readAllBytes(path);
        String content = new String(bytes, "gbk");
        System.out.println(content);
        //List<String> strings = Files.readAllLines(path,StandardCharsets.UTF_8);
        //System.out.println(strings);

    }

}
