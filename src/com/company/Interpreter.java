package com.company;

import java.util.ArrayList;

public class Interpreter {
    public static void main(String[] args) {

        Kontekst kontekst = new Kontekst();
        ArrayList<WyrazenieAbstrakcyjne> wyrazenie = new ArrayList<>();

        wyrazenie.add(new WyrazenieTerminalne());
        wyrazenie.add(new WyrazenieNieterminalne());
        wyrazenie.add(new WyrazenieTerminalne());

//        for (WyrazenieAbstrakcyjne wyr: wyrazenie
//             ) {
//            wyr.Interpretuj(kontekst);
//        }

        wyrazenie.forEach((n) -> n.Interpretuj(kontekst));
    }
}

class Kontekst{}

abstract class WyrazenieAbstrakcyjne {

    public abstract void Interpretuj(Kontekst kontekst);

}

class WyrazenieTerminalne extends WyrazenieAbstrakcyjne{

    @Override
    public void Interpretuj(Kontekst kontekst) {
        System.out.println("Wywołano WyrazenieTerminalne.Interpretuj()");
    }
}
class WyrazenieNieterminalne extends WyrazenieAbstrakcyjne{

    @Override
    public void Interpretuj(Kontekst kontekst) {
        System.out.println("Wywołano WyrazenieNieterminalne.Interpretuj()");
    }
}

