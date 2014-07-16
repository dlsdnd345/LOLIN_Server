package com.iris.service;

import java.util.List;

import com.iris.entities.Reple;

public interface RepleService {
	public List<Reple> findAll();
	public String save(int boardId , String userName , String content);
}
