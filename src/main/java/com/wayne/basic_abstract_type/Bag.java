package com.wayne.basic_abstract_type;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<Item> implements Iterable<Item>{

    public Bag() {
    }

    void add(Item item){

    }

    boolean isEmpty(){
        return false;
    }

    int size(){
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    @Override
    public void forEach(Consumer<? super Item> action) {
        Iterable.super.forEach(action);
    }


    @Override
    public Spliterator<Item> spliterator() {
        return Iterable.super.spliterator();
    }
}
