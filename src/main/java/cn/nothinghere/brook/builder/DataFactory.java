package cn.nothinghere.brook.builder;

/**
 * use XXXBuilder.of() to create Builder
 * @author amos.chenj@outlook.com
 */
@Deprecated
public final class DataFactory {

    public static IdCardBuilder idCardBuilder() {
        return IdCardBuilder.of();
    }

    public static NameBuilder nameBuilder() {
        return NameBuilder.of();
    }

    public static PhoneBuilder phoneBuilder() {
        return PhoneBuilder.of();
    }

    public static EmailBuilder emailBuilder() {
        return EmailBuilder.of();
    }

    public static BankCardBuilder bankCardBuilder() {
        return BankCardBuilder.of();
    }

    public static AddressBuilder addressBuilder() {
        return AddressBuilder.of();
    }

    public static CompanyBuilder companyBuilder() {
        return CompanyBuilder.of();
    }

    public static LicensePlateBuilder licensePlateBuilder() {
        return LicensePlateBuilder.of();
    }

    public static OccupationBuilder occupationBuilder() {
        return OccupationBuilder.of();
    }

    private DataFactory() {
    }
}
