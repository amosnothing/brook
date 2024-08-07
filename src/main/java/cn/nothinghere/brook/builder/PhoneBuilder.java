package cn.nothinghere.brook.builder;


import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomStringUtils;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.util.YamlUtils;
import cn.nothinghere.brook.value.Operator;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author amos.chenj@outlook.com
 */
public final class PhoneBuilder implements Builder {

    private final Mac mac;

    PhoneBuilder() {
        mac = new Mac();
    }

    public static PhoneBuilder of() {
        return new PhoneBuilder();
    }

    public PhoneBuilder withOperator(Operator operator) {
        this.mac.setOperator(operator);
        return this;
    }

    @Override
    public String build() {
        this.mac.randomIfNull();
        return this.mac.asString() + RandomStringUtils.numeric(8);
    }

    public static class Mac implements Field, Randomize, Serializable {

        private static final long serialVersionUID = 6000249338314631722L;

        private static final Map<String, List<Integer>> MAC_MAP;

        static {
            MAC_MAP = Collections.unmodifiableMap(YamlUtils.load("mac.yml"));
        }

        private Operator operator;

        public Operator getOperator() {
            return operator;
        }

        public void setOperator(Operator operator) {
            this.operator = operator;
        }

        @Override
        public String asString() {
            String opName = this.operator.name().toLowerCase();
            List<Integer> list = MAC_MAP.get(opName);
            return RandomUtils.choice(list).toString();
        }

        @Override
        public void randomIfNull() {
            if (null == operator) {
                this.operator = RandomUtils.choice(Operator.values());
            }
        }
    }
}
