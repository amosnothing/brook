package cn.nothinghere.brook.builder;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.util.YamlUtils;
import cn.nothinghere.brook.value.Country;

/**
 * amos.chenj@outlook.com
 *
 * @author amos
 */
public class CompanyBuilder implements Builder {

    private final Company company;

    CompanyBuilder() {
        this.company = new Company();
    }

    public static CompanyBuilder of() {
        return new CompanyBuilder();
    }

    /**
     * 选择国家
     *
     * @param country 国家or地区
     *
     * @return self
     */
    public CompanyBuilder withCountry(Country country) {
        Objects.requireNonNull(country);
        this.company.setCountry(country);
        return this;
    }

    @Override
    public String build() {
        this.company.randomIfNull();
        return this.company.asString();
    }


    public static class Company implements Serializable, Field, Randomize {

        private static final Map<String, List<String>> MAP;
        private static final long serialVersionUID = -5271600656300216514L;

        private Country country;
        private String name;

        public Country getCountry() {
            return this.country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        static {
            MAP = Collections.unmodifiableMap(YamlUtils.load("company.yml"));
        }

        @Override
        public String asString() {
            return this.getName();
        }

        @Override
        public void randomIfNull() {
            // 国家随机
            if (this.country == null) {
                this.country = RandomUtils.choice(Country.values());
            }
            // 从国家所属公司列表中随机选一个
            this.name = RandomUtils.choice(MAP.get(this.country.getShortName()));
        }
    }
}
