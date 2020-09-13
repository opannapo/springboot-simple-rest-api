package com.example.napofirestore.entities;

import com.example.napofirestore.api.templates.response.View;
import com.fasterxml.jackson.annotation.JsonView;
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
@JsonView({View.All.class, View.Owner.class,})
public class TopicTypeEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "label")
    private String label;


}
