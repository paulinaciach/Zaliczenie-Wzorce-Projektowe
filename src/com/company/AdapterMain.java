package com.company;

/**
 * Implementacja wzorca projektowego Adapter
 * Zadnie 1
 * brak metody wirtualnej, w Jabvie z zalozenia metody sa wirtualne z kilkoma wyjatkami
 **/

public class AdapterMain {

    public static void main(String[] args) {

        ElementDocelowy elementDocelowy = new Adapter();
        elementDocelowy.MetodaA();
    }
}

class ElementDocelowy {

    public void MetodaA(){
        System.out.println("Wywołano ElementDocelowy MetodaA()");
    }
}

class Adaptowany{

    public void MetodaAdaptowanego(){
        System.out.println("Wywołano MetodaAdaptowanego()");
    }

}

class Adapter extends ElementDocelowy{

    private Adaptowany adaptowany = new Adaptowany();

    @Override
    public void MetodaA() {
        adaptowany.MetodaAdaptowanego();
    }
}