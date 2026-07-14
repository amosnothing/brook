package cn.nothinghere.brook.util;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomUtilsTest {

    @Test
    public void testChoiceDoesNotMutateSourceList() {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> snapshot = new ArrayList<>(source);

        List<Integer> result = RandomUtils.choice(source, 3);

        assertThat(result).hasSize(3);
        assertThat(source).containsExactlyElementsOf(snapshot);
    }

    @Test
    public void testNextIntRangeValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> RandomUtils.nextInt(3, 3));
        assertThatIllegalArgumentException().isThrownBy(() -> RandomUtils.nextInt(4, 3));
    }
}
