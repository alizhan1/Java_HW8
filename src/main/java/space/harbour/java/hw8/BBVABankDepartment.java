package space.harbour.java.hw8;

public class BBVABankDepartment extends BankDepartment {

    @Override
    public void update(myATM atm, String  message) {
        System.out.println("[BBVA Bank] ATM with id " + atm.hashCode() + " sent message: " + message);
    }
}
