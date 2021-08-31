package com.challenge.challenge;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="province")
public class Province {
    private @GeneratedValue @Id Long id;
    private String name;
    private String capital;
    
    public Province() {}

    public Province(String name , String capital) {
        this.name = name;
        this.capital = capital;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    
}
