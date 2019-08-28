package com.wang.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Getter
@Setter
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="article_id")
	private Integer articleId;

	@Lob
	@Column(name="article_description")
	private String articleDescription;

	@Column(name="article_title")
	private String articleTitle;

	@Column(name="comment_count")
	private int commentCount;

	@Column(name="create_time")
	private Timestamp createTime;

	@Column(name="like_count")
	private int likeCount;

	@Column(name="update_time")
	private Timestamp updateTime;

	@Column(name="view_count")
	private int viewCount;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserInfo userInfo;

	//bi-directional many-to-many association to Tag
	@ManyToMany
	@JoinTable(
		name="article_tag"
		, joinColumns={
			@JoinColumn(name="article_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tag_id")
			}
		)
	private Set<Tag> tags;



}