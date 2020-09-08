package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.value.Operator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;


public class PhoneBuilderTest {
    private final int loop = 10000;

    @Test
    public void testWithOperator() {
        for (int i = 0; i < loop; i++) {
            String phone = Factory.phoneBuilder().withOperator(Operator.CMCC).build();
            System.out.println(phone);
            Assertions.assertThat(phone.length()).isEqualTo(11);
            phone = Factory.phoneBuilder().withOperator(Operator.CUCC).build();
            System.out.println(phone);
            Assertions.assertThat(phone.length()).isEqualTo(11);
            phone = Factory.phoneBuilder().withOperator(Operator.CTCC).build();
            System.out.println(phone);
            Assertions.assertThat(phone.length()).isEqualTo(11);

        }
    }

    @Test
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            String phone = Factory.phoneBuilder().build();
            Assertions.assertThat(phone.length()).isEqualTo(11);
            phone = Factory.phoneBuilder().build();
            Assertions.assertThat(phone.length()).isEqualTo(11);
            phone = Factory.phoneBuilder().build();
            Assertions.assertThat(phone.length()).isEqualTo(11);
        }
    }

}