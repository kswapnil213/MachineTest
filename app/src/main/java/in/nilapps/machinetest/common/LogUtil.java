package in.nilapps.machinetest.common;

import android.util.Log;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import in.nilapps.machinetest.BuildConfig;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class LogUtil {

    public static void info(String Tag, String message) {
        if (BuildConfig.BUILD_TYPE.equals(AppConstants.BUILD_RELEASE))
            return;
        Log.d(Tag, message);
    }

    public static void printObject(Object object) {
        if (BuildConfig.BUILD_TYPE.equals(AppConstants.BUILD_RELEASE))
            return;
        String string = ((new Gson()).toJson(object));
        LogUtil.info(object.getClass().getSimpleName(), string);
    }

    public static void printVolleyError(VolleyError error) {
        if (BuildConfig.BUILD_TYPE.equals(AppConstants.BUILD_RELEASE))
            return;
        error.printStackTrace();

    }

    public static void printException(Exception exception){
        if (BuildConfig.BUILD_TYPE.equals(AppConstants.BUILD_RELEASE))
            return;
        exception.printStackTrace();

    }

}
