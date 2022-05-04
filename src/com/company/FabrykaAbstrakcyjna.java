package com.company;

public class FabrykaAbstrakcyjna {

    public static FabrykaCzekolady getTypCzekolady(String typCzekolady) {
        switch(typCzekolady) {
            case "Klasyczne":
                return new KlasyzneCzekoladyFactory();
            case "Nowatorskie":
                return new NowatorskieCzelkoladyFactory();
            default:
                return null;
        }
    }
    public static void main(String[] args){
        FabrykaCzekolady klasycznaCzekolada = getTypCzekolady("Klasyczne");
        CzekoladaMelczna czekoladaMelczna = klasycznaCzekolada.stworzCzekoladeMleczna();
        System.out.println("Wymiar klasycznej czekolady mlecznej:" + czekoladaMelczna.getWymiar());

        FabrykaCzekolady nowatorskaCzekolada = getTypCzekolady("Nowatorskie");
        CzekoladaMelczna nowatorskaCzekoladaMleczna = nowatorskaCzekolada.stworzCzekoladeMleczna();
        System.out.println("Wymiar nowatorskiej czekolady mlecznej:" + nowatorskaCzekoladaMleczna.getWymiar());

        CzekoladaZNadzieniem czekoladaZNadzieniem = klasycznaCzekolada.stworzCzekoladeZNadzieniem();
        System.out.println("Nadzienie klasycznej czekolady: " + czekoladaZNadzieniem.getNadzienie());

        CzekoladaZNadzieniem nowatorskaCzekoladaZNadzieniem = nowatorskaCzekolada.stworzCzekoladeZNadzieniem();
        System.out.println("Nadzienie nowatorskiej czekolady: " + nowatorskaCzekoladaZNadzieniem.getNadzienie());
    }

}

interface FabrykaCzekolady {
    CzekoladaMelczna stworzCzekoladeMleczna();
    CzekoladaZNadzieniem stworzCzekoladeZNadzieniem();
    Bombonierka stworzBombonierke();
}

interface CzekoladaMelczna {
    String getWymiar();
}
interface CzekoladaZNadzieniem {
    String getNadzienie();
}
interface Bombonierka {
    String getPudelko();
}
class KlasyzneCzekoladyFactory implements FabrykaCzekolady {
    public CzekoladaMelczna stworzCzekoladeMleczna() {
        return new KlasycznaCzekoladaMleczna();
    }
    public CzekoladaZNadzieniem stworzCzekoladeZNadzieniem() {
        return new KlasycznaCzekoladaZNadzieniem();

    }
    public Bombonierka stworzBombonierke() {
        return new KlasycznaBombonierka();
    }
}
class KlasycznaCzekoladaMleczna implements CzekoladaMelczna {
    public String getWymiar() {
        return "kawadrat 10x15";
    }
}

class KlasycznaCzekoladaZNadzieniem implements CzekoladaZNadzieniem {
    public String getNadzienie() {
        return "truskawka";
    }
}

class KlasycznaBombonierka implements Bombonierka {
    public String getPudelko() {
        return "blaszane pudełko";
    }
}
class NowatorskieCzelkoladyFactory implements FabrykaCzekolady {
    public CzekoladaMelczna stworzCzekoladeMleczna() {
        return new NowatorskaCzekoladaMleczna();
    }
    public CzekoladaZNadzieniem stworzCzekoladeZNadzieniem() {
        return new NowatorskaCzekoladaZNadzieniem();

    }
    public Bombonierka stworzBombonierke() {
        return new NowatorskaBombonierka();
    }
}


class NowatorskaCzekoladaMleczna implements CzekoladaMelczna {
    public String getWymiar() {
        return "trojkat 10x10x10";
    }
}

class NowatorskaCzekoladaZNadzieniem implements CzekoladaZNadzieniem {
    public String getNadzienie() {
        return "pomarancza z chilli";
    }
}

class NowatorskaBombonierka implements Bombonierka {
    public String getPudelko() {
        return "plastikowe pudelko w ksztalcie kwiatu lotosu";
    }
}