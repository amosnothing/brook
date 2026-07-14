package cn.nothinghere.brook;

import cn.nothinghere.brook.builder.AddressBuilder;
import cn.nothinghere.brook.builder.BankCardBuilder;
import cn.nothinghere.brook.builder.IdCardBuilder;
import cn.nothinghere.brook.builder.NameBuilder;
import cn.nothinghere.brook.value.bank.BankCardType;
import cn.nothinghere.brook.value.human.Gender;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaintainabilityRegressionTest {

    @Test
    public void testAddressFormatting() {
        String address = AddressBuilder.of()
                .withProvince(Province.GUANGDONG)
                .withCity(City.GUANGZHOU)
                .withDistrict("天河区")
                .build();

        assertThat(address).isEqualTo("广东省广州市天河区");
    }

    @Test
    public void testBankCardLengthResolution() {
        String bankCard = BankCardBuilder.of()
                .withType(BankCardType.DC)
                .withLength(16)
                .build();

        assertThat(bankCard).hasSize(16).matches("\\d+");
    }

    @Test
    public void testGenderParsingAndNameBuilder() {
        String femaleName = NameBuilder.of().withGender("女").withLength(3).build();
        String maleName = NameBuilder.of().withGender("MALE").withLength(3).build();

        assertThat(femaleName).hasSize(3);
        assertThat(maleName).hasSize(3);
    }

    @Test
    public void testIdCardGenderStringValidation() {
        String idCard = IdCardBuilder.of()
                .withProvince(Province.GUANGDONG)
                .withCity(City.GUANGZHOU)
                .withDistrict("天河区")
                .withGender("男")
                .build();

        assertThat(idCard).hasSize(18).matches("\\d{17}[X\\d]");
        assertThat(Gender.fromName("男")).isEqualTo(Gender.MALE);
    }
}
