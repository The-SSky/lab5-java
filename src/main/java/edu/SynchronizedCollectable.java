package edu;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;

public class SynchronizedCollectable implements Collectable {

    private final Collectable c;

    public SynchronizedCollectable(Collectable c) {
        this.c = c;
    }

    @Override
    public synchronized String getTitle(){
        return c.getTitle();
    }

    @Override
    public synchronized int getItemsCount(){
        return c.getItemsCount();
    }

    @Override
    public synchronized int getPrice(){
        return c.getPrice();
    }

    @Override
    public synchronized String getItem(int index){
        return c.getItem(index);
    }

    @Override
    public synchronized int getDuration(int index){
        return c.getDuration(index);
    }

    @Override
    public synchronized void setTitle(String title){
        c.setTitle(title);
    }

    @Override
    public synchronized void setPrice(int price){
        c.setPrice(price);
    }

    @Override
    public synchronized void setItem(int index, String title){
        setItem(index, title);
    }

    @Override
    public synchronized void setDuration(int index, int duration){
        c.setDuration(index, duration);
    }

    @Override
    public synchronized int getTotalDuration(){
        return c.getTotalDuration();
    }

    @Override
    public synchronized void output(OutputStream out) throws IOException{
        c.output(out);
    }

    @Override
    public synchronized void write(BufferedWriter out) throws IOException{
        c.write(out);
    }
}
