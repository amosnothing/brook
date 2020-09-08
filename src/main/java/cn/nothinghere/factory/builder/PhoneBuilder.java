package cn.nothinghere.factory.builder;


import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.Field;
import cn.nothinghere.factory.Randomize;
import cn.nothinghere.factory.util.RandomStringUtil;
import cn.nothinghere.factory.util.RandomUtil;
import cn.nothinghere.factory.util.YamlUtil;
import cn.nothinghere.factory.value.Operator;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author chenjun
 * @date 2020/6/8 18:33
 */
public final class PhoneBuilder implements Builder {

    private final Mac mac = new Mac();

    public PhoneBuilder withOperator(Operator operator) {
        this.mac.setOperator(operator);
        return this;
    }

    @Override
    public String build() {
        this.mac.randomIfNull();
        return this.mac.asString() + RandomStringUtil.numeric(8);
    }

    public static class Mac implements Field, Randomize, Serializable {

        private static final long serialVersionUID = 6000249338314631722L;
        private static final Map<String, List<Integer>> MAC_MAP = YamlUtil.load("mac.yml");

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
            return RandomUtil.choice(list).toString();
        }

        @Override
        public void randomIfNull() {
            if (null == operator) {
                this.operator = RandomUtil.choice(Operator.values());
            }
        }
    }
}
