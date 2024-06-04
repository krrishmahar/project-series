package app.Features;

import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.ToDoList;

public class DisplayAll extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println();
        System.out.println("Here are all the tasks: ");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void execute(String command) {
        ToDoList.tasks.forEach((key,task) -> {
            System.out.println("ID: " + key + ", Description: " + task.getDescription() + ", Due Date: "
                    + SortByDATE.convertDateToString(task.getDueDate(),"dd-MM-yyyy") + ", Status: "
                    + task.getStatus() + " Task type: " + task.getTaskType());
            System.out.println("Sub-task: ");

            // Split the subtasks string by '\n' and print each subtask
            String[] subTasksArray = task.getSubTasks().split("|");
            for (String subTask : subTasksArray) {
                System.out.println("- " + subTask);
            }
        });

        Task task = new Task();
        System.out.println("The Total Star Count is "+ task.getStarCount() +"⭐");
    }
}
