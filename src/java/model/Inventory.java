package model;

import model.enums.GENDER;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    private String name;

    private int herb;

    private int redHerb;

@Enumerated(value = EnumType.STRING)
    private GENDER gender;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRedHerb() {
        return redHerb;
    }

    public void setRedHerb(int redHerb) {
        this.redHerb = redHerb;
    }

    public int getHerb() {
        return herb;
    }

    public void setHerb(int herb) {
        this.herb = herb;
    }
    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}
