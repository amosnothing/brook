package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import cn.nothinghere.brook.value.Plate;
import cn.nothinghere.brook.value.PlateType;

import java.util.Objects;

/**
 * 汽车车牌号: license plate number
 *
 * @author amos.chenj@outlook.com
 */
public final class LicensePlateBuilder implements Builder {

    private final Plate plate;

    LicensePlateBuilder() {
        this.plate = new Plate();
    }

    public static LicensePlateBuilder of() {
        return new LicensePlateBuilder();
    }

    public LicensePlateBuilder withType(PlateType type) {
        Objects.requireNonNull(type, "type");
        this.plate.setType(type);
        return this;
    }

    public LicensePlateBuilder withProvince(Province province) {
        Objects.requireNonNull(province, "province");
        this.plate.setProvince(province.getName());
        return this;
    }

    public LicensePlateBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        this.plate.setProvince(province);
        return this;
    }

    public LicensePlateBuilder withCity(City city) {
        Objects.requireNonNull(city, "city");
        this.plate.setCity(city.getName());
        return this;
    }

    public LicensePlateBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        this.plate.setCity(city);
        return this;
    }

    @Override
    public String build() {
        this.plate.verify();
        return this.plate.asString();
    }
}
