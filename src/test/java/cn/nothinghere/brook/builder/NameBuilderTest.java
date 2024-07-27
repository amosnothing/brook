package cn.nothinghere.brook.builder;

import java.security.SecureRandom;

import cn.nothinghere.brook.value.human.Gender;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameBuilderTest extends BaseTest {

    @Test(description = "不传入参数时")
    public void testBuild() {
        String name;
        for (int i = 0; i < LOOP; i++) {
            name = NameBuilder.of().build();
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "传入长度参数时")
    public void testBuildWithLength() {
        String name;
        for (int i = 0; i < LOOP; i++) {
            // 长度可选为 2 ~ 3
            int length =
                new SecureRandom().nextInt(2) + 2;
            // 男性
            name = NameBuilder.of().withLength(length)
                .withGender(Gender.MALE)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 女性
            name = NameBuilder.of().withLength(length)
                .withGender(Gender.FEMALE)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 性别不限
            name = NameBuilder.of().withLength(length)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "指定生成姓氏或者名字")
    public void testBuildWithPosition() {
        String name;
        for (int i = 0; i < LOOP; i++) {
            int length =
                new SecureRandom().nextInt(2) + 2;
            // 指定姓氏 + 长度
            name = NameBuilder.of().withLength(length)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 指定名字 + 长度
            name = NameBuilder.of().withLength(length)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 指定名字
            name = NameBuilder.of()
                .build();
            assertThat(name).matches("\\W+");
            // 指定姓氏
            name = NameBuilder.of()
                .build();
            assertThat(name).matches("\\W+");

            length =
                new SecureRandom().nextInt(3) + 2;
            // 全名 + 长度
            name = NameBuilder.of().withLength(length)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 全名
            name = NameBuilder.of()
                .build();
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "参数都传入的情况")
    public void testAllParameters() {
        String name;
        for (int i = 0; i < LOOP; i++) {
            int length = new SecureRandom().nextInt(3) + 2;
            // 男性 + 姓氏 + 长度
            name = NameBuilder.of().withLength(length)
                .withGender(Gender.MALE)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 女性 + 名字 + 长度
            name = NameBuilder.of().withLength(length)
                .withGender(Gender.FEMALE)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");

            length = new SecureRandom().nextInt(3) + 2;
            // 全名 + 长度 + 性别
            name = NameBuilder.of().withLength(length)
                .withGender(new SecureRandom().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE)
                .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");

            name = NameBuilder.of().withLength(2)
                .withGender(Gender.UNKNOWN)
                .build();
            assertThat(name).hasSize(2);
            assertThat(name).matches("\\W+");
        }
    }

    @Test(enabled = false)
    public void testException() {

        // 长度<=0时 IllegalArgumentException
        assertThatIllegalArgumentException().isThrownBy(
            () -> NameBuilder.of().withLength(0));
        // 长度超过最大长度
        assertThatIllegalArgumentException().isThrownBy(
            () -> NameBuilder.of().withLength(5));
        // 不传入性别 只传入长度=3 无异常
        assertThatCode(() -> NameBuilder.of().withLength(3).build()).doesNotThrowAnyException();

        assertThatIllegalArgumentException().isThrownBy(
            () -> NameBuilder.of().withLength(3).build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
            () -> NameBuilder.of().build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
            () -> NameBuilder.of().withGender("123").build()
        );
    }
}