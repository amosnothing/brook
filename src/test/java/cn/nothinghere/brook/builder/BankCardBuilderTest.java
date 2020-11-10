package cn.nothinghere.brook.builder;

import cn.nothinghere.brook.value.Bin;
import cn.nothinghere.brook.value.CityBankCode;
import cn.nothinghere.brook.value.StateBankCode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankCardBuilderTest {

    private String bankCardNo = null;
    private final int loop = 10000;

    @Test
    public void testWithBankCode() {
        for (int i = 0; i < loop; i++) {
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.ABC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.BOC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.BOHAIB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.COMM).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.CCB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.CEB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.CIB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.CZBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.CITIC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.EGBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.GDB).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.HXBANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.ICBC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.PSBC).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.SPABANK).build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(StateBankCode.SPDB).build();
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
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(CityBankCode.XMBANK)
                    .withType(Bin.CardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(CityBankCode.XMCCB)
                    .withType(Bin.CardType.DC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(CityBankCode.BOD)
                    .withType(Bin.CardType.CC)
                    .build();
            assertThat(bankCardNo).matches("\\d+");
            bankCardNo = DataFactory.bankCardBuilder().withBankCode(CityBankCode.YXCCB)
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