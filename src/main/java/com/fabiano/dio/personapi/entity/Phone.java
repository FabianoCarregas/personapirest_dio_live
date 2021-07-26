package com.fabiano.dio.personapi.entity;
import com.fabiano.dio.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data    //  getter and setter insert
@Builder   // constructor insert
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id                         //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // id creator
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)       //not null
    private PhoneType type;

    @Column(nullable = false)
                                                            //many phone-numbers to one person
    private String number;



}
