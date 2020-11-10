package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.region.City;
import cn.nothinghere.factory.region.Province;
import cn.nothinghere.factory.value.Area;

import java.util.Objects;

/**
 * 省->市(市辖区)->县(区、市)->镇(街道)->村(居委会)
 *
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
        area.randomIfNull();
        return area.asString();
    }
}
