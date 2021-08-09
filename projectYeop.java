package day9_2_project;
import java.util.Arrays;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;


public class projectYeop {

        // Scanner 설정
        static Scanner sc = new Scanner(System.in);


        ///// 전역 변수 /////

        // 음식 선택한 배열
        static String[] menuBox = new String[0];

        //음식 선택한 것
        static String foods;

        // 요청사항 배열
        static String[] requestBox = new String[0];

        // 메뉴선택 함수
        static void menuSelect() {
            // 선택한 음식을 보관하는 배열
            String[] selectFood = new String[0];

            System.out.println("***** 메뉴를 선택 하세요 *****");
            System.out.println("짜장면 - 5000원");
            System.out.println("짬뽕 - 6000원");
            System.out.println("볶음밥 - 7000원");
            System.out.println("탕수육 - 12000원");
            System.out.println("칠리새우 - 30000원");
            System.out.println("메뉴 선택이 완료 되었으면 \"선택완료\"라고 입력하세요!!");

            int totalCost = 0;
            // 주문작업
            while (true) {
                System.out.print(">> ");

                // 음식을 선택하는 작업
                String food = sc.next();
                foods = food;
                sc.nextLine();
                if (food.equals("선택완료")) {
                    break;
                } else if (food.equals("짜장면")) {
                    totalCost += 5000;

                } else if (food.equals("짬뽕")) {
                    totalCost += 6000;

                } else if (food.equals("볶음밥")) {
                    totalCost += 7000;


                } else if (food.equals("탕수육")) {
                    totalCost += 12000;


                } else if (food.equals("칠리새우")) {
                    totalCost += 30000;

                }

                // selectFood의 음식들을 넣는 새로운 배열
                String[] temp = new String[selectFood.length + 1];


                // 선택한 음식을 배열에 넣는 것
                for (int i = 0; i < selectFood.length; i++) {
                    temp[i] = selectFood[i];

                }

                temp[temp.length - 1] = food;
                selectFood = temp;

                menuBox = selectFood;
                temp = null;


            } // end while


            while (true) {
                System.out.println("주문 하신 음식의 가격은 " + totalCost + "입니다.");
                System.out.println("주문 하시려면 \"예\"를 다시 주문하고 싶으면 \"아니요\"를 입력하세요!!");
                System.out.print(">> ");
                String lastFoodSelect = sc.next();
                if (lastFoodSelect.equals("예")) {
                    System.out.println("주문이 접수되었습니다!!");
                    System.out.println("주문하신 음식: " + Arrays.toString(selectFood));
                    System.out.println("총 금액: " + totalCost + "원");

                    break;
                } else if (lastFoodSelect.equals("아니요")) {

                    System.out.println("주문을 처음부터 다시 접수하세요!!");

                    // selectFood 배열을 빈배열로 만드는 작업 (초기화)
                    String[] resetFood = new String[0];
                    selectFood = resetFood;
                    menuBox = resetFood;
                    resetFood = null;

                    break;
                }
            } // end while

        } // end menuSelect

        // 주문한 메뉴 수정 및 삭제 함수
        static void menuModifyDelete() {

        } // end menuModifyDelete

        // 요청사항 함수
        static void requestList() {
            System.out.println("음식 주문 요청사항을 입력하세요!!");
            while (true) {
                System.out.print(">> ");
                // 요청사항을 입력하는 작업
                String request = sc.nextLine();

                // 요청사항을 보관하는 배열
                String[] requestStore = new String[0];

                // requestStore의 요청사항을 넣는 새로운 배열
                String[] requestTemp = new String[requestStore.length + 1];

                for (int i = 0; i < requestStore.length; i++) {
                    requestTemp[i] = requestStore[i];
                }

                requestTemp[requestTemp.length - 1] = request;
                requestStore = requestTemp;
                requestBox = requestTemp;
                requestTemp = null;

                System.out.println("요청사항이 입력되었습니다!!");
                System.out.println(" ");


                // 최종 주문을 입력하는 작업
//         System.out.println("주문하신 음식은 " + Arrays.toString(selectFood) + "입니다.");
                System.out.println("고객님의 요청사항은 " + Arrays.toString(requestStore) + "입니다.");

                System.out.println();

                // 최종 주문이 이루어지는 작업
                System.out.println("위의 내용이 맞으면 \"예\"를 틀리면 \"아니요\"를 입력하세요!!");
                System.out.print(">> ");
                String lastOrder = sc.next();

                // true 와 false를 담는 변수 선언
                boolean rightAnswer;
                boolean wrongAnswer;

                // 최종 판단
                if (lastOrder.equals("예")) {
                    rightAnswer = true;
                    System.out.println("주문한 음식: " + Arrays.toString(menuBox));
                    System.out.println("요청사항: " + Arrays.toString(requestStore));
                    System.out.println("최종적으로 주문 접수가 완료 되었습니다. 감사합니다!!");
                    break;
                } else if (lastOrder.equals("아니요")) {
                    wrongAnswer = false;
                    System.out.println("처음부터 다시 입력해주세요^^");
                    // requestStore 배열을 빈배열로 만드는 작업 (초기화)
                    String[] resetRequest = new String[0];
                    requestStore = resetRequest;
                    menuBox = resetRequest;
                    resetRequest = null;
                    break;
                }
            }
        }// end menuSelect

        // 주문내역 함수
        static void orderList() {
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 MM월dd일");
            Date time = new Date();
            String time2 = format2.format(time);

            System.out.println("*****최근 주문목록 *****");
            if (menuBox.length != 0) {
                for (int i = 0; i < menuBox.length; i++) {
                    System.out.println(time2 + " " + menuBox[i]);
                }
            }else{
                System.out.println("최근에 주문한 것이 없습니다. 많이 이용해주세요!!");
            }
        }

        public static void main(String[] args) {

            //메뉴선택 함수 호출
            //menuSelect();

            //메뉴 수정 및 삭제 함수 호출
            //menuModifyDelete();

            //요청사항 함수 호출
            //requestList();


            //주문 내역 함수 호출
            //orderList();

        } //main end

}
