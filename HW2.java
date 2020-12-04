import java.util.Scanner;

public class second {
	public static double changeGradeToDouble (String subjectGrade, double subjectCredit) {
		double result;
		
		switch(subjectGrade) {
			case "A+":
				result = 4.5;
				break;
			case "A0":
				result = 4.0;
				break;
			case "B+":
				result = 3.5;
				break;
			case "B0":
				result = 3.0;
				break;
			case "C+":
				result = 2.5;
				break;
			case "C0":
				result = 2.0;
				break;
			case "D+":
				result = 1.5;
				break;
			case "D0":
				result = 1.0;
				break;
			default:
				result = 0.0;
				break;
		}
		//과목평점 (추후 학점 계산시 사용)
		return (result * subjectCredit);
	}
	
	public static void main(String[] args) {
		/*****************************
		* 프로그램명: 학점 계산 프로그램
		* 작성자 : 2019038006 유현진
		* 작성일 : 2020.09.18
		* 프로그램 설명 : 키보드로부터 학번, 이름, 국어, 영어, 수학, C언어 입력받아  총점, 평균, 학점을 출력하는 프로그램
		*********************************/
		int studentNum;
		String name, koreanGrade,englishGrade, mathGrade, cLangGrade;
		//[0] : 원점수, [1] : 이수학점, [2] : 과목평점
		double korean[] = new double[3], english[] = new double[3], math[] = new double[3], cLang[] = new double[3];
		double scoreSum, mean, totalGrade;
		
		//학번, 이름 
		System.out.println("학번, 이름을 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		studentNum = scanner.nextInt();
		name = scanner.next();
		
		//국어
		System.out.println("국어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
		Scanner scanKorean = new Scanner(System.in);
		korean[0] = scanKorean.nextDouble();
		koreanGrade = scanKorean.next();
		korean[1] = scanKorean.nextDouble();
		korean[2] = changeGradeToDouble(koreanGrade, korean[1]);
		
		//영어
		System.out.println("영어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
		Scanner scanEnglish = new Scanner(System.in);
		english[0] = scanEnglish.nextDouble();
		englishGrade = scanEnglish.next();
		english[1] = scanEnglish.nextDouble();
		english[2] = changeGradeToDouble(englishGrade, english[1]);
		
		//수학
		System.out.println("수학의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
		Scanner scanMath = new Scanner(System.in);
		math[0] = scanMath.nextDouble();
		mathGrade = scanMath.next();
		math[1] = scanMath.nextDouble();
		math[2] = changeGradeToDouble(mathGrade, math[1]);
		
		//C언어
		System.out.println("C언어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
		Scanner scanCLang = new Scanner(System.in);
		cLang[0] = scanCLang.nextDouble();
		cLangGrade = scanCLang.next();
		cLang[1] = scanCLang.nextDouble();
		cLang[2] = changeGradeToDouble(cLangGrade, cLang[1]);
		
		//원점수 총점, 원점수 평균, 학점
		scoreSum = korean[0] + english[0] + math[0] + cLang[0];
		mean = scoreSum / 4;
		totalGrade = (korean[2]+english[2]+math[2]+cLang[2]) / (korean[1]+english[1]+math[1]+cLang[1]);
		
		//총점, 평균, 학점 출력
		System.out.println("학번 : " + studentNum + "	 " + "이름 : " + name);
		System.out.println("총점 : " + scoreSum);
		System.out.println("평균 : " + mean);
		System.out.println("학점 : " + String.format("%.2f",totalGrade));
		
		scanKorean.close();
		scanEnglish.close();
		scanMath.close();
		scanCLang.close();
		scanner.close();
		
	}
}
