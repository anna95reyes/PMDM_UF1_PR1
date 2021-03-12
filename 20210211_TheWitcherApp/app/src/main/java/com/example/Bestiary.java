
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bestiary {

    @SerializedName("sections")
    @Expose
    private List<MonsterType> monsterTypes = null;

    public List<MonsterType> getMonsterTypes() {
        return monsterTypes;
    }

    public void setMonsterTypes(List<MonsterType> monsterTypes) {
        this.monsterTypes = monsterTypes;
    }


    @Override
    public String toString() {
        return "Bestiary{" +
                "sections=" + monsterTypes +
                '}';
    }
}
