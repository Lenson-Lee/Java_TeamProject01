package day9_2_project;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class projectcopy {
    //=======================================
    //++++++++++++++ 전역 변수 +++++++++++++++
    //=======================================

    //전역변수로 뺄 때는 static 사용.
    static Scanner sc = new Scanner(System.in);
    // 음식 선택한 배열
    static String[] menuBox = new String[0];
    //음식 선택한 것
    static String foods;
    // 요청사항 배열
    static String[] requestBox = new String[0];


    //=========================================
    //++++++++++사장님, 손님 구분 로그인++++++++++
    //=========================================

    static  String guestLogin(String id) {
        String[] idArr = {"guest1","guest2"};
        String[] pwArr = {"1234", "5678"};
        String[] nickArr = {"밥그릇", "숟가락"};
        int idx = -1;

        while (true) {
            //id 인덱스 탐색
            for (int i = 0; i < idArr.length; i++) {
                if (idArr[i].equals(id)) {
                    idx = i;
                    break;
                }
            }//ID for end

        //동일한 인덱스의 비밀번호 배열에서 일치여부 조회
        System.out.println("1-비밀번호를 입력해 주세요!");
        String pw = sc.next();

            if (pwArr[idx].equals(pw)){ //로그인 성공
                //로그인 성공
                System.out.println(nickArr[idx] + "님 환영합니다!\n");
                break;
            } else { //로그인 실패
                System.out.println("비밀번호가 일치하지 않습니다! 프로그램을 종료합니다.");
                break;
            }//pw id == pw if
        }//while end
        return id;
    }//end guestLogin 손님 계정 로그인 끝


    //=======================================
    //++++++++++++++손님 전용 폼+++++++++++++++
    //=======================================

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
                boolean flag = selectYesOrNo(selectFood, totalCost);
                //***
                if (flag) {
                    break;
                } else {
                    continue;
                }
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

    } // end menuSelect

    private static boolean selectYesOrNo(String[] selectFood, int totalCost) {
        while (true) {
            System.out.println("\n\n주문 하신 음식의 가격은 " + totalCost + "입니다.");
            System.out.println("주문 하시려면 \"예\"를 다시 주문하고 싶으면 \"아니요\"를 입력하세요!!");
            System.out.print(">> ");
            String lastFoodSelect = sc.next();
            sc.nextLine();

            if (lastFoodSelect.equals("예")) {
                System.out.println("\n\n주문이 접수되었습니다!!");
                System.out.println("주문하신 음식: " + Arrays.toString(selectFood));
                System.out.println("\n총 금액: " + totalCost + "원");
                menuModifyDelete();
                return true;
            } else if (lastFoodSelect.equals("아니요")) {
                System.out.println("주문을 처음부터 다시 접수하세요!!");

                // selectFood 배열을 빈배열로 만드는 작업 (초기화)
                String[] resetFood = new String[0];
                selectFood = resetFood;
                menuBox = resetFood;
                resetFood = null;
                return false;
            }
        } // end while
    }

    // 주문한 메뉴 수정 및 삭제 함수
    static void menuModifyDelete() {
        System.out.println("취소하고싶은 음식을 입력하세요!!");
        System.out.print(">> ");
        String deleteFood = sc.next();
        sc.nextLine();

        int idx = -1;
        //탐색
        for (int i = 0; i < menuBox.length; i++) {
            if (menuBox[i].equals(deleteFood)) {
                idx = i;
                break;
            }
        }
        // 탐색 후에 배열안에 있으면
        if (idx != -1) {
            for (int i = idx; i < menuBox.length-1; i++) {
                menuBox[i] = menuBox[i + 1];
                break;
            }
        }
        // 새로운 배열 생성
        String[] deleteTemp = new String[menuBox.length - 1];

        // 새로운 배열에 삭제된 배열을 넣는 작업
        for (int i = 0; i < deleteTemp.length; i++) {
            deleteTemp[i] = menuBox[i];
        }

        menuBox = deleteTemp;
        deleteTemp = null;

        System.out.println("취소 후 주문하신 음식: " + Arrays.toString(menuBox));

    } // end menuModifyDelete


    // 요청사항 함수
    static void requestList() {
        System.out.println("\n\n음식 주문 요청사항을 입력하세요!!");
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
            sc.nextLine();

            // true 와 false를 담는 변수 선언
            boolean rightAnswer;
            boolean wrongAnswer;

            // 최종 판단
            if (lastOrder.equals("예")) {
                rightAnswer = true;
                System.out.println("주문한 음식: " + Arrays.toString(menuBox));
                System.out.println("요청사항: " + Arrays.toString(requestStore));
                System.out.println("최종적으로 주문 접수가 완료 되었습니다. 감사합니다!!");
                System.out.println("메인 화면으로 돌아갑니다.\n\n");
                guestForm();
                return;
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

        System.out.println("\n\n*****최근 주문목록 *****");
        if (menuBox.length != 0) {
            for (int i = 0; i < menuBox.length; i++) {
                System.out.println(time2 + " " + menuBox[i]);
                System.out.println("");
                System.out.println("");
            }
            guestForm();
        }else{
            System.out.println("최근에 주문한 것이 없습니다. 많이 이용해주세요!!");
        }
    }

    //게스트 폼
    static void guestForm() {
        System.out.println("=================================");
        System.out.println("1. 메뉴 선택");
        System.out.println("2. 내 주문 기록");
        System.out.println("3. 프로그램 종료");
        System.out.println("=================================");
        System.out.println("원하는 메뉴 번호를 입력해 주세요!");

        int menu = sc.nextInt();

        switch (menu) {
            case 1:
            System.out.println("1. 메뉴 선택");
                menuSelect();
//                menuModifyDelete();
                requestList();
                break;
            case 2:
                System.out.println("2. 내 주문 기록");
                orderList();

                break;
            case 3:
            System.out.println("3. 프로그램 종료");
                break;
            default:
            System.out.println("# 잘못된 입력입니다. 프로그램을 종료합니다.");
                break;
        }
    }


    //=======================================
    //+++++++++++++사장님 전용 폼++++++++++++++
    //=======================================

    static void historyMaster() {
        String[] history = {"[08.02]숟가락님의 주문입니다", "[08.03]밥그릇님의 주문입니다.", "[08.03]뚝배기님의 주문입니다."};
        int[] price = {13500, 28000, 10000};
        int total = 0;
//
//        System.out.println("3. 최근 주문기록 조회하기");
        System.out.println("\n=================================");
        System.out.println("이번달 주문내역은 총" + history.length + "개 입니다.");

        for (int i = 0; i < price.length; i++) {
            total += price[i];
        }

        System.out.printf("이번달 총 수익은 %d원 입니다.\n", total);
        System.out.println("\n");

    }


    static void masterForm() {
        System.out.println("=================================");
        System.out.println("1. 메뉴판 수정하기");
        System.out.println("2. 신규 주문 확인하기");
        System.out.println("3. 최근 주문기록 조회하기");
        System.out.println("4. 리뷰 관리");
        System.out.println("=================================");
        System.out.println("원하는 메뉴 번호를 입력해 주세요!");

        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                System.out.println("1. 메뉴판 수정하기");

            case 2:
                System.out.println("2. 주문서 조회하기");
            case 3:
                System.out.println("3. 최근 주문기록 조회하기");
                historyMaster();
            case 4:
                System.out.println("4. 리뷰 관리");

        }
    }



    // ===================================================
    // +++++++++++++++++메인 실행 함수+++++++++++++++++++++
    // ===================================================

    public static void main(String[] args) {//메인함수

        System.out.println("=================================");
        System.out.println("\n++++++++++주문서 프로그램++++++++++\n");
        System.out.println("=================================");
        System.out.println("로그인을 해주세요!\n");
        System.out.print(">> ");
        System.out.println("id를 입력해 주세요!");
        String id = sc.next();


        switch (id) {
            case "master"://사장님 계정, 비밀번호 일치시 함수 실행
                System.out.println("사장님 계정 입니다.");
                System.out.println("비밀번호를 입력해 주세요!");
                String pw = sc.next();
                String realPw = "abc";

                if (pw.equals("abc")) {
                    if (pw.equals(realPw)){
                        System.out.println("사장님 어서오세요!\n");
                        masterForm();
                    } else {
                        System.out.println("비밀번호가 틀렸습니다. 프로그램을 종료합니다.");
                    }
                }
                masterForm();
                break;
            default: //손님 계정. 비밀번호 일치 시 함수 실행
                guestLogin(id);
                guestForm();
                break;
        }





    }//class end
}
