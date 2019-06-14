package com.votesystem.votesystem.model;


import lombok.*;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Topic implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private int count;
    @Column(name = "status")
    private boolean status;

    public Topic(String description) {
        this.description = description;
    }
}
