package com.iris.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * lombok 라이브러리 이용하여 @Getter@Setter를 이용.
 * 참조사이트 : http://projectlombok.org/ 를 통해 jar 파일을 받고
 * 파일을 실행시켜 컴파일 시켜준다. 그후에 jar 파일을 이클립스에 넣어준다.
 */

/*
 * 1. @Entity 등록
 * 2. @Table(name="histories") 테이블 이름 명시
 * 3. @Id pk지정
 * 4. @Column(name="id") 디비 컬럼명 매핑
 * 5. @GeneratedValue(strategy=GenerationType.AUTO) 숫자 자동증가 지정
 * 6. @ManyToOne n:1 지정 (@JoinColumn(name="bookId") 과 같이 동작한다.)
 * 7. @JoinColumn 디비 컬럼명을 맞춰준다.
 * 8. @OneToMany(mappedBy="book") 해당 변수(fk)를 지정
 * 
 *  ※ Hibernate 를 사용하기 위해서는 기본생성자가 항시 있어야 한다.
 */

@Entity
@Table(name = "board")
public class Board implements Serializable {
	private static final long serialVersionUID = -426888916618211173L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "position")
	private String position;

	@Column(name = "rank")
	private String rank;

	@Column(name = "writeTime")
	private Date writeTime;

	@Column(name = "playTime")
	private String playTime;

	@Column(name = "tea")
	private String tea;
	
	@Column(name = "os")
	private String os;
	
	@OneToMany(mappedBy="addBoards")
	private List<Reple> addReple;

	@ManyToOne
	@JoinColumn(name="userId")
	private User addUsers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public List<Reple> getAddReple() {
		return addReple;
	}
	
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setAddReple(List<Reple> addReple) {
		this.addReple = addReple;
	}

	public User getAddUsers() {
		return addUsers;
	}

	public void setAddUsers(User addUsers) {
		this.addUsers = addUsers;
	}
	
}
