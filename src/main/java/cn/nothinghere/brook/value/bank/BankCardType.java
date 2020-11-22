package cn.nothinghere.brook.value.bank;

/**
 * @author amos
 */

public enum BankCardType {
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
