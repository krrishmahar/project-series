package app.Features;

import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.ToDoList;

import java.util.Scanner;

public class Display extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println();
        System.out.println("Enter the task ID to display: ");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void execute(String index) {
        int taskId;
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        taskId = Integer.parseInt(index);
        Task task = ToDoList.tasks.get(index);
        if (task != null){
            System.out.println("ID: " + task.getId() + ", Description: " + task.getDescription() + ", Due Date: "
                    + SortByDATE.convertDateToString(task.getDueDate(), "dd-MM-yyyy") + ", Status: "
                    + task.getStatus() + "Task type: " + task.getTaskType());
            System.out.println("Sub-task: ");
            // Split the subtasks string by '\n' and print each subtask
            String[] subTasksArray = task.getSubTasks().split("|");
            for (String subTask : subTasksArray) {
                System.out.println("- " + subTask);
            }
        }else {
            System.out.println("Task ID " + taskId + " not found.");
        }
    }
}
