/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datafiltering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danil
 */
public class DataFiltering {
    /**
     * Опция отвечающая за конечную дерикторию записи файлов
     */
    static String flagO;
    /**
     * Опция отвечающая за префиксы к output файлам
     */
    static String flagP;
    /**
     *Опция отвечающая за режим добавления в существующие файлы
     */
    static boolean flagA;
    /**
     *Краткая статистика сортировки
     */
    static boolean flagS;
    /**
     *полная статистика сортировки
     */
    static boolean flagF;
    /**
     * объект управляющего класса
     */
    public static TypeSorting sorting;
    
    /**
     * main функция
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        parseCommandLine(args);
        
        try {
            sorting = new TypeSorting(flagO, flagP, flagA);
            sorting.readFiles(getNameFiles(args));
            sorting.serializerObj();
            sorting.printInfo(flagS, flagF);
        } catch (IOException ex) {
            Logger.getLogger(DataFiltering.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Отбор имен input файлов из аргуметов командной строки
     * @param args аргументы командной строки
     * @return возращает параметризованный список имен input файлов
     */    
    public static List<String> getNameFiles(String[] args) {
        List<String> files = new ArrayList<>();
        String workingDir = System.getProperty("user.dir");
        for (String arg : args) {
            if (arg.endsWith(".txt")) {
                // Если путь к файлу не абсолютный, добавляем рабочую директорию
                String filePath = arg.startsWith("C:\\") ? arg : workingDir + File.separator + arg;
                files.add(filePath);
            }
        }
        return files;
    }
    
    /**
     * Парсер аргуметов командной строки.
     * Выявление наличия опций и их значений
     * @param args аргументы командной строки
     */
    public static void parseCommandLine(String[] args) {
        String workingDir = System.getProperty("user.dir");
        flagO = workingDir;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-o":
                    if (i < args.length - 1) {
                        flagO = args[++i];
                    } else {
                        System.out.println("The path is not specified for -o");
                    }
                    break;
                case "-p":
                    if (i < args.length - 1) {
                        flagP = args[++i];
                    } else {
                        System.out.println("No file prefix specified for -p");
                    }
                    break;
                case "-a":
                    flagA = true;
                    break;
                case "-s":
                    flagS = true;
                    flagF = false;
                    break;
                case "-f":
                    flagS = true;
                    flagF = true;
                    break;
            }
        }
    }
}
