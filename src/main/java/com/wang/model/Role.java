package com.wang.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;



@Entity
@Getter
@Setter
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="role_name")
	private String roleName;

	@ManyToMany(mappedBy="roles")
	private List<Permission> permissions;

	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="open_id")
			}
		)
	private Set<UserInfo> userInfos;


}