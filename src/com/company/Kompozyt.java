package com.company;

import java.util.*;

public class Kompozyt extends Element{

    private List<Element> dzieci = new ArrayList<Element>();

    public Kompozyt(String nazwa) {
        super(nazwa);
    }

    @Override
    public void Dodaj(Element c) {
        dzieci.add(c);
    }

    @Override
    public void Usun(Element c) {
        dzieci.remove(c);
    }

    @Override
    public void Pokaz(int poziom) {

        String poziomdash ="-";

        System.out.println( poziomdash.repeat(poziom)+ nazwa);

        for (Element element : dzieci
             ) {
            element.Pokaz(poziom + 2);
        }
    }
}

abstract class Element {

    protected String nazwa;

    public Element(String nazwa) {
        this.nazwa = nazwa;
    }
    public abstract void Dodaj(Element c);

    public abstract void Usun(Element c);

    public abstract void Pokaz(int poziom);


}

class Lisc extends Element{

    public Lisc(String nazwa) {
        super(nazwa);
    }

    @Override
    public void Dodaj(Element c) {
        System.out.println("Nie można dodać do liscia");
    }

    @Override
    public void Usun(Element c) {
        System.out.println("Nie można usunąć z liścia");
    }

    @Override
    public void Pokaz(int poziom) {

        String poziomdash ="-";

        System.out.println( poziomdash.repeat(poziom)+ nazwa);
    }
}

class KompozytMain{
    public static void main(String[] args) {
        Kompozyt root = new Kompozyt("root");
        root.Dodaj(new Lisc("Lisc A"));
        root.Dodaj(new Lisc("Lisc B"));

        Kompozyt comp = new Kompozyt("Kompozyt X");
        comp.Dodaj(new Lisc("Lisc XA"));
        comp.Dodaj(new Lisc("Lisc XB"));

        root.Dodaj(comp);
        root.Dodaj(new Lisc("Lisc C"));

        Lisc leaf = new Lisc("Lisc D");
        root.Dodaj(leaf);
        root.Usun(leaf);

        root.Pokaz(1);
    }
}