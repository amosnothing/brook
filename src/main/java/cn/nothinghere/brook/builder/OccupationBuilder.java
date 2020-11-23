package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.occupation.MajorType;
import cn.nothinghere.brook.value.occupation.Occupation;

/**
 * 职业
 *
 * @author amos.chenj@outlook.com
 */
public final class OccupationBuilder implements Builder {
    private final Occupation occupation;

    protected OccupationBuilder() {
        occupation = new Occupation();
    }

    public OccupationBuilder withType(MajorType type) {
        occupation.setMajorType(type);
        return this;
    }

    @Override
    public String build() {
        occupation.randomIfNull();
        occupation.verify();
        return occupation.asString();
    }
}
