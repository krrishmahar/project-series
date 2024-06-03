package app.Features.Task;

public abstract class TaskManager {
    //features will be overridden further

    //CAPITALIZING letters for constant variable
    private static final int ADD_TASK = 1;
    private static final int EDIT_TASK = 2;
    private static final int REMOVE_TASK = 3;
    private static final int MARK_AS_COMPLETE = 4;
    private static final int DISPLAY = 5;
    private static final int DISPLAY_ALL = 6;
    private static final int SORT_BY_DATE = 7;
    private static final int SORT_BY_ID = 8;
    private static final int SAVE_TO_FILE = 9;
    private static final int READ_FILE = 10;
    private static final int EXIT = 11;
    /*  This method prints list of steps of task and basically implement the user guide in each action*/

    public abstract void showActionInfo();

/*  This method will  */
    public abstract String readInput();
    public abstract void execute(String command);
}
