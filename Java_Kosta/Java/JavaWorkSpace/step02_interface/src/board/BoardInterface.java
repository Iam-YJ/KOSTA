package board;

/*
 *  interface
 *  : ���� ������� �۾��� �� ������ �԰ݼ��� �����ϰ��� �� 
 *  
 * */

public interface BoardInterface {
	
	//���
	boolean insert(Board board);
	
	//�۹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϱ�
	Board selectByNo(int no);
	
	
	/*
	 * java 1.8 version �߰� - interface ������
	 * 
	 * 1) default �޼ҵ�
	 *    ��ɱ��� ����
	 *    �ݵ�� ������ü�� �־�߸� ���� ����
	 *    
	 *  2)��ɱ��� ����
	 *    ��ɱ��� ����
	 *    ������ü ���� interface �̸�.�޼ҵ��̸�() ����
	 *    
	 *  *�߰��� ����
	 *   : �̹� ���ߵ� ���¿��� �������� �� �� Ư�� ������ü���� �ʿ��� 
	 *   	�޼ҵ带 �����ϰ� ���� �� static or default �޼ҵ带 �̿��ϸ� 
	 *    	��� ������ü�� �������� �ʿ���� �ʿ��� �������� ������ �ϰų�
	 *    	�� ����� �׳� ����ϸ� �ȴ�.
	 *  
	 *  	 * */
	
	//����
	default boolean delete(int no) {
		System.out.println("BoardInterface�� delete(int no) ȣ���");
		return false;
	}
	//���� 
	static boolean update(Board board) {
		System.out.println("BoardInterface�� update() ȣ���");
		return true;
	}
}
