import java.util.Scanner;
import Exception.Counter;
import Functions.Func;

public class AnimalRegistry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int choice = 0;
        try (Counter count = new Counter()) {
            while (choice != 5) {
                System.out.println("Выберите пункт меню:");
                System.out.println("1. Создать запись животного");
                System.out.println("2. Посмотреть все записи животных");
                System.out.println("3. Посмотреть запись животного по номеру в списке");
                System.out.println("4. Обучить животное по номеру в списке и добавить ему команды");
                System.out.println("5. Выход");
                choice = scanner.nextInt();
                if (count.getCount() != Func.animals.size()) {
                    count.setResourceClosed(true);
                }
                switch (choice) {
                    case 1:
                        count.add();
                        Func.createAnimal();
                        break;
                    case 2:
                        Func.viewAllList();
                        break;
                    case 3:
                        Func.viewAnimal();
                        break;
                    case 4:
                        Func.trainAnimal();
                        break;
                    case 5:
                        System.out.println("Выход из программы");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Неверный выбор");
                        break;
                }
            }
        }
    }
}
