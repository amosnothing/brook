package cn.nothinghere.factory.builder;


import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.value.Gender;
import cn.nothinghere.factory.value.Name;

/**
 * 名字素材来源: 见name.yml
 *
 * @author amos.chenj@outlook.com
 */
public final class NameBuilder implements Builder {

    private final Name name;

    protected NameBuilder() {
        name = new Name();
    }

    public NameBuilder withGender(Gender gender) {
        name.setGender(gender);
        return this;
    }

    public NameBuilder withGender(String gender) {
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
