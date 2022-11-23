package com.kh.RestApi.entity;

import com.kh.RestApi.dao.ItemRepository;
import com.kh.RestApi.dao.MemberRepository;
import com.kh.RestApi.dao.OrderItemRepository;
import com.kh.RestApi.dao.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
class OrderTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @PersistenceContext
    EntityManager em;
//    아이템 하나 추가하는 코드
    public Item createItem(){
        Item item = new Item();
        item.setItemName("테스트 상품");
        item.setPrice(1000);
        item.setItemDetail("상세설명");
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        return item;
    }
    @Test
    @DisplayName("영속성 전이 테스트")
    @Rollback(value = false) //테스트 결과를 롤백시키지 않음
    public void cascadeTest(){
        Order order = new Order();
        for(int i =0; i<3; i++){
            Item item = this.createItem();
            itemRepository.save(item);
//            내가 주문할 상품에 대한거
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);
//            무슨소리지
            order.getOrderItems().add(orderItem); //주문 아이템을 생성해서 주문 목록에 추가
        }
//        order 엔티티를 저장하면서 강제로 flush를 호출하여 영속성 컨텍스트에 있는 객체들을 DB에 반영
        orderRepository.saveAndFlush(order);
        em.clear(); //영속성 컨텍스트를 초기화

//        order.getId 오더 테이블 생성하면 자동 생성되는 애
        Order savedOrder = orderRepository.findById(order.getId()).orElseThrow(EntityNotFoundException::new);
//  itemOrder 엔티티 3개가 실제로 DB에 저장되었는지 검사, 예상값과 같으면 결과를 출력
        assertEquals(3, savedOrder.getOrderItems().size());

    }
//    주문 하나 만듦
    public Order createOrder(){
        Order order = new Order();
        for(int i = 0; i<3; i++){
            Item item = createItem();
            itemRepository.save(item);
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(10);
            orderItem.setOrderPrice(1000);
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
        }
        Member member = new Member();
        memberRepository.save(member);
//        멤버 정보를 넣어줌
        order.setMember(member);
        orderRepository.save(order);
        return order;
    }
    @Test@DisplayName("고아객체 제거 테스트")
    public void orphanRemovalTest(){
        Order order = this.createOrder();
//        index 번호 넣어주면 해당하는 아이템 삭제..?
        order.getOrderItems().remove(0);
        em.flush();
    }
    @Test
    @DisplayName("지연 로딩 테스트")
    public void lazyLoadingTest(){
        Order order = this.createOrder();
        Long orderItemId = order.getOrderItems().get(0).getId();
        em.flush();
        em.clear();
        OrderItem orderItem = orderItemRepository.findById(orderItemId)
                .orElseThrow(EntityNotFoundException::new);
        log.warn("order class : " + orderItem.getOrder().getClass());
    }
}