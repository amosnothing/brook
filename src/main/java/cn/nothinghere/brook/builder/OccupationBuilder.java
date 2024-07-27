package cn.nothinghere.brook.builder;

import java.util.Objects;

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

    OccupationBuilder() {
        this.occupation = new Occupation();
    }

    public static OccupationBuilder of() {
        return new OccupationBuilder();
    }

    public OccupationBuilder withType(MajorType type) {
        Objects.requireNonNull(type);
        this.occupation.setMajorType(type);
        return this;
    }

    @Override
    public String build() {
        this.occupation.randomIfNull();
        this.occupation.verify();
        return this.occupation.asString();
    }
}
