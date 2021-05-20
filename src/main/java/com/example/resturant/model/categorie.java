package com.example.resturant.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name="categorie")
public class categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categorieId;

    public int getcategorieId() {
        return categorieId;
    }

    public void setcategorieId(int categorieId) { this.categorieId = categorieId; }
    ////////////////////////////////////////////
    @NotEmpty( message="Name may not be empty")
    @Column(name = "categorie_name")
    private String categorieName ;

    public String getcategorieName() { return categorieName ; }

    public void setcategorieName(String categorieName ) { this.categorieName  = categorieName ; }
    ////////////////////////////////////////////

}
