package json;//package json;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @Desription json转化
// * @Author zhouxuan
// * @Create 2017-11-22 14:29
// **/
//public class JsonDemo {
//    //所需jar 1、jackson-annotation 2、jackson-core 3、jackson-databind
//
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * convert Object to jsonStr
//     *
//     * @param object
//     * @return
//     */
//    public String Object2JsonStr(Object object) {
//        String jsonStr = "";
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            jsonStr = objectMapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            jsonStr = "convert to json exception";
//        }
//        return jsonStr;
//    }
//
//    /**
//     * convert jsonStr to Map
//     *
//     * @param jsonStr
//     * @return
//     */
//    public Map jsonStr2Map(String jsonStr) {
//        Map map = null;
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//            map = objectMapper.readValue(jsonStr, Map.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("convert str to map exception");
//        }
//        return map;
//    }
//
//    /**
//     * convert jsonStr to Object
//     *
//     * @param json
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public static <T> T writeJsonToObject(String json, Class<T> t) {
//        T instance = null;
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        try {
//            instance = objectMapper.readValue(json, t);
//        } catch (IOException e) {
//
//        }
//        return instance;
//    }
//}
