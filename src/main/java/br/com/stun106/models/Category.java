package br.com.stun106.models;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nameCategorie;
    
    public Category() {
        
    }

    public Category(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategorie() {
        return nameCategorie;
    }

    public void setNameCategorie(String nameCategorie) {
        this.nameCategorie = nameCategorie;
    }


}
