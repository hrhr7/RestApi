package com.kh.RestApi.entity;

import com.kh.RestApi.dao.CartRepository;
import com.kh.RestApi.dao.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@Slf4j
//@TestPropertySource(locations = "classpath:application-test.properties")
class CartTest {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;
    @PersistenceContext //영속성 context
    EntityManager em;
    public Member createMember(){
        Member member = new Member();
        member.setUserId("jks2024");
        member.setPwd("jks2024");
        member.setName("곰돌이사육사");
        member.setEmail("jks2024@naver.com");
        member.setRegDate(LocalDateTime.now());
        return member;
    }
    @Test
    @DisplayName("장바구니 회원 매핑 테스트")
    public void findCartAndMemberTest(){
        Member member = createMember();
        memberRepository.save(member);

//        여기서부터 개어렵당 ㅎ
        Cart cart = new Cart();
        cart.setMember(member);
        cartRepository.save(cart);


//        여기까지 db에 저장되기 직전 flush작업을 수행하면 db에 저장해준다
        em.flush();
        em.clear(); //버퍼 비우기
        Cart savedCart = cartRepository.findById(cart.getId())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals(savedCart.getMember().getUserId(),member.getUserId());
    }
}