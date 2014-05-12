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
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = -426888916618211173L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "facebookId")
	private String facebookId;

	@Column(name = "writeTime")
	private Date writeTime;
	
	@OneToMany(mappedBy="addUsers")
	private List<Board> addBoard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Board> getAddBoard() {
		return addBoard;
	}

	public void setAddBoard(List<Board> addBoard) {
		this.addBoard = addBoard;
	}
	
}
