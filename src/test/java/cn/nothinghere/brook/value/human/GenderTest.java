package cn.nothinghere.brook.value.human;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenderTest {

    @Test
    public void testFromName() {
        assertThat(Gender.fromName("male")).isEqualTo(Gender.MALE);
        assertThat(Gender.fromName("FEMALE")).isEqualTo(Gender.FEMALE);
        assertThat(Gender.fromName("男")).isEqualTo(Gender.MALE);
        assertThat(Gender.fromName("女")).isEqualTo(Gender.FEMALE);
        assertThat(Gender.fromName(null)).isEqualTo(Gender.UNKNOWN);
        assertThat(Gender.fromName("other")).isEqualTo(Gender.UNKNOWN);
    }
}
