import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay(Scanner scanner){ //Заполнение статистики шагов
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        int month = scanner.nextInt();
        if (1 <= month && month <= 12) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            int day = scanner.nextInt();
            if (1 <= day && day <= 30) {
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                if (steps >= 0) {
                    MonthData monthData = monthToData[month - 1];
                    monthData.days[day - 1] = monthData.days[day - 1] + steps;
                } else {
                    System.out.println("Количество шагов не может быть отрицательным.\n" +
                            "Шаги назад всё равно считаются в плюс");
                }
            } else {
                System.out.println("Неверный ввод. Количество дней от 1 до 30 (включительно).");
            }
        } else {
            System.out.println("Неверный ввод. Количество месяцев от 1 до 12 (включительно)");
        }
    }

    void changeStepGoal(Scanner scanner){ //Изменение цели шагов на день
        System.out.println("Введите новую цель шагов на день");
        int stepAim = scanner.nextInt();
        if (stepAim == goalByStepsPerDay) {
            System.out.println("Данное значение цели шагов на день совпадает с установленным.");
        } else if (stepAim > 0) {
            goalByStepsPerDay = stepAim;
        } else {
            System.out.println("Неверное значение. Цель шагов на день должна быть больше ноля.");
        }
    }

    void printStatistic(){ //Печать статистики за определённый месяц
        System.out.println("Введите месяц от 1 до 12 (включительно)");
        int month = scanner.nextInt();
        if (1 <= month && month <= 12){
            MonthData monthData = monthToData[month - 1];
            int sumSteps = monthData.sumStepsFromMonth();
            for (int i = 0; i < monthData.days.length; i++){
               System.out.println("День "+ (i + 1) + ". Пройдено " + monthData.days[i] + " шагов.");
           }
           System.out.println("Общее количество шагов за месяц: " + sumSteps);
           System.out.println("Максимальное количество шагов в день: " + monthData.maxSteps());
           System.out.println("Среднее количество шагов: " + sumSteps/monthData.days.length);
           System.out.println("Пройдено километров: " + converter.convertToKm(sumSteps));
           System.out.println("Сожжено Ккал: " + converter.convertStepsToKilocalories(sumSteps));
           System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
           System.out.println();
        } else {
            System.out.println("Неверный ввод месяца");
        }
    }
}