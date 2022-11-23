package com.kh.RestApi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    generate 타입을 주면 값이 자동으로 증가 되기 때문에 string 보다는 자동 생성되는 long, int로 타입을 줘야 함
    private Long memberId;
    private String userId;
    private String pwd;
    private String name;
    @Column(unique = true) //이메일은 유일값으로 (중복허용안함)
    private String email;
    private LocalDateTime regDate;
}
