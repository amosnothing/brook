package cn.nothinghere.factory.builder;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 正则表达式从 https://tool.oschina.net/regex# 抄的
 */
public class EmailBuilderTest {

    private final int loop = 10000;

    @Test
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            String email = Factory.emailBuilder().build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        }
    }

    @Test
    public void testWithName() {
        for (int i = 0; i < loop; i++) {
            String name = Factory.nameBuilder().build();
            String email = Factory.emailBuilder().withName(name).build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        }
    }
}