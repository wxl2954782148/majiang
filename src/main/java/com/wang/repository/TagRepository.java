package com.wang.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{
	
}
