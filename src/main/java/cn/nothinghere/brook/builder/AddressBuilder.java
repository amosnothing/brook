package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import cn.nothinghere.brook.value.region.Area;

import java.util.Objects;

/**
 * @author amos.chenj@outlook.com
 */
public final class AddressBuilder implements Builder {

    private final Area area;

    protected AddressBuilder() {
        area = new Area();
    }

    public AddressBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        area.setProvince(province);
        return this;
    }

    public AddressBuilder withProvince(Province province) {
        Objects.requireNonNull(province, "province");
        area.setProvince(province.getName());
        return this;
    }

    public AddressBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        area.setCity(city);
        return this;
    }

    public AddressBuilder withCity(City city) {
        Objects.requireNonNull(city, "city");
        area.setCity(city.getName());
        return this;
    }

    public AddressBuilder withDistrict(String district) {
        Objects.requireNonNull(district, "district");
        area.setDistrict(district);
        return this;
    }

    @Override
    public String build() {
        area.verify();
        return area.asString();
    }
}
