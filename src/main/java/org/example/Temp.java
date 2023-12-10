package org.example;

import java.util.*;

// Класс Temp описывает методы для работы с коллекциями, которые имплементируют интерфейс List:
// LinkedList, ArrayList и Stack
// У данных коллекций работают все методы List: add() - вставка, remove() - удаление, set() (вставка элемента с заменой),
// indexOf() - поиск индекса по значению)
// Для LinkedList отличаются только методы, работающие с началом и концом строки.
// Поэтому для LinkedList переписаны методы 6.удаление первых 5% элементов и 7.удаление последних 5% элементов)
// В Stack метод удаления pop работает только с концом коллекции, поэтому переписан только метод 7.удаление последних 5% элементов

public class Temp {
    static Random random = new Random();

    //Метод заполнения коллекции с интерфейсом List
    public static List<String> createList (int count, List<String> testArray) {
        String[] names = {"Андрей", "Ирина", "Полина", "Татьяна", "Сергей", "Екатерина",
                "Марина", "Николай", "Артем", "Иван", "Павел", "Елена", "Семен", "Роман", "Наталья",
                "Антон", "Александр", "Алексей", "Игорь", "Олеся"};
//        List<String> testArray = new ArrayList();
        for (int i = 0; i < count; i++) {
            testArray.add(names[random.nextInt(0, names.length)]);
        }
//        System.out.println(testArray); //для теста, что коллекция формируется
//        System.out.println("Длина коллекции: " + testArray.size()); //длина коллекции для проверки
        return testArray;
    }

    //1. вставка - случайный элемент коллекции заменить на Джек
    public static long addNewRandom(List<String> testArray) {
        long start = System.nanoTime();
        testArray.set(random.nextInt(0, testArray.size()-1), "Джек");
        long finish = System.nanoTime();
//        System.out.println(testArray);  //для контроля вставки
        return (finish - start);      //возвращаем итоговую разницу
    }

    //2. поиск элементов - найти имя Джек
    public static long findElement(List<String> testArray) {
        int index = testArray.indexOf("Джек");  //находим индекс для Джек
        long start = System.nanoTime();         //засекаем время выполнения
        testArray.get(index);                   //находим по индексу имя Джек без вывода на печать
        long finish = System.nanoTime();        //финишируем время выполнения
        return (finish - start);      //возвращаем итоговую разницу
    }

    //3. удаление элемента - удалить имя Джек из коллекции
    public static long removeElement(List<String> testArray) {
        long start = System.nanoTime();     //засекаем время выполнения
        testArray.remove("Джек");
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //для контроля удаления
        return (finish - start);      //возвращаем итоговую разницу
    }

    //4. доступ к первым 5% элементов - получить доступ к первым 5% элементов коллекции (без вывода)
    public static long getFirstElement(List<String> testArray) {
        int n = (int) Math.ceil(testArray.size()*0.05);     //округление вверх
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = 0; i < n; i++) {
//            System.out.println(testArray.get(i));   //убрать вывод на экран при тесте
            testArray.get(i);               //для теста измеряем только время доступа к элементам
        }
        long finish = System.nanoTime();    //финишируем время выполнения
        return (finish - start);      //возвращаем итоговую разницу
    }

    //5. доступ к последним 5% элементов - получить доступ к последним 5% элементов коллекции (без вывода)
    public static long getLastElement(List<String> testArray) {
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = testArray.size()-1; i > Math.floor((testArray.size())*0.95-1); i--) {
//            System.out.println(testArray.get(i));   //убрать вывод на экран при тесте
            testArray.get(i);       //для теста измеряем только время доступа к элементам
        }
        long finish = System.nanoTime();    //финишируем время выполнения
        return (finish - start);      //возвращаем итоговую разницу
    }

    //6. удаление первых 5% элементов - удалить первые 5% элементов коллекции (по одному)
    public static long removeFirstElement(List<String> testArray) {
        int n = testArray.size();   //фиксируем длину коллекции, нельзя в формулу вставлять длинну коллекции,
        // т.к. после удаления каждый раз будет меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = 0; i < Math.ceil(n*0.05); i++) {    //округление вверх
            testArray.remove(i);            //удаляем элемент
        }
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //выводим на экран для контроля
        return (finish - start);              //возвращаем итоговую разницу
    }

    //7. удаление последних 5% элементов - удалить последние 5% элементов коллекции (по одному)
    public static long removeLastElement(List<String> testArray) {
        int n = testArray.size();   //фиксируем длину коллекции, нельзя в формулу вставлять длинну коллекции,
        // т.к. после удаления каждый раз будет меняться длина коллекции и пересчитываться начальное и конечное значения цикла
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = n-1; i > (n*0.95-1); i--) {
            testArray.remove(i);            //удаляем элемент
        }
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //выводим на экран для контроля
        return (finish - start);              //возвращаем итоговую разницу
    }

}
