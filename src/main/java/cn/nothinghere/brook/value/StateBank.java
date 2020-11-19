package cn.nothinghere.brook.value;

/**
 * @author amos.chenj@outlook.com
 */

public enum StateBank implements Bank {
    /**
     * 国有大型商业银行
     */
    COMM("COMM", "交通银行"),
    BOC("BOC", "中国银行"),
    CCB("CCB", "中国建设银行"),
    ABC("ABC", "中国农业银行"),
    ICBC("ICBC", "中国工商银行"),
    PSBC("PSBC", "中国邮政储蓄银行"),
    /**
     * 股份制商业银行
     */
    CEB("CEB", "中国光大银行"),
    CMBC("CMBC", "中国民生银行"),
    CMB("CMB", "招商银行"),
    CITIC("CITIC", "中信银行"),
    HXBANK("HXBANK", "华夏银行"),
    SPDB("SPDB", "上海浦东发展银行"),
    SPABANK("SPABANK", "平安银行"),
    GDB("GDB", "广发银行"),
    CIB("CIB", "兴业银行"),
    CZBANK("CZBANK", "浙商银行"),
    BOHAIB("BOHAIB", "渤海银行"),
    EGBANK("EGBANK", "恒丰银行"),
    ;

    private final String code;
    private final String bankName;

    StateBank(String code, String bankName) {
        this.code = code;
        this.bankName = bankName;
    }

    public static Bank ofCode(String code) {
        StateBank[] codes = StateBank.values();
        for (StateBank stateBankCode : codes) {
            if (stateBankCode.code.equals(code)) {
                return stateBankCode;
            }
        }
        return null;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.bankName;
    }
}
