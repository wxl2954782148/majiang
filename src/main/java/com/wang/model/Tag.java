package com.wang.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@Getter
@Setter
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tag_id")
	private Integer tagId;

	@Column(name="tag_descption")
	private String tagDescption;

	@Column(name="tag_name")
	private String tagName;

	@ManyToMany(mappedBy="tags")
	private Set<Article> articles;

	
}