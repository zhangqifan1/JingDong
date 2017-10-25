package com.bawei.jingdong.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 张祺钒
 * on2017/10/17.
 */

public class JsonUtils {
    //判断返回值
    public static boolean isTrueJson(String content) {
        return content.length() > 8 && content.contains("{") && content.contains("}") && content.contains("code=200") && !content.contains("\"error\"");
    }
    //邮箱格式
    public static boolean isEmailAddress(String url) {
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(url);
        return matcher.matches();
    }

}
