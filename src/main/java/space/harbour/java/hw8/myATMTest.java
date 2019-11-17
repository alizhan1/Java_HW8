package space.harbour.java.hw8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class myATMTest {
    myATM bankATM;

    @BeforeEach
    public void setUp() {
        bankATM = new myATM();

//      As sorting in the container is not implemented
//      please add bills in descending order

        bankATM.addBanknotesIntoATM(20, 10);
        bankATM.addBanknotesIntoATM(10, 10);
        bankATM.addBanknotesIntoATM(5, 10);

//      Create instances of Caixa and BBVA Banks

        BankDepartment caixaBank = new CaixaBankDepartment();
        BankDepartment bbvaBank = new BBVABankDepartment();

        bankATM.addObserver(caixaBank);
        bankATM.addObserver(bbvaBank);
    }

    @AfterEach
    public void tearDown() {}

    @Test
    public void withdrawTest() {
        Assertions.assertTrue(bankATM.withdraw(25));
        Assertions.assertFalse(bankATM.withdraw(11));
    }

    @Test
    public void remainingBalanceTest() {
        Assertions.assertEquals(350, bankATM.remainingBalance());
        bankATM.withdraw(50);
        Assertions.assertEquals(300, bankATM.remainingBalance());
    }

    @Test
    public void observerTest() {
        bankATM.withdraw(210);
        System.out.println(bankATM.remainingBalance());
    }

}