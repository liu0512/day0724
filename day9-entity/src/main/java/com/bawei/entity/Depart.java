package com.bawei.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hg_depart")
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
