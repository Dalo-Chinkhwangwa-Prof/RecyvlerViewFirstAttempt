package com.example.internalstorageapp.util;

import android.util.Log;

public class Logger {

    private static final String ERROR_TAG = "TAG_ERROR";
    private static final String TAG = "TAG_DEBUG";

    public static void logError(Throwable throwable){

        Log.e(ERROR_TAG, throwable.getMessage());
    }

    public static void logDebug(String log){
        Log.d(TAG, log);
    }

}
