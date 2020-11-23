package cn.nothinghere.brook.builder;

/**
 * @author amos.chenj@outlook.com
 */
public final class DataFactory {

    public static IdCardBuilder idCardBuilder() {
        return new IdCardBuilder();
    }

    public static NameBuilder nameBuilder() {
        return new NameBuilder();
    }

    public static PhoneBuilder phoneBuilder() {
        return new PhoneBuilder();
    }

    public static EmailBuilder emailBuilder() {
        return new EmailBuilder();
    }

    public static BankCardBuilder bankCardBuilder() {
        return new BankCardBuilder();
    }

    public static AddressBuilder addressBuilder() {
        return new AddressBuilder();
    }

    public static CompanyBuilder companyBuilder() {
        return new CompanyBuilder();
    }

    public static LicensePlateBuilder licensePlateBuilder() {
        return new LicensePlateBuilder();
    }

    public static OccupationBuilder occupationBuilder() {
        return new OccupationBuilder();
    }

    private DataFactory() {
    }
}
