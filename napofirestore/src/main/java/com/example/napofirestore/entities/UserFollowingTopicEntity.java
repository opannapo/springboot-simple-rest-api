package com.example.napofirestore.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user_following_topic", schema = "napo-firestore")
@EqualsAndHashCode
@ToString
@Setter
@Getter
public class UserFollowingTopicEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "topic_type_id")
    private Integer topicTypeId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({"userFollowingTopics"})
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "topic_type_id", insertable = false, updatable = false)
    private TopicTypeEntity topicType;
}