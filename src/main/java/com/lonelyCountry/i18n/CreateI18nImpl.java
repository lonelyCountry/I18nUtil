package com.lonelyCountry.i18n;

import com.github.nobodxbodon.zhconverter.简繁转换类;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.lonelyCountry.constant.Engine;
import com.lonelyCountry.constant.I18n;
import com.lonelyCountry.utils.EditUtil;
import com.lonelyCountry.utils.UnicodeUtil;
import com.lsj.trans.LANG;
import com.lsj.trans.Translator;
import com.lsj.trans.factory.TFactory;
import com.lsj.trans.factory.TranslatorFactory;

import java.io.File;
import java.util.Map;

public class CreateI18nImpl implements CreateI18n {
    private final Map<String, String> param;
    private final Engine engine;

    public CreateI18nImpl(Map<String, String> param, Engine engine) {
        this.param = param;
        this.engine = engine;
    }

    @Override
    public void createFile(I18n i18n, String path) throws Exception {
        String separator = System.getProperty("line.separator");
        File file = EditUtil.createOrGetFile(path);

        StringBuilder sb = new StringBuilder();
        EditUtil.writeFirst(sb);
        for (String key : param.keySet()) {
            String value = param.get(key);
            String space = EditUtil.getSpace(41 - key.length());
            switch (i18n) {
                case CN:
                    sb.append(key + space + " = " + UnicodeUtil.cnToUnicode(value) + separator);
                    break;
                case TW:
                    简繁转换类 convert = 简繁转换类.取实例(简繁转换类.目标.繁体);
                    sb.append(key + space + " = " + UnicodeUtil.cnToUnicode(convert.转换(value)) + separator);
                    break;
                case EN:
                    TFactory factory = new TranslatorFactory();
                    Translator lator = null;
                    switch (engine) {
                        case GOOGLE:
                            lator = factory.get("google");
                            break;
                        case BAIDU:
                            lator = factory.get("baidu");
                            break;
                        case YOUDAO:
                            lator = factory.get("youdao");
                            break;
                        case JINSHAN:
                            lator = factory.get("jinshan");
                            break;
                        case TENCENT:
                            lator = factory.get("tencent");
                            break;
                    }
                    sb.append(key + space + " = " + lator.trans(LANG.ZH, LANG.EN, value) + separator);
                    break;
            }
        }
        Files.append(sb.toString(), file, Charsets.UTF_8);
    }
}
