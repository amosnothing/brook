package cn.nothinghere.brook.value;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomStringUtil;
import cn.nothinghere.brook.util.RandomUtil;
import cn.nothinghere.brook.util.YamlUtil;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 银行卡卡bin类
 *
 * @author amos.chenj@outlook.com
 */
public class Bin implements Field, Randomize, Serializable {

    private static final long serialVersionUID = 2011815396278203785L;

    private Bank bank;
    private CardType type;

    protected static final Map<String, Object> BIN_MAP;

    static {
        BIN_MAP = YamlUtil.load("bin.yml");
    }

    /**
     * 只包含银行卡类型映射关系表
     * 因为类型在map的第三级，查找起来比较困难，需要单独取出再组合
     */
    protected static final Map<String, Map<String, Integer>> CARD_TYPE_MAP = new HashMap<>();

    static {
        Set<String> keySet = BIN_MAP.keySet();
        // 取到每个银行的map
        for (String codeKey : keySet) {
            // 取到该银行下 所有的卡类型map
            @SuppressWarnings("unchecked")
            Map<String, Map<String, Integer>> typeMap = (Map<String, Map<String, Integer>>) BIN_MAP.get(codeKey);
            merge(CARD_TYPE_MAP, typeMap);
        }
    }

    @SuppressWarnings("unchecked")
    private static <K, V> void merge(Map<K, V> mapLeft, Map<K, V> mapRight) {
        // go over all the keys of the right map
        for (K key : mapRight.keySet()) {
            // if the left map already has this key, merge the maps that are behind that key
            if (mapLeft.containsKey(key)) {
                if (mapLeft.get(key) instanceof Map && mapRight.get(key) instanceof Map) {
                    merge((Map) mapLeft.get(key), (Map) mapRight.get(key));
                } else {
                    return;
                }
            } else {
                // otherwise just add the map under that key
                mapLeft.put(key, mapRight.get(key));
            }
        }
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String asString() {
        // 若入参为空 则随机赋值
        randomIfNull();
        String code;
        String type;
        // code为null，则type一定不为null
        Map<String, Integer> typeMap;
        if (null == this.bank && null != this.type) {
            type = this.type.getType();
            typeMap = CARD_TYPE_MAP.get(type);
        } else if (null == this.type && null != this.bank) {
            code = this.bank.getCode();
            Map<String, Object> codeMap = (Map<String, Object>) BIN_MAP.get(code);
            typeMap = (Map<String, Integer>) RandomUtil.choiceV(codeMap);

        }
        // 都不为null的情况
        else {
            code = this.bank.getCode();
            type = this.type.getType();
            Map<String, Object> codeMap = (Map<String, Object>) BIN_MAP.get(code);
            typeMap = (Map<String, Integer>) codeMap.get(type);
            if (null == typeMap) {
                throw new IllegalArgumentException(MessageFormat.format("There is no type-{0} in Bank-{1}", type, code));
            }
        }
        String bin = RandomUtil.choiceK(typeMap);
        int length = typeMap.get(bin);
        // 剩余的一位留下作为检验码
        return bin + RandomStringUtil.numeric(length - 1 - bin.length());
    }

    @Override
    public void randomIfNull() {
        // 只有当都没有传参时才做随机赋值
        // 否则外部传参 + 随机赋值，可能导致没有对应的bin匹配
        if (null == this.getBank() && null == this.getType()) {
            this.setBank(RandomUtil.choice(StateBank.values()));
            this.setType(CardType.DC);
        }
    }


    public enum CardType {
        /**
         * DC: "储蓄卡",
         * CC: "信用卡",
         * SCC: "准贷记卡",
         * PC: "预付费卡"
         */
        DC, CC, SCC, PC;

        public String getType() {
            return this.name();
        }
    }
}
