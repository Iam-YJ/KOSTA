package exam;

public class ProductMainView {
  public static void main(String[] args) {
	  /**
	   * [1]. ���ڵ� ����
	   * */
	  System.out.println("********** [1] ��ǰ ����ϱ� ******************");
	  
	  
	  /**
	   * [2].   ex) select * from productList
	   *         ex)  select * from productList where �˻��ʵ� like  �˻��ܾ�
	   *          ex) select *from productList order by ���Ĵ��
	   *          ex) select * from productList where �˻��ʵ� like  �˻��ܾ�  order by ���Ĵ��
	   * */
	  System.out.println("********** [2] ��� �Խù� �˻� �Ǵ� ���ǿ� ���� �˻� �� ���� ******************");
	  
	 
	  /**
	   * [3].  parameter ������ ���� ���ڵ� �����Ѵ�.
	   *     ��ǰ�ڵ忡 �ش��ϴ� ��ǰ�� 
	   *     ��ǰ�̸�, ��ǰ����, ��ǰ����, ��ǰ�������� �����ϵ� parameter �� ������ �ִ� �����͸� �����Ѵ�.
	   * 
	   * */
	  System.out.println("********** [3] ��ǰ �����ϱ� ******************");
	  
	  /**
	   * [4].��ǰ�ڵ忡 �ش��ϴ� ���ڵ� ����
	   * */
	  System.out.println("********** [4] ��ǰ �����ϱ� ******************");
	  
	 /**
	  * [5]. ��� ��ǰ�� ������ ����Ѵ�.

		  select sum(p_qty) from product -- ����ǰ�� qty�����հ�
	  * */
	  System.out.println("********** [5] ��ϵ� �� ��ǰ ���� ******************");
	  


	  /**
	   * [6]. parameter�� ��ǰ�ڵ忡 �ش��ϴ� ���ڵ� �˻�
	   * ex)select * from productList where in ��ǰ�ڵ� in (?,?,...)
	   * */
	  System.out.println("********** [6] ��ǰ�ڵ忡 �ش��ϴ� ���ڵ� �˻� ******************");
	  

}
}







