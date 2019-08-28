package com.wang.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_info")
@Getter
@Setter
public class UserInfo {

	@Id
	@Column(name = "open_id")
	private String openId;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column(name = "user_bio")
	private String userBio;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_img")
	private String userImg;

	@OneToMany(mappedBy = "userInfo")
	private List<Article> articles;

	@ManyToMany(mappedBy = "userInfos")
	private Set<Role> roles;
}