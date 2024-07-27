package cn.nothinghere.brook.builder;


import cn.nothinghere.brook.value.human.Gender;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class IdCardBuilderTest extends BaseTest {

    public static final String HEBEI = "河北省";
    public static final String HEBEI_SHIJIAZHUANG = "石家庄市";
    public static final String HEBEI_SHIJIAZHUANG_ZHANGANQU = "长安区";

    public static final String SHANXI = "山西省";
    public static final String SHANXI_TAIYUAN = "太原市";
    public static final String SHANXI_TAIYUAN_XIAODIANQU = "小店区";


    @Test
    public void testWithProvince() {
        String idCard;
        Province[] provinces = Province.values();
        for (Province province : provinces) {
            idCard = IdCardBuilder.of().withProvince(province).build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
            idCard = IdCardBuilder.of().withProvince(province.getName()).build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }

    @Test
    public void testWithCity() {
        String idCard;
        // 只传入【市】
        City[] cities = City.values();
        for (City city : cities) {
            idCard = IdCardBuilder.of().withCity(city).build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }

        // 同时传入【省+市】
        Province[] provinces = Province.values();
        for (Province province : provinces) {
            City[] cities1 = City.getByParent(province);
            for (City city : cities1) {
                idCard = IdCardBuilder.of()
                        .withProvince(province)
                        .withCity(city)
                        .build();
                assertThat(idCard).hasSize(18);
                assertThat(idCard).matches("\\d{17}[X\\d]");
            }
        }
    }

    @Test
    public void testWithDistrict() {
        String idCard;
        for (int i = 0; i < LOOP; i++) {
            idCard = IdCardBuilder.of()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");

            idCard = IdCardBuilder.of()
                    .withProvince(Province.GUANGDONG)
                    .withCity(City.GUANGZHOU)
                    .withDistrict("天河区")
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");

        }
    }

    @Test
    public void testWithAge() {
        String idCard;
        for (int i = 0; i < LOOP; i++) {
            idCard = IdCardBuilder.of().withProvince(SHANXI)
                    .withCity(SHANXI_TAIYUAN)
                    .withDistrict(SHANXI_TAIYUAN_XIAODIANQU)
                    .withAge(20)
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }


    @Test
    public void testWithGender() {
        String idCard;
        for (int i = 0; i < LOOP; i++) {

            idCard = IdCardBuilder.of()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(18, 31)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");

            idCard = IdCardBuilder.of()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(21, 38)
                    .withGender(Gender.FEMALE.getName())
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }


    @Test
    public void testWithAgeRange() {
        String idCard;
        for (int i = 0; i < LOOP; i++) {
            idCard = IdCardBuilder.of()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(18, 31)
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }

    @Test
    public void testWithBirthday() {
        String idCard;
        for (int i = 0; i < LOOP; i++) {
            idCard = IdCardBuilder.of()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withBirthday("19880123")
                    .build();
            assertThat(idCard).hasSize(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }

        // 日期传参格式不正确
        assertThatIllegalArgumentException().isThrownBy(() -> IdCardBuilder.of().withBirthday("2020-10-10"));
        assertThatIllegalArgumentException().isThrownBy(() -> IdCardBuilder.of().withBirthday("2020/10/10"));
    }
}