package com.company;


class FasadaMain
{
    public static void main(String[] args) {

        Fasada fasada = new Fasada("jeden", "dwa", "trzy", "cztery");

        fasada.MetodaA();

        fasada.MetodaB();
    }
}

class PodSystemPierwszy
{

    public void MetodaPierwsza()
    {
        System.out.println("PodSystem Pierwszy");
    }

}
class PodSystemDrugi
{
    public void MetodaDruga()
    {
        System.out.println("PodSystem Drugi");
    }
}
class PodSystemTrzeci
{
    public void MetodaTrzecia()
    {
        System.out.println("PodSystem Trzeci");
    }
}
class PodSystemCzwarty
{
    public void MetodaCzwarta()
    {
        System.out.println("PodSystem Czwarty");
    }
}

class Fasada
{
    String jeden;
    String dwa;
    String trzy;
    String cztery;

    public Fasada(String jeden, String dwa, String trzy, String cztery)
    {
        this.jeden = jeden;
        this.dwa = dwa;
        this.trzy = trzy;
        this.cztery = cztery;
    }

    PodSystemPierwszy podSystemPierwszy = new PodSystemPierwszy();
    PodSystemDrugi podSystemDrugi = new PodSystemDrugi();
    PodSystemTrzeci podSystemTrzeci = new PodSystemTrzeci();
    PodSystemCzwarty podSystemCzwarty = new PodSystemCzwarty();


    public void MetodaA()
    {

        System.out.println("To jest metoda A");

        podSystemPierwszy.MetodaPierwsza();

        podSystemDrugi.MetodaDruga();

        podSystemCzwarty.MetodaCzwarta();



    }
    public void MetodaB()
    {
        System.out.println("To jest metoda B");

        podSystemDrugi.MetodaDruga();

        podSystemTrzeci.MetodaTrzecia();

    }

}



