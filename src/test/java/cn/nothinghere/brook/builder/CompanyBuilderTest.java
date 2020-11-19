package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.Country;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class CompanyBuilderTest {

    @Test
    public void testBuild() {

        for (int i = 0; i < 10000; i++) {
            String company1 = DataFactory.companyBuilder().build();
            String company2 = DataFactory.companyBuilder().withCountry(Country.AMERICA).build();
            String company3 = DataFactory.companyBuilder().withCountry(Country.CHINA).build();

            Assertions.assertThat(company1).isNotEmpty();
            Assertions.assertThat(company2).isNotEmpty();
            Assertions.assertThat(company3).isNotEmpty();
        }
    }
}