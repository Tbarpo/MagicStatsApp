package com.topdeckstudios.magicstats;

import java.util.Date;

/**
 * Created by anthony on 1/23/16.
 */
public class MatchData {

    public Deck deck1;
    public Deck deck2;
    public String notes;
    public int deck1Wins;
    public int deck2Wins;
    public Date date;

    public MatchData(Deck deck1, Deck deck2, String notes, int deck1Wins, int deck2Wins) {
        this.deck1 = deck1;
        this.deck2 = deck2;
        this.notes = notes;
        this.deck1Wins = deck1Wins;
        this.deck2Wins = deck2Wins;
        date = new Date();
    }

    public Deck getDeck1() {
        return deck1;
    }

    public Deck getDeck2() {
        return deck2;
    }

    public String getNotes() {
        return notes;
    }

    public int getDeck1Wins() {
        return deck1Wins;
    }

    public int getDeck2Wins() {
        return deck2Wins;
    }

    public Date getDate() {
        return date;
    }
}