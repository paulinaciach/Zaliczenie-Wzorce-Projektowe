package com.company;
/**
 * Implementacja wzorca projektowego Singleton przy wykorzystaniu diagramu
 * klas udostepnionego w kursie w zakładce Singleton
**/
public final class Singleton {

    public static void main(String[] args) {

        Singleton singleton = Singleton.zwrocInstancje("Singleton1");
        Singleton singleton1 = Singleton.zwrocInstancje("Singleton2");

        System.out.println(singleton.wartosc);
        System.out.println(singleton1.wartosc);
    }

    private static Singleton instancja;
    public String wartosc;

    private Singleton(String wartosc) {
        this.wartosc = wartosc;
    }

    public static Singleton zwrocInstancje(String wartosc) {
        if (instancja == null) {
            instancja = new Singleton(wartosc);
        }
        return instancja;
    }

}
