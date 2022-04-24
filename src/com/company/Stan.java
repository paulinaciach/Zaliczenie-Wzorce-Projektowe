package com.company;

abstract class Stan {

    public abstract void Odpowiedz(KontekstStan kontekst);
}

class KontekstStan {

    private Stan stan;

    public KontekstStan(Stan _stan) {
        this.stan = _stan;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
        System.out.println("Stan: " + stan.getClass().getName().toString());
    }
    public void Zapytaj()
    {
        stan.Odpowiedz(this);
    }
}

class SpecyficznyStanA extends Stan {

    @Override
    public void Odpowiedz(KontekstStan kontekst) {

        kontekst.setStan(new SpecyficznyStanB());
    }
}
class SpecyficznyStanB extends Stan {

    @Override
    public void Odpowiedz(KontekstStan kontekst) {

        kontekst.setStan(new SpecyficznyStanA());
    }
}
class StanMain{
    public static void main(String[] args) {
        KontekstStan k = new KontekstStan(new SpecyficznyStanA());

        k.Zapytaj();
        k.Zapytaj();
        k.Zapytaj();
        k.Zapytaj();
    }
}