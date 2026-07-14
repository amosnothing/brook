package cn.nothinghere.brook;

import cn.nothinghere.brook.builder.BaseTest;
import cn.nothinghere.brook.value.Operator;
import cn.nothinghere.brook.value.bank.BankCardType;
import cn.nothinghere.brook.value.human.Gender;
import cn.nothinghere.brook.value.occupation.MajorType;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BrookTest extends BaseTest {

    @Test
    public void testBuildWithoutCustomizer() {
        for (int i = 0; i < LOOP; i++) {
            assertThat(Brook.idCard()).hasSize(18).matches("\\d{17}[X\\d]");
            assertThat(Brook.name()).isNotBlank();
            assertThat(Brook.phone()).hasSize(11).matches("\\d+");
            assertThat(Brook.email()).contains("@");
            assertThat(Brook.bankCard()).matches("\\d+");
            assertThat(Brook.address()).isNotBlank();
            assertThat(Brook.company()).isNotBlank();
            assertThat(Brook.licensePlate()).hasSize(8);
            assertThat(Brook.occupation()).isNotBlank();
        }
    }

    @Test
    public void testBuildWithCustomizer() {
        String idCard = Brook.idCard(builder -> builder
                .withProvince(Province.GUANGDONG)
                .withCity(City.GUANGZHOU)
                .withDistrict("天河区")
                .withAge(20, 30)
                .withGender(Gender.MALE));
        assertThat(idCard).hasSize(18).matches("\\d{17}[X\\d]");

        String name = Brook.name(builder -> builder
                .withGender(Gender.FEMALE)
                .withLength(3));
        assertThat(name).hasSize(3).matches("\\W+");

        String phone = Brook.phone(builder -> builder.withOperator(Operator.CMCC));
        assertThat(phone).hasSize(11).matches("\\d+");

        String email = Brook.email(builder -> builder.withName("张三"));
        assertThat(email).startsWith("zhangsan@");

        String bankCard = Brook.bankCard(builder -> builder
                .withType(BankCardType.DC)
                .withLength(16));
        assertThat(bankCard).hasSize(16).matches("\\d+");

        String address = Brook.address(builder -> builder
                .withProvince(Province.GUANGDONG)
                .withCity(City.GUANGZHOU)
                .withDistrict("天河区"));
        assertThat(address)
                .contains(Province.GUANGDONG.getName())
                .contains(City.GUANGZHOU.getName())
                .contains("天河区");

        String company = Brook.company(builder -> builder.withCountry(cn.nothinghere.brook.value.Country.CHINA));
        assertThat(company).isNotBlank();

        String licensePlate = Brook.licensePlate(builder -> builder
                .withProvince(Province.GUANGDONG)
                .withCity(City.GUANGZHOU));
        assertThat(licensePlate).hasSize(8).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");

        String occupation = Brook.occupation(builder -> builder.withType(MajorType.PROFESSION));
        assertThat(occupation).isNotBlank();
    }
}
