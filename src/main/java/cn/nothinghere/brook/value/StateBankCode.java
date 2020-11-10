package cn.nothinghere.brook.value;

/**
 *
 *
 * @author amos.chenj@outlook.com
 */

public enum StateBankCode implements BankCode {
    /**
     * 国有大型商业银行
     */
    COMM("交通银行"),
    BOC("中国银行"),
    CCB("中国建设银行"),
    ABC("中国农业银行"),
    ICBC("中国工商银行"),
    PSBC("中国邮政储蓄银行"),
    /**
     * 股份制商业银行
     */
    CEB("中国光大银行"),
    CMBC("中国民生银行"),
    CMB("招商银行"),
    CITIC("中信银行"),
    HXBANK("华夏银行"),
    SPDB("上海浦东发展银行"),
    SPABANK("平安银行"),
    GDB("广发银行"),
    CIB("兴业银行"),
    CZBANK("浙商银行"),
    BOHAIB("渤海银行"),
    EGBANK("恒丰银行"),
    ;

    private String bankName;

    StateBankCode(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String getCode() {
        return this.name();
    }
}
