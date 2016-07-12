import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentInfo = reader.readLine().split("\\s+");
        String[] workerInfo = reader.readLine().split("\\s+");
        try {
            Student student = new Student(studentInfo[0],studentInfo[1],studentInfo[2]);
            Worker worker = new Worker(workerInfo[0],workerInfo[1],Double.parseDouble(workerInfo[2]),Integer.parseInt(workerInfo[3]));
            System.out.println(student.toString());
            System.out.println();
            System.out.println(worker.toString());
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
