package app.Features.Task;
import app.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class BuildTask extends Task implements TaskInterface {

    private static int counter = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;
    private String[] sub_task;

    public BuildTask(String description, String[] sub_task) {
        super();
        this.id = ++counter;
        this.description = description;
        this.sub_task = sub_task;
        this.status = false;
    }

    public BuildTask(int id, String description, LocalDate dueDate, String taskType, String[] sub_task) {

        this.id = ++counter;
        this.description = description;
        this.status = false;
        this.dueDate = dueDate;
        this.taskType = taskType;
        this.sub_task = sub_task;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat( "MM/dd");

//        return id +"." + description + (status ? " [Complete] " : "") + "\t\t\t" + df.format(dueDate)+ "\nSteps: " + Arrays.toString(sub_task) ;


//        else use StringBuilder for complex stuff since it's more efficient.
        {
            StringBuilder sb = new StringBuilder();
            sb.append(id).append(". ").append(description).append(status ? " [complete]" : "").append("\t\t\t").append(df.format(dueDate)).append("\nSteps:");
            for (String step : sub_task) {
                sb.append("\n- ").append(step);
            }
            return sb.toString();
        }

    }

    @Override
    public LocalDate dueDate() {
        return dueDate;
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    //allowing editing in task desc
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setTaskType(String taskType) {
        this.taskType = "extra";
    }
    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    //special setter for completed task
    @Override
    public void markAsComplete() {
        this.status = true;
    }

    @Override
    public boolean status() {
        return true;
    }

}