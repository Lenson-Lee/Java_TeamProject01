package day9_2_project;
import java.util.Scanner;

public class projectcopy {
    //전역변수로 뺄 때는 static 사용.
    static Scanner sc = new Scanner(System.in);

    //사장님, 손님 구분 로그인
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
        System.out.println("비밀번호를 입력해 주세요!");
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

    static void guestForm() {
        System.out.println("=================================");
        System.out.println("1. 메뉴 선택");
        System.out.println("2. 요청사항 입력");
        System.out.println("3. 내 주문 기록");
        System.out.println("4. 프로그램 종료");
        System.out.println("=================================");
        System.out.println("원하는 메뉴 번호를 입력해 주세요!");

        int menu = sc.nextInt();

        switch (menu) {
            case 1:
            System.out.println("1. 메뉴 선택");

                break;
            case 2:
            System.out.println("2. 요청사항 입력");
                break;
            case 3:
            System.out.println("3. 내 주문 기록");
                break;
            case 4:
            System.out.println("4. 프로그램 종료");
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




    public static void main(String[] args) {//메인함수

        System.out.println("=================================");
        System.out.println("\n++++++++++주문서 프로그램++++++++++\n");
        System.out.println("=================================");
        System.out.println("로그인을 해주세요!\n");
        System.out.print(">> ");
        System.out.println("id를 입력해 주세요!");
        String id = sc.next();

        System.out.println("비밀번호를 입력해 주세요!");
        String pw = sc.next();
        String realPw = "abc";

        switch (id) {
            case "master"://사장님 계정, 비밀번호 일치시 함수 실행
                System.out.println("사장님 계정 입니다.");

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
