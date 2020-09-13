package com.example.napofirestore.entities;

import com.example.napofirestore.api.templates.response.View;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
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
@JsonView(View.All.class)
public class UserEntity {
    @Id
    @Column(name = "id")
    @JsonView(View.Public.class)
    private int id;

    @Basic
    @Column(name = "first_name")
    @JsonView(View.Public.class)
    private String firstName;

    @Basic
    @Column(name = "last_name")
    @JsonView(View.Public.class)
    private String lastName;

    @Basic
    @Column(name = "profile_picture")
    @JsonView(View.Public.class)
    private String profilePicture;

    @Basic
    @Column(name = "birth_date")
    @JsonView(View.Public.class)
    private Integer birthDate;

    @Basic
    @Column(name = "phone")
    @JsonView(View.Public.class)
    private String phone;

    @Basic
    @Column(name = "email")
    @JsonView(View.Public.class)
    private String email;

    @OneToMany(targetEntity = UserFollowingTopicEntity.class, mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<UserFollowingTopicEntity> userFollowingTopics;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private CredentialEntity credential;

    @Transient
    private String token;
}
