package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestArrayList {
    private ArrayList testArray = new ArrayList<String>();

    public TestArrayList() {
        this.testArray = testArray;
    }

    //Метод запуска
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
            massTemp[i][6] = Temp.removeLastElement(testArray);
        }
        return massTemp;
    }
}
