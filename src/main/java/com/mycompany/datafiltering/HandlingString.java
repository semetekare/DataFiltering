/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.util.Collections;
import java.util.List;

/**
 * Класс для обработки строковых значений.
 * Класс параметризован типом String.
 * @author danil
 * @param <T>
 */
public class HandlingString<T extends String> extends Handling<T>{
    /**
     * Минимальное значение в списке.
     */
    private static String min;
    /**
     * Максимальное значение в списке.
     */
    private static String max;

    /**
     * Конструктор класса HandlingString.
     * 
     * @param list Список значений для обработки.
     * @param flagP префикс
     */
    public HandlingString(List<T> list, String flagP) {
        super(list, flagP);
        String[] minMax = minMax();
        this.min = minMax[0];
        this.max = minMax[1];
    }

    /**
     * Метод для определения минимального и максимального значений списка строк.
     * 
     * @return Массив из двух элементов, содержащий минимальное и максимальное значения.
     */
    public String[] minMax() {
        List<T> tmp = this.list;
        Collections.sort(tmp,(s1, s2) -> s1.length() - s2.length());
        String[] res = new String[2];
        res[0] = tmp.get(0);
        res[1] = tmp.get(tmp.size()-1);
        return res;
    }

    /**
     * Метод для получения краткой статистике о списке.
     * 
     * @return Информация о списке.
     */
    public String info(){
        return super.toString();
    }
    
    /**
     * @return the min
     */
    public static String getMin() {
        return min;
    }

    /**
     * @param aMin the min to set
     */
    public static void setMin(String aMin) {
        min = aMin;
    }

    /**
     * @return the max
     */
    public static String getMax() {
        return max;
    }

    /**
     * @param aMax the max to set
     */
    public static void setMax(String aMax) {
        max = aMax;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        return str + "\n short string: " + min + "\n long string: " + max;
    }
}