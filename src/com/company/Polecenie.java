package com.company;

abstract class Polecenie {
    protected Odbiorca odbiorca;

    public Polecenie(Odbiorca odbiorca) {
        this.odbiorca = odbiorca;
    }

    public abstract void Wykonaj();
}

class Odbiorca {
    public void Uruchom() {
        System.out.println("Wywołano Odbiorca.Uruchom()");
    }
}

class ObiektWywolujacy {
    private Polecenie polecenie;

    public void UstawPolecenie(Polecenie polecenie) {
        this.polecenie = polecenie;
    }

    public void WykonajPolecenie() {
        polecenie.Wykonaj();
    }
}

class SpecyficznePolecenie extends Polecenie {

    public SpecyficznePolecenie(Odbiorca odbiorca) {
        super(odbiorca);
    }

    @Override
    public void Wykonaj() {
        odbiorca.Uruchom();
    }
}


class PolecenieMain {
    public static void main(String[] args) {
        Odbiorca odbiorca = new Odbiorca();
        Polecenie polecenie = new SpecyficznePolecenie(odbiorca);
        ObiektWywolujacy wywolujacy = new ObiektWywolujacy();

        wywolujacy.UstawPolecenie(polecenie);
        wywolujacy.WykonajPolecenie();
    }
}