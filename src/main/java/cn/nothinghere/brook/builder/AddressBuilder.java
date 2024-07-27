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

    AddressBuilder() {
        this.area = new Area();
    }

    public static AddressBuilder of() {
        return new AddressBuilder();
    }

    public AddressBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        this.area.setProvince(province);
        return this;
    }

    public AddressBuilder withProvince(Province province) {
        Objects.requireNonNull(province, "province");
        this.area.setProvince(province.getName());
        return this;
    }

    public AddressBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        this.area.setCity(city);
        return this;
    }

    public AddressBuilder withCity(City city) {
        Objects.requireNonNull(city, "city");
        this.area.setCity(city.getName());
        return this;
    }

    public AddressBuilder withDistrict(String district) {
        Objects.requireNonNull(district, "district");
        this.area.setDistrict(district);
        return this;
    }

    @Override
    public String build() {
        this.area.verify();
        return this.area.asString();
    }
}
