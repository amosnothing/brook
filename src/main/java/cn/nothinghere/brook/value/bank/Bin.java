package cn.nothinghere.brook.value.bank;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Verifiable;
import cn.nothinghere.brook.util.JsonPathUtils;
import cn.nothinghere.brook.util.RandomStringUtils;
import cn.nothinghere.brook.util.YamlUtils;
import com.jayway.jsonpath.PathNotFoundException;

import java.io.Serializable;
import java.util.Map;

/**
 * 银行卡卡bin类
 *
 * @author amos.chenj@outlook.com
 */
public class Bin implements Field, Verifiable, Serializable {

    private static final long serialVersionUID = 2011815396278203785L;

    private Bank bank;
    private BankCardType type;
    private Integer length;

    private Map.Entry<String, Object> kvHolder;

    protected static final Map<String, Object> BIN_MAP;

    static {
        BIN_MAP = YamlUtils.load("bin.yml");
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankCardType getType() {
        return type;
    }

    public void setType(BankCardType type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String asString() {
        String key = kvHolder.getKey();
        // 根据最后的两个数字取到长度
        int len = Integer.parseInt(key.substring(key.length() - 4, key.length() - 2));
        String bin = kvHolder.getValue().toString();
        return bin + RandomStringUtils.numeric(len - bin.length() - 1);
    }

    @Override
    public void verify() {
        String bankCode = this.bank == null ? null : this.bank.getCode();
        String cardType = this.type == null ? null : this.type.getType();
        String cardLength = this.length == null ? null : this.length.toString();
        try {
            kvHolder = JsonPathUtils.random(BIN_MAP, bankCode, cardType, cardLength);
        } catch (PathNotFoundException exception) {
            throw new IllegalArgumentException(exception.getMessage().replace('$', ' '));
        }
    }
}
