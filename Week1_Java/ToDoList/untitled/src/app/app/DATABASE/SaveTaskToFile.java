package app.DATABASE;

import app.Features.Task.TaskManager;
import app.ToDoList;

import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class SaveTaskToFile extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println("");
        System.out.println("Please enter path to file:");

        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println();
            System.out.print("path:");

            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            return userInput;
        }
    }

    @Override
    public void execute(String path) {
        List<String> lines = ToDoList.tasks.entrySet().stream()
                .map(entry -> entry.getValue().toString())
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(path), lines);
            System.out.println("Tasks successfully saved to file: " + path);
        } catch (Exception e) {
            System.out.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }



}
