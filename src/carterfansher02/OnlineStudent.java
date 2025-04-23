package carterfansher02;

public class OnlineStudent extends StudentFees {
    public int noOfMonths;
    public static final double MONTHLY_FEE = 300.0;

    public OnlineStudent(String id, String name, boolean enrolled, int noOfMonths) {
        super(id, name, enrolled);
        this.noOfMonths = noOfMonths;
    }

    public double getPayableAmount() {
        if (!enrolled) return 0.0;
        return noOfMonths * MONTHLY_FEE;
    }
}
