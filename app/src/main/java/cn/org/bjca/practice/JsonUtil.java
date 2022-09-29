package cn.org.bjca.practice;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Object与Json辅助类
 */
public class JsonUtil {
    public static String object2Json(Object obj) {
        try {
            Gson e = new Gson();
            String json = e.toJson(obj);
            return json;
        } catch (Exception var3) {
            Log.e("JSONERR", var3.getMessage());
            var3.printStackTrace();
            return "{}";
        }
    }

    public static <T> T json2Object(String json, Class<T> valueType) {
        try {
            Gson e = new Gson();
            return e.fromJson(json.trim(), valueType);
        } catch (Exception var) {
            var.printStackTrace();
            return null;
        }
    }
}
