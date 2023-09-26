package com.SmartManager.SmartContactManager.entity;



import jakarta.persistence.*;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
    private long id;
@NotBlank(message = " Name shouldn't be blank.!!")
    private String name;
    @Column(unique = true)
    private String email;
    @Size(min = 5,message = "password should contain minimum 5 character!!")
    private String password;
    private String role;
    private String bloodGroup;
    private  boolean enabled;
    private String imageUrl;
    @Column(length = 500)

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "users")

    private List<Contact> contactList=new ArrayList<>();



}
