package com.example.sample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",length = 20,nullable = false)
    private String name;
    @Column(length = 24,nullable = false)
    private String family;
    @Column(nullable = false)
    private Integer age;
    @Column(length = 10,nullable = false,unique = true)
    private String nationalCode;
    @Column(nullable = false)
    private LocalDate birthDay;
//    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
//    private List<Account> accounts;
//
//    public User(Long id, String name, String family, Integer age, String nationalCode, LocalDate birthDay) {
//        this.id = id;
//        this.name = name;
//        this.family = family;
//        this.age = age;
//        this.nationalCode = nationalCode;
//        this.birthDay = birthDay;
//    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", family='" + family + '\'' +
//                ", age=" + age +
//                ", nationalCode='" + nationalCode + '\'' +
//                ", birthDay=" + birthDay +
//                '}';
//    }
}