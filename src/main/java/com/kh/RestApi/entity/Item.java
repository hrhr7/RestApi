package com.kh.RestApi.entity;

import com.kh.RestApi.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter@Setter@ToString
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드
    @Column(nullable = false, length = 50) //null이 와서는 안된다
    private String itemName; //상품명
    @Column(name = "price",nullable = false)
    private int price; //가격
    @Column(nullable = false)
    private int stockNumber; //재고 수량
    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품의 상세 설명
    @Enumerated(EnumType.STRING)
//    순서적인 효과..
    private ItemSellStatus itemSellStatus;
}
