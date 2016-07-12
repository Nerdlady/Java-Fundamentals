public class Worker extends Human {
    private double weekSalary;
    private int workingHours;

    public Worker(String firstName, String lastName, double weekSalary, int workingHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkingHours(workingHours);
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        if (workingHours < 1 || workingHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }


    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        return String.format("%sWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",super.toString(),this.weekSalary,(double)this.workingHours,this.calculateSalatyPerHour());
    }

    private double calculateSalatyPerHour() {
        double daySalary = this.weekSalary / 7.0;
        return daySalary / this.workingHours;
    }
}
