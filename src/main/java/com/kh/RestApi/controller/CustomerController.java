//package com.kh.RestApi.controller;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CustomerController {
////    dao와 다르게 객체(new) 생성 안함(내부가 싱글톤 패턴이라)
//    private CustomerRepository repository;
//    public CustomerController(CustomerRepository repository){
////       ....무슨소리지............
//        this.repository = repository;
//    }
////    회원 추가 (insert)
//    @PutMapping("/customer")
//    public Customer putCustomer(Customer customer){
//        return repository.save(customer);
//    }
////    정보 수정
//    @PostMapping("/customer")
//    public Customer postCustomer(Customer customer){
//        return repository.save(customer);
//    }
////    삭제는 결과값을 반환할 필요가 없어서 return 값이 없음
//    @DeleteMapping("/customer")
////    왜 여기 void 쓰는건지?
//    public void deleteCustomer(int id){
////        id 해당하는 데이터 삭제
//        repository.deleteById(id);
//    }
////    개별조회
//    @GetMapping("/customer")
//    public Customer getCustomer(int id){
//        return repository.findById(id).orElse(null); //찾는 값이 없으면 null 반환
//    }
////    전체조회
//    @GetMapping("/customer/list")
////    반환타입이 customer면 안됨 왜냐면 리스트로 전체 조회할거라서
//    public List<Customer> getCustomer(){
//        return repository.findAll();
//    }
////    이름 사용해서 조회
//    @GetMapping("/customer/name")
//    public List<Customer> getCustomer(String name){
//        return repository.findByName(name);
//    }
//    //   주소 사용해서 조회
//    @GetMapping("/customer/address")
//    public List<Customer> getCustomerAddr(String address){
//        return repository.findByAddress(address);
//    }
////    like 검색 해보기
//    @GetMapping("/customer/search")
//    public List<Customer> searchCustomer(String name){
////        해당하는 이름이 있으면 다 조회
////        return repository.findByNameLike("%" + name + "%");
//        return repository.findByNameLikeOrderByAddressDesc("%" + name +"%");
//    }
////    이름 또는 주소에 맞는 항목 검색
//    @GetMapping("/customer/searchDouble")
//    public List<Customer> doubleSearch(String name, String address){
//        return repository.findByNameAndAddress(name,address);
//    }
////    Native 쿼리 호출
//    @GetMapping("/customer/native")
//    public List<Customer> getNative(String name, String address){
//        return repository.findVipList1(name, address);
//    }
//}
