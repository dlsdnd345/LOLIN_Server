package com.iris.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reple")
public class Reple implements Serializable{

	private static final long serialVersionUID = -5419776218282668048L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	@Column(name = "userName")
	private String userName;

	@Column(name = "content")
	private String content;

	@Column(name = "facebookId")
	private String facebookId;
	
	@Column(name = "writeTime")
	private Date writeTime;
	
	
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board addBoards;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	public Board getAddBoards() {
		return addBoards;
	}

	public void setAddBoards(Board addBoards) {
		this.addBoards = addBoards;
	}
	
}
