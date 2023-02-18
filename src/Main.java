import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш магазин \"Азбука просрочки\"!");
        System.out.println("Для управления своей корзиной вы можете выбрать одну из операций:");
        System.out.println("1. Добавить товар");
        System.out.println("2. Показать корзину");
        System.out.println("3. Удалить товар из корзины");
        System.out.println("end - выйти из программы");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию:");
            String choice = scanner.nextLine();
            if (choice.equals("end")) break;
        }
        System.out.println("Программа завершена!");
    }
}