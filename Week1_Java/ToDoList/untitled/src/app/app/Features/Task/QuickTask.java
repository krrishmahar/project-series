package app.Features.Task;

import app.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class QuickTask extends Task implements TaskInterface {

    private static int counter = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;

    //Initiating the first quick start
    public QuickTask(String description) {
        super();
        this.id = ++counter;
        this.description = description;
        this.status = false;
    }

    public QuickTask(int id, String description, LocalDate dueDate) {
        this.id = ++counter;
        this.description = description;
        this.dueDate = dueDate;
        this.status = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean status() {
        return status;
    }

    @Override
    public void markAsComplete() {
        this.status = true;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd");

        return id + ". " + description + (status ? " [complete]" : "" + "\t\t\t"+ df.format(dueDate));
    }



    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public LocalDate dueDate() {
        return dueDate;
    }


    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void setTaskType(String taskType) {
        this.taskType = "quick";
    } //we are not going to take much details for a QuickTask

}
