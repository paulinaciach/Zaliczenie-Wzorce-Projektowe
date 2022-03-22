package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PylekMain {

    public static void main(String[] args) {

        int daneZewnetrzne = 42;

        FabrykaPylkow fabryka = new FabrykaPylkow();

        SpecyficznyPylek specQ = (SpecyficznyPylek) fabryka.GetPylek("Q");
        specQ.PrzykladowaMetoda(--daneZewnetrzne);

        SpecyficznyPylek specW = (SpecyficznyPylek) fabryka.GetPylek("W");
        specW.PrzykladowaMetoda(--daneZewnetrzne);

        SpecyficznyPylek specE = (SpecyficznyPylek) fabryka.GetPylek("E");
        specE.PrzykladowaMetoda(--daneZewnetrzne);
    }

}

abstract class Pylek{


    public abstract void PrzykladowaMetoda(int daneZewnetrzne);
}

class SpecyficznyPylek extends Pylek {

    @Override
    public void PrzykladowaMetoda(int daneZewnetrzne) {
        System.out.println("SpecyficznyPylek: " + daneZewnetrzne);
    }

}
class FabrykaPylkow{

    private Map<String, Object> pylki = new HashMap<String, Object>();


    public FabrykaPylkow() {
        pylki.put("Q",  new SpecyficznyPylek());
        pylki.put("W",  new SpecyficznyPylek());
        pylki.put("E",  new SpecyficznyPylek());
    }


    public Pylek GetPylek(String klucz)
    {
        return ((Pylek) pylki.get(klucz));
    }


}
