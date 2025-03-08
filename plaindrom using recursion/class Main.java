class Teacher {
    String subject = "Mathematics";

    void teach() {
        System.out.println("Teaching " + subject);
    }
}

class Student extends Teacher {
    String name = "Rahul";

    void study() {
        System.out.println(name + " is studying " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.teach();  // Inherited from Teacher
        s.study();
    }
}