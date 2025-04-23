package carterfansher02;

public class GraduateStudent extends StudentFees {
    public int coursesEnrolled;
    public boolean isGraduateAssistant;
    public String graduateAssistantType;
    public static final int CREDITS_PER_COURSE = 3;
    public static final double PER_CREDIT_FEE = 500.0;
    public static final double ADDITIONAL_FEE = 250.0;

    public GraduateStudent(String id, String name, boolean enrolled, int coursesEnrolled, boolean isGraduateAssistant, String assistantType) {
        super(id, name, enrolled);
        this.coursesEnrolled = coursesEnrolled;
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = assistantType;
    }

    public double getPayableAmount() {
        if (!enrolled) return 0.0;
        double tuition = coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE;
        if (isGraduateAssistant) {
            if (graduateAssistantType.equals("full")) tuition = 0.0;
            else if (graduateAssistantType.equals("half")) tuition = tuition / 2;
        }
        return tuition + ADDITIONAL_FEE;
    }
}
