package com.project.twitterclone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tweet tweet;

}
