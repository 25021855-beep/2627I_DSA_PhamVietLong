import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}


//Complete the code
public class Main {
    static boolean dungtruoc(Student A, Student B) {
        if (A.getCgpa() != B.getCgpa()) {
            return A.getCgpa() > B.getCgpa();
        }
        int c = A.getFname().compareTo(B.getFname());
        if (c != 0) {
            return c < 0;
        }
        return A.getId() < B.getId();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = i + 1; j < studentList.size(); j++) {
                if ( dungtruoc(studentList.get(j),studentList.get(i))) {
                    Student tmp = studentList.get(i);
                    studentList.set(i, studentList.get(j));
                    studentList.set(j,tmp);
                }
            }
        }
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
