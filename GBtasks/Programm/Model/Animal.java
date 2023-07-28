package Model;

import java.util.ArrayList;

public class Animal {
    private String name;
    private String animalType;
    private ArrayList<String> commands;

    public Animal(String name, String animalType, ArrayList<String> commands) {
        this.name = name;
        this.animalType = animalType;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void trainAnimal(ArrayList<String> newCommands) {
        commands.addAll(newCommands);
    }
}

