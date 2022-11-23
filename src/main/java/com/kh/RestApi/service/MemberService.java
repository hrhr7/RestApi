package com.kh.RestApi.service;

import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.dto.MemberDTO;
import com.kh.RestApi.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MemberService {
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//    전체 조회
    public List<MemberDTO> getMemberList(){
        List<MemberDTO> memberDTOS = new ArrayList<>();
        List<Member> memberList = memberRepository.findAll();
        for(Member e : memberList) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setUser(e.getUserId());
            memberDTO.setPwd(e.getPwd());
            memberDTO.setName(e.getName());
            memberDTO.setEmail(e.getEmail());
            memberDTO.setGrade("VIP");
            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }
//    userId로 검색
public MemberDTO getMemberList(String userId){
    Member member = memberRepository.findByUserId(userId);
    MemberDTO memberDTO = new MemberDTO();
    memberDTO.setUser(member.getUserId());
    memberDTO.setPwd(member.getPwd());
    memberDTO.setName(member.getName());
    memberDTO.setEmail(member.getEmail());
    memberDTO.setGrade("VIP");
    return memberDTO;
}
//    회원가입(성공과 실패만 있어서 boolean)
    public boolean regMember(String userId, String pwd, String name, String mail){
        Member member = new Member();
        member.setUserId(userId);
        member.setPwd(pwd);
        member.setName(name);
        member.setEmail(mail);
        member.setRegDate(LocalDateTime.now());
        Member rst = memberRepository.save(member);
        log.warn(rst.toString());
        return  true;
    }
//    로그인 체크
    public boolean loginCheck(String user, String pwd){
        List<Member> memberList = memberRepository.findByUserIdAndPwd(user,pwd);
        for(Member e : memberList){
            return true;
        }
//        아니면
        return false;
    }
}