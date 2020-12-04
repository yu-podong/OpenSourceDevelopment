import java.util.Scanner;

public class third {
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
		* 작성일 : 2020.09.25
		* 프로그램 설명 : 키보드로부터 5명의 학번, 이름, 국어, 영어, 수학, C언어 입력받아  총점, 평균, 학점을 출력하는 프로그램
		*********************************/
		
		//studentNum[i] : i번째 학생의 학번
		int studentNum[] = new int[5];
		//name[i] : i번째 학생 이름, *Grade[i] : i번째 학생의 *과목 성적학점(A= ~ F)
		String name[] = new String [5], koreanGrade[] = new String [5], englishGrade[] = new String [5], mathGrade[] = new String [5], cLangGrade[] = new String [5];
		//[i][0] : i번째 학생의 원점수, [i][1] : i번째 학생의 이수학점, [i][2] : i번째 학생의 과목평점
		double korean[][] = new double[5][3], english[][] = new double[5][3], math[][] = new double[5][3], cLang[][] = new double[5][3];
		//scoreSum[i], mean[i], totalGrade[i] : i번째 학생의 총점, 평균, 학점
		double scoreSum[] = new double[5], mean[] = new double[5], totalGrade[] = new double[5];
		
		//5명의 인적 정보와 과목 정보를 입력
		for(int i = 0; i < 5; i++) {
			//학번, 이름 
			System.out.println((i + 1) + "번째 학생의 학번, 이름을 입력하세요.");
			Scanner scanner = new Scanner(System.in);
			studentNum[i] = scanner.nextInt();
			name[i] = scanner.next();
			
			//국어
			System.out.println("국어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
			Scanner scanKorean = new Scanner(System.in);
			korean[i][0] = scanKorean.nextDouble();
			koreanGrade[i] = scanKorean.next();
			korean[i][1] = scanKorean.nextDouble();
			korean[i][2] = changeGradeToDouble(koreanGrade[i], korean[i][1]);
			
			//영어
			System.out.println("영어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
			Scanner scanEnglish = new Scanner(System.in);
			english[i][0] = scanEnglish.nextDouble();
			englishGrade[i] = scanEnglish.next();
			english[i][1] = scanEnglish.nextDouble();
			english[i][2] = changeGradeToDouble(englishGrade[i], english[i][1]);
			
			//수학
			System.out.println("수학의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
			Scanner scanMath = new Scanner(System.in);
			math[i][0] = scanMath.nextDouble();
			mathGrade[i] = scanMath.next();
			math[i][1] = scanMath.nextDouble();
			math[i][2] = changeGradeToDouble(mathGrade[i], math[i][1]);
			
			//C언어
			System.out.println("C언어의 원점수, 성적학점(A+ ~ F), 이수학점을 순서대로 입력하세요. ");
			Scanner scanCLang = new Scanner(System.in);
			cLang[i][0] = scanCLang.nextDouble();
			cLangGrade[i] = scanCLang.next();
			cLang[i][1] = scanCLang.nextDouble();
			cLang[i][2] = changeGradeToDouble(cLangGrade[i], cLang[i][1]);
			
			//원점수 총점, 원점수 평균, 학점
			scoreSum[i] = korean[i][0] + english[i][0] + math[i][0] + cLang[i][0];
			mean[i] = scoreSum[i] / 4;
			totalGrade[i] = (korean[i][2]+english[i][2]+math[i][2]+cLang[i][2]) / (korean[i][1]+english[i][1]+math[i][1]+cLang[i][1]);
			
			//for문이 마지막까지 loop하기 전에 close하면 error 발생 because 한번 닫힌 scanner는 다시 열 수 없음
			if(i == 4) {
				scanKorean.close();
				scanEnglish.close();
				scanMath.close();
				scanCLang.close();
				scanner.close();
			}
		}
		//총점, 평균, 학점 출력
		System.out.println("______________________________________________________________________________________");
		System.out.println("     학번\t" + "\t     이름\t" + "\t국어\t" + "영어\t" + "수학\t" + "C언어\t" + "총점\t" + "평균\t" + "학점\t");
		for(int i=0;i<5;i++) {
			System.out.println(studentNum[i] + "\t" + name[i] + "\t" + koreanGrade[i] + "\t" + englishGrade[i] + "\t" + mathGrade[i] + "\t" + cLangGrade[i] + "\t" + scoreSum[i] + "\t" + mean[i] + "\t" + String.format("%.2f", totalGrade[i]));
		}
	}
}
