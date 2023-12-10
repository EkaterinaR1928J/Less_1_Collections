package org.example;

import java.util.*;

//вставка - случайный элемент коллекции заменить на Джек
//поиск элементов - найти и вывести на экран имя Джек
//удаление элемента - удалить имя Джек из коллекции
//доступ к первым 5% элементов - получить доступ к первым 5% элементов коллекции (без вывода)
//доступ к последним 5% элементов - получить доступ к последним 5% элементов коллекции (без вывода)
//удаление первых 5% элементов - удалить первые 5% элементов коллекции (по одному)
//удаление последних 5% элементов - удалить последние 5% элементов коллекции (по одному)

//linkedList  ArrayList   ArrayDeque  Stack

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1. Коллекции");

        int n = 5;                          //количество экспериментов
        int[] m = {100, 2000, 50000};       //длина основного массива

        Arrays.stream(m).forEach(el -> TempFinal.startMethod(el, n));

    }
}