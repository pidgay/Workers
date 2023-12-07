package model;

public class Salesman extends Employee {
    private int commission;
    private int commissionLimit;
    public Salesman(
            String pesel, String name, String surname, String salary, String phone,
            String commission, String commissionLimit
    ){
        super(pesel, name, surname, salary, phone);
        this.commission = Integer.parseInt(commission);
        this.commissionLimit  = Integer.parseInt(commissionLimit);
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getCommissionLimit() {
        return commissionLimit;
    }

    public void setCommissionLimit(int commissionLimit) {
        this.commissionLimit = commissionLimit;
    }
}
