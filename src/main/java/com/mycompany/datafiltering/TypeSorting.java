/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс для сортировки и обработки данных исходных input файлов
 * @author danil
 */
public class TypeSorting {
    /**
     * Сериализатор для сериализации и десериализации данных.
     */
    public static Serializator serializator;

    /**
     * Обработчик целочисленных данных.
     */
    private static HandlingInteger handInt;

    /**
     * Обработчик данных с плавающей точкой.
     */
    private static HandlingFloat handFloat;

    /**
     * Обработчик строковых данных.
     */
    private static HandlingString handStr;

    /**
     * Список целочисленных данных.
     */
    private static List<Integer> listInt;

    /**
     * Список данных с плавающей точкой.
     */
    private static List<Float> listFloat;

    /**
     * Список строковых данных.
     */
    private static List<String> listStr;

    /**
     * Имя файла.
     */
    public static String fileName;

    /**
     * Путь для сохранения файлов.
     */
    private static String flagO;

    /**
     * Префикс для имен файлов.
     */
    private static String flagP;

    /**
     * Флаг, указывающий на режим добавления данных в файлы.
     */
    private static boolean flagA;
    
    /**
     * Конструктор класса.
     * 
     * @param flagO Путь для сохранения файлов.
     * @param flagP Префикс для имен файлов.
     * @param flagA Флаг, указывающий на режим добавления данных в файлы.
     */
    public TypeSorting(String flagO, String flagP, boolean flagA) {
        serializator = new Serializator();
        this.listInt = new ArrayList<>();
        this.listFloat = new ArrayList<>();
        this.listStr = new ArrayList<>();
        this.flagO = flagO;
        this.flagP = flagP;
        this.flagA = flagA;
    }
    
    /**
     * Метод для чтения данных из файлов.
     * после его выполнения так же заполнятся массивы listInt, listFloat, listStr
     * @param files Список файлов для чтения.
     * @throws IOException Исключение, возникающее при ошибке ввода-вывода.
     */
    public static void readFiles(List files) throws IOException {
        try {
            for (int i = 0; i < files.size(); i++){
            serializator.deserialization(files.get(i).toString());
            }
        } 
        catch (IOException e) {
            throw new IOException("Сouldn't read the file", e);
        }
    }
    
    /**
     * Метод для сериализации output файлов.
     */
    public static void serializerObj() {
        if (!listInt.isEmpty()){
            DataFiltering.sorting.handInt = new HandlingInteger(listInt, flagP);
            fileName = flagO + "\\" + flagP + "integer" + ".txt";
            try {
                serializator.serialization(listInt, fileName, flagA);
            } catch (IOException ex) {
                Logger.getLogger(TypeSorting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!listFloat.isEmpty()){
            DataFiltering.sorting.handFloat = new HandlingFloat(listFloat, flagP);
            fileName = flagO + "\\" + flagP + listFloat.get(0).getClass().getSimpleName().toLowerCase()+ ".txt";
            try {
                serializator.serialization(listFloat, fileName, flagA);
            } catch (IOException ex) {
                Logger.getLogger(TypeSorting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!listStr.isEmpty()){
            DataFiltering.sorting.handStr = new HandlingString(listStr, flagP);
            fileName = flagO + "\\" + flagP + listStr.get(0).getClass().getSimpleName().toLowerCase() + ".txt";
            try {
                serializator.serialization(listStr, fileName, flagA);
            } catch (IOException ex) {
                Logger.getLogger(TypeSorting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Метод для вывода статискики по разным типам данных
     * @param flagS Флаг, указывающий на вывод краткой статистики
     * @param flagF Флаг, указывающий на вывод полной статистики
     */
    public void printInfo(boolean flagS, boolean flagF){
        if (flagS) {
            if (flagF) {
                if (!listInt.isEmpty()) {
                    System.out.println(handInt.toString()+ "\n");
                }
                if (!listFloat.isEmpty()) {
                    System.out.println(handFloat.toString()+ "\n");
                }
                if (!listStr.isEmpty()){
                    System.out.println(handStr.toString()+ "\n");
                }
            } else {
                if (!listInt.isEmpty()) {
                    System.out.println(handInt.info()+"\n");
                }
                if (!listFloat.isEmpty()) {
                    System.out.println(handFloat.info()+"\n");
                }
                if (!listStr.isEmpty()){
                    System.out.println(handStr.info()+"\n");
                }
            }
            
        }
    }
    
    /**
     * Метод для получения списка целых чисел.
     * 
     * @return Список целых чисел.
     */
    public List getListInt(){
        return this.listInt;
    }
    
    /**
     * Метод для получения списка чисел с плавающей точкой.
     * 
     * @return Список чисел с плавающей точкой.
     */
    public List getListFloat(){
        return this.listFloat;
    }
    
    /**
     * Метод для получения списка строк.
     * 
     * @return Список строк.
     */
    public List getListStr(){
        return this.listStr;
    }
}
