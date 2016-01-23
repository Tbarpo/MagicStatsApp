package com.topdeckstudios.magicstats;

/**
 * Created by anthony on 1/23/16.
 */
public class Deck {

    public String name;
    public String format;
    public boolean owned;

    public Deck(String name, String format, boolean owned) {
        this.name = name;
        this.format = format;
        this.owned = owned;
    }
}