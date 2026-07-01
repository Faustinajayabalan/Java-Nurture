class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println(employeeId + " | " + name + " | " + position + " | Rs." + salary);
    }
}

public class Exercise4_EmployeeManagement {
    static Employee[] employees = new Employee[10];
    static int count = 0;

    static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Array is full");
        }
    }

    static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                System.out.println("Employee deleted successfully");
                return;
            }
        }
        System.out.println("Employee not found");
    }

    static void displayEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(101, "Faustina", "Developer", 45000));
        addEmployee(new Employee(102, "Ramya", "Tester", 35000));
        addEmployee(new Employee(103, "John", "Manager", 60000));

        System.out.println("\nEmployee List:");
        displayEmployees();

        System.out.println();
        searchEmployee(102);

        System.out.println();
        deleteEmployee(101);

        System.out.println("\nFinal Employee List:");
        displayEmployees();
    }
}