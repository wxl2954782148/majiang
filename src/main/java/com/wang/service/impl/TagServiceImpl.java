package com.wang.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.wang.model.Tag;
import com.wang.repository.TagRepository;
import com.wang.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository tagRepository;

	@Override
	public Tag findByTagName(String tagName) {
		Tag tag = new Tag();
		tag.setTagName(tagName);
		Example<Tag> example = Example.of(tag);
		Optional<Tag> optional = tagRepository.findOne(example);
		return optional.get();
	}

}
