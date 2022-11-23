//package com.kh.RestApi.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//
////@RequestMapping("/api/v1/post-api")
//public class PostController {
////    @RequestBody : POST 형식의 데이터를 body에서 추출
//    @PostMapping("/member")
//    public String postMember(@RequestBody Map<String, Object> postData){
//        StringBuilder sb = new StringBuilder();
//        postData.entrySet().forEach(map->{
//            sb.append(map.getKey() + " : " + map.getValue()+"\n");
//        });
//        return sb.toString();
//    }
////    실질적인 예제
//    @PostMapping("/Login2")
////    요청을 어떻게 받을건지 어노테이션 사용
//    public ResponseEntity<Map<String,String>> memberLogin(@RequestBody Map<String, String> postData){
//        String getId = postData.get("id");
//        String getPwd = postData.get("pwd");
//        Map<String,String> map = new HashMap<>();
////      결과 날려줌
//        map.put("result","OK");
//        return new ResponseEntity(map, HttpStatus.valueOf(RESPONSE_FAIL_PARAM_ERR));
//    }
//}
