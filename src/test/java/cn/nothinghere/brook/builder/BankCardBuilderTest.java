package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.bank.BankCardType;
import cn.nothinghere.brook.value.bank.CityBank;
import cn.nothinghere.brook.value.bank.StateBank;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankCardBuilderTest {

    private String bankCardNo = null;
    private final int loop = 10000;

    @Test
    public void testWithBankCode() {
        for (int i = 0; i < loop; i++) {
            StateBank[] stateBanks = StateBank.values();
            for (StateBank stateBank : stateBanks) {
                bankCardNo = DataFactory.bankCardBuilder().withBank(stateBank).build();
                assertThat(bankCardNo).matches("\\d+");
            }
            CityBank[] cityBanks = CityBank.values();
            for (CityBank cityBank : cityBanks) {
                bankCardNo = DataFactory.bankCardBuilder().withBank(cityBank).build();
                assertThat(bankCardNo).matches("\\d+");
            }
        }
    }

    @Test
    public void testWithCardType() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withType(BankCardType.DC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(BankCardType.CC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(BankCardType.PC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(BankCardType.SCC).build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }


    @Test
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.XMBANK)
                    .withType(BankCardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.XMCCB)
                    .withType(BankCardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.BOD)
                    .withType(BankCardType.CC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.YXCCB)
                    .withType(BankCardType.CC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }

    @Test
    public void testWithoutParam() {
        for (int i = 0; i < loop; i++) {
            String bankCardNo = DataFactory.bankCardBuilder().build();
            assertThat(bankCardNo).isNotBlank();
        }

    }
}