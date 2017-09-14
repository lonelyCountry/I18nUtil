#I18nUtil
####一种专门为解决国际化编辑繁琐而生的快捷工具
##前言
#####本工程在类的构建上采用了builder模式，好处是在类的参数过多的时候使用参数为方法名可以简单明了的查看代码，不会因为参数过多导致开发人员读代码效率低下。
#####使用方法
#####T t = new T.Builder(必填参数).参数名1().参数名2().build();
#####t.do();
##1、最小实例
<pre>
<code>
public class test {
    @Test
    public void test1() throws Exception {
        Map param = new HashMap();//你需要操作的国际化键值对
        param.put("uc.ucconfig.js", "你们好");//example
        I18nFactory i18nFactory = new I18nFactory.Builder(param).build();
        i18nFactory.create();
    }
}
</code>
</pre>
#####当前生成的对象在create后不会有任何操作，因为没有输入国际化文件路径。
##2、基础实例
<pre>
<code>
public class test {
    @Test
    public void test1() throws Exception {
        Map param = new HashMap();//你需要操作的国际化键值对
        param.put("uc.ucconfig.js", "你们好");//example
        I18nFactory i18nFactory = new I18nFactory.Builder(param)
            .cnPath("/usr/test/cn.txt")
            .twPath("/usr/test/tw.txt")
            .enPath("/usr/test/en.txt")
            .build();
        i18nFactory.create();
    }
}
</code>
</pre>
#####文件是以追加的形式写到文档里，所以您完全可以把已经编辑过国际化文件的路径作为参数赋值
* 其中cnPath是生成简体中文的unicode国际化文件
* 其中twPath是生成繁体中文的unicode国际化文件
* 其中enPath是生成翻译成英语的国际化文件(默认Google翻译)

##3、自定义实例
<pre>
<code>
public class test {
    @Test
    public void test1() throws Exception {
        Map param = new HashMap();//你需要操作的国际化键值对
        param.put("uc.ucconfig.js", "你们好");//example
        I18nFactory i18nFactory = new I18nFactory.Builder(param)
                .cnPath("/usr/test/cn.txt")
                .engine(Engine.GOOGLE)
                .build();
        i18nFactory.create();
    }
}
</code>
</pre>
#####当你只需要简体中文的国际化文件的时候，可以只给简体中文文件路径赋值，那么就会只生成简体中文的文件。
#####翻译引擎目前有下列五种
* 谷歌翻译 Engine.GOOGLE(没有vpn的情况下，可能无法走通)
* 百度翻译 Engine.BAIDU
* 有道翻译 Engine.YOUDAO
* 金山翻译 Engine.JINSHAN
* 腾讯翻译 Engine.TENCENT
##4、完全体实例
<pre>
<code>
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
</code>
</pre>
#####以上是全部使用文档，有什么不懂可以加我QQ： 1037349711 备注：I18nUtil