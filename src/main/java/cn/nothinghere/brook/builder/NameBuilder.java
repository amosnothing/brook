package cn.nothinghere.brook.builder;


import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.value.human.Gender;
import cn.nothinghere.brook.value.human.Name;

import java.util.Objects;

/**
 * 名字素材来源: 见name.yml
 *
 * @author amos.chenj@outlook.com
 */
public final class NameBuilder implements Builder {

    private final Name name;

    NameBuilder() {
        this.name = new Name();
    }

    public static NameBuilder of() {
        return new NameBuilder();
    }

    public NameBuilder withGender(Gender gender) {
        Objects.requireNonNull(gender, "gender");
        name.setGender(gender);
        return this;
    }

    public NameBuilder withGender(String gender) {
        Objects.requireNonNull(gender, "gender");
        name.setGender(Gender.fromName(gender));
        return this;
    }

    public NameBuilder withLength(int length) {
        name.setLength(length);
        return this;
    }

    @Override
    public String build() {
        name.randomIfNull();
        return this.name.asString();
    }
}
