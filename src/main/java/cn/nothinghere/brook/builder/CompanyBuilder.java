package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomUtil;
import cn.nothinghere.brook.util.YamlUtil;
import cn.nothinghere.brook.value.Country;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * amos.chenj@outlook.com
 *
 * @author amos
 */
public class CompanyBuilder implements Builder {

    private final Company company;

    protected CompanyBuilder() {
        company = new Company();
    }

    /**
     *  选择国家
     * @param country 国家or地区
     * @return self
     */
    public CompanyBuilder withCountry(Country country) {
        Objects.requireNonNull(country);
        company.setCountry(country);
        return this;
    }

    @Override
    public String build() {
        company.randomIfNull();
        return company.asString();
    }


    public static class Company implements Serializable, Field, Randomize {

        private static final Map<String, List<String>> MAP;
        private static final long serialVersionUID = -5271600656300216514L;

        private Country country;
        private String name;

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        static {
            MAP = YamlUtil.load("company.yml");
        }

        @Override
        public String asString() {
            return this.getName();
        }

        @Override
        public void randomIfNull() {
            // 国家随机
            if (country == null) {
                country = RandomUtil.choice(Country.values());
            }
            // 从国家所属公司列表中随机选一个
            this.name = RandomUtil.choice(MAP.get(this.country.getShortName()));
        }
    }
}
