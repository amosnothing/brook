package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.value.Gender;
import org.testng.annotations.Test;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameBuilderTest {

    private String name = null;
    private final int loop = 10000;

    @Test(description = "不传入参数时")
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            name = Factory.nameBuilder().build();
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "传入长度参数时")
    public void testBuildWithLength() {

        for (int i = 0; i < loop; i++) {
            // 长度可选为 2 ~ 3
            int length =
                    new SecureRandom().nextInt(2) + 2;
            // 男性
            name = Factory.nameBuilder().withLength(length)
                    .withGender(Gender.MALE)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 女性
            name = Factory.nameBuilder().withLength(length)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 性别不限
            name = Factory.nameBuilder().withLength(length)
                    .build();
            System.out.println(length);
            System.out.println(name);
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "指定生成姓氏或者名字")
    public void testBuildWithPosition() {

        for (int i = 0; i < loop; i++) {
            int length =
                    new SecureRandom().nextInt(2) + 2;
            // 指定姓氏 + 长度
            name = Factory.nameBuilder().withLength(length)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 指定名字 + 长度
            name = Factory.nameBuilder().withLength(length)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 指定名字
            name = Factory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");
            // 指定姓氏
            name = Factory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");

            length =
                    new SecureRandom().nextInt(3) + 2;
            // 全名 + 长度
            name = Factory.nameBuilder().withLength(length)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 全名
            name = Factory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "参数都传入的情况")
    public void testAllParameters() {
        for (int i = 0; i < loop; i++) {
            int length =
                    new SecureRandom().nextInt(2) + 2;
            // 男性 + 姓氏 + 长度
            name = Factory.nameBuilder().withLength(length)
                    .withGender(Gender.MALE)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            // 女性 + 名字 + 长度
            name = Factory.nameBuilder().withLength(length)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");

            length = new SecureRandom().nextInt(2) + 2;
            // 全名 + 长度 + 性别
            name = Factory.nameBuilder().withLength(length)
                    .withGender(new SecureRandom().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE)
                    .build();
            assertThat(name.length()).isEqualTo(length);
            assertThat(name).matches("\\W+");
            name = Factory.nameBuilder().withLength(2)
                    .withGender(Gender.MALE)
                    .build();
            assertThat(name.length()).isEqualTo(2);
            assertThat(name).matches("\\W+");
        }
    }

    @Test(enabled = false)
    public void testException() {

        // 性别传入为null
        assertThatNullPointerException().isThrownBy(
                () -> Factory.nameBuilder()
        );
        // 长度<=0时 IllegalArgumentException
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().withLength(-1)
        );
        // 长度超过最大长度
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().withLength(5).build()
        );
        // 不传入位置和性别 只传入长度=3 无异常
        assertThatCode(() -> Factory.nameBuilder().withLength(3).build()).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().withLength(3).build()
        );
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().withLength(3).build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
                () -> Factory.nameBuilder().withGender("123").build()
        );
    }
}