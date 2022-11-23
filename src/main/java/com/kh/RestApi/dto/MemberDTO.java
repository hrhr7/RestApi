package com.kh.RestApi.dto;

import lombok.Getter;
import lombok.Setter;

//값을 프론트로 전달
//사용자가 원하는 값만 전달 해도 됨
@Getter
@Setter
public class MemberDTO {
    private String user;
    private String pwd;
    private String name;
    private String email;
    private String grade;

}
