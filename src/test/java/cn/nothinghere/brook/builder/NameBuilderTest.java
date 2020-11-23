package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.human.Gender;
import org.testng.annotations.Test;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.*;

public class NameBuilderTest {

    private String name = null;
    private final int loop = 10000;

    @Test(description = "不传入参数时")
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            name = DataFactory.nameBuilder().build();
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
            name = DataFactory.nameBuilder().withLength(length)
                    .withGender(Gender.MALE)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 女性
            name = DataFactory.nameBuilder().withLength(length)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 性别不限
            name = DataFactory.nameBuilder().withLength(length)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "指定生成姓氏或者名字")
    public void testBuildWithPosition() {

        for (int i = 0; i < loop; i++) {
            int length =
                    new SecureRandom().nextInt(2) + 2;
            // 指定姓氏 + 长度
            name = DataFactory.nameBuilder().withLength(length)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 指定名字 + 长度
            name = DataFactory.nameBuilder().withLength(length)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 指定名字
            name = DataFactory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");
            // 指定姓氏
            name = DataFactory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");

            length =
                    new SecureRandom().nextInt(3) + 2;
            // 全名 + 长度
            name = DataFactory.nameBuilder().withLength(length)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 全名
            name = DataFactory.nameBuilder()
                    .build();
            assertThat(name).matches("\\W+");
        }
    }

    @Test(description = "参数都传入的情况")
    public void testAllParameters() {
        for (int i = 0; i < loop; i++) {
            int length =
                    new SecureRandom().nextInt(3) + 2;
            // 男性 + 姓氏 + 长度
            name = DataFactory.nameBuilder().withLength(length)
                    .withGender(Gender.MALE)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");
            // 女性 + 名字 + 长度
            name = DataFactory.nameBuilder().withLength(length)
                    .withGender(Gender.FEMALE)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");

            length = new SecureRandom().nextInt(3) + 2;
            // 全名 + 长度 + 性别
            name = DataFactory.nameBuilder().withLength(length)
                    .withGender(new SecureRandom().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE)
                    .build();
            assertThat(name).hasSize(length);
            assertThat(name).matches("\\W+");

            name = DataFactory.nameBuilder().withLength(2)
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
                () -> DataFactory.nameBuilder().withLength(0));
        // 长度超过最大长度
        assertThatIllegalArgumentException().isThrownBy(
                () -> DataFactory.nameBuilder().withLength(5));
        // 不传入性别 只传入长度=3 无异常
        assertThatCode(() -> DataFactory.nameBuilder().withLength(3).build()).doesNotThrowAnyException();

        assertThatIllegalArgumentException().isThrownBy(
                () -> DataFactory.nameBuilder().withLength(3).build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
                () -> DataFactory.nameBuilder().build()
        );
        // 入参不符合枚举值
        assertThatIllegalArgumentException().isThrownBy(
                () -> DataFactory.nameBuilder().withGender("123").build()
        );
    }
}