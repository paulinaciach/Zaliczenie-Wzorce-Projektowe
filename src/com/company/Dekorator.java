package com.company;


abstract class Komponent{
    public abstract void Operacja();
}

class Produkt extends Komponent{

    @Override
    public void Operacja() {
        System.out.println("Produkt Operacja()");
    }
}

abstract class Dekorator extends Komponent{

    protected Komponent komponent;

    public void ustawKomponent(Komponent komponent){
        this.komponent = komponent;
    }

    @Override
    public void Operacja() {
        if(komponent != null){
            komponent.Operacja();
        }
    }
}

class DekoratorA extends Dekorator{
    @Override
    public void Operacja()
    {
        super.Operacja();

        DodanaFunkcjonalnosc();
        System.out.println("DekoratorA.Operacja()");
    }

    void DodanaFunkcjonalnosc()
    {
        System.out.println("Wywołano dodatkową funkcjonalność z dekoratora A");
    }

}

class DekoratorB extends Dekorator{

    @Override
    public void Operacja()
        {
        super.Operacja();
        System.out.println("DekoratorB.Operacja()");
        }
}

class DekoratorMain{
    public static void main(String[] args) {

        Produkt p = new Produkt();
        DekoratorA da = new DekoratorA();
        DekoratorB db = new DekoratorB();

        db.ustawKomponent(p);
        da.ustawKomponent(db);


        da.Operacja();

    }
}