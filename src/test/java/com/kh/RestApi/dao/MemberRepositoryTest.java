package com.kh.RestApi.dao;

import com.kh.RestApi.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
//넣으면 test db용으로 가게 됨
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberRepositoryTest {
    @Autowired
//  utowired가 없었다면 MemberRepository memberRepository = new MemberRepositoey(); 이렇게 해줬어야함
    MemberRepository memberRepository;
    @Test
    @DisplayName("회원 가입 테스트")
    public void regMemberTest() {
        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setUserId("jsk2024" + i);
            member.setPwd("jsk2024");
            member.setName("곰돌이" + i);
            member.setEmail("jsk@hmail.com" + i);
            member.setRegDate(LocalDateTime.now());
//         이 만든 데이터들을 db에 넣어줘야 한다
            memberRepository.save(member);
        }
    }
}