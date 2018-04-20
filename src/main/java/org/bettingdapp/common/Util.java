package org.bettingdapp.common;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class Util {
    public static String toJson(Object obj)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObjectFromJson(String json, Class theClass)
    {
        try
        {
            return jsonToObject(json, theClass);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static <T> T jsonToObject(String json, Class theClass)
            throws JsonParseException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (T) mapper.readValue(json, theClass);
    }
}
