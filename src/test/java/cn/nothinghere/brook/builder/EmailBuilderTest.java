package cn.nothinghere.brook.builder;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 正则表达式从 <a href="https://tool.oschina.net/regex#">oschina</a> 抄的
 */
public class EmailBuilderTest extends BaseTest {

    @Test
    public void testBuild() {
        for (int i = 0; i < LOOP; i++) {
            String email = EmailBuilder.of().build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:\\w(?:[\\w-]*\\w)?\\.)+\\w(?:[\\w-]*\\w)?");
        }
    }

    @Test
    public void testWithName() {
        for (int i = 0; i < LOOP; i++) {
            String name = NameBuilder.of().build();
            String email = EmailBuilder.of().withName(name).build();
            assertThat(email).matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:\\w(?:[\\w-]*\\w)?\\.)+\\w(?:[\\w-]*\\w)?");
        }
    }
}