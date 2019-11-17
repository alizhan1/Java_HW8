package space.harbour.java.hw8;

public class Container {

    private Denomination current;
    private Integer size = 0;
    private Denomination head;

    public class Denomination {

        private Integer bill;
        private Integer amount;
        public Denomination next;

        public Denomination(Integer bill, Integer amount) {
            this.bill = bill;
            this.amount = amount;
        }

        public Denomination() {}

        public Integer getAmount() {
            return this.amount;
        }

        public Integer getBill() {
            return this.bill;
        }

        public void setBill(Integer bill) {
            this.bill = bill;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }
    }

    public Container() {}

    public void add(Integer bill, Integer amount) {
        if (size == 0) {
            this.current = new Denomination(bill, amount);
            this.current.next = null;
            this.head = this.current;
            size++;
        }
        else {
            this.current.next = new Denomination(bill, amount);
            this.current = this.current.next;
            this.current.next = null;
            size++;
        }
    }

    public Integer size() {
        return size;
    }

    public Denomination getHead() {
        return head;
    }
}
