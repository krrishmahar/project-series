package app;

import app.Sorting.SortByDATE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Task {

    private static int counter = 0;
    private int starCount = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;
    private String subTasks;

    //Initiating the constructor/task
//    public Task() {
//        this.id = counter++;
//        this.status = false;
//    }


    public Task() {
        this.starCount = starCount;
        this.id = counter++;
        this.description = description;
        this.status = false;
        this.dueDate = dueDate;
        this.taskType = taskType;
        this.subTasks = subTasks;
    }

    //start-point
    public void incrementStarCount(){
        this.starCount++;
    }
    public int getStarCount() {
        return starCount;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setStatus(String status) {
        if (status.equalsIgnoreCase("completed")){
            this.status = true;
        }else {
            this.status = false;
        }
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    //changing the default toString
    @Override
    public String toString() {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

//        return id + ". " + description + "[" + df.format(dueDate) + "]" + (taskType != null ? "[" + taskType + "]" : "")
//                + (status ? "complete" : "");

        return id + "," + description + "," + SortByDATE.convertDateToString(dueDate, "dd-MM-yyyy") + "," + taskType + "," + subTasks;


    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        if (status){
            return "completed";
        }else return "incomplete";
    }

    public String getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(String subTasks) {
        this.subTasks = subTasks;
    }
}