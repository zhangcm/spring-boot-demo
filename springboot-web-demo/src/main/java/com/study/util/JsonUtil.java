package com.study.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.util.Base64Utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author OF1264
 * @since 1.0, 2017/9/5 下午8:04
 */
public final class JsonUtil {

    private JsonUtil() {
    }

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //过滤 null
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //map 中包含的 null
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public static <T> T parseObject(String content, Class<T> objType) {
        try {
            return mapper.readValue(content, objType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> List<T> parseArray(String content, TypeReference<List<T>> objType) {
        try {
            return mapper.readValue(content, objType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJSONString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        String content = "测试😁";
        String encode = new String(Base64Utils.encode(content.getBytes(Charset.forName("UTF-8"))));
        System.out.println(encode);
        String decode = new String(Base64Utils.decode(encode.getBytes(Charset.forName("UTF-8"))));
        System.out.println(decode);
    }
}
