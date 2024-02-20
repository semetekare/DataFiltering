/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.util.Collections;
import java.util.List;

/**
 * Класс для расчета статистики целочисленных значений.
 * Класс параметризован типом Long, так как возможна ситуация, когда сумма нескольких и/или 
 * некоторое значение превышает диапазон типа int.
 * 
 * @author danil
 * @param <T>
 */
public class HandlingInteger<T extends Long> extends Handling<T>{
    /**
     * минимальный элемент списка
     */
    private static long min;
    /**
     * максимальный элемеент списка
     */
    private static long max;
    /**
     * среднеарифмитическое значения элементов списка
     */
    private static long mean;
    /**
     * сумма всех элементов списка
     */
    private static long sum;

    /**
     * Конструктор класса HandlingInteger.
     * 
     * @param list Список значений для обработки.
     * @param flagP префикс
     */
    HandlingInteger(List<T> list, String flagP) {
        super(list, flagP);
        long[] minMax = minMax();
        long[] sumMean = sumMean();
        this.min = minMax[0];
        this.max = minMax[1];
        this.sum = sumMean[0];
        this.mean = sumMean[1];
    }

    /**
     * Метод для определения минимального и максимального значений списка.
     * 
     * @return Массив из двух элементов, содержащий минимальное и максимальное значения.
     */
    public long[] minMax() {
        List<T> tmp = this.getList();
        Collections.sort(tmp);
        long[] res = new long[2];
        res[0] = tmp.get(0);
        res[1] = tmp.get(tmp.size()-1);
        return res;
    }

    /**
     * Метод для вычисления суммы и среднего арифметического значений списка.
     * 
     * @return Массив из двух элементов, содержащий сумму и среднее арифметическое.
     */
    public long[] sumMean(){
        long[] res = new long[2];
        res[0] = 0L;
        for (int i=0;i<getList().size();i++){
            res[0] += (long)getList().get(i);
        }
        res[1] = res[0]/getList().size();
        return res;
    }

    /**
     * Метод для получения краткой статистики о списке.
     * 
     * @return Информация о списке.
     */
    public String info(){
        return super.toString();
    }
    
    /**
     * @return the min
     */
    public static long getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(int aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static long getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(int aMax) {
        max = aMax;
    }

    /**
     * @return the mean
     */
    public static Long getMean() {
        return mean;
    }

    /**
     * @param aMean the mean to set
     */
    public static void setMean(Long aMean) {
        mean = aMean;
    }

    /**
     * @return the sum
     */
    public static Long getSum() {
        return sum;
    }

    /**
     * @param aSum the sum to set
     */
    public static void setSum(Long aSum) {
        sum = aSum;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n minimum value: " + min + "\n maximum value: " + max
                + "\n mean value: " + mean + "\n sum value: " + sum;
    }
}