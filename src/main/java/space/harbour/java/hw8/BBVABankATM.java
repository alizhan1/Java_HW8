package space.harbour.java.hw8;

class BBVABankATM extends myATM{
    public static final String NAME = "BBVABankATM";

    @Override
    public myATM clone() {
        return new BBVABankATM();
    }

    @Override
    public String toString() {
        return NAME;
    }
}
