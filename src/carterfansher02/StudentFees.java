package carterfansher02;

public abstract class StudentFees {
    public String id;
    public String name;
    public boolean enrolled;

    public StudentFees(String id, String name, boolean enrolled) {
        this.id = id;
        this.name = name;
        this.enrolled = enrolled;
    }

    public abstract double getPayableAmount();
}
