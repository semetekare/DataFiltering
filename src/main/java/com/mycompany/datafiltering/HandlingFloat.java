/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.util.Collections;
import java.util.List;

/**
 * Класс для расчета статистики значений типа float.
 * Класс параметризован типом Float.
 * @author danil
 * @param <T>
 */
public class HandlingFloat<T extends Float> extends Handling<T>{
    /**
     * Минимальное значение в списке.
     */
    private static float min;
    /**
     * Максимальное значение в списке.
     */
    private static float max;
    /**
     * Среднее арифметическое значение элементов списка.
     */
    private static double mean;
    /**
     * Сумма всех элементов списка.
     */
    private static double sum;

    /**
     * Конструктор класса HandlingFloat.
     * 
     * @param list Список значений для обработки.
     * @param flagP префикс
     */
    public HandlingFloat(List<T> list, String flagP) {
        super(list, flagP);
        float[] minMax = minMax();
        double[] sumMean = sumMean();
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
    public float[] minMax() {
        List<T> tmp = this.list;
        Collections.sort(tmp);
        float[] res = new float[2];
        res[0] = tmp.get(0);
        res[1] = tmp.get(tmp.size()-1);
        return res;
    }

    /**
     * Метод для вычисления суммы и среднего арифметического значений списка.
     * 
     * @return Массив из двух элементов, содержащий сумму и среднее арифметическое.
     */
    public double[] sumMean(){
        double[] res = new double[2];
        for (int i=0;i<list.size();i++){
            res[0] += (double)list.get(i);
        }
        res[1] = res[0]/list.size();
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
    public static float getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(float aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static float getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(float aMax) {
        max = aMax;
    }

    /**
     * @return the mean
     */
    public static double getMean() {
        return mean;
    }

    /**
     * @param aMean the mean to set
     */
    public static void setMean(double aMean) {
        mean = aMean;
    }

    /**
     * @return the sum
     */
    public static double getSum() {
        return sum;
    }

    /**
     * @param aSum the sum to set
     */
    public static void setSum(double aSum) {
        sum = aSum;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n minimum value: " + min + "\n maximum value: " + max
                + "\n mean value: " + mean + "\n sum value: " + sum;
    }
}