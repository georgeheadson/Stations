package org.example.stations.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "power")
public class Power {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public Integer id;

    @Column (name = "name", nullable = false)
    public String name;

    @Column (name = "parent")
    public Integer parent;

    @Column (name = "comment")
    public String comment;

}
