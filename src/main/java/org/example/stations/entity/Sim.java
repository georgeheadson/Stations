package org.example.stations.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "sim")
@Getter
@Setter
public class Sim {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public Integer id;

    @Column (name = "iccid")
    public String iccid;

    @Column (name = "phone")
    public String phone;

    @Column (name = "ip")
    public String ip;

    @Column (name = "vendor")
    public String vendor;

    @Column (name = "apn")
    public String apn;
}
