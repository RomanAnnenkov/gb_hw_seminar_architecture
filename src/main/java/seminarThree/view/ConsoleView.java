package seminarThree.view;

import seminarThree.model.exceptions.ExcersizeFactoryException;
import seminarThree.model.excersize.BaseExcersize;
import seminarThree.model.excersize.IExcersizeFactory;
import seminarThree.model.workout.Workout;

import java.util.Scanner;

public class ConsoleView implements IView {

    private Scanner scanner = new Scanner(System.in);

    private Workout workout;

    private IExcersizeFactory iExcersizeFactory;

    public ConsoleView(Workout workout, IExcersizeFactory iExcersizeFactory) {
        this.workout = workout;
        this.iExcersizeFactory = iExcersizeFactory;
    }

    @Override
    public void run() {
        System.out.println("Программа для тренировок");
        printInfo();
        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "add":
                    addExcersize();
                    break;
                case "rm":
                    rmExcersize();
                    break;
                case "list":
                    listExcersizes();
                    break;
                case "start":
                    startWorkout();
                    break;
                case "exit":
                    return;
                default:
                    printInfo();
            }

        }
    }

    private void listExcersizes() {
        for (BaseExcersize baseExcersize: workout.getExcersizeList()) {
            System.out.println(baseExcersize.getName());
        }
    }

    private void rmExcersize() {
        System.out.println("Введите порядковый номер упражнения: ");
        String input = scanner.nextLine();
        if (input.matches("\\d+")) {
            int num = Integer.parseInt(input);
            if (num <= workout.getExcersizeList().size()) {
                workout.removeExcersize(num - 1);
                System.out.println("Упражнение удалено.");
            }
        }
    }

    private void addExcersize() {
        System.out.print("Для добавления введите строку в формате '<название>' '<repeat|time>' '<число>'");
        String input = scanner.nextLine();
        try {
            workout.addExcersize(iExcersizeFactory.create(input));
        } catch (ExcersizeFactoryException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startWorkout() {
        workout.doExcersizes();
    }

    private void printInfo() {
        System.out.println("""
                add - добавить упражнение
                rm - удалить упражнение
                start - начать тренировку
                list - список упражнений
                exit - выход из программы
                """);
    }
}
