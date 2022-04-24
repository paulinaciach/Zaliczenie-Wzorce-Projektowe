package com.company;

abstract class Mediator {

    public abstract void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik);

}
abstract class ObiektWspolpracownika {

    protected Mediator mediator;

    public ObiektWspolpracownika(Mediator mediator){
        this.mediator=mediator;
    }

}
class SpecyficznyObiekt1  extends ObiektWspolpracownika{

    public SpecyficznyObiekt1(Mediator mediator) {
        super(mediator);
    }
    public void Wyslij(String wiadomosc)
    {
        mediator.Wyslij(wiadomosc, this);
    }

    public void Powiadom(String wiadomosc)
    {
        System.out.println("SpecyficznyObiekt1 dostaje wiadomość: " + wiadomosc);
    }
}
class SpecyficznyObiekt2 extends ObiektWspolpracownika{

    public SpecyficznyObiekt2(Mediator mediator) {
        super(mediator);
    }
    public void Wyslij(String wiadomosc)
    {
        mediator.Wyslij(wiadomosc, this);
    }

    public void Powiadom(String wiadomosc)
    {
        System.out.println("SpecyficznyObiekt2 dostaje wiadomość: " + wiadomosc);
    }
}
class SpecyficznyMediator extends Mediator{

    public void setWspolpracownik1(SpecyficznyObiekt1 wspolpracownik1) {
        this.wspolpracownik1 = wspolpracownik1;
    }

    public void setWspolpracownik2(SpecyficznyObiekt2 wspolpracownik2) {
        this.wspolpracownik2 = wspolpracownik2;
    }

    SpecyficznyObiekt1 wspolpracownik1;
    SpecyficznyObiekt2 wspolpracownik2;

    @Override
    public void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik) {

        if(wspolpracownik == wspolpracownik1){
            wspolpracownik2.Powiadom(wiadomosc);
        }else
            wspolpracownik1.Powiadom(wiadomosc);
    }
}
class MediatorMain{
    public static void main(String[] args) {

        SpecyficznyMediator specyficznyMediator = new SpecyficznyMediator();
        SpecyficznyObiekt1 specyficznyObiekt1 = new SpecyficznyObiekt1(specyficznyMediator);
        SpecyficznyObiekt2 specyficznyObiekt2 = new SpecyficznyObiekt2(specyficznyMediator);

        specyficznyMediator.setWspolpracownik1(specyficznyObiekt1);
        specyficznyMediator.setWspolpracownik2(specyficznyObiekt2);

        specyficznyObiekt1.Wyslij("Hej! Bedziesz na zajeciach?");
        specyficznyObiekt2.Wyslij("Jasne, że tak :)");
        specyficznyObiekt1.Wyslij("Dziekuje za potwierdzenie");
        specyficznyObiekt2.Wyslij("Proszę");
        specyficznyObiekt1.Wyslij("Miłego!");
    }
}