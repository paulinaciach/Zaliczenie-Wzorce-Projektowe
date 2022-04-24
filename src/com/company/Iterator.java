package com.company;

import java.util.ArrayList;
import java.util.List;


interface Iterator< E >{
    boolean hasNext();
    E next();
}

class ArrayIterator< E > implements Iterator {

    int posistion = 0;
    E[] items;

    public ArrayIterator(E[] items){
        this.items = items;
    }

    @Override
    public boolean hasNext(){
        if (posistion >= items.length || items[posistion] == null){
            return false;
        }
        return true;
    }

    @Override
    public E next(){
        E item = items[posistion];
        posistion++;
        return item;
    }
}


class ListIterator< E > implements Iterator {

    int posistion = 0;
    List< E > items;

    public ListIterator(List< E > items){
        this.items = items;
    }

    @Override
    public boolean hasNext(){
        if (posistion >= items.size() || items.get(posistion) == null){
            return false;
        }
        return true;
    }

    @Override
    public E next(){
        E item = items.get(posistion);
        posistion++;
        return item;
    }
}


class DesignPatternsIterator{


    private static Integer[] intArray = new Integer[10];
    private static ArrayList< Integer > intList = new ArrayList< Integer >();

    public static void main(String[] args){

        intArray[0] = 1;
        intArray[1] = 11;
        intArray[2] = 21;
        intArray[3] = 31;
        intArray[4] = 41;
        intArray[5] = 51;
        intArray[6] = 61;
        intArray[7] = 71;
        intArray[8] = 81;
        intArray[9] = 91;

        intList.add(1);
        intList.add(11);
        intList.add(21);
        intList.add(31);
        intList.add(41);
        intList.add(51);
        intList.add(61);
        intList.add(71);
        intList.add(81);


        printData(new ArrayIterator(intArray), "Tablica");
        printData(new ListIterator(intList), "Lista");
    }


    private static void printData(Iterator iterator, String info){

        if (iterator != null){

            System.out.println("Dane: " + info);
            while (iterator.hasNext()){
                System.out.print(iterator.next() + ", ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
}
