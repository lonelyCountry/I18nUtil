package com.lonelyCountry.utils;

public class UnicodeUtil {

    public static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        StringBuilder returnStr = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.' || chars[i] == '!' || chars[i] == '?' || chars[i] == ',' || chars[i] == ':' ||
                    chars[i] == '(' || chars[i] == ')') {
                returnStr.append(chars[i]);
            } else if (chars[i] == '{' || chars[i] == '0' || chars[i] == '}' || chars[i] == '1' || chars[i] == '2' ||
                    chars[i] == '3' || chars[i] == '4' || chars[i] == '5') {
                returnStr.append(chars[i]);
            } else {
                returnStr.append("\\u").append(Integer.toString(chars[i], 16));
            }
        }
        return returnStr.toString();
    }

    public static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }
}
