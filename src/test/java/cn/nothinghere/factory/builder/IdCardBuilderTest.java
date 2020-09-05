package cn.nothinghere.factory.builder;


import cn.nothinghere.factory.value.Gender;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IdCardBuilderTest {

    public static final String ANHUI = "安徽省";
    public static final String BEIJING = "北京市";

    public static final String HEBEI = "河北省";
    public static final String HEBEI_SHIJIAZHUANG = "石家庄市";
    public static final String HEBEI_SHIJIAZHUANG_ZHANGANQU = "长安区";

    public static final String SHANXI = "山西省";
    public static final String SHANXI_TAIYUAN = "太原市";
    public static final String SHANXI_TAIYUAN_XIAODIANQU = "小店区";

    private String idCard = null;
    private final int loop = 10000;

    @Test
    public void testWithProvince() {

        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder().withProvince(ANHUI).build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }

    @Test
    public void testWithCity() {
        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder().withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }

    @Test
    public void testWithDistrict() {
        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");

        }
    }

    @Test
    public void testWithAge() {
        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder().withProvince(SHANXI)
                    .withCity(SHANXI_TAIYUAN)
                    .withDistrict(SHANXI_TAIYUAN_XIAODIANQU)
                    .withAge(20)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }


    @Test
    public void testWithGender() {
        for (int i = 0; i < loop; i++) {

            idCard = Factory.idCardBuilder()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(18, 31)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");

            idCard = Factory.idCardBuilder()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(21, 38)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }


    @Test
    public void testWithAgeRange() {
        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withAge(18, 31)
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }

    @Test
    public void testWithBirthday() {
        for (int i = 0; i < loop; i++) {
            idCard = Factory.idCardBuilder()
                    .withProvince(HEBEI)
                    .withCity(HEBEI_SHIJIAZHUANG)
                    .withDistrict(HEBEI_SHIJIAZHUANG_ZHANGANQU)
                    .withBirthday("19880123")
                    .build();
            assertThat(idCard.length()).isEqualTo(18);
            assertThat(idCard).matches("\\d{17}[X\\d]");
        }
    }
}