package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.Bin;
import cn.nothinghere.brook.value.CityBank;
import cn.nothinghere.brook.value.StateBank;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankCardBuilderTest {

    private String bankCardNo = null;
    private final int loop = 10000;

    @Test
    public void testWithBankCode() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.ABC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.BOC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.BOHAIB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.COMM).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.CCB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.CEB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.CIB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.CZBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.CITIC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.EGBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.GDB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.HXBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.ICBC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.PSBC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.SPABANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(StateBank.SPDB).build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }

    @Test
    public void testWithCardType() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withType(Bin.CardType.DC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(Bin.CardType.CC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(Bin.CardType.PC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withType(Bin.CardType.SCC).build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }
    

    @Test
    public void testBuild() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.XMBANK)
                    .withType(Bin.CardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.XMCCB)
                    .withType(Bin.CardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.BOD)
                    .withType(Bin.CardType.CC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBank(CityBank.YXCCB)
                    .withType(Bin.CardType.CC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
        }
    }

    @Test
    public void testWithoutParam(){
        for (int i = 0; i < loop; i++) {
            String bankCardNo = DataFactory.bankCardBuilder().build();
            assertThat(bankCardNo).isNotBlank();
        }

    }
}