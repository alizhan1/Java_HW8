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
        bankATM.addBanknotesIntoATM(5, 10);
        bankATM.addBanknotesIntoATM(10, 10);
        bankATM.addBanknotesIntoATM(20, 10);
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
        Assertions.assertEquals(bankATM.remainingBalance(), 350);
        bankATM.withdraw(50);
        Assertions.assertEquals(bankATM.remainingBalance(), 300);
    }

}