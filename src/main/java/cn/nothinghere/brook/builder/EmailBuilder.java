package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.Field;
import cn.nothinghere.factory.Randomize;
import cn.nothinghere.factory.util.PinyinUtil;
import cn.nothinghere.factory.util.RandomUtil;
import cn.nothinghere.factory.util.YamlUtil;
import cn.nothinghere.factory.value.Name;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author amos.chenj@outlook.com
 */
public final class EmailBuilder implements Builder {

    private final Name name;
    private final Domain domain;
    private String nameChinese;

    protected EmailBuilder() {
        name = new Name();
        domain = new Domain();
    }

    public EmailBuilder withName(String name) {
        Objects.requireNonNull(name);
        this.nameChinese = name;
        return this;
    }

    @Override
    public String build() {
        if (null == nameChinese) {
            name.randomIfNull();
            nameChinese = name.asString();
        }
        domain.randomIfNull();
        return PinyinUtil.toPinyin(nameChinese) + '@' + domain.asString();
    }

    public static class Domain implements Field, Serializable, Randomize {

        private static final Map<String, List<String>> MAP;
        private static final List<String> DOMAIN_LIST;
        private static final long serialVersionUID = -4467242699676921562L;

        static {
            MAP = YamlUtil.load("email.yml");
            DOMAIN_LIST = MAP.get("domain");
        }

        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public void randomIfNull() {
            if (null == data) {
                setData(RandomUtil.choice(DOMAIN_LIST));
            }
        }

        @Override
        public String asString() {
            return getData();
        }
    }
}
