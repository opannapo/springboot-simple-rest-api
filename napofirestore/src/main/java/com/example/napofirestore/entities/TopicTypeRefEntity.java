package com.example.napofirestore.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "topic_type_ref", schema = "napo-firestore", catalog = "")
public class TopicTypeRefEntity {
    private int id;
    private Integer topicId;
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
    @Column(name = "topic_id")
    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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
        TopicTypeRefEntity that = (TopicTypeRefEntity) o;
        return id == that.id &&
                Objects.equals(topicId, that.topicId) &&
                Objects.equals(topicTypeId, that.topicTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topicId, topicTypeId);
    }
}
