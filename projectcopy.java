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

            if (pwArr[idx].equals(pw) && idx != -1){ //로그인 성공
                //로그인 성공
                System.out.println(nickArr[idx] + "님 환영합니다!");
                break;
            } else { //로그인 실패
                System.out.println("비밀번호가 일치하지 않습니다! 프로그램을 종료합니다.");
                break;
            }//pw id == pw if
        }//while end
        return id;
    }//end guestLogin 손님 계정 로그인 끝


    // 사장님 계정 접속
    static String masterLogin() {
        System.out.println("비밀번호를 입력해 주세요!");
        String pw = sc.next();
        String realPw = "abc";
        if (pw.equals(realPw)){
            System.out.println("사장님 어서오세요!");
        } else {
            System.out.println("비밀번호가 틀렸습니다. 프로그램을 종료합니다.");
        }
        return "master";
    }//masterLogin end 사장님 계정 접속 끝

    //손님 전용 폼
    static void guestForm() {
        System.out.println("1. 메뉴 선택");
        System.out.println("2. 요청사항 입력");
        System.out.println("3. 내 주문 기록");
        System.out.println("4. 프로그램 종료");

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
        return ;
    }

    //사장님 전용 폼
    static void masterForm() {
        System.out.println("주문서 확인하기");
        System.out.println("최근 주문내역 조회하기");


    }
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("\n++++++++++주문서 프로그램++++++++++\n");
        System.out.println("=================================");
        System.out.println("로그인을 해주세요!\n");
        System.out.print(">> ");
        System.out.println("id를 입력해 주세요!");
        String id = sc.next();
        switch (id) {
            case "master":
                System.out.println("사장님 계정 입니다.");
                masterLogin();
                break;
            default:
                guestLogin(id);
                break;
        }





    }//class end
}
