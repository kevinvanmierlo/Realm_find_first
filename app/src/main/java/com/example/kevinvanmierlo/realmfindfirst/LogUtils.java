package com.example.kevinvanmierlo.realmfindfirst;

import android.util.Log;

/**
 * Created by kevinvanmierlo on 09-03-15.
 */
public class LogUtils
{
    private static final String LOG_PREFIX = "zooma_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    public static String makeLogTag(String str)
    {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH)
        {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }

        return LOG_PREFIX + str;
    }

    public static String makeLogTag(Class cls)
    {
        return makeLogTag(cls.getSimpleName());
    }

    public static void LOGD(final String tag, String message)
    {
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG))
        {
            Log.d(tag, message);
        }
    }
}
