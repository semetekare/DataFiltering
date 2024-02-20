/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datafiltering;

import java.util.List;

/**
 * Класс родитель для типизированных классов
 * @author danil
 */
public class Handling<T> {
    /**
     * параметризованный список всех значений которые подходят под T
     */
    List<T> list;
    /**
     * Префекс output файла
     */
    String prefix;
    
    /**
     * объектный инициализатор
     */
    {
        prefix = "";
    }

    /**
     * пустой конструктор
     */
    Handling(){}
    
    /**
     * конструктор с двумя параметрами
     * @param list список параметризованных значений
     * @param flagP Префекс output файла
     */
    public Handling(List<T> list, String flagP){
        this.list = list;
        this.prefix = flagP;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    
    /**
     * переопределенный toString
     * @return 
     */
    @Override
    public String toString(){
        return prefix + list.get(0).getClass().getSimpleName().toLowerCase() + ".txt:\n"
                + "number of elements: " + list.size();
    }
}
