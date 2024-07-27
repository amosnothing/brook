package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBuilderTest extends BaseTest {

    /**
     * 传入的是【省】的字符串
     */
    @Test
    public void testWithProvince() {
        String address;
        for (int i = 0; i < LOOP; i++) {
            Province[] provides = Province.values();
            for (Province provide : provides) {
                address = AddressBuilder.of().withProvince(provide.getName()).build();
                assertThat(address).startsWith(provide.getName());
            }
        }
    }

    /**
     * 传入的是省的枚举类
     */
    @Test
    public void testWithProvinceEnum() {
        String address;
        for (int i = 0; i < LOOP; i++) {
            Province[] provides = Province.values();
            for (Province provide : provides) {
                address = AddressBuilder.of().withProvince(provide).build();
                assertThat(address).startsWith(provide.getName());
            }
        }
    }

    /**
     * 传入的是【市】的字符串
     */
    @Test
    public void testWithCity() {
        String address;
        for (int i = 0; i < LOOP; i++) {
            City[] cities = City.values();
            for (City city : cities) {
                address = AddressBuilder.of().withCity(city.getName()).build();
                assertThat(address).contains(city.getName());
            }
        }
    }

    /**
     * 传入的是【省+市】OR【市】的枚举类
     */
    @Test
    public void testWithCityEnum() {
        String address;
        for (int i = 0; i < LOOP; i++) {
            Province[] provides = Province.values();
            for (Province provide : provides) {
                City[] cities = City.getByParent(provide);
                for (City city : cities) {
                    // 省市 组合使用的情况
                    address = AddressBuilder.of()
                            .withProvince(provide)
                            .withCity(city)
                            .build();
                    assertThat(address).startsWith(provide.getName());
                    assertThat(address).contains(city.getName());

                    // 市 单独使用的情况
                    // 由于可能存在一个市 对应多个省的情况
                    // 所以不便于另外再检验一遍省 只校验市即可
                    address = AddressBuilder.of()
                            .withCity(city)
                            .build();
                    assertThat(address).contains(city.getName());
                }
            }
        }
    }

    /**
     * 由于区字段没有单独定义成枚举类
     * 所以需要根据已知的区来做校验
     */
    @Test
    public void testWithDistrict() {
        String address;
        for (int i = 0; i < LOOP; i++) {

            String tianhe = "天河区";
            address = AddressBuilder.of().withDistrict(tianhe).build();
            assertThat(address).contains(tianhe);

            String tongs = "通什镇";
            address = AddressBuilder.of().withDistrict(tongs).build();
            assertThat(address).contains(tongs);
        }
    }
}