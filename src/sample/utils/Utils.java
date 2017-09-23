package sample.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

public class Utils {

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != JSONObject.NULL) {
            retMap = toMap(json);
            
            for (Map.Entry<String,Object> entry : retMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                // do stuff
                System.out.println(key + " " + value.toString());
              }
        }
        
        return retMap;
    }

    
    @SuppressWarnings("unchecked")
    protected static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        
        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);
            
           
            System.out.println(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
               
                value = toMap((JSONObject) value);
            }
            
            System.out.println(key + " " + value.toString());
            map.put(key, value);
        }
        
        return map;
    }

    /**
     * Method used to return the list of Objects, if the object is a JSONArray.
     * @param JSONArray array - JSON to be converted.
     * @return List<Object> - the result List.
     */
    protected static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
    
    /**
     * Converts the given list of Strings to JSONArray
     * @param list the list to be converted
     * @return the converted list
     */
    public static JSONArray listToJson(List<String> list) {
        JSONArray array = new JSONArray();
        
        for (String string : list) {
            array.put(string);
        }
        
        return array;
    }
}

