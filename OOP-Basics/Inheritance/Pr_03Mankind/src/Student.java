public class Student extends Human {
    private String facultyNNumber;

    public Student(String firstName, String lastName,String facultyNNumber) {
        super(firstName, lastName);
        this.setFacultyNNumber(facultyNNumber);
    }


    public String getFacultyNNumber() {
        return facultyNNumber;
    }

    public void setFacultyNNumber(String facultyNNumber) {
        if (facultyNNumber.length() < 5 || facultyNNumber.length() > 10 ){
            throw new IllegalArgumentException("Invalid faculty number!");
        }


        this.facultyNNumber = facultyNNumber;
    }

    @Override
    public String toString() {
        return String.format("%sFaculty number: %s",super.toString(),this.facultyNNumber);
    }
}
