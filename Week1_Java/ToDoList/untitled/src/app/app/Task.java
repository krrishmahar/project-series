package app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Task {

    private static int counter = 0;
    private static int starCount = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;

    //Initiating the constructor/task
    public Task() {
        this.id = counter++;
        this.status = false;
    }

    //start-point
    public static int getStarCount() {
        return starCount;
    }

    public static void setStarCount(int starCount) {
        Task.starCount = starCount;
    }



    //changing the default toString
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd");

        return id + ". " + description + "[" + df.format(dueDate) +"]" + (taskType != null ? "[" + taskType + "]" : "")
                + (status? "complete": "");

    }

    public LocalDate getDueDate() {
        return dueDate;
    }

//    public static Task buildTask(String id, LocalDate dueDate, String status, String projectName) {
//        Task task = new Task();
//
//        task.setId(id);
//        task.setTitle(title);
//        task.setDueDate(dueDate);
//        task.setStatus(status);
//        task.setProjectName(projectName);
//
//        return task;
//    }
}
