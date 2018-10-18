package file;

import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * @Desription
 * @Author zhouxuan
 * @Create 2017-11-23 14:12
 **/
public class Test02 {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        try {
            FileInputStream fos = new FileInputStream("E:\\14_problem_data.txt");

            //字节流转字符流

            InputStreamReader inputStreamReader = new InputStreamReader(fos, "GBK");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            int count = 1;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("第"+ String.valueOf(count++) +"行！");
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
