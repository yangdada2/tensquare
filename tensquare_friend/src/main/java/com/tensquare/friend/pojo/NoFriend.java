package com.tensquare.friend.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="tb_nofriend")
@IdClass(Friend.class)
@Data
public class NoFriend {
    @Id
    private String userid;

    @Id
    private String friendid;
}
