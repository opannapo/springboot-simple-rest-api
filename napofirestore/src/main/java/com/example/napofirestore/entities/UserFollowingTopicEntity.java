package com.example.napofirestore.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_following_topic", schema = "napo-firestore", catalog = "")
public class UserFollowingTopicEntity {
    private int id;
    private Integer userId;
    private Integer topicTypeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "topic_type_id")
    public Integer getTopicTypeId() {
        return topicTypeId;
    }

    public void setTopicTypeId(Integer topicTypeId) {
        this.topicTypeId = topicTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFollowingTopicEntity that = (UserFollowingTopicEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(topicTypeId, that.topicTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, topicTypeId);
    }
}
