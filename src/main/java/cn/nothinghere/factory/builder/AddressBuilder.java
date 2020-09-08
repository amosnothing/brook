package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.value.Area;

import java.util.Objects;

/**
 * @author amos
 */
public final class AddressBuilder implements Builder {

    private final Area area = new Area();

    public AddressBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        area.setProvince(province);
        return this;
    }

    public AddressBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        area.setCity(city);
        return this;
    }

    public AddressBuilder withDistrict(String district) {
        Objects.requireNonNull(district, "district");
        area.setDistrict(district);
        return this;
    }

    @Override
    public String build() {
        return null;
    }
}
