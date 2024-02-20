/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Класс для сериализации и десериализации данных
 * @author danil
 */
public class Serializator {
    /**
     * Метод для сериализации списка в текстовый файл
     * @param list Список для сериализации
     * @param fileName Имя файла для записи
     * @param append Флаг, указывающий на добавление данных в конец файла (true) или перезапись файла (false)
     * @return Строка с информацией об успешном завершении сериализации
     * @throws IOException Исключение, возникающее при ошибке ввода-вывода
     */
    public String serialization(List list, String fileName, boolean append) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
        try {
            for (Object element : list) {
                writer.write(element.toString());
                writer.newLine(); 
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        } finally{
            if (writer != null){
                try {
                    writer.close();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
        }
        return "Serialization completed";
    }

    /**
     * Метод для десериализации данных из текстового файла.
     * Данные должны быть записаны через \n
     * распределяет данные в зависимости от типа по соответствующим спискам
     * @param fileName Имя файла для чтения
     * @return Строка с информацией об успешном завершении десериализации
     * @throws IOException Исключение, возникающее при ошибке ввода-вывода
     */
    public String deserialization(String fileName) throws IOException{ 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (Pattern.matches("-?\\d+", line.trim())) {
                    DataFiltering.sorting.getListInt().add(Long.valueOf(line.trim()));
                } else if (Pattern.matches("-?\\d+\\.\\d+", line.trim())) {
                    DataFiltering.sorting.getListFloat().add(Float.valueOf(line.trim()));
                } else if (Pattern.matches("\\s*[a-zA-Zа-яА-ЯёЁ ]+\\s*", line.trim())) {
                    DataFiltering.sorting.getListStr().add(line.trim());
                } else {
                    System.out.println("Failed to determine string type");
                }
            }
        } catch (IOException e) {
            throw new IOException("Error when reading a file", e);
        }
        return "deserialization completed";
    }
}
