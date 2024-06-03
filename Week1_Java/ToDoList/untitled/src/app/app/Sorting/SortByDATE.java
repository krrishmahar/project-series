package app.Sorting;

import app.Features.Task.TaskManager;
import app.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class SortByDATE extends TaskManager {

    public static LocalDate parseDate(String pattern, String dueDate) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(dueDate, formatter);
        return localDate;
    }

    @Override
    public void showActionInfo() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void execute(String command) {
    List<Map.Entry<String, Task>> entries = new ArrayList<>();
    Collections.sort(entries, new Comparator<Map.Entry<String, Task>>() {
        @Override
        public int compare(Map.Entry<String, Task> task1, Map.Entry<String, Task> task2) {
            LocalDate dueDateFirstTask = task1.getValue().getDueDate();
            LocalDate dueDateSecondTask = task2.getValue().getDueDate();
            return dueDateFirstTask.compareTo(dueDateSecondTask);
        }
    });

    }


    /*isValid() will check the validity of String by creating a formatter of required pattern
    * meaning date(30th June) is converted into pattern(06-30) and localDate parse value into that pattern
    * and further changed into String datatype and check if it is valid by .equals()*/

    public static boolean isValid(String pattern, String value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate localDate =  LocalDate.parse(value, formatter);
            String result = localDate.format(formatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
             e.printStackTrace(); // just for testing purpose, remove later
             return false;
        }
    }

    /*changes Date into String*/
    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result;
        try {
            result = date.format(formatter);
        } catch (DateTimeParseException | IllegalArgumentException e) {
            return null;
        }
        return result;
    }

}