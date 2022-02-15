package ex0810;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****메인 시작*****");
		try {
			String data = args[0];
			System.out.println("data = " + data);

			int no = Integer.parseInt(data);
			System.out.println("변환후 : " + no);

			int result = 100 / no;
			System.out.println("나눈 결과 : " + result);

			// catch 블럭 여러개 작성할 때 반드시 서브 class 부터 작성한다

		} catch (ArrayIndexOutOfBoundsException e) {
			// 예외발생 했을 때 해야할 일 작성
			System.out.println("인수를 꼭 넣어주세요 : " + e);
			// e -> e의 주소값이 아닌 어떤 클래스에서 무슨 오류가 났는지 나옴
			// 즉 오류에 대한 정보가 나온다
			

		} catch (NumberFormatException e) {
			System.out.println("반드시 숫자만 입력해주세요 : " + e.getMessage());
			// 유저들에게 어떤 오류가 났는지 메세지 보낼 때 사용함
		} catch (Exception e) { // 다형성 이용
			System.out.println("예외가 발생했습니다. ");

			e.printStackTrace();
			// sysout 필요없음
			// 오류 정보를 가장 detail하게 stack에 쌓아두었다가 한번에 출력

		} finally {
			System.out.println("예외발생여부와 상관없이 난 무조건 실행한다.");
		}

		System.out.println("*****메인 끝*****");

	}

}
