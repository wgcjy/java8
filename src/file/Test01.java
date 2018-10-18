package file;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.lang.model.element.VariableElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-08-31 14:21
 **/
public class Test01 {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        try {
            File origFile = new File("D:\\platApplicationContext-soa.xml");
            File dir = new File("D:\\txtdir\\mytest");
            if (!dir.exists()){
                dir.mkdirs();
            }
            FileInputStream fis = new FileInputStream(origFile);
            File toFile = new File(dir,"copy.xml");
            FileOutputStream fos = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            System.out.println(fis.available());//available to read length
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
