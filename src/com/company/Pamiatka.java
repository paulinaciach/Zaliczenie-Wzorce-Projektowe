package com.company;

public class Pamiatka {

    private String stan;

    public Pamiatka(String stan)
    {
        this.stan = stan;
    }

    public String getStan() {
        System.out.println(("Stan = " + stan));
        return stan;
    }

}

class Zarzadzajacy{

    public Pamiatka pamiatka;

    public Pamiatka getPamiatka() {
        return pamiatka;
    }

    public void setPamiatka(Pamiatka value) {
        this.pamiatka = value;
    }

}

class Inicjator{

    public String stan;

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        stan = stan;
    }

    public Pamiatka UtworzPamiatke()
    {
        return (new Pamiatka(stan));
    }
    public void UstawPamiatke(Pamiatka pamiatka)
    {
        System.out.println("Przywracanie stanu...");
        stan = pamiatka.getStan();
    }
}

class PamiatkaMain{
    public static void main(String[] args) {
        Inicjator i = new Inicjator();
        i.stan = "Włącz";

        Zarzadzajacy z = new Zarzadzajacy();
        z.pamiatka = i.UtworzPamiatke();

        i.stan = "Wyłącz";

        i.UstawPamiatke(z.pamiatka);
    }
}