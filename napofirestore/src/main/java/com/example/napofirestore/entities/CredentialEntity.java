package com.example.napofirestore.entities;

import com.example.napofirestore.api.templates.response.View;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "credential", schema = "napo-firestore")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@JsonView(View.All.class)
public class CredentialEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "key")
    private String key;

    @Basic
    @Column(name = "signature")
    private String signature;

    @Basic
    @Column(name = "type")
    @JsonView(View.AuthDefault.class)
    private int type;

    @Basic
    @Column(name = "user_id")
    @JsonView(View.AuthDefault.class)
    private int userId;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, insertable = false, name = "user_id")
    @JsonIgnoreProperties({"credential"})
    private UserEntity user;

    @Transient
    @JsonView(View.AuthDefault.class)
    String token;
}
