package com.kh.RestApi.entity;

import com.kh.RestApi.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @ManyToOne //한명의 회원은 여러번 주문할 수 있으므로 다대일 관계
    @JoinColumn(name = "member_id")
    private Member member;
    private LocalDateTime orderDate;//주문일
    @Enumerated(EnumType.STRING) // string으로 하면 이름 그대로 들어간다는데 이게 뭔 뜻
    private OrderStatus orderStatus; // 주문상태
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

//    mappedBy 옵션은 주인이 아닌 쪽에 사용(주인이 반대편)
//    부모 엔티티의 영속성 상태 변화를 자식 엔티티에 모두 전이
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();


}
