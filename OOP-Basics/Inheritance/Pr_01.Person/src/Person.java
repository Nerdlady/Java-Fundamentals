public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if (age < 1){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
      final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",this.name,this.age));
        return stringBuilder.toString();

    }
}
