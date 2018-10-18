package test;

import java.io.File;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-09-13 15:57
 **/
public class Test03 {



    public static void main(String[] args) throws IllegalAccessException {

        Cat cat = new Cat();
        Field[] fields = cat.getClass().getFields();
        for (Field field : fields) {
            if ("name".equals(field)) {
                field.setAccessible(true);
                Object o = field.get(cat);
                System.out.println(o);
            }
        }





    }
}

class Cat{
    String name = "jelly";
    String feture = "cat";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeture() {
        return feture;
    }

    public void setFeture(String feture) {
        this.feture = feture;
    }
}

