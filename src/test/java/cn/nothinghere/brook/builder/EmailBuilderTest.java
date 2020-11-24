package cn.nothinghere.brook.builder;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 正则表达式从 https://tool.oschina.net/regex# 抄的
 */
public class EmailBuilderTest extends BaseTest {

    @Test
    public void testBuild() {
        for (int i = 0; i < LOOP; i++) {
            String email = DataFactory.emailBuilder().build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        }
    }

    @Test
    public void testWithName() {
        for (int i = 0; i < LOOP; i++) {
            String name = DataFactory.nameBuilder().build();
            String email = DataFactory.emailBuilder().withName(name).build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        }
    }
}