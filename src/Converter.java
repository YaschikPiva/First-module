public class Converter {
    int stepLength = 75; //длина шага в см
    int stepCal = 50; //Калорий на шаг

    int convertToKm(int steps){ //Пересчёт шагов в клиометры
        int stepsKm = steps * stepLength / (100 * 1000);
        return stepsKm;
    }

    int convertStepsToKilocalories(int steps){ //Пересчёт шагов в КИЛОкалории
        int stepsKilocalories = steps * stepCal / 1000;
        return stepsKilocalories;
    }
}
