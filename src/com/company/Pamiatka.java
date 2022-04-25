package com.company;

public class Pamiatka {

    public String setStan(String stan) {
        System.out.println(("Stan = " + stan));
        this.stan = stan;
        return stan;
    }

    public String getStan() {
        return stan;
    }

    private String stan;

    public Pamiatka(String stan)
    {
        this.stan = stan;
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

        System.out.println("Stan = " + stan);
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
        this.stan = pamiatka.setStan(pamiatka.getStan());
    }
}

class PamiatkaMain{
    public static void main(String[] args) {
        Inicjator i = new Inicjator();
        i.stan = "Włącz";
        i.getStan();

        Zarzadzajacy z = new Zarzadzajacy();
        z.pamiatka = i.UtworzPamiatke();

        i.stan = "Wyłącz";
        i.getStan();

        i.UstawPamiatke(z.pamiatka);

    }
}