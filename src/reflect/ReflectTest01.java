package reflect;/**
 * @Author:zhouxuan
 * @Description:
 * @Date:2018/1/10 0010 23:24
 */

import java.lang.reflect.Field;

/**
 * @Author:zhouxuan
 * @create:2018-01-10-23:24
 **/
public class ReflectTest01 {
    public static void main(String[] args) throws Exception {

        //Person p = new Person();
        //p.setName("zhangsan");
        //p.setPassWord("zhangsan123");
        //p.setAge(18);


        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"zhangsan");
        System.out.println(person.getName());


        //Field[] fields = clazz.getFields();
        //Field[] fields = clazz.getDeclaredFields();//申明的变量

        //for (Field field : fields) {
        //    //field.setAccessible(true);
        //    //System.out.println("=======");
        //    System.out.println(field.getName());
        //}


    }
}
