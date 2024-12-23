package tests;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;

import java.util.ArrayList;
import java.util.Scanner;


public class main_dz {

    // Enum for menu commands
    enum Command {
        ADD, LIST, EXIT
    }


    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите команду (add/list/exit): ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                Command command = Command.valueOf(input);

                switch (command) {
                    case ADD:
                        System.out.print("Какое животное? (cat/dog/duck): ");
                        String type = scanner.nextLine().trim().toLowerCase();

                        System.out.print("Введите имя: ");
                        String name = scanner.nextLine().trim();

                        System.out.print("Введите возраст: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());

                        System.out.print("Введите вес: ");
                        double weight = Double.parseDouble(scanner.nextLine().trim());

                        System.out.print("Введите цвет: ");
                        String color = scanner.nextLine().trim();

                        Animal animal;
                        switch (type) {
                            case "cat":
                                animal = new Cat(name, age, weight, color);
                                break;
                            case "dog":
                                animal = new Dog(name, age, weight, color);
                                break;
                            case "duck":
                                animal = new Duck(name, age, weight, color);
                                break;
                            default:
                                System.out.println("Неизвестное животное.");
                                continue;
                        }

                        animals.add(animal);
                        animal.say();
                        break;

                    case LIST:
                        if (animals.isEmpty()) {
                            System.out.println("Список животных пуст.");
                        } else {
                            for (Animal a : animals) {
                                System.out.println(a);
                            }
                        }
                        break;

                    case EXIT:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неизвестная команда.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

}






