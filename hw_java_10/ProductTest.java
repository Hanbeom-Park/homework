package com.ssafy.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ProductTest {
	static void print(ArrayList<Product> p) {
		for (Product a:p) {
			System.out.println(a);
		}
	}
	public static void main(String[] args) {
		ProductManagerImpl manager = ProductManagerImpl.getInstance();
		manager.open();
		print(manager.findAll());
		manager.add(new TV("TV1",0,0,0));//상품 중복
		manager.findByNo("99");//번호 못찾음
		manager.findByAboveTV(50);
		manager.findByAboveRefrigerator(400);
		manager.updateProduct("1", 99999);

		manager.close();
		/*
		int n = 1;
		Scanner sc = new Scanner(System.in);
		while (n != 0) {
			System.out.println("What do you want?\n 1.전체 상품 목록\n 2.번호로 상품 찾기\n 3.이름으로 상품찾기\n 4.TV정보 보기\n 5.냉장고 정보 보기\n"
					+ " 6.용량 정보로 냉장고 보기\n 7.사이즈 정보로 TV보기 \n 8.상품 정보 수정\n 9.상품 정보 삭제\n 10.총 상품 가격\n 11.상품 갯수\n "
					+ "12.ID로 회원 찾기\n 13.이름으로 회원찾기 \n 14.회원 수정하기\n 15.회원 정보 삭제\n 16.판매 정보 출력 \n 17.id로 판매정보 찾기\n "
					+ "18.물건 번호로 판매정보 찾기\n 19.총 매출\n 20.판매정보 삭제 \n0.종료\n");
			switch (sc.nextInt()) {

			case 0:
				n=0;
				break;

			case 1:
				System.out.println("--------------전체 상품목록-------------\n" + manager.findAll());

				break;
			case 2:
				System.out.println("번호 입력:");
				System.out.println("--------------번호로 상품 목록 찾기-------------\n" + manager.findByNo(sc.next()));

				break;
			case 3:
				System.out.println("이름 입력:");
				System.out.println("-------------이름으로 상품 찾기-------------\n" + manager.findByName(sc.next()));

				break;
			case 4:

				System.out.println("-------------TV정보 보기-------------\n" + manager.findOnlyTV());

				break;
			case 5:
				System.out.println("-------------냉장고 정보 보기-------------\n" + manager.findOnlyRefrigerators());

				break;
			case 6:
				System.out.println("최대 용량 입력:");
				System.out.println(
						"-------------용량 정보로 냉장고 보기-------------\n" + manager.findByAboveRefrigerator(sc.nextInt()));

				break;
			case 7:
				System.out.println("최대 크기 입력:");
				System.out.println("--------------사이즈 정보로 TV보기-------------\n" + manager.findByAboveTV(sc.nextInt()));

				break;
			case 8:
				System.out.println("번호,가격 입력:");
				manager.updateProduct(sc.next(), sc.nextInt());
				System.out.println("--------------상품 정보 수정-------------\n");

				break;
			case 9:
				System.out.println("번호 입력:");
				manager.deleteProduct(sc.next());
				System.out.println("--------------상품 정보 삭제-------------\n");
				break;
			case 10:
				System.out.println("--------------총 상품 가격-------------\n" + manager.booksTotalPrice());

				break;
			case 11:
				System.out.println("--------------상품 갯수-------------\n" + manager.size());

				break;
			case 12:
				System.out.println("회원 ID 입력:");
				System.out.println("--------------ID로 회원 찾기-------------\n" + manager.findMemberById(sc.next()));

				break;
			case 13:
				System.out.println("회원 이름 입력:");
				System.out.println("--------------이름으로 회원 찾기-------------\n" + manager.findMemberByName(sc.next()));

				break;
			case 14:
				System.out.println("회원 번호, 회원 정보 입력:");
				System.out.println("--------------회원 수정하기-------------\n"
						+ manager.updateMember(sc.next(), new Member(sc.next(), sc.next(), sc.next())));

				break;
			case 15:
				System.out.println("회원 번호 입력:");
				System.out.println("--------------회원 정보 삭제-------------\n" + manager.removeMember(sc.next()));

				break;
			case 16:
				System.out.println("--------------전체 판매정보 -------------\n" + manager.findAllSale());

				break;
			case 17:
				System.out.println("ID 입력:");
				System.out.println("--------------id로 판매정보 찾기-------------\n" + manager.findSaleById(sc.next()));

				break;
			case 18:
				System.out.println("물건 번호 입력:");
				System.out.println("--------------물건 번호로 판매정보 찾기-------------\n" + manager.findSaleByNo(sc.next()));

				break;
			case 19:
				System.out.println("--------------총 매출-------------\n" + manager.TotalSales());

				break;
			case 20:
				System.out.println("주문 번호 입력:");
				System.out.println("--------------주문 취소-------------\n" + manager.removeSale(sc.nextInt()));
				break;
			}
		}
*/
	}

}
