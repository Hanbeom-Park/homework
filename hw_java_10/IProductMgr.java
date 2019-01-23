package com.ssafy.hw;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product product);
	ArrayList<Product> findAll();
	Product findByNo(String no);
	ArrayList<Product> findByName(String name);
	ArrayList<TV> findOnlyTV();
	ArrayList<Refrigerator> findOnlyRefrigerators();
	ArrayList<Refrigerator> findByAboveRefrigerator(int capacity);
	ArrayList<TV> findByAboveTV(int wide);
	
	void updateProduct(String no, int price);
	void deleteProduct(String no);
	
	long booksTotalPrice();
	int size();
	
	boolean addMember(Member b);//회원저장
	Member findMemberById(String id);//회원찾기
	ArrayList<Member> findMemberByName(String name);//이름으로 찾기
	Member updateMember(String id, Member b );//회원id로 찾아 수정
	boolean removeMember(String id);//회원탈퇴
	
	boolean addSale(Sale b);//상품 판매 추가
	ArrayList<Sale> findAllSale();
	ArrayList<Sale> findSaleById(String id);//판매 정보 회원id로 찾기
	ArrayList<Sale> findSaleByNo(String no);//판매 정보 물건 번호로 찾기
//	Member updateSale(String id, Member b );//회원id로 찾아 수정
	long TotalSales();//물건별 판매량 및 수익 
	boolean removeSale(int seq);//주문 취소
	void open();
	void close();
	
	
}
