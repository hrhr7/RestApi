package com.kh.RestApi.dao;

import com.kh.RestApi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//인터페이스는 구현부가 있으면 안됨 구현부가 뭔데?..
//인터페이스는 선언만 해야함
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUserIdAndPwd(String user, String pwd);
    Member findByUserId(String user);



}
