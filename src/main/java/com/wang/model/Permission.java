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
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="permission_id")
	private int permissionId;

	@Column(name="permission_name")
	private String permissionName;

	@ManyToMany
	@JoinTable(
		name="role_permisson"
		, joinColumns={
			@JoinColumn(name="permission_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private Set<Role> roles;

}