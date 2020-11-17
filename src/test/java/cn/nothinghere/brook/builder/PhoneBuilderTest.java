package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.Operator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class PhoneBuilderTest {
    private final int loop = 10000;

    @Test
    public void testWithOperator() {
        for (int i = 0; i < loop; i++) {
            String phone = DataFactory.phoneBuilder().withOperator(Operator.CMCC).build();
            Assertions.assertThat(phone).hasSize(11);
            phone = DataFactory.phoneBuilder().withOperator(Operator.CUCC).build();
            Assertions.assertThat(phone).hasSize(11);
            phone = DataFactory.phoneBuilder().withOperator(Operator.CTCC).build();
            Assertions.assertThat(phone).hasSize(11);

        }
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            String phone = DataFactory.phoneBuilder().build();
            Assertions.assertThat(phone).hasSize(11);
            phone = DataFactory.phoneBuilder().build();
            Assertions.assertThat(phone).hasSize(11);
            phone = DataFactory.phoneBuilder().build();
            Assertions.assertThat(phone).hasSize(11);
        }
    }

}