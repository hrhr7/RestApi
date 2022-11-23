//package com.kh.RestApi.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("api/v1/get-api")
//public class GetController {
//    @RequestMapping(value = "/hello",method = RequestMethod.GET )
//    public String getHello(){
//
//        return "Hello Spring boot";
//    }
////    방법2 (자주쓰는방법)
//    @GetMapping("/name")
//    public String getName(){
//
//        return "Name : 천지훈";
//    }
////    매개변수를 받는 GET 메서드 구현 : 실무 환경에서는 대부분 매개변수가 존재
////    {} 쓰는이유? 변수 넣는 자리
//    @GetMapping("/variable1/{variable}")
//    public String getVariable1(@PathVariable("variable") String var){
//        return "당신의 이름은" + var;
//    }
////    키와 값으로 구성된 형태로 전달하는 방법
////    Get 요청을 구현할 때 URL 경로에 쿼리 형식으로 값을 전달 하는 방식 입니다.
////    URI에서 "?"를 기준으로 우측에 '{키}={값}', 여러키를 이으려면 &로 구분
////    이 방식 쓰는걸 추천
//    @GetMapping("/request1")
//    public String getRequestParam(
////            name, email, company = 키
//            @RequestParam String name,
//            @RequestParam String email,
//            @RequestParam String company){
//            return  "이름 : "+name+"이메일 : "+email+"회사 : "+company;
//    }
//    @GetMapping("/member")
////    @ResponseBody 생략해줘도 됨 안걸어도 똑같이 json 형태로 변환해줌 restApi 형태는 다 알고 있다~!!
////    객체 여러가지를 넘겨줘야 할때는 list 사용
////    list 형태를 반환하는 가장 많이 쓰이는 형태  public List<Map<String, Object>>
////    members 라는 객체를 만듦
//    public List<Map<String, Object>> getMembers(){
//        List<Map<String, Object>> members = new ArrayList<>();
////        for 문 돌리는 이유? db없어서 가상 데이터 생성해서 날리기 위해
//        for(int i = 1; i<= 20; i++){
////        map 객체를 list 에 담으려면 ????
//            Map<String, Object> member = new HashMap<>();
////        put을 사용해서 값 입력
//            member.put("id", i);
//            member.put("name", i + "번 개발자");
//            member.put("age", 10+i);
////          members 라는 객체 list에 담기
//            members.add(member);
//        }
//        return members;
//    }
//    @GetMapping("/memberVO")
//    public List<MemberVO> getMemberVO(){
//        List<MemberVO> list = new ArrayList<>();
//        for(int i = 0; i<10; i++){
//            MemberVO vo = new MemberVO();
//            vo.setId("jks2024");
//            vo.setPwd("jsk2024");
//            vo.setName("곰돌이사육사");
//            vo.setEmail("jks2024@gmail.com");
////       list를 vo 객체에 담기
//            list.add(vo);
//        }
//         return list;
//    }
////    @ResponseEntry : 예외 상황에 대해 좀 더 세밀한 제어가 필요한 경우
//    @GetMapping("/memberList")
//    public ResponseEntity<List<MemberVO>> listMember(){
//        List<MemberVO> list = new ArrayList<>();
//        for(int i=0; i<10; i++){
//            MemberVO vo = new MemberVO();
//            vo.setId("jsk2024");
//            vo.setPwd("jsk2024");
//            vo.setName("곰돌이");
//            vo.setEmail("bear@gmail.com");
//            list.add(vo);
//        }
////        (반환할 정보,http상태)
////        return new ResponseEntity<>(list, HttpStatus.OK);
////       넘겨줄 정보 없으면 error
//        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//
//    }
//}
