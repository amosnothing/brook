package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.bank.BankCardType;
import cn.nothinghere.brook.value.bank.CityBank;
import cn.nothinghere.brook.value.bank.StateBank;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankCardBuilderTest extends BaseTest {

    @Test
    public void testWithBankCode() {
        String bankCardNo;
        for (int i = 0; i < LOOP; i++) {
            StateBank[] stateBanks = StateBank.values();
            for (StateBank stateBank : stateBanks) {
                bankCardNo = BankCardBuilder.of().withBank(stateBank).build();
                assertThat(bankCardNo).matches("\\d+");
            }
            CityBank[] cityBanks = CityBank.values();
            for (CityBank cityBank : cityBanks) {
                bankCardNo = BankCardBuilder.of().withBank(cityBank).build();
                assertThat(bankCardNo).matches("\\d+");
            }
        }
    }

    @Test
    public void testWithCardType() {
        String bankCardNo;
        for (int i = 0; i < LOOP; i++) {
            bankCardNo = BankCardBuilder.of().withType(BankCardType.DC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withType(BankCardType.CC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withType(BankCardType.PC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withType(BankCardType.SCC).build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }

    @Test
    public void testWithLength() {
        String bankCardNo;
        int len16 = 16;
        int len17 = 17;
        int len18 = 18;
        int len19 = 19;
        for (int i = 0; i < LOOP; i++) {
            bankCardNo = BankCardBuilder.of().withLength(len16).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len16);
            bankCardNo = BankCardBuilder.of().withLength(len17).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len17);
            bankCardNo = BankCardBuilder.of().withLength(len18).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len18);
            bankCardNo = BankCardBuilder.of().withLength(len19).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len19);
            bankCardNo = BankCardBuilder.of().withType(BankCardType.DC).withLength(len16).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len16);
            bankCardNo = BankCardBuilder.of().withType(BankCardType.DC).withLength(len17).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len17);
            bankCardNo = BankCardBuilder.of().withType(BankCardType.DC).withLength(len18).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len18);
            bankCardNo = BankCardBuilder.of().withType(BankCardType.DC).withLength(len19).build();
            assertThat(bankCardNo).matches("\\d+");
            assertThat(bankCardNo).hasSize(len19);
        }
    }

    @Test
    public void testBuild() {
        String bankCardNo;
        for (int i = 0; i < LOOP; i++) {
            bankCardNo = BankCardBuilder.of().withBank(CityBank.XMBANK)
                .withType(BankCardType.DC)
                .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withBank(CityBank.XMCCB)
                .withType(BankCardType.DC)
                .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withBank(CityBank.BOD)
                .withType(BankCardType.CC)
                .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = BankCardBuilder.of().withBank(CityBank.YXCCB)
                .withType(BankCardType.CC)
                .build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }

    @Test
    public void testWithoutParam() {
        String bankCardNo;
        for (int i = 0; i < LOOP; i++) {
            bankCardNo = BankCardBuilder.of().build();
            assertThat(bankCardNo).isNotBlank();
        }
    }
}