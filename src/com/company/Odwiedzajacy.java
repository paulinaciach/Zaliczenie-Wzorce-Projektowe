package com.company;

import java.util.ArrayList;
import java.util.List;

abstract class ElementOdwiedzajacy {
    public abstract void Akceptuj(Odwiedzajacy odwiedzajacy);
}

class SpecyficznyElement extends ElementOdwiedzajacy {

    @Override
    public void Akceptuj(Odwiedzajacy odwiedzajacy) {
        odwiedzajacy.OdwiedzSpecyficznyElement(this);
    }

    public void ZrobCos() {
    }
}

class InnySpecyficznyElement extends ElementOdwiedzajacy {
    @Override
    public void Akceptuj(Odwiedzajacy odwiedzajacy) {
        odwiedzajacy.OdwiedzInnySpecyficznyElement(this);
    }

    public void ZrobCos() {
    }
}

abstract class Odwiedzajacy {
    public abstract void OdwiedzSpecyficznyElement(
            SpecyficznyElement specyficznyElement);

    public abstract void OdwiedzInnySpecyficznyElement(
            InnySpecyficznyElement innySpecyficznyElement);
}

class SpecyficznyOdwiedzajacy extends Odwiedzajacy {
    @Override
    public void OdwiedzSpecyficznyElement(
            SpecyficznyElement specyficznyElement) {
        System.out.println(specyficznyElement.getClass().getName() + " odwiedzony przez "
                + this.getClass().getName());
    }

    @Override
    public void OdwiedzInnySpecyficznyElement(
            InnySpecyficznyElement innySpecyficznyElement) {
        System.out.println(innySpecyficznyElement.getClass().getName() + " odwiedzony przez "
                + this.getClass().getName());
    }
}

class InnySpecyficznyOdwiedzajacy extends Odwiedzajacy {
    @Override
    public void OdwiedzSpecyficznyElement(
            SpecyficznyElement specyficznyElement) {
        System.out.println(specyficznyElement.getClass().getName() + " odwiedzony przez "
                + this.getClass().getName());
    }

    @Override
    public void OdwiedzInnySpecyficznyElement(
            InnySpecyficznyElement innySpecyficznyElement) {
        System.out.println(innySpecyficznyElement.getClass().getName() + " odwiedzony przez "
                + this.getClass().getName());
    }
}
class Struktura
{
    private List<ElementOdwiedzajacy> elementy = new ArrayList<ElementOdwiedzajacy>();

    public void Dolacz(ElementOdwiedzajacy element)
    {
        elementy.add(element);
    }

    public void Odlacz(ElementOdwiedzajacy element)
    {
        elementy.remove(element);
    }

    public void Akceptuj(Odwiedzajacy odwiedzajacy)
    {
        elementy.forEach((n) ->n.Akceptuj(odwiedzajacy));
    }
}
class OdwiedzajacyMain {
    public static void main(String[] args) {

        Struktura o = new Struktura();
        o.Dolacz(new SpecyficznyElement());
        o.Dolacz(new InnySpecyficznyElement());

        SpecyficznyOdwiedzajacy v1 = new SpecyficznyOdwiedzajacy();
        InnySpecyficznyOdwiedzajacy v2 = new InnySpecyficznyOdwiedzajacy();

        o.Akceptuj(v1);
        o.Akceptuj(v2);

    }
}