package cn.nothinghere.brook;

import cn.nothinghere.brook.builder.AddressBuilder;
import cn.nothinghere.brook.builder.BankCardBuilder;
import cn.nothinghere.brook.builder.CompanyBuilder;
import cn.nothinghere.brook.builder.EmailBuilder;
import cn.nothinghere.brook.builder.IdCardBuilder;
import cn.nothinghere.brook.builder.LicensePlateBuilder;
import cn.nothinghere.brook.builder.NameBuilder;
import cn.nothinghere.brook.builder.OccupationBuilder;
import cn.nothinghere.brook.builder.PhoneBuilder;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 单行数据构造入口。
 *
 * @author amos.chenj@outlook.com
 */
public final class Brook {

    private Brook() {
    }

    public static String idCard() {
        return build(IdCardBuilder::of);
    }

    public static String idCard(Consumer<IdCardBuilder> customizer) {
        return build(IdCardBuilder::of, customizer);
    }

    public static String name() {
        return build(NameBuilder::of);
    }

    public static String name(Consumer<NameBuilder> customizer) {
        return build(NameBuilder::of, customizer);
    }

    public static String phone() {
        return build(PhoneBuilder::of);
    }

    public static String phone(Consumer<PhoneBuilder> customizer) {
        return build(PhoneBuilder::of, customizer);
    }

    public static String email() {
        return build(EmailBuilder::of);
    }

    public static String email(Consumer<EmailBuilder> customizer) {
        return build(EmailBuilder::of, customizer);
    }

    public static String bankCard() {
        return build(BankCardBuilder::of);
    }

    public static String bankCard(Consumer<BankCardBuilder> customizer) {
        return build(BankCardBuilder::of, customizer);
    }

    public static String address() {
        return build(AddressBuilder::of);
    }

    public static String address(Consumer<AddressBuilder> customizer) {
        return build(AddressBuilder::of, customizer);
    }

    public static String company() {
        return build(CompanyBuilder::of);
    }

    public static String company(Consumer<CompanyBuilder> customizer) {
        return build(CompanyBuilder::of, customizer);
    }

    public static String licensePlate() {
        return build(LicensePlateBuilder::of);
    }

    public static String licensePlate(Consumer<LicensePlateBuilder> customizer) {
        return build(LicensePlateBuilder::of, customizer);
    }

    public static String occupation() {
        return build(OccupationBuilder::of);
    }

    public static String occupation(Consumer<OccupationBuilder> customizer) {
        return build(OccupationBuilder::of, customizer);
    }

    private static <T extends Builder> String build(Supplier<T> supplier) {
        return build(supplier, builder -> {
        });
    }

    private static <T extends Builder> String build(Supplier<T> supplier, Consumer<T> customizer) {
        Objects.requireNonNull(supplier, "supplier");
        Objects.requireNonNull(customizer, "customizer");
        T builder = supplier.get();
        customizer.accept(builder);
        return builder.build();
    }
}
