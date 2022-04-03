package com.company;

public class Most {

    public static void main(String[] args) {

        Abstrakcja ab = new AbstrakcjaPochodna();

        ab.implementacja = new SpecyficznaImplementacja();
        ab.MetodaImplementacji();

        ab.implementacja = new JakasInnaImplementacja();
        ab.MetodaImplementacji();

    }

}

abstract class Implementacja{

    public abstract void MetodaImplementacji();
}

class Abstrakcja {

    protected Implementacja implementacja;

    public Abstrakcja (Implementacja implementacja) {
        this.implementacja = implementacja;
    }

    public Abstrakcja() {

    }

    public void MetodaImplementacji()
    {
        implementacja.MetodaImplementacji();
    }

}

class AbstrakcjaPochodna extends Abstrakcja{

    public AbstrakcjaPochodna(Implementacja implementacja) {
        super(implementacja);
    }

    public AbstrakcjaPochodna() {
        super();
    }

    @Override
    public void MetodaImplementacji() {
        implementacja.MetodaImplementacji();
    }
}

class SpecyficznaImplementacja extends Implementacja{

    @Override
    public void MetodaImplementacji() {
        System.out.println("SpecyficznaImplementacja MetodaImplementacji");
    }
}

class JakasInnaImplementacja extends Implementacja{

    @Override
    public void MetodaImplementacji() {
        System.out.println("JakasInnaImplementacja MetodaImplementacji");
    }
}