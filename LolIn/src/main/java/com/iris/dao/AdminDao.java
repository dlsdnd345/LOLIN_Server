package com.iris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iris.entities.Admin;
import com.iris.entities.Board;
import com.iris.entities.User;

/*
 * GenericDao 를 상속받는 과정에서 해당 interFace의 Entity Type 을 지정해 준다.
 * 첫번째 매개변수 : Type , 두번째 PK 키의 Type'
 * 상속을 통해 기본적인 CRUD를 JPA 에서 만들어 준다 .
 * 
 * 상속을 통해서 커버 되지 않는 쿼리문은 
 * findByXXXX method 를 통해서 처리한다 .
 * 
 */
public interface AdminDao extends JpaRepository<Admin, Integer> {

	List<Admin> findByUserIdAndPassword(String userId , String password);
}
