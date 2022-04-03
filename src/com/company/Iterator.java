package com.company;

abstract class Iterator
{
    public abstract Object Pierwszy();
    public abstract Object Nastepny();
    public abstract Boolean CzyKoniec();
    public abstract Object PobierzElement();
}

class SpecyficznyIterator extends Iterator{

    private SpecyficznyKontener kontener;
    private int obecny = 0;

    public SpecyficznyIterator(SpecyficznyKontener kontener) {
        this.kontener = kontener;
    }

    @Override
    public Object Pierwszy() {
        return null;
    }

    @Override
    public Object Nastepny() {
        return null;
    }

    @Override
    public Boolean CzyKoniec() {
        return null;
    }

    @Override
    public Object PobierzElement() {
        return null;
    }
}

class SpecyficznyKontener {
}