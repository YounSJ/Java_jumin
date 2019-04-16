package juminEx;

import java.util.Random;
import java.util.Scanner;

public class Jumin {
	//주민등록번호 7번째 자리
		public static int n7(int year, char gender) {
			if(1900 <= year && year <= 1999 && gender == 'm') return 1;
			else if(1900 <= year && year <= 1999 && gender == 'f') return 2;
			else if(2000 <= year && year <= 2099 && gender == 'm') return 3;
			else if(2000 <= year && year <= 2099 && gender == 'f') return 4;
			else return 0;
		}
		//월 입력
		public static int month(int month) {
			if(1 <= month && month <= 12) return month;
			else return 0;
		}
		//일 입력
		public static int day(int year ,int month, int day) {
			if((month(month) == 1 || month(month) == 3 || month(month) == 5 || month(month) == 7 || month(month) == 8 ||month(month) == 10 || month(month) == 12) && (1 <= day && day <= 31))
				return day;
			else if ((month(month) == 4 || month(month) == 6 || month(month) == 9 || month(month) == 11) && (1 <= day && day <= 30))
				return day;
			else if ((month(month) == 2) && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) return day=29; //윤년(4년마다 2월에 29일 포함)
			else if ((month(month) == 2) && (1 <= day && day <= 28)) return day;
			else return 0;
		}
		//지역코드
		public static int localCode(String address) {
			Random random = new Random();
			int localCode = 0;
			/* 
			 * 주민등록번호 지역코드 출처 : https://namu.wiki/w/%EC%A3%BC%EB%AF%BC%EB%93%B1%EB%A1%9D%EB%B2%88%ED%98%B8
			 * 세종특별자치시 : 44, 96인데 44만 입력되도록 함
			 * 전라남도 : 55~66, 광주광역시 : 55, 56 이 두개가 겹쳐지기 때문에 전라남도를 57~66으로 수정
			 * 대구광역시 : 67~69, 76인데 67~69로 통일
			 * 경상북도, 경상남도의 경우 각각 76, 85는 다른지역이기 때문에 번거롭지만 다시 입력받도록 함
			 */
			
			if(address.equals("서울") || address.equals("서울특별시")) return localCode = random.nextInt(9); //서울특별시 : 00~08
			else if(address.equals("부산") || address.equals("부산광역시")) return localCode = random.nextInt(4)+9; //부산광역시 : 09~12
			else if(address.equals("인천") || address.equals("인천광역시")) return localCode = random.nextInt(3)+13; //인천광역시 : 13~15
			else if(address.equals("경기도")) return localCode = random.nextInt(10)+16; //경기도 : 16~25
			else if(address.equals("강원도")) return localCode = random.nextInt(9)+26; //강원도 : 26~34
			else if(address.equals("충청북도") || address.equals("충북")) return localCode = random.nextInt(5)+35; //충청북도 : 35~39
			else if(address.equals("대전") || address.equals("대전광역시")) return localCode = 40; //대전광역시 : 40
			else if(address.equals("충청남도") || address.equals("충남")) return localCode = random.nextInt(7)+41; //충청남도 : 41~47
			else if(address.equals("세종") || address.equals("세종특별자치시")) return localCode = 44; //세종특별자치시 : 44, 96
			else if(address.equals("전라북도") || address.equals("전북")) return localCode = random.nextInt(7)+48; //전라북도 : 48~54
			else if(address.equals("전라남도") || address.equals("전남")) return localCode = random.nextInt(10)+55; //전라남도 : 57~66
			else if(address.equals("광주") || address.equals("광주광역시")) return localCode = random.nextInt(2)+55; //광주광역시 : 55, 56
			else if(address.equals("대구") || address.equals("대구광역시")) return localCode = random.nextInt(3)+67; //대구광역시 : 67~69, 76
			else if(address.equals("경상북도") || address.equals("경북")) {
				localCode = random.nextInt(12)+70; //경상북도 : 70~75, 77~81
				if(localCode == 76) return 0;
				else return localCode;
			}
			else if(address.equals("경상남도") || address.equals("경남")) {
				localCode = random.nextInt(11)+82;//경상남도 : 82~84, 86~92
				if(localCode == 85) return 0;
				else return localCode; 
			}
			else if(address == "울산" || address.equals("울산광역시")) return localCode = 85; //울산광역시 : 85
			else if(address == "제주" || address.equals("제주특별자치도")) return localCode = random.nextInt(6)+93; //제주특별자치도 : 93~95	
			else return 0;
		}
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			
			int[] rrn = new int[13]; //resident registration number(주민등록번호,rrn)
			int[] last = new int[13];
			int year, month, day, sum=0, localCode=0;
			int juminCenter=random.nextInt(99)+1; //juminCenter(뒤의 두자리는 행정자치부에 의해 부여 되기때문에 몰라서 랜덤으로 대체)
			int birth=random.nextInt(5)+1; //그날 주민센터에서 출생신고를 한 순서, 보통 5명을 넘기지 않는다고 함
			char gender;
			String address = null;
			
			System.out.print("년도를 입력하시오(ex 1994) ");
			year = Integer.parseInt(sc.nextLine());
			System.out.print("월을 입력하시오 ");
			month = Integer.parseInt(sc.nextLine());
			System.out.print("일을 입력하시오 ");
			day = Integer.parseInt(sc.nextLine());
			System.out.print("성별을 입력하시오(남자:m,여자:f) ");
			gender = sc.nextLine().charAt(0);
			System.out.print("지역을 입력하시오(ex 서울 or 서울특별시) ");
			address = sc.nextLine();
			
			//월 다시 입력
			while(true) {
				if(month(month) == 0) {
					System.out.print("월을 다시 입력하시오(1~12월) ");
					month = Integer.parseInt(sc.nextLine());
				}
				else break;
			}
			//일 다시 입력	
			while(true) {
				if(day(year,month,day) == 0) {
					System.out.print("년도를 다시 입력하시오!! ");
					year = Integer.parseInt(sc.nextLine());
					System.out.print("월을 다시 입력하시오!! ");
					month = Integer.parseInt(sc.nextLine());
					System.out.print("일을 다시 입력하시오!! ");
					day = Integer.parseInt(sc.nextLine());
				}
				else break;
			}
			//주민번호 뒷자리 첫번째 다시 입력
			while(true) {
				if(n7(year,gender) == 0) {
					System.out.print("성별을 다시 입력하시오(남자:m,여자:f) ");
					gender = sc.nextLine().charAt(0);
				}
				else break;
			}
			//지역코드
			while(true) {
				if(localCode(address) == 0) {
					System.out.print("지역을 다시 입력해주세요 ");
					address = sc.nextLine();
				}
				else break;
			}
			
			//주민번호 앞 6자리
			rrn[0] = year % 100 / 10;
			rrn[1] = year % 10;
			rrn[2] = month(month) / 10;
			rrn[3] = month(month) % 10;
			rrn[4] = day(year,month,day) / 10;
			rrn[5] = day(year,month,day) % 10;
			
			//주민번호 뒷 6자리
			rrn[6] = n7(year,gender);
			localCode = localCode(address);
			rrn[7] = localCode / 10;
			rrn[8] = localCode % 10;
			rrn[9] = juminCenter / 10;
			rrn[10] = juminCenter % 10;
			rrn[11] = birth;
			
			//마지막 자릿수
			for(int i=0; i<12; i++) {
				if(i<8)	last[i] = rrn[i]*(2+i);
				else last[i] = rrn[i]*(i-6);
				sum += last[i];
			}
			
			if(11-(sum%11) == 10) rrn[12] = 0;
			else if(11-(sum%11) == 11) rrn[12] = 1;
			else rrn[12]=11-(sum%11);	
			
			for(int i = 0; i < 13; i++) {
				if(i == 6) System.out.print("-"+rrn[i]);
				else System.out.print(rrn[i]);
			}
		}
}
