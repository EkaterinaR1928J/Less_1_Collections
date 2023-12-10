package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    private LinkedList testArray = new LinkedList<String>();

    public TestLinkedList() {
        this.testArray = testArray;
    }



    //6. LinkedList удаление первых 5% элементов - удалить первые 5% элементов коллекции (по одному)
    private long removeFirstElementLinkedList() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во удалений от фиксированной длины коллекции,
        // нельзя в формулу вставлять длинну коллекции, т.к. после удаления каждый раз будет
        // меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();         //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            testArray.pollFirst();              //удаляем первый элемент
        }
        long finish = System.nanoTime();        //финишируем время выполнения
//        System.out.println(testArray);        //выводим на экран для контроля
        return (finish - start);                //возвращаем итоговую разницу
    }

    //7. LinkedList удаление последних 5% элементов - удалить последние 5% элементов коллекции (по одному)
    private long removeLastElementLinkedList() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во удалений от фиксированной длины коллекции,
        // нельзя в формулу вставлять длинну коллекции, т.к. после удаления каждый раз будет
        // меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();         //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            testArray.pollLast();               //удаляем последний элемент
        }
        long finish = System.nanoTime();        //финишируем время выполнения
//        System.out.println(testArray);        //выводим на экран для контроля
        return (finish - start);                //возвращаем итоговую разницу
    }


    public long[][] startFull(int n, int m) {   //n - кол-во экспериментов
        long[][] massTemp = new long[n][7];
        for (int i = 0; i < n; i++) {
            testArray.clear();
            Temp.createList(m, this.testArray);
            massTemp[i][0] = Temp.addNewRandom(testArray);
            massTemp[i][1] = Temp.findElement(testArray);
            massTemp[i][2] = Temp.removeElement(testArray);
            massTemp[i][3] = Temp.getFirstElement(testArray);
            massTemp[i][4] = Temp.getLastElement(testArray);
            massTemp[i][5] = removeFirstElementLinkedList();
            massTemp[i][6] = removeLastElementLinkedList();
        }
        return massTemp;
    }


}
