package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.bank.Bank;
import cn.nothinghere.brook.value.bank.BankCardType;
import cn.nothinghere.brook.value.bank.Bin;

import java.util.Objects;

/**
 * @author amos.chenj@outlook.com
 */
public final class BankCardBuilder implements Builder {

    private final Bin bin;

    BankCardBuilder() {
        this.bin = new Bin();
    }

    public static BankCardBuilder of() {
        return new BankCardBuilder();
    }

    public BankCardBuilder withBank(Bank bank) {
        Objects.requireNonNull(bank);
        bin.setBank(bank);
        return this;
    }

    public BankCardBuilder withType(BankCardType cardType) {
        Objects.requireNonNull(cardType);
        bin.setType(cardType);
        return this;
    }

    public BankCardBuilder withLength(int length) {
        bin.setLength(length);
        return this;
    }

    /**
     * 生成最后一位校验码
     *
     * @param nonCheckCode 未添加最后一位校验码的银行卡
     * @return 校验码：luhm算法生成
     */
    private static char buildCheckCode(String nonCheckCode) {
        if (nonCheckCode == null || nonCheckCode.trim().length() == 0
                || !nonCheckCode.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCode.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    @Override
    public String build() {
        bin.verify();
        String uncheckCode = bin.asString();
        return uncheckCode + buildCheckCode(uncheckCode);
    }
}
