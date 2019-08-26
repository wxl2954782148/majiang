package com.wang.model;

import javax.persistence.*;

import lombok.Data;

import java.sql.Timestamp;



@Entity
@Table(name="user_info")
@Data
public class UserInfo {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="open_id")
	private String openId;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="user_bio")
	private String userBio;

	@Column(name="user_name")
	private String userName;

	@Column(name="token")
	private String token;
}