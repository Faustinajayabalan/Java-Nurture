class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class Exercise5_TaskManagement {

    static Task head = null;

    static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task added successfully.");
    }

    static void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found:");
                System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task not found.");
    }

    static void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task List is Empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task prev = head;
        Task curr = head.next;

        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Task deleted successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Task not found.");
    }

    static void displayTasks() {
        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        Task temp = head;

        while (temp != null) {
            System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.status);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        addTask(101, "Complete Java Assignment", "Pending");
        addTask(102, "Prepare Presentation", "In Progress");
        addTask(103, "Submit Project", "Completed");

        System.out.println("\nTask List:");
        displayTasks();

        System.out.println("\nSearching Task:");
        searchTask(102);

        System.out.println("\nDeleting Task:");
        deleteTask(101);

        System.out.println("\nFinal Task List:");
        displayTasks();
    }
}