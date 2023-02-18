import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
import java.lang.String;

public class Main {
    protected static List<String> listOperation, listProduct;
    protected static List<String> listBasket = new ArrayList<>();//создаем корзину;
    protected static Scanner scanner = new Scanner(System.in);

    public static void addProductBasket() {
        Iterator<String> iteratorProduct = listProduct.iterator();
        System.out.println("Укажите номер товара или введите stop:");
        while (iteratorProduct.hasNext()) {
            String s = iteratorProduct.next();
            System.out.println(listProduct.indexOf(s) + 1 +". " + s);
        }
        System.out.print("Какую покупку хотите добавить? ");
        System.out.println("...или введите stop");
    }

    public static void showBasket() {
        Iterator<String> iteratorBasked = listBasket.iterator();
        System.out.println("Список покупок: ");
        while (iteratorBasked.hasNext()) {
            String s = iteratorBasked.next();
            System.out.println(listBasket.indexOf(s) + 1 +". " + s);
        }
    }

    public static void deleteProduct() {
        System.out.println("Какую хотите удалить? Введите номер или название: ");
        String choice = scanner.nextLine();
        if (listBasket.contains(choice)) {
            System.out.println("Покупка " + choice + " была удалена");
            listBasket.remove(choice);
            showBasket();
        } else {//может быть был введен номер?
            try {
                int num = Integer.parseInt(choice);
                System.out.println("Покупка " + listBasket.get(num - 1) + " была удалена");
                listBasket.remove(num - 1);
                showBasket();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Указанный продукт " + choice + " не найден!");
            }
        }
    }

    public static void findProduct() {
        System.out.println("Введите текст для поиска: ");
        String choice = scanner.nextLine();
        System.out.println("Найдено: ");
        for (int i = 0; i < listBasket.size(); i++) {
            if (listBasket.get(i).toLowerCase().contains(choice.toLowerCase())) {
                System.out.println(listBasket.indexOf(listBasket.get(i)) + 1 + ". " +listBasket.get(i));
            }
        }
    }
    public static void main(String[] args) {
        listOperation = new ArrayList<>();
        listOperation.add("Добавить товар");
        listOperation.add("Показать корзину");
        listOperation.add("Удалить товар из корзины");
        listOperation.add("Поиск покупок по ключевым словам");
        listProduct = new ArrayList<>();
        listProduct.add("Молоко");
        listProduct.add("Хлеб");
        listProduct.add("Сыр");
        listProduct.add("Хлебные сушки");
        listProduct.add("Бургер \"Родной хлебушек\"");
        System.out.println("Добро пожаловать в наш магазин \"Азбука просрочки\"!");
        System.out.println("Для управления своей корзиной вы можете выбрать одну из операций:");
        for (String s : listOperation) {
            System.out.println(listOperation.indexOf(s) + 1 +". " + s);
        }
        System.out.println("end - для выхода из программы");
        while (true) {
            System.out.print("Выберите операцию или введите end: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case ("1"):
                    while (true) {
                        addProductBasket();
                        choice = scanner.nextLine();
                        if (choice.equals("stop")) break;
                        try {
                            if (listBasket.contains(listProduct.get(Integer.parseInt(choice) - 1))) {
                                System.out.println("Такой товар уже выбран!");
                            } else {
                                listBasket.add(listProduct.get(Integer.parseInt(choice) - 1));
                            }
                        } catch (IndexOutOfBoundsException | NumberFormatException e) {
                            System.out.println("Такого товара нет в списке!");
                        }
                    }
                    break;
                case ("2"):
                    showBasket();
                    break;
                case ("3"):
                    showBasket();
                    deleteProduct();
                    break;
                case ("4"):
                    findProduct();
                    break;
                default:
                    break;
            }
            if (choice.equals("end")) break;
        }
        System.out.println("Программа завершена!");
    }
}