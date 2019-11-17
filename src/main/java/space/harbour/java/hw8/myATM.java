package space.harbour.java.hw8;

public class myATM implements ATM {

    public Container myATMContainer = new Container();

    @Override
    public boolean withdraw(Integer cash) {
        Container.Denomination currentDenomination = myATMContainer.getHead();
        if (cash % 5 == 0) {
            while (currentDenomination != null && currentDenomination.getAmount() != 0) {
                if (cash % currentDenomination.getBill() == 0 && currentDenomination.getAmount() != 0) {
                    currentDenomination.setAmount(currentDenomination.getAmount() - 1);
                    continue;
                }
                else {
                    currentDenomination = currentDenomination.next;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Integer remainingBalance() {
        Integer totalBalance = 0;
        Container.Denomination currDenomination = myATMContainer.getHead();
        while (currDenomination != null) {
            totalBalance += currDenomination.getAmount()*currDenomination.getBill();
            currDenomination = currDenomination.next;
        }
        return totalBalance;
    }
    
    public void addBanknotesIntoATM(Integer bill, Integer amount) {
        myATMContainer.add(bill, amount);
    }
}
