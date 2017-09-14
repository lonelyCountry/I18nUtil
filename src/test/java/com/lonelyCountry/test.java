package com.lonelyCountry;

import com.lonelyCountry.constant.Engine;
import com.lonelyCountry.factory.I18nFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1() throws Exception {
        Map param = new HashMap();//你需要操作的国际化键值对
        param.put("uc.ucconfig.js", "你们好");//example
        I18nFactory i18nFactory = new I18nFactory.Builder(param)
                .cnPath("/usr/test/cn.txt")
                .twPath("/usr/test/tw.txt")
                .enPath("/usr/test/en.txt")
                .engine(Engine.BAIDU)
                .build();
        i18nFactory.create();
    }
}
