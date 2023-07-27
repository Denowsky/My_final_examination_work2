import java.util.ArrayList;
import java.util.Scanner;

class Animal {
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

public class AnimalRegistry {
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int choice = 0;

        while (choice != 4) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Создать запись животного");
            System.out.println("2. Посмотреть запись животного по индексу");
            System.out.println("3. Обучить животное по индексу и добавить ему команды");
            System.out.println("4. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAnimal();
                    break;
                case 2:
                    viewAnimal();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void createAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        String animalType = null;
        System.out.println("Выберите тип животного (1 - кошка, 2 - собака, 3 - хомяк):");
        int type = scanner.nextInt();
        switch (type) {
                        case 1:
                            animalType = "Кошка";
                            break;
                        case 2:
                            animalType = "Собака";
                            break;
                        case 3:
                            animalType = "Хомяк";
                            break;
                        default:
                            System.out.println("Неверный выбор");
                            break;
        }
        ArrayList<String> commands = new ArrayList<>();
        System.out.println("Введите команды, которые животное умеет выполнять (введите '-', чтобы закончить):");
        String command = scanner.nextLine();
        while (!command.equals("-")) {
            command = scanner.nextLine();
            if (!command.equals("-")) {
                commands.add(command);
            }
        }

        Animal animal = new Animal(name, animalType, commands);
        animals.add(animal);

        System.out.println("Запись животного успешно создана.");
    }

    private static void viewAllList(){
        int counter = 1;
        for (int i = 0; i < animals.size(); i++){
            
        }
    }

    private static void viewAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите индекс записи животного:");
        int index = scanner.nextInt();

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index-1);
            System.out.println("Имя: " + animal.getName());
            System.out.println("Тип животного: " + animal.getAnimalType());
            System.out.println("Команды: " + animal.getCommands());
        } else {
            System.out.println("Запись не найдена.");
        }
    }

    private static void trainAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите индекс записи животного:");
        int index = scanner.nextInt();

        if (index >= 0 && index < animals.size()) {
            Animal animal = animals.get(index);

            ArrayList<String> newCommands = new ArrayList<>();
            System.out.println("Введите новые команды для обучения животного (введите '-', чтобы закончить):");
            String command = scanner.nextLine();
            while (!command.equals("-")) {
                command = scanner.nextLine();
                if (!command.equals("-")) {
                    newCommands.add(command);
                }
            }

            animal.trainAnimal(newCommands);
            System.out.println("Животное успешно обучено и команды добавлены.");
        } else {
            System.out.println("Запись не найдена.");
        }
    }
}