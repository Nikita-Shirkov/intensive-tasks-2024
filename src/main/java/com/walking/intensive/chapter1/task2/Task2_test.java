package com.walking.intensive.chapter1.task2;

import java.awt.geom.FlatteningPathIterator;
import java.util.Scanner;


/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {

    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        String result = getFlatLocation(2,2,12); //Этаж, Подъезд, Номер квартиры
        System.out.println(result);
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        if(flatNumber > (entranceAmount*floorAmount*4)){return("Такой квартиры не существует");}
        if(flatNumber <= 0){return("Некорректные входные данные");}

        int entranceAmountONE = flatNumber / (floorAmount*4); // Заполнение подъезда
        int flatNumberONE = flatNumber - (entranceAmountONE*floorAmount*4); // Номер квартиры относительно начала подъезда
        double floorAmountONE = flatNumberONE/4; // Сколько под квартирой этажей

        if (floorAmountONE == 1.0) floorAmountONE--;
        int pozK = flatNumberONE - (int)floorAmountONE * 4; //Позиция квартиры относительно лифта
        String poz = switch (pozK) {
            case 1 -> "слева от лифта, влево";
            case 2 -> "слева от лифта, вправо";
            case 3 -> "справа от лифта, влево";
            case 4, 0 -> "справа от лифта, вправо";
            default -> null;
        };
        return (flatNumber + " кв - " + (entranceAmountONE + 1) + " подъезд, " + ((int)floorAmountONE + 1) + " этаж, " + poz);

    }
}


