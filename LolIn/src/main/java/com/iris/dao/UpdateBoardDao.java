package com.iris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iris.entities.UpdateBoard;

public interface UpdateBoardDao extends JpaRepository<UpdateBoard, Integer>{

	UpdateBoard findByVersion(String version);
}
