package space.harbour.java.hw8;

class CaixaBankATM extends myATM {
    public static final String NAME = "CaixaBankATM";

    @Override
    public myATM clone() {
        return new CaixaBankATM();
    }

    @Override
    public String toString() {
        return NAME;
    }
}
