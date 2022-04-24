package com.company;

public class LancuchZobowiazan {
    public static void main(String[] args) {

        AbstrakcyjnaObsluga Abo1 = new SpecyficznaOblsuga1();
        AbstrakcyjnaObsluga Abo2 = new SpecyficznaObsluga2();

        Abo1.UstawNastepce(Abo2);

        int[] zobowiazania = {1, 4, 17, 26, 18, 5, 28, 22};

        for (int zobowiazanie : zobowiazania
        ) {
            Abo1.Obsluz(zobowiazanie);
        }
    }
}

abstract class AbstrakcyjnaObsluga {

    protected AbstrakcyjnaObsluga nastepca;

    public void UstawNastepce(AbstrakcyjnaObsluga nastepca) {
        this.nastepca = nastepca;
    }

    public abstract void Obsluz(int zobowiazanie);
}

class SpecyficznaOblsuga1 extends AbstrakcyjnaObsluga {

    @Override
    public void Obsluz(int zobowiazanie) {
        if (zobowiazanie >= 0 && zobowiazanie < 10) {
            System.out.println(this.getClass().getName() + " Obsłużono zobowiazanie " +
                    zobowiazanie);
        } else if (nastepca != null) {
            nastepca.Obsluz(zobowiazanie);
        }
    }
}

class SpecyficznaObsluga2 extends AbstrakcyjnaObsluga {
    @Override
    public void Obsluz(int zobowiazanie) {
        if (zobowiazanie >= 10 && zobowiazanie < 20) {
            System.out.println(this.getClass().getName() + " Obsłużono zobowiazanie " +
                    zobowiazanie);
        } else if (nastepca != null) {
            nastepca.Obsluz(zobowiazanie);
        }
    }
}
