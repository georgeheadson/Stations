package org.example.stations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Table (name= "station")
@Getter
@Setter
public class Station {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "sim.id")
    public Sim sim;

    @Column (name = "isur_id")
    public Integer isurId;

    @Column (name = "zabbix_id")
    public Integer zabbixId;

    @Column(name = "power")
    public String power;

    @Column (name = "mac")
    public String mac;

    @Column (name = "name")
    public String name;

    @Column (name= "place")
    public String place;

    @Column (name = "place_date")
    public LocalDateTime placeDate;

    @Column (name = "username")
    public String username;

    @Column (name = "passsword")
    public String password;

    @Column (name = "program")
    public String program;

    @Column (name = "area")
    public String area;

    @Column (name = "coordinates")
    public String coordinates;

    @Column (name = "replace_date")
    public LocalDateTime replaceDate;

    @Column (name = "replace_reason")
    public String replaceReason;

    @Column (name = "type")
    @Enumerated(EnumType.STRING)
    public StationType type;

    @Column (name = "comment")
    public String comment;

    @CreationTimestamp (source = SourceType.DB)
    @Column (name = "creation_time")
    public LocalDateTime creationTime;


}
