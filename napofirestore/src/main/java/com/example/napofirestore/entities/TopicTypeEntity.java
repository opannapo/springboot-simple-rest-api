package com.example.napofirestore.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "topic_type", schema = "napo-firestore")
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class TopicTypeEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "label")
    private String label;



}
