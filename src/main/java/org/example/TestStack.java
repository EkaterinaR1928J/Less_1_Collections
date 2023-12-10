package org.example;

import java.util.Stack;

public class TestStack {
    Stack testArray = new Stack<String>();

    public TestStack() {
        this.testArray = testArray;
    }

    //7. Stack удаление последних 5% элементов - удалить последние 5% элементов коллекции (по одному)
    private long removeLastElementStack() {
        int n = (int)Math.ceil(testArray.size()*0.05);   //считаем кол-во удалений от фиксированной длины коллекции,
        // нельзя в формулу вставлять длинну коллекции, т.к. после удаления каждый раз будет
        // меняться длина коллекции и пересчитываться конечное значения цикла
        long start = System.nanoTime();         //засекаем время выполнения
        for (int i = 0; i < n; i++) {
            testArray.pop();                    //удаляем последний элемент
        }
        long finish = System.nanoTime();        //финишируем время выполнения
//        System.out.println(testArray);          //выводим на экран для контроля
        return (finish - start);                //возвращаем итоговую разницу
    }

    public long[][] startFull(int n, int m) {   //n - кол-во экспериментов
        long[][] massTemp = new long[n][7];
        for (int i = 0; i < n; i++) {
            testArray.clear();
            Temp.createList(m, testArray);
            massTemp[i][0] = Temp.addNewRandom(testArray);
            massTemp[i][1] = Temp.findElement(testArray);
            massTemp[i][2] = Temp.removeElement(testArray);
            massTemp[i][3] = Temp.getFirstElement(testArray);
            massTemp[i][4] = Temp.getLastElement(testArray);
            massTemp[i][5] = Temp.removeFirstElement(testArray);
            massTemp[i][6] = removeLastElementStack();
        }
        return massTemp;
    }

}
