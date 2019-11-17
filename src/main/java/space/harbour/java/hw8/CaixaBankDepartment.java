package space.harbour.java.hw8;

public class CaixaBankDepartment extends BankDepartment {

    @Override
    public void update(myATM atm, String  message) {
        System.out.println("[Caixa Bank] ATM with id " + atm.hashCode() + " sent message: " + message);
    }
}
