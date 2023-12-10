package org.example;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Для класса ArrayDeque все методы прописаны отдельно, т.к. в сигнатуре явно должен быть передан тип класса - ArrayDeque
// Так же есть отдельные методы для удаления первого или последнего элемента коллекции - removeFirst(), removeLast()
// Через Iterator получаем доступ к элементам методом next() (descendingIterator() - отсчет с конца очереди,
// iterator() - отсчет с начала очереди)

public class TempArrayDeque {
    private static Random random = new Random();
    private ArrayDeque testArray = new ArrayDeque<String>();

    public TempArrayDeque() {
        this.testArray = testArray;
    }

    //Метод заполнения коллекции с интерфейсом List
    private ArrayDeque<String> createList (int count) {
        String[] names = {"Андрей", "Ирина", "Полина", "Татьяна", "Сергей", "Екатерина",
                "Марина", "Николай", "Артем", "Иван", "Павел", "Елена", "Семен", "Роман", "Наталья",
                "Антон", "Александр", "Алексей", "Игорь", "Олеся"};
        for (int i = 0; i < count; i++) {
            testArray.add(names[random.nextInt(0, names.length)]);
        }
//        System.out.println(testArray); //для теста, что коллекция формируется
//        System.out.println("Длина коллекции: " + testArray.size()); //длина коллекции для проверки
        return testArray;
    }

    //1. вставка - случайный элемент коллекции заменить на Джек
    private long addNewRandom() {
        int n = random.nextInt(0, testArray.size()-1);  //находим случайное число для индекса элемента к удалению
        Iterator<String> iter = testArray.iterator();               //добавляем итератор, чтобы перебирать очередь
        long start = System.nanoTime();                             //засекаем время
        for (int i = 0; i < testArray.size(); i++) {
            String s = iter.next();         //временной переменной присваиваем значение элемента из очереди
            if (i == n) {                   //когда доходим до полученного случайного значения индекса
//                System.out.println(s);      //для контроля элемента, который нужно удалить
                testArray.remove(s);    //удаляем элемент
                testArray.add("Джек");  //добавляем Джека в конец очереди, т.к. в ArrayDeque нет возможности вставить
                // в произвольное место (только в начало или только в конец очереди)
                break;
            }
        }
        long finish = System.nanoTime();    //финишируем время
//        System.out.println(testArray);  //для контроля удаления и вставки
        return (finish - start);      //возвращаем итоговую разницу
    }

    //2. поиск элементов - найти имя Джек
    private long findElement() {
        Iterator<String> iter = testArray.iterator();   //задаем итератор по очереди
        long start = System.nanoTime();                 //засекаем время выполнения
        for (int i = 0; i < testArray.size(); i++) {
            if (iter.next().equals("Джек")) {
//                System.out.println(iter.next());
                break;
            }
        }
        long finish = System.nanoTime();        //финишируем время выполнения
        return (finish - start);      //возвращаем итоговую разницу
    }

    //3. удаление элемента - удалить имя Джек из коллекции
    private long removeElement() {
        long start = System.nanoTime();     //засекаем время выполнения
        testArray.remove("Джек");
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //для контроля удаления
        return (finish - start);      //возвращаем итоговую разницу
    }

    //4. доступ к первым 5% элементов - получить доступ к первым 5% элементов коллекции (без вывода)
    private long getFirstElement() {
        int n = (int) Math.ceil(testArray.size()*0.05);     //считаем кол-во итераций от первоначальной длины очереди
        Iterator<String> iter = testArray.iterator();
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            iter.next();               //для теста измеряем только время доступа к элементам
        }
        long finish = System.nanoTime();    //финишируем время выполнения
        return (finish - start);            //возвращаем итоговую разницу
    }

    //5. доступ к последним 5% элементов - получить доступ к последним 5% элементов коллекции (без вывода)
    private long getLastElement() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во итераций от первоначальной длины очереди
        Iterator<String> iter = testArray.descendingIterator();
        long start = System.nanoTime();     //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            iter.next();       //для теста измеряем только время доступа к элементам
        }
        long finish = System.nanoTime();    //финишируем время выполнения
        return (finish - start);      //возвращаем итоговую разницу
    }

    //6. удаление первых 5% элементов - удалить первые 5% элементов коллекции (по одному)
    private long removeFirstElement() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во удалений от фиксированной длины коллекции,
        // нельзя в формулу вставлять длинну коллекции, т.к. после удаления каждый раз будет
        // меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();         //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            testArray.removeFirst();            //удаляем первый элемент
        }
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //выводим на экран для контроля
        return (finish - start);              //возвращаем итоговую разницу
    }

    //7. удаление последних 5% элементов - удалить последние 5% элементов коллекции (по одному)
    private long removeLastElement() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во удалений от фиксированной длины коллекции,
        // нельзя в формулу вставлять длинну коллекции, т.к. после удаления каждый раз будет
        // меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();         //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            testArray.removeLast();            //удаляем последний элемент
        }
        long finish = System.nanoTime();    //финишируем время выполнения
//        System.out.println(testArray);      //выводим на экран для контроля
        return (finish - start);              //возвращаем итоговую разницу
    }

    public long[][] startFull(int n, int m) {   //n - кол-во экспериментов
        long[][] massTemp = new long[n][7];
        for (int i = 0; i < n; i++) {
            testArray.clear();
            createList(m);
            massTemp[i][0] = addNewRandom();
            massTemp[i][1] = findElement();
            massTemp[i][2] = removeElement();
            massTemp[i][3] = getFirstElement();
            massTemp[i][4] = getLastElement();
            massTemp[i][5] = removeFirstElement();
            massTemp[i][6] = removeLastElement();
        }
        return massTemp;
    }
}
