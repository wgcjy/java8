package utils;//package utils;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.ObjectMapper;
////import com.xforceplus.xplat.core.utils.UppercaseNamingStrategy; can't find this object,but is necessary
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
///**
// * 版权：    上海云砺信息科技有限公司
// * 创建者:   yefei
// * 创建时间: 2016/11/13 16:37
// * 功能描述:
// * 修改历史:
// * 2016/11/13 16:37 yefei 描述
// */
//public class JsonUtils {
//
//    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
//
//    /**
//     * 把对象转换成JSON字符串
//     *
//     * @param o
//     * @return
//     */
//    public static String writeObjectToJson(Object o) {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonStr = "";
//        try {
//            jsonStr = objectMapper.writeValueAsString(o);
//        } catch (JsonProcessingException e) {
//            logger.error("Map序列化错误 "+e.getMessage(), e);
//
//        }
//        return jsonStr;
//    }
//
//
//    /**
//     * 把字符串转换成Object对象
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
//
//    public static <T> T writeJsonToObjectForUpperCaseKey(String json,Class<T> t)
//    {
//        T instance = null;
//        ObjectMapper objectMapper = new ObjectMapper();
//        //objectMapper.setPropertyNamingStrategy(new UppercaseNamingStrategy());暂时找不到该包，need this object
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        try {
//            instance = objectMapper.readValue(json, t);
//        } catch (IOException e) {
//
//        }
//        return instance;
//    }
//
//    /**
//     * 把字符串转换成Object集合
//     *
//     * @param json
//     * @param t
//     * @return
//     */
//    public static <T> List<T> writeJsonToListObject(String json, Class<T> t) {
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////        mapper.setPropertyNamingStrategy(new UppercaseNamingStrategy());
////        mapper.enableDefaultTyping();
//        List<T> jsonList = null;
//        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, t);
//
//        try {
//            jsonList = mapper.readValue(json, javaType);
//        } catch (IOException e) {
//            logger.error("解析发票文本错误!", e);
//            throw new RuntimeException(e);
//        }
//        return jsonList;
//    }
//
//    public static <T> List<T> writeJsonToListObjectForUpperCaseKey(String json, Class<T> t) {
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        //mapper.setPropertyNamingStrategy(new UppercaseNamingStrategy());can't find this object,but is necessary
////        mapper.enableDefaultTyping();
//        List<T> jsonList = null;
//        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, t);
//
//        try {
//            jsonList = mapper.readValue(json, javaType);
//        } catch (IOException e) {
//            logger.error("解析发票文本错误!", e);
//            throw new RuntimeException(e);
//        }
//        return jsonList;
//    }
//
//
//    /**
//     * JSON字符串转换Map
//     * @param json
//     * @return
//     */
//    public static Map writeJsonToMap(String json){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        Map map = null;
//        try {
//            map = mapper.readValue(json, Map.class);
//        } catch (IOException e) {
//            logger.error("解析发票文本错误!",e);
//        }
//        return map;
//    }
//
//    /**
//     * 将 List<Map> 转换成其他实体Bean List
//     * @param mList
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> transforMapListToBeanList(List<Map> mList, Class<T> t ){
//
//        String mStr = writeObjectToJson(mList);
//        return writeJsonToListObject(mStr, t);
//    }
//
//}
