package com.example.napofirestore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "napo-firestore")
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class UserEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "profile_picture")
    private String profilePicture;

    @Basic
    @Column(name = "birth_date")
    private Integer birthDate;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "email")
    private String email;

    @OneToMany(targetEntity = UserFollowingTopicEntity.class, mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<UserFollowingTopicEntity> userFollowingTopics;

}
