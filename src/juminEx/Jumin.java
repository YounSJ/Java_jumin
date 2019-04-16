package juminEx;

import java.util.Random;
import java.util.Scanner;

public class Jumin {
	//�ֹε�Ϲ�ȣ 7��° �ڸ�
		public static int n7(int year, char gender) {
			if(1900 <= year && year <= 1999 && gender == 'm') return 1;
			else if(1900 <= year && year <= 1999 && gender == 'f') return 2;
			else if(2000 <= year && year <= 2099 && gender == 'm') return 3;
			else if(2000 <= year && year <= 2099 && gender == 'f') return 4;
			else return 0;
		}
		//�� �Է�
		public static int month(int month) {
			if(1 <= month && month <= 12) return month;
			else return 0;
		}
		//�� �Է�
		public static int day(int year ,int month, int day) {
			if((month(month) == 1 || month(month) == 3 || month(month) == 5 || month(month) == 7 || month(month) == 8 ||month(month) == 10 || month(month) == 12) && (1 <= day && day <= 31))
				return day;
			else if ((month(month) == 4 || month(month) == 6 || month(month) == 9 || month(month) == 11) && (1 <= day && day <= 30))
				return day;
			else if ((month(month) == 2) && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) return day=29; //����(4�⸶�� 2���� 29�� ����)
			else if ((month(month) == 2) && (1 <= day && day <= 28)) return day;
			else return 0;
		}
		//�����ڵ�
		public static int localCode(String address) {
			Random random = new Random();
			int localCode = 0;
			/* 
			 * �ֹε�Ϲ�ȣ �����ڵ� ��ó : https://namu.wiki/w/%EC%A3%BC%EB%AF%BC%EB%93%B1%EB%A1%9D%EB%B2%88%ED%98%B8
			 * ����Ư����ġ�� : 44, 96�ε� 44�� �Էµǵ��� ��
			 * ���󳲵� : 55~66, ���ֱ����� : 55, 56 �� �ΰ��� �������� ������ ���󳲵��� 57~66���� ����
			 * �뱸������ : 67~69, 76�ε� 67~69�� ����
			 * ���ϵ�, ��󳲵��� ��� ���� 76, 85�� �ٸ������̱� ������ ���ŷ����� �ٽ� �Է¹޵��� ��
			 */
			
			if(address.equals("����") || address.equals("����Ư����")) return localCode = random.nextInt(9); //����Ư���� : 00~08
			else if(address.equals("�λ�") || address.equals("�λ걤����")) return localCode = random.nextInt(4)+9; //�λ걤���� : 09~12
			else if(address.equals("��õ") || address.equals("��õ������")) return localCode = random.nextInt(3)+13; //��õ������ : 13~15
			else if(address.equals("��⵵")) return localCode = random.nextInt(10)+16; //��⵵ : 16~25
			else if(address.equals("������")) return localCode = random.nextInt(9)+26; //������ : 26~34
			else if(address.equals("��û�ϵ�") || address.equals("���")) return localCode = random.nextInt(5)+35; //��û�ϵ� : 35~39
			else if(address.equals("����") || address.equals("����������")) return localCode = 40; //���������� : 40
			else if(address.equals("��û����") || address.equals("�泲")) return localCode = random.nextInt(7)+41; //��û���� : 41~47
			else if(address.equals("����") || address.equals("����Ư����ġ��")) return localCode = 44; //����Ư����ġ�� : 44, 96
			else if(address.equals("����ϵ�") || address.equals("����")) return localCode = random.nextInt(7)+48; //����ϵ� : 48~54
			else if(address.equals("���󳲵�") || address.equals("����")) return localCode = random.nextInt(10)+55; //���󳲵� : 57~66
			else if(address.equals("����") || address.equals("���ֱ�����")) return localCode = random.nextInt(2)+55; //���ֱ����� : 55, 56
			else if(address.equals("�뱸") || address.equals("�뱸������")) return localCode = random.nextInt(3)+67; //�뱸������ : 67~69, 76
			else if(address.equals("���ϵ�") || address.equals("���")) {
				localCode = random.nextInt(12)+70; //���ϵ� : 70~75, 77~81
				if(localCode == 76) return 0;
				else return localCode;
			}
			else if(address.equals("��󳲵�") || address.equals("�泲")) {
				localCode = random.nextInt(11)+82;//��󳲵� : 82~84, 86~92
				if(localCode == 85) return 0;
				else return localCode; 
			}
			else if(address == "���" || address.equals("��걤����")) return localCode = 85; //��걤���� : 85
			else if(address == "����" || address.equals("����Ư����ġ��")) return localCode = random.nextInt(6)+93; //����Ư����ġ�� : 93~95	
			else return 0;
		}
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			
			int[] rrn = new int[13]; //resident registration number(�ֹε�Ϲ�ȣ,rrn)
			int[] last = new int[13];
			int year, month, day, sum=0, localCode=0;
			int juminCenter=random.nextInt(99)+1; //juminCenter(���� ���ڸ��� ������ġ�ο� ���� �ο� �Ǳ⶧���� ���� �������� ��ü)
			int birth=random.nextInt(5)+1; //�׳� �ֹμ��Ϳ��� ����Ű� �� ����, ���� 5���� �ѱ��� �ʴ´ٰ� ��
			char gender;
			String address = null;
			
			System.out.print("�⵵�� �Է��Ͻÿ�(ex 1994) ");
			year = Integer.parseInt(sc.nextLine());
			System.out.print("���� �Է��Ͻÿ� ");
			month = Integer.parseInt(sc.nextLine());
			System.out.print("���� �Է��Ͻÿ� ");
			day = Integer.parseInt(sc.nextLine());
			System.out.print("������ �Է��Ͻÿ�(����:m,����:f) ");
			gender = sc.nextLine().charAt(0);
			System.out.print("������ �Է��Ͻÿ�(ex ���� or ����Ư����) ");
			address = sc.nextLine();
			
			//�� �ٽ� �Է�
			while(true) {
				if(month(month) == 0) {
					System.out.print("���� �ٽ� �Է��Ͻÿ�(1~12��) ");
					month = Integer.parseInt(sc.nextLine());
				}
				else break;
			}
			//�� �ٽ� �Է�	
			while(true) {
				if(day(year,month,day) == 0) {
					System.out.print("�⵵�� �ٽ� �Է��Ͻÿ�!! ");
					year = Integer.parseInt(sc.nextLine());
					System.out.print("���� �ٽ� �Է��Ͻÿ�!! ");
					month = Integer.parseInt(sc.nextLine());
					System.out.print("���� �ٽ� �Է��Ͻÿ�!! ");
					day = Integer.parseInt(sc.nextLine());
				}
				else break;
			}
			//�ֹι�ȣ ���ڸ� ù��° �ٽ� �Է�
			while(true) {
				if(n7(year,gender) == 0) {
					System.out.print("������ �ٽ� �Է��Ͻÿ�(����:m,����:f) ");
					gender = sc.nextLine().charAt(0);
				}
				else break;
			}
			//�����ڵ�
			while(true) {
				if(localCode(address) == 0) {
					System.out.print("������ �ٽ� �Է����ּ��� ");
					address = sc.nextLine();
				}
				else break;
			}
			
			//�ֹι�ȣ �� 6�ڸ�
			rrn[0] = year % 100 / 10;
			rrn[1] = year % 10;
			rrn[2] = month(month) / 10;
			rrn[3] = month(month) % 10;
			rrn[4] = day(year,month,day) / 10;
			rrn[5] = day(year,month,day) % 10;
			
			//�ֹι�ȣ �� 6�ڸ�
			rrn[6] = n7(year,gender);
			localCode = localCode(address);
			rrn[7] = localCode / 10;
			rrn[8] = localCode % 10;
			rrn[9] = juminCenter / 10;
			rrn[10] = juminCenter % 10;
			rrn[11] = birth;
			
			//������ �ڸ���
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
