package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.Operator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class PhoneBuilderTest extends BaseTest{

    @Test
    public void testWithOperator() {
        for (int i = 0; i < LOOP; i++) {
            String phone = PhoneBuilder.of().withOperator(Operator.CMCC).build();
            Assertions.assertThat(phone).hasSize(11);
            phone = PhoneBuilder.of().withOperator(Operator.CUCC).build();
            Assertions.assertThat(phone).hasSize(11);
            phone = PhoneBuilder.of().withOperator(Operator.CTCC).build();
            Assertions.assertThat(phone).hasSize(11);

        }
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < LOOP; i++) {
            String phone = PhoneBuilder.of().build();
            Assertions.assertThat(phone).hasSize(11);
            phone = PhoneBuilder.of().build();
            Assertions.assertThat(phone).hasSize(11);
            phone = PhoneBuilder.of().build();
            Assertions.assertThat(phone).hasSize(11);
        }
    }

}