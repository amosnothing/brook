package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.occupation.MajorType;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class OccupationBuilderTest extends BaseTest {

    @Test
    public void testBuild() {
        for (int i = 0; i < LOOP; i++) {
            String build = DataFactory.occupationBuilder().build();
            Assertions.assertThat(build).isNotNull();
        }
    }

    @Test
    public void testBuildWithType() {
        for (int i = 0; i < LOOP; i++) {
            for (MajorType majorType : MajorType.values()) {
                String build = DataFactory.occupationBuilder()
                        .withType(majorType)
                        .build();
                Assertions.assertThat(build).isNotNull();
            }
        }

    }
}