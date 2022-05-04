package com.company;

import java.util.ArrayList;

abstract class Iterator2
{
    public abstract Object Pierwszy();
    public abstract Object Nastepny();
    public abstract Boolean CzyKoniec();
    public abstract Object PobierzElement();
}

class SpecyficznyIterator extends Iterator2
{
    public SpecyficznyIterator(SpecyficznyKontener kontener) {
        this.kontener = kontener;
    }

    private SpecyficznyKontener kontener;
    private int obecny = 0;

    @Override
    public Object Pierwszy() {
        return kontener.getElementy().get(0);
    }

    @Override
    public Object Nastepny() {
        Object ret = null;
        if (obecny < kontener.Ilosc() - 1)
        {
            ret = kontener.getElementy().get(++obecny);
        }

        return ret;
    }

    @Override
    public Boolean CzyKoniec() {
        return obecny >= kontener.Ilosc();
    }

    @Override
    public Object PobierzElement() {
        return kontener.getElementy().get(obecny);
    }

}

abstract class Kontener
{
    public abstract Iterator2 StworzIterator();
}

class SpecyficznyKontener extends Kontener
{
    public ArrayList getElementy() {
        return elementy;
    }

    public void setElementy(ArrayList elementy) {
        this.elementy = elementy;
    }

    public ArrayList<String> elementy = new ArrayList<String>();

    @Override
    public Iterator2 StworzIterator() {
        return (Iterator2) new SpecyficznyIterator(this);
    }

    public int Ilosc()
    {
       return elementy.size();
    }
}

class IteratorMain{
    public static void main(String[] args) {
        SpecyficznyKontener kontenter = new SpecyficznyKontener();
        kontenter.elementy.add(0, "Element A");
        kontenter.elementy.add(1, "Element B");
        kontenter.elementy.add(2, "Element C");
        kontenter.elementy.add(3, "Element D");



        Iterator2 iterator = kontenter.StworzIterator();

        System.out.println("Iteracja kolekcji:");

        Object element = iterator.Pierwszy();
        while (element != null)
        {
            System.out.println((element));
            element = iterator.Nastepny();
        }

    }
}