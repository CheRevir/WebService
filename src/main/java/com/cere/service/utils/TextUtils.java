package com.cere.service.utils;

/**
 * Created by CheRevir on 2021/8/27
 */
public class TextUtils {
    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }
}
