package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.Area;

/**
 * 汽车车牌号
 *
 * @author amos.chenj@outlook.com
 */
public final class LicensePlateBuilder implements Builder {

    private final Area area;

    protected LicensePlateBuilder() {
        area = new Area();
    }

    @Override
    public String build() {
        return null;
    }
}
