package org.itstep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java. Lesson027. Task01
 * Command help, echo, now, exit (Без использования Pattern и Matcher)
 * Semenyuk Alexander
 * Date 19.10.2022
 * Завдання
 * Вдосконалити попереднье домашнє завдання з інтерфейсами
 * https://github.com/OOP-Java-DTU-Step-2020/practice-interface
 * за рахунок застосування анонімних класів замість конкретних класів команд.
 * Для цього необхідно в методі main() створити масив команд і реалізувати всі команди у вигляді анонімних класів.
 * Код повинен бути адаптивним щоб легко було додати нову команду.
 * Дивись приклад з заняття.
 */
public class Task01 {
    public static void main(String[] args) {
        // Без использования Pattern и Matcher
        abstract class Command {
            String command;

            abstract void execute(String... args);
        }

        Command[] commands = {
                new Command() {
                    {
                        command = "help";
                    }

                    @Override
                    public void execute(String... args) {
                        System.out.println("Help executed");
                    }
                },

                new Command() {
                    {
                        command = "echo";
                    }

                    @Override
                    public void execute(String... args) {
                        for (int i = 0; i < args.length; i++) {
                            if (!args[i].equals("echo")) {
                                if (i != args.length - 1) {
                                    System.out.print(args[i] + " ");
                                } else {
                                    System.out.print(args[i]);
                                }
                            }
                        }
                        System.out.println();
                    }
                },
                new Command() {
                    {
                        command = "now";
                    }

                    @Override
                    public void execute(String... args) {
                        System.out.println(System.currentTimeMillis());
                    }
                },
                new Command() {
                    {
                        command = "exit";
                    }

                    @Override
                    public void execute(String... args) {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                }
        };


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter operation: ");
            String line = scanner.nextLine();
            for (Command part : commands) {
                if (line.contains(part.command)) {
                    String[] array = line.split(" ");
                    part.execute(array);
                    break;
                }
            }

        }
    }
}
