package com.company;

/**
 * Implementacja wzorca projektowego Fabryka  przy wykorzystaniu diagramu
 * klas udostepnionego pod adresem: https://blog.artmetic.pl/wzorzec-fabryka-abstrakcyjna-i-metoda-wytworcza-cqt/
 **/

public class Fabryka {
    public static void main(String[] args) {
        for (OfertaFactory.OfertaTyp ofertaTyp : OfertaFactory.OfertaTyp.values()) {
            System.out.println("Szczegóły dla oferty typu: " + ofertaTyp + " ---> " + OfertaFactory.createOferta(ofertaTyp).pokaz());
        }
    }
}

interface Oferta{
    public String getOfertaPodstawowa();
    public String getDodatki();
    public String pokaz();
}

class OszczednaOferta implements Oferta{

    private String informacja = "1 wejście w miesiacu";
    private String dodatki = "Brak dodatkow";

    @Override
    public String getOfertaPodstawowa() {
        return informacja;
    }
    @Override
    public String getDodatki() {
        return dodatki;
    }
    @Override
    public String pokaz() {
        return "Wejscia: " + informacja +" ---> Dodatki: "+ dodatki;
    }
}

class SredniaOferta implements Oferta{

    private String informacja = "2 wejścia w tygodniu";
    private String dodatki = "Sauna bezpłatna";

    @Override
    public String getOfertaPodstawowa() {
        return informacja;
    }
    @Override
    public String getDodatki() {
        return dodatki;
    }
    @Override
    public String pokaz() {
        return "Wejscia: " + informacja +" ---> Dodatki: "+ dodatki;
    }
}

class DrogaOferta implements Oferta{

    private String informacja = "Wejścia bez limitu";
    private String dodatki = "Konsultacje trenera";

    @Override
    public String getOfertaPodstawowa() {

        System.out.println(informacja);

        return informacja;
    }
    @Override
    public String getDodatki() {
        return dodatki;
    }
    @Override
    public String pokaz() {
        return "Wejscia: " + informacja +" ---> Dodatki: "+ dodatki;
    }
}

class OfertaFactory {
    public enum OfertaTyp {
        Oszczedna,
        Srednia,
        Droga
    }

    public static Oferta createOferta(OfertaTyp ofertaTyp) {
        switch (ofertaTyp) {
            case Oszczedna:
                return new OszczednaOferta();
            case Srednia:
                return new SredniaOferta();
            case Droga:
                return new DrogaOferta();
        }
        throw new IllegalArgumentException("Typ " + ofertaTyp + " jest nie rozpoznawalny.");
    }
}
