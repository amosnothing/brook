package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.PlateType;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LicensePlateBuilderTest extends BaseTest {

    @Test
    public void testWithType() {
        for (int i = 0; i < LOOP; i++) {
            PlateType[] types = PlateType.values();
            for (PlateType plateType : types) {
                String s = DataFactory.licensePlateBuilder().withType(plateType).build();
                assertThat(s).hasSize(8);
                assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
            }
        }
    }

    @Test
    public void testWithProvinceEnum() {
        for (int i = 0; i < LOOP; i++) {
            Province[] provinces = Province.values();
            for (Province province : provinces) {
                String s = DataFactory.licensePlateBuilder().withProvince(province).build();
                assertThat(s).hasSize(8);
                assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
            }
        }
    }

    @Test
    public void testWithProvince() {
        for (int i = 0; i < LOOP; i++) {
            Province[] provinces = Province.values();
            for (Province province : provinces) {
                String s = DataFactory.licensePlateBuilder().withProvince(province.getName()).build();
                assertThat(s).hasSize(8);
                assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
            }
        }
    }

    @Test
    public void testWithCityEnum() {
        for (int i = 0; i < LOOP; i++) {
            City[] cities = City.values();
            for (City city : cities) {
                String s = DataFactory.licensePlateBuilder().withCity(city).build();
                assertThat(s).hasSize(8);
                assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
            }

            Province[] provinces = Province.values();
            for (Province province : provinces) {
                City[] cities1 = City.getByParent(province);
                for (City city : cities1) {
                    String s = DataFactory.licensePlateBuilder().withProvince(province)
                            .withCity(city)
                            .build();
                    assertThat(s).hasSize(8);
                    assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
                }
            }
        }
    }

    @Test
    public void testWithCity() {
        for (int i = 0; i < LOOP; i++) {
            City[] cities = City.values();
            for (City city : cities) {
                String s = DataFactory.licensePlateBuilder().withCity(city.getName()).build();
                assertThat(s).hasSize(8);
                assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
            }

            Province[] provinces = Province.values();
            for (Province province : provinces) {
                City[] cities1 = City.getByParent(province);
                for (City city : cities1) {
                    String s = DataFactory.licensePlateBuilder().withProvince(province.getName())
                            .withCity(city.getName())
                            .build();
                    assertThat(s).hasSize(8);
                    assertThat(s).matches("[\\u4e00-\\u9fa5][ABCDEFGHJKLMNPQRSTUVWXYZ0-9]{7}");
                }
            }
        }
    }
}