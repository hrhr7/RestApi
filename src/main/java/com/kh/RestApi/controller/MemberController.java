package com.kh.RestApi.controller;

import com.kh.RestApi.dto.MemberDTO;
import com.kh.RestApi.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemberController{
//    서비스 로직 연결
    private MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
//    전체 멤버 조회
    @GetMapping("/GetMember/List")
    public ResponseEntity<List<MemberDTO>> memberList(){
        List<MemberDTO> list = memberService.getMemberList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
//    userId로 회원 조회 하기
//    개별 조회할때 requestParam
    @GetMapping("/GetMember")
    public ResponseEntity<List<MemberDTO>> memberList(@RequestParam String userId){
        MemberDTO memberDTO = memberService.getMemberList(userId);
        return new ResponseEntity(memberDTO,HttpStatus.OK);

    }
//    회원가입 만들기
    @PostMapping("/RegMember")
//    클래스프레임워크는 객체로 가져와야 해서 boolean 앞글자 대문자로
    public ResponseEntity<Boolean> registerMember(@RequestBody Map<String, String> regData){
        String userId = regData.get("user");
        String pwd = regData.get("pwd");
        String name = regData.get("name");
        String mail = regData.get("mail");
        boolean result = memberService.regMember(userId, pwd, name, mail);
        if(result){
            return new ResponseEntity(true, HttpStatus.OK);
        } else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }
//    로그인 체크
    @PostMapping("/login")
    public ResponseEntity<Boolean> memberLogin(@RequestBody Map<String,String> loginData){
        String user = loginData.get("user");
        String pwd = loginData.get("pwd");
//      서비스 로직 불러주기
        boolean result = memberService.loginCheck(user,pwd);
        if (result){
            return new ResponseEntity(true,HttpStatus.OK);
        }else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }
    // 회원 가입
    @PostMapping("/reg-Member")
    public ResponseEntity<Map<String, String>> memberRegister(@RequestBody Map<String, String> regData) {
        String getUserId = regData.get("user");
        String getPwd = regData.get("pwd");
        String getName = regData.get("name");
        String getMail = regData.get("mail");
        boolean result = memberService.regMember(getUserId, getPwd, getName, getMail);
        if(result) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }
}