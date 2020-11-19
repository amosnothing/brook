package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.Bank;
import cn.nothinghere.brook.value.Bin;

import java.util.Objects;

/**
 * @author amos.chenj@outlook.com
 */
public final class BankCardBuilder implements Builder {

    private final Bin bin;

    protected BankCardBuilder() {
        bin = new Bin();
    }

    public BankCardBuilder withBank(Bank bank) {
        Objects.requireNonNull(bank);
        bin.setBank(bank);
        return this;
    }

    public BankCardBuilder withType(Bin.CardType cardType) {
        Objects.requireNonNull(cardType);
        bin.setType(cardType);
        return this;
    }

    /**
     * 生成最后一位校验码
     *
     * @param nonCheckCode
     * @return
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
        String uncheckCode = bin.asString();
        return uncheckCode + buildCheckCode(uncheckCode);
    }
}
