package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJsonUtil {

    public static JSONArray getJsonArray (JSONObject jsonObject, String arrayNodeName) {
        try {
            return jsonObject.getJSONArray(arrayNodeName);
        } catch (JSONException e) {
            throw new IllegalStateException("Given JSON node is not an array or doesn't exist");
        }
    }

    public static JSONObject getInnerJsonByKeyAndValue(JSONArray dataArray, String key, String value) {
        for (int i = 0; i < dataArray.length(); i ++) {
            JSONObject innerJson = new JSONObject(dataArray.get(i).toString());
            if (innerJson.get(key).equals(value)) {
                return innerJson;
            }
        }
        throw new IllegalStateException("Given jsonArray doesn't contain key " + key + " with value " + value);
    }

}
