package com.example.AutoWorkShop.domain.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity{

    private String firstName;
    private String secondName;
    private String telephone;
//    private Set<CarEntity> carEntities = new HashSet<>();

    public ClientEntity() {
    }

    public ClientEntity(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    @Column(name = "telephone", nullable = false)
    public String getTelephone() {
        return telephone;
    }

//    @OneToMany(mappedBy = "client")
//    public Set<CarEntity> getCarEntities() {
//        return carEntities;
//    }

    public ClientEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ClientEntity setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public ClientEntity setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

//    public ClientEntity setCarEntities(Set<CarEntity> carEntities) {
//        this.carEntities = carEntities;
//        return this;
//    }
}
