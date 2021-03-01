
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bestiary {

    @SerializedName("sections")
    @Expose
    private List<MonsterType> monsters = null;

    public List<MonsterType> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<MonsterType> monsters) {
        this.monsters = monsters;
    }


    @Override
    public String toString() {
        return "Bestiary{" +
                "sections=" + monsters +
                '}';
    }
}
