package Shop;

/*
 * ����� ���� Exceptioin
 *  : ����ڰ� ���� Ŭ������ ��{���� ������ �Ǳ� ���ؼ� �ݵ�� 
 *  	XxxException ��ü ���� �ϳ��� ��ӹ޴´�.
 *  
 *  : ���� ����
 *  	1) üũ Exception
 *  	2) ��üũ Exception - RuntimeException ���� Ŭ���� (���൵�� �߻�)
 *  
 * */

public class ExceptionExam extends Exception {

	public ExceptionExam() {
	}

	public ExceptionExam(String s) {
		super(s);
	}

}
