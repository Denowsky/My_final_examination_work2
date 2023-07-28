package Functions;

import java.util.ArrayList;
import java.util.Scanner;
import Model.Animal;

public class Func {
    public static ArrayList<Animal> animals = new ArrayList<>();

    public static void createAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        try {
            if (name.equals("")) {
                throw new Exception("Пустое имя");
            }
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
                    throw new Exception("Неверный выбор");
            }
            ArrayList<String> commands = new ArrayList<>();
            System.out.println("Введите команды, которые животное умеет выполнять (введите '-', чтобы закончить):");
            String command = scanner.nextLine();
            while (!command.equals("-")) {
                command = scanner.nextLine();
                if (!command.equals("-")) {
                    commands.add(command);
                }
                if (commands.size() < 1) {
                    throw new Exception("Не введены команды");
                }
            }

            Animal animal = new Animal(name, animalType, commands);
            animals.add(animal);

            System.out.println("Запись животного успешно создана.");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void viewAllList() {
        if (animals.size() < 1) {
            System.out.println("Записей нет");
        } else {
            System.out.println("Список животных: ");
            int counter = 1;
            for (int i = 0; i < animals.size(); i++) {
                System.out.println(counter + ". " + animals.get(i).getName());
                counter++;
            }
        }
    }

    public static void viewAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите номер записи животного:");
        int index = scanner.nextInt();

        if (index >= 0 && index < animals.size() + 1) {
            Animal animal = animals.get(index - 1);
            System.out.println("Имя: " + animal.getName());
            System.out.println("Тип животного: " + animal.getAnimalType());
            System.out.println("Команды: " + animal.getCommands());
        } else {
            System.out.println("Запись не найдена.");
        }
    }

    public static void trainAnimal() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите номер записи животного:");
        int index = scanner.nextInt();

        if (index >= 0 && index < animals.size() + 1) {
            Animal animal = animals.get(index - 1);

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
