package carterfansher02;

public class UGStudent extends StudentFees {
    public boolean hasScholarship;
    public double scholarshipAmount;
    public int coursesEnrolled;
    public static final int CREDITS_PER_COURSE = 3;
    public static final double PER_CREDIT_FEE = 250.0;
    public static final double ADDITIONAL_FEE = 150.0;

    public UGStudent(String id, String name, boolean enrolled, int coursesEnrolled, boolean hasScholarship, double scholarshipAmount) {
        super(id, name, enrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
    }

    public double getPayableAmount() {
        if (!enrolled) return 0.0;
        double tuition = coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE;
        double total = tuition + ADDITIONAL_FEE;
        return hasScholarship ? total - scholarshipAmount : total;
    }
}
