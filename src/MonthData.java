public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(){ //Вывод статистики за месяц (день - шаги)
        for (int i = 0; i < days.length; i++){
            System.out.println("День" + (i + 1) + ": пройдено " + days[i] + " шагов.");
        }
    }

    int sumStepsFromMonth(){ //Сумма шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++){
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps(){ //Поиск максимального количества шагов за месяц
        int MaxSteps = 0;
        for (int i = 0; i < days.length; i++){
            if (MaxSteps < days[i]) {
                MaxSteps = days[i];
            }
        }
        return MaxSteps;
    }

    int bestSeries(int goalByStepsPerDay){ //Поиск лучшей серии шагов больше установленной цели
        int currentSeries = 0;
        int BestSeries = 0;
        for (int i = 0; i < days.length; i++){
            if (goalByStepsPerDay <= days[i]) {
                currentSeries = currentSeries + 1;
            } else {
                if (BestSeries < currentSeries){
                    BestSeries = currentSeries;
                    currentSeries = 0;
                } else {
                    currentSeries = 0;
                }
            }
        }
        return BestSeries;
    }
}
