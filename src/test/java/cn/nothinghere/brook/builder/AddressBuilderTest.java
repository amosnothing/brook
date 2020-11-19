package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.region.Province;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBuilderTest {

    private String address = null;
    private final int loop = 10000;

    @Test
    public void testWithProvince() {
        for (int i = 0; i < loop; i++) {
            String beijing = "北京";
            address = DataFactory.addressBuilder().withProvince(beijing).build();
            assertThat(address).startsWith(beijing);
            String hubei = "湖北省";
            address = DataFactory.addressBuilder().withProvince(hubei).build();
            assertThat(address).startsWith(hubei);
            String guangdong = "广东省";
            address = DataFactory.addressBuilder().withProvince(guangdong).build();
            assertThat(address).startsWith(guangdong);
        }
    }

    @Test
    public void testWithProvince1() {
        for (int i = 0; i < loop; i++) {
            Province beijing = Province.BEIJING;
            address = DataFactory.addressBuilder().withProvince(beijing).build();
            assertThat(address).startsWith(beijing.getName());
            Province hubei = Province.HUBEI;
            address = DataFactory.addressBuilder().withProvince(hubei).build();
            assertThat(address).startsWith(hubei.getName());
            Province guangdong = Province.GUANGDONG;
            address = DataFactory.addressBuilder().withProvince(guangdong).build();
            assertThat(address).startsWith(guangdong.getName());
        }
    }

    @Test
    public void testWithCity() {
        for (int i = 0; i < loop; i++) {
            Province beijing = Province.BEIJING;
            address = DataFactory.addressBuilder().withProvince(beijing)
                    .withCity("北京市").build();
            assertThat(address).startsWith(beijing.getName());
            Province hubei = Province.HUBEI;
            address = DataFactory.addressBuilder().withProvince(hubei).build();
            assertThat(address).startsWith(hubei.getName());
            Province guangdong = Province.GUANGDONG;
            address = DataFactory.addressBuilder().withProvince(guangdong).build();
            assertThat(address).startsWith(guangdong.getName());
        }
    }

    @Test
    public void testWithCity1() {
    }

    @Test
    public void testWithDistrict() {
    }
}