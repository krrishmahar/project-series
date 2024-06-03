package app.Features;

import app.Features.Task.BuildTask;
import app.Features.Task.QuickTask;
import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.DATABASE.Database;

import java.util.Scanner;
public class AddTask extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println("");
        System.out.println("To add a new task, please follow the instructions(typo) below and press ENTER:");
        System.out.println("Add Id, Description, Due_date('MM-dd'), Task_type and Sub_Task(optional).");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {

        while (true){
            System.out.println("");
            System.out.println("Enter Information:\n");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")){
                String[] parts = userInput.split(",");
                if (parts.length >= 4){
                    //adding CHECKS:
                    if (SortByDATE.isValid("MM-dd", parts[2])){
                        if (Database.tasks.get(parts[0] == null)){
                            return userInput;
                        }else {
                            System.out.println("A task with this ID already exists, try again :( ");
                        }
                    }else {
                        System.out.println("The date entered is invalid, try again :( ");
                    }
                }else {
                    System.out.println("Please follow instructions, try again :( ");
                }
            }else {
                return userInput;
            }
        }
    }

    @Override
    public void execute(String command) {
        String[] parts = command.split(",");
        String id = parts[0];
        String description = parts[1];
        String dueDate = parts[2];
        String taskType = parts[3];
        String[] subTasks = parts.length > 4 ? parts[4].split("\n") : new String[0];

        Task task;
        if (taskType.equalsIgnoreCase("quicktask")) {
            task = new QuickTask(Integer.parseInt(id), description, SortByDATE.parseDate("MM-dd", dueDate));
        } else if (taskType.equalsIgnoreCase("buildtask")) {
            task = new BuildTask(Integer.parseInt(id), description,SortByDATE.parseDate("MM-dd", dueDate), taskType, subTasks);
        } else {
            System.out.println("Invalid task type. Task not added.");
            return;
        }

        Database.tasks.put(id, task);
        System.out.println("Task successfully added!");
    }

}