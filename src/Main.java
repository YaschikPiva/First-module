import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StepTracker track = new StepTracker(scanner);// создание нового экземпляра
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
               track.addNewNumberStepsPerDay(scanner);  //Ввод шагов
            } else if (i == 2) {
                track.changeStepGoal(scanner);//Изменение цели шагов на день
            } else if (i == 3) {
                track.printStatistic();//Вывод статистики за определённый месяц
            } else if (i == 4) { //Выход
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
                System.out.println();
            }
        }
    }

    static void printMenu() { //Печать меню
        System.out.println();
        System.out.println("Выберите пункт меню\n"+
                "1 - Ввести количество шагов за определённый день.\n"+
                "2 - Изменить цель количества шагов в день.\n"+
                "3 - Напечатать статистистику за определённый месяц\n"+
                "4 - Выход.");
    }
}

