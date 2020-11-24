package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;
import cn.nothinghere.brook.value.Plate;
import cn.nothinghere.brook.value.PlateType;

/**
 * 汽车车牌号: license plate number
 *
 * @author amos.chenj@outlook.com
 */
public final class LicensePlateBuilder implements Builder {

    private final Plate plate;

    protected LicensePlateBuilder() {
        plate = new Plate();
    }

    public LicensePlateBuilder withType(PlateType type) {
        plate.setType(type);
        return this;
    }

    public LicensePlateBuilder withProvince(Province province) {
        plate.setProvince(province.getName());
        return this;
    }

    public LicensePlateBuilder withProvince(String province) {
        plate.setProvince(province);
        return this;
    }

    public LicensePlateBuilder withCity(City city) {
        plate.setCity(city.getName());
        return this;
    }

    public LicensePlateBuilder withCity(String city) {
        plate.setCity(city);
        return this;
    }

    @Override
    public String build() {
        plate.verify();
        return plate.asString();
    }
}
