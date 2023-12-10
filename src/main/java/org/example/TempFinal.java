package org.example;

import java.util.Arrays;

public class TempFinal {
    public static void startMethod(int n, int m) {
        //получаем результаты отработки методов для каждого варианта Коллекции (n - кол-во экспериментов, m - кол-во эл-тов)
        long[][] example1 = new TestArrayList().startFull(n, m);
        long[][] example2 = new TestLinkedList().startFull(n, m);
        long[][] example3 = new TestStack().startFull(n, m);
        long[][] example4 = new TempArrayDeque().startFull(n, m);

//      //вывод для контроля
//      printMass(example1);
//      printMass(example2);
//      printMass(example3);
//      printMass(example4);

        //получение средних значение по методам
        long[] midl1 = midl(example1);
        long[] midl2 = midl(example2);
        long[] midl3 = midl(example3);
        long[] midl4 = midl(example4);

        System.out.println();
        //вывод результирующих данных по 4-м коллекциям
        printResolt(midl1, midl2, midl3, midl4, n, m);

    }

    //вывод результирующих данных по 4-м коллекциям
    public static void printResolt(long[] midl1, long[] midl2, long[] midl3, long[] midl4, int n, int m) {
        System.out.printf("Результаты для %d экспериментов с объемом в %d элементов:", n, m);
        System.out.printf("\n=========================================================" +
                "=====================================");
        System.out.printf("\n          \t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s","addEl","findEl","removeEl","getFirst",
                "getLast","removeFirst","removeLast");
        System.out.printf("\n----------------------------------------------------------" +
                "------------------------------------");
        System.out.printf("\n%10s\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d","ArrayList",midl1[0],midl1[1],midl1[2],
                midl1[3],midl1[4],midl1[5],midl1[6]);
        System.out.printf("\n%10s\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d","linkedList",midl2[0],midl2[1],midl2[2],
                midl2[3],midl2[4],midl2[5],midl2[6]);
        System.out.printf("\n%10s\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d","Stack",midl3[0],midl3[1],midl3[2],midl3[3],
                midl3[4],midl3[5],midl3[6]);
        System.out.printf("\n%10s\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d\t%10d","ArrayDeque",midl4[0],midl4[1],midl4[2],
                midl4[3],midl4[4],midl4[5],midl4[6]);
        System.out.println();
    }

    // подсчет среднего значения с игнорированием первой строки результирующего массива
    // для исключения времени старта джава-машины
    public static long[] midl(long[][] massResolt) {
        long[] massRes = new long[massResolt[0].length];
        for (int j = 0; j < massResolt[0].length; j++) {
            int count = 0;
            for (int i = 1; i < massResolt.length; i++) {
                count += massResolt[i][j];
            }
            count = count / (massResolt.length - 1);
            massRes[j] = count;
        }
        return massRes;
    }


    //печать двумерного массива (используется только в выводе проверочного массива)
    public static void printMass (long[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                System.out.print("\t" + mass[i][j]);
            }
            System.out.println();
        }
    }

    //печать одномерного массива
    public static void printMass1 (long[] mass) {
        Arrays.stream(mass).forEach(el -> System.out.print("\t" + el));
    }
}

