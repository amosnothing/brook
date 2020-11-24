package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.PinyinUtils;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.util.YamlUtils;
import cn.nothinghere.brook.value.human.Name;

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
    private String chineseName;

    protected EmailBuilder() {
        name = new Name();
        domain = new Domain();
    }

    public EmailBuilder withName(String name) {
        Objects.requireNonNull(name);
        this.chineseName = name;
        return this;
    }

    @Override
    public String build() {
        if (null == chineseName) {
            name.randomIfNull();
            chineseName = name.asString();
        }
        domain.randomIfNull();
        return PinyinUtils.toPinyin(chineseName) + '@' + domain.asString();
    }

    public static class Domain implements Field, Serializable, Randomize {

        private static final Map<String, List<String>> MAP;
        private static final List<String> DOMAIN_LIST;
        private static final long serialVersionUID = -4467242699676921562L;

        static {
            MAP = YamlUtils.load("email.yml");
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
                setData(RandomUtils.choice(DOMAIN_LIST));
            }
        }

        @Override
        public String asString() {
            return getData();
        }
    }
}
