package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.value.Area;

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
