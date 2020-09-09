package com.example.napofirestore.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credential", schema = "napo-firestore", catalog = "")
public class CredentialEntity {
    private int id;
    private String key;
    private String signature;
    private int type;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "signature")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialEntity that = (CredentialEntity) o;
        return id == that.id &&
                type == that.type &&
                userId == that.userId &&
                Objects.equals(key, that.key) &&
                Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, signature, type, userId);
    }
}
