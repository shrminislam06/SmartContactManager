package com.SmartManager.SmartContactManager.entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "CONTACT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nickName;
    private String work;
    private String email;
    private String phone;
    private String images;
    @Column(length = 50000)
    private String description;

    @ManyToOne
    private Users users;

}
