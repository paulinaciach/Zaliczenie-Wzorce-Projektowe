package com.company;

import java.util.ArrayList;

public class Budowniczy {

    public static void main(String[] args) {

        Kierownik kierownik = new Kierownik();
        EkspresBudowniczy ekspresBudowniczy = new EkspresBudowniczy();

        kierownik.ZrobKawe(ekspresBudowniczy, 100, 100,10, 5);

        ekspresBudowniczy.nowaKawa.PokazSkladniki();

        ekspresBudowniczy.nowaKawa.DodajCukier(10);

        System.out.println("**********");

        ekspresBudowniczy.nowaKawa.PokazSkladniki();

    }

    static class KawaProdukt{

        private ArrayList<Integer> skladniki = new ArrayList<Integer>();

        public void DodajSkladniki(int woda, int mleko, int kawa)
        {
            skladniki.add(woda);
            skladniki.add(mleko);
            skladniki.add(kawa);
        }

        public void PokazSkladniki()
        {
            System.out.println("\nSkladniki kawki -------");
            for (int skladnik : skladniki
                 ) {
                System.out.println(skladnik);
            }
        }

        public void DodajCukier(int cukier) {
            skladniki.add(cukier);
        }
    }

    public interface IEkspresBudowniczy{

        public void ZrobKawe(int woda, int mleko, int kawa);
        public void EkstraCukier(int cukier);
        public KawaProdukt ZwrocProdukt();
    }

    public static class EkspresBudowniczy implements IEkspresBudowniczy{

        private KawaProdukt nowaKawa = new KawaProdukt();

        @Override
        public void ZrobKawe(int woda, int mleko, int kawa) {
            nowaKawa.DodajSkladniki(woda, mleko, kawa);
        }

        @Override
        public void EkstraCukier(int cukier) {

            nowaKawa.DodajCukier(cukier);

        }

        @Override
        public KawaProdukt ZwrocProdukt() {
            return nowaKawa;
        }
    }
    static class Kierownik
    {
        public void ZrobKawe(EkspresBudowniczy ekspresBudowniczy, int woda, int mleko, int kawa, int cukier)
        {
            ekspresBudowniczy.ZrobKawe(woda, mleko, kawa);
            ekspresBudowniczy.EkstraCukier(cukier);
        }
    }



}
