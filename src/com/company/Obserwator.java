package com.company;


import java.util.ArrayList;
import java.util.List;

abstract class Obserwator{

    public abstract void Aktualizuj();

}

abstract class Obserwowany{

    private List<Obserwator> obserwatorzy = new ArrayList<>();

    public void DolaczObserwatora(Obserwator obserwator)
    {
        obserwatorzy.add(obserwator);
    }

    public void OdlaczObserwatora(Obserwator obserwator)
    {
        obserwatorzy.remove(obserwator);
    }

    public void Powiadom()
    {
        for (Obserwator obs : obserwatorzy
             ) {
            obs.Aktualizuj();
        }
    }
}

class SpecyficznyObserwowany extends Obserwowany{

    public String StanObserwowanego;

    public String getStanObserwowanego() {
        return StanObserwowanego;
    }

    public void getStanObserwowanego(String obserwowany) {
        StanObserwowanego = obserwowany;
    }
}

class SpecyficznyObserwator extends Obserwator{

    private String nazwa;
    private String obserwatorStan;
    public SpecyficznyObserwowany Obserwowany;

    public SpecyficznyObserwowany getObserwowany() {
        return Obserwowany;
    }

    public void setObserwowany(SpecyficznyObserwowany obserwowany) {
        Obserwowany = obserwowany;
    }
    public SpecyficznyObserwator(
            SpecyficznyObserwowany obserwowany, String nazwa)
    {
        this.Obserwowany = obserwowany;
        this.nazwa = nazwa;
    }

    @Override
    public void Aktualizuj() {

        obserwatorStan = Obserwowany.StanObserwowanego;
        System.out.println("Obserwator "+nazwa+" ma nowy stan o wartości: "+ obserwatorStan);

    }
}

class ObserwatorMain{
    public static void main(String[] args) {
        SpecyficznyObserwowany s = new SpecyficznyObserwowany();

        s.DolaczObserwatora(new SpecyficznyObserwator(s, "X"));
        s.DolaczObserwatora(new SpecyficznyObserwator(s, "Y"));
        s.DolaczObserwatora(new SpecyficznyObserwator(s, "Z"));

        s.StanObserwowanego = "ABC";
        s.Powiadom();
    }
}