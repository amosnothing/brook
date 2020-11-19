package cn.nothinghere.brook.value;

/**
 * 国家和地区
 *
 * @author amos
 */

public enum Country {
    /**
     * 国家 包括 英文名 - 语言 - 简称 - 中文名
     */
    CHINA("CHINA", "CHINESE", "CN", "中国"),
    AMERICA("United States of America", "English", "US", "美国"),
    ;
    private final String enName;
    private final String language;
    private final String shortName;
    private final String cnName;

    Country(String enName, String language, String shortName, String cnName) {
        this.enName = enName;
        this.language = language;
        this.shortName = shortName;
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public String getLanguage() {
        return language;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCnName() {
        return cnName;
    }
}
