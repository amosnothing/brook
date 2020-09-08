package cn.nothinghere.factory.builder;


import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.value.Gender;
import cn.nothinghere.factory.value.Name;

/**
 * 名字素材来源: 见name.yml
 *
 * @author amos
 */
public final class NameBuilder implements Builder {

    private final Name name = new Name();

    private final static int MIN_LENGTH = 2;
    private final static int MAX_LENGTH = 4;

    protected NameBuilder() {
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
        if (!(length == MIN_LENGTH || length == MAX_LENGTH)) {
            throw new IllegalArgumentException("length");
        }
        name.setLength(length);
        return this;
    }


    @Override
    public String build() {
        name.randomIfNull();
        return this.name.asString();
    }
}
