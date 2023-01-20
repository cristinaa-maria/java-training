package clean.code.design_patterns.requirements.Builder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        System.out.println("How many tasks do you want to add?");
        Scanner numbers = new Scanner(System.in);
        int maxNumberOfTasks = numbers.nextInt();
        todolist todayList = new todolist();

      do {
          System.out.println("Add a task: ");
          Scanner scan = new Scanner(System.in);
          String text = scan.nextLine();
          boolean taskStatus = false;
          System.out.println("Is it important? T/F");
          Scanner importance = new Scanner(System.in);
          boolean taskImportance = importance.nextBoolean();
          System.out.println("Do you want to add a due date? If yes, add a day. If no, type no");
          String taskDueDate;
          Scanner due = new Scanner(System.in);
          String dueDate = due.nextLine();
          if(!dueDate.equals("no")) {
              taskDueDate = dueDate;
          }
          else { taskDueDate = null;}
          Task t = new Task.TaskBuilder(text, taskStatus).setPriority(taskImportance).setDueDate(taskDueDate).build();
          todayList.addTask(t);
          System.out.println("Did you already completed the task? T/F");
          Scanner changeStatus = new Scanner(System.in);
          boolean newStatus = changeStatus.nextBoolean();
          if(newStatus) todayList.changeCompleteStatus(i, newStatus);
          i++;
      }while(i < maxNumberOfTasks);

        todayList.display();

    }
}