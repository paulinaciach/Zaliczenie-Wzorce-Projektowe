package com.company;

public class Pelnomocnik extends Przedmiot {

    private KonkretnyPrzedmiot konkretnyPrzedmiot;

    @Override
    public void Zapytanie() {

        if(konkretnyPrzedmiot == null){

            this.konkretnyPrzedmiot = new KonkretnyPrzedmiot();
            konkretnyPrzedmiot.Zapytanie();
        }

    }
}

abstract class Przedmiot{

    public abstract void Zapytanie();

}

class KonkretnyPrzedmiot extends Przedmiot{

    @Override
    public void Zapytanie() {
        System.out.println("Wywołanie KonkretnyPrzedmiot.Zapytanie()");
    }
}

class PelnomocnikMain{

    public static void main(String[] args) {

        Pelnomocnik pelnomocnik = new Pelnomocnik();
        pelnomocnik.Zapytanie();

    }


}