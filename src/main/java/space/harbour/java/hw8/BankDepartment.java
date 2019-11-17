package space.harbour.java.hw8;

import java.util.HashMap;
import java.util.Map;

public abstract class BankDepartment {

    public static Map<String, myATM> prototypes = new HashMap<>(){{
        put("CaixaATM", new CaixaBankATM());
        put("BBVAATM", new BBVABankATM());
    }};

    public static myATM getPrototype(String type) {
        return prototypes.get(type).clone();
    }

    public void update(myATM atm, String message) {}
}
