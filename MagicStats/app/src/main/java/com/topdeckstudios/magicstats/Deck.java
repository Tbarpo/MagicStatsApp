package com.topdeckstudios.magicstats;

import java.io.Serializable;

/**
 * Created by anthony on 1/23/16.
 */
public class Deck implements Serializable{

    public String name;
    public String format;
    public boolean owned;



    public Deck(String name, String format, boolean owned) {
        this.name = name;
        this.format = format;
        this.owned = owned;
    }

    public String getName() {
        return name;
    }
    public String getFormat() {
        return format;
    }
    public boolean getOwned() {
        return owned;
    }

    public boolean equals(Deck o){
        return this.name.compareTo(o.name)== 0 && this.format.compareTo(o.format)==0 && this.owned == o.owned;
    }

}