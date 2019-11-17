package space.harbour.java.hw8;

import java.util.ArrayList;
import java.util.List;

public class myATM implements ATM {

    List<BankDepartment> observers = new ArrayList<>();

    public Container myATMContainer = new Container();

    @Override
    public boolean withdraw(Integer cash) {
        Container.Denomination currentDenomination = myATMContainer.getHead();
        Integer currentCash = cash;
        if (cash % 5 == 0) {
            while (currentDenomination != null) {
                if (currentCash - currentDenomination.getBill() >= 0 && currentDenomination.getAmount() != 0) {
                    currentDenomination.setAmount(currentDenomination.getAmount() - 1);
                    currentCash -= currentDenomination.getBill();
                    continue;
                }
                else if (currentDenomination.getAmount() == 0) {
                    for (BankDepartment bd : observers) {
                        bd.update(this, constructMessage(currentDenomination.getBill()));
                    }
                    currentDenomination = currentDenomination.next;
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

    public String constructMessage(Integer bill) {
        return "no bills/banknotes left in " + bill.toString() + " euros container";
    }
    
    public void addBanknotesIntoATM(Integer bill, Integer amount) {
        myATMContainer.add(bill, amount);
    }

    public myATM clone() {
        return new myATM();
    }

    public void addObserver(BankDepartment bd) {
        observers.add(bd);
    }

}
