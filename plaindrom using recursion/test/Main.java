package test;
// help desk management system
//employee class
enum Category{
    software,hardware
}
class Employee{
    String fullName;
    int pointLevel;
    Category assignedCategory;

    public Employee(String fullName, int pointLevel, Category assignedCategory) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;

}
}
// Ticket Class
class Ticket {
    int id;
    String name;
    Category category;
    int point;
    String assignedEmployee = "";
    boolean isCompleted = false;

    public Ticket(int id, String name, Category category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }
}
// HelpDesk Class
class HelpDesk {
    Employee emp1, emp2;
    Ticket[] tickets = new Ticket[5];

    public void addEmployee(Employee e, int pos) {
        if (pos == 1) emp1 = e;
        else if (pos == 2) emp2 = e;
    }

    public void addTicket(Ticket t, int pos) {
        tickets[pos - 1] = t;
    }

    public void completeTicket(String employeeName, int ticketId) {
        Employee employee = (emp1 != null && emp1.fullName.equals(employeeName)) ? emp1 :
                            (emp2 != null && emp2.fullName.equals(employeeName)) ? emp2 : null;

        if (employee == null) return;

        for (Ticket t : tickets) {
            if (t != null && t.id == ticketId && !t.isCompleted) {
                if (employee.pointLevel >= t.point) {
                    t.isCompleted = true;
                    t.assignedEmployee = employeeName;
                    System.out.println("Ticket " + ticketId + " marked as completed by " + employeeName + ".");
                } else {
                    System.out.println("Ticket " + ticketId + " cannot be completed by " + employeeName + " (Insufficient points).");
                }
                return;
            }
        }
    }
    public int getWaitingTicketCount() {
        int count = 0;
        for (Ticket t : tickets) {
            if (t != null && !t.isCompleted) count++;
        }
        return count;
    }

    public int getCompletedTicketsTotalPoint() {
        int total = 0;
        for (Ticket t : tickets) {
            if (t != null && t.isCompleted) total += t.point;
        }
        return total;
    }
}


public class Main {
    public static void main(String[] args) {
        // Creating HelpDesk system
        HelpDesk helpDesk = new HelpDesk();

        // Adding Employees
        Employee alice = new Employee("Alice Brown", 5, Category.SOFTWARE);
        Employee bob = new Employee("Bob Smith", 8, Category.HARDWARE);
        
        helpDesk.addEmployee(alice, 1);
        helpDesk.addEmployee(bob, 2);

        // Adding Tickets
        Ticket t1 = new Ticket(101, "Software Bug", Category.SOFTWARE, 4);
        Ticket t2 = new Ticket(102, "Network Issue", Category.HARDWARE, 7);
        Ticket t3 = new Ticket(103, "System Crash", Category.HARDWARE, 10);
        Ticket t4 = new Ticket(104, "Printer Not Working", Category.HARDWARE, 3);
        Ticket t5 = new Ticket(105, "UI Bug", Category.SOFTWARE, 2);

        helpDesk.addTicket(t1, 1);
        helpDesk.addTicket(t2, 2);
        helpDesk.addTicket(t3, 3);
        helpDesk.addTicket(t4, 4);
        helpDesk.addTicket(t5, 5);

        // Completing Tickets
        helpDesk.completeTicket("Alice Brown", 101); // Success
        helpDesk.completeTicket("Bob Smith", 102);   // Success
        helpDesk.completeTicket("Alice Brown", 103); // Failed (Insufficient points)
        helpDesk.completeTicket("Bob Smith", 104);   // Success
        helpDesk.completeTicket("Alice Brown", 105); // Success

        // Output Queries
        System.out.println(helpDesk.getWaitingTicketCount()); // Expected Output: 2
        System.out.println(helpDesk.getCompletedTicketsTotalPoint()); // Expected Output: 16
    }
}

