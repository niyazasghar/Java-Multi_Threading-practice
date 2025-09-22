package F07_Lembda_Expression;

public class Test {
    public static void main(String[] args) {

        //(Runnable) --- this is the functional interface ,implementation of run (method) of this interface can also
        // be done using Lambda expression
        Runnable task= new Runnable() {
            @Override
            public void run() {
                System.out.println("hello World");
            }
        };
        Thread thread= new Thread(task);
        thread.start();

        // Labmda expression implementation
        Runnable task2 = () -> {
            System.out.println("hello World");
        };
        Thread thread2= new Thread(task2);
        thread2.start();

        // for engineering student another class(engineeringStudent){where method of the interface is implemented} is created and its object is created and then method is called
        EngineeringStudent engineeringStudent= new EngineeringStudent();
        String str= engineeringStudent.getName();
        System.out.println(str);

        // similar thing can be done without explicitely creating another class for the Medical Student
        // using Anonymous class implementation this can be done as below
        Student MedicalStudent= new Student(){
            @Override
            public String getName(){
                return name+" is a medical Student";
            }
        };
        System.out.println(MedicalStudent.getName());


        // but this class(Student) is a Functional Interface, so its method can also be implemented using lambda
        // expression , so see lambda for law student
        Student LawStudent = () -> {
                return Student.name +" is a Law Student";
        };
        System.out.println(LawStudent.getName());

        Student ArtStudent= () ->{
            return Student.name + "this is the Atrs Student";
        };
        System.out.println(ArtStudent.getName());
    }
}
