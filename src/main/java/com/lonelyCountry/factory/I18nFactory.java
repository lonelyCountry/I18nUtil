package com.lonelyCountry.factory;

import com.lonelyCountry.constant.Engine;
import com.lonelyCountry.constant.I18n;
import com.lonelyCountry.i18n.CreateI18n;
import com.lonelyCountry.i18n.CreateI18nImpl;

import java.util.Map;

public class I18nFactory {
    private final Map<String, String> param;
    private String cnPath;
    private String twPath;
    private String enPath;
    private Engine engine;

    private I18nFactory(Builder builder) {
        param = builder.param;
        cnPath = builder.cnPath;
        twPath = builder.twPath;
        enPath = builder.enPath;
        engine = builder.engine;
    }

    public void create() throws Exception {
        CreateI18n createI18n = new CreateI18nImpl(param, engine);

        boolean flag_zh_cn_blank = cnPath == null || "".equals(cnPath);
        boolean flag_zh_tw_blank = twPath == null || "".equals(twPath);
        boolean flag_zh_en_blank = enPath == null || "".equals(enPath);

        if (!flag_zh_cn_blank) {
            createI18n.createFile(I18n.CN, cnPath);
        }
        if (!flag_zh_tw_blank) {
            createI18n.createFile(I18n.TW, twPath);
        }
        if (!flag_zh_en_blank) {
            createI18n.createFile(I18n.EN, enPath);
        }
    }

    public static final class Builder {
        private final Map<String, String> param;
        private String cnPath;
        private String twPath;
        private String enPath;
        private Engine engine;

        public Builder(Map<String, String> param) {
            this.param = param;
        }

        public Builder cnPath(String val) {
            cnPath = val;
            return this;
        }

        public Builder twPath(String val) {
            twPath = val;
            return this;
        }

        public Builder enPath(String val) {
            enPath = val;
            return this;
        }

        public Builder engine(Engine val) {
            engine = val;
            return this;
        }

        public I18nFactory build() {
            return new I18nFactory(this);
        }
    }
}
