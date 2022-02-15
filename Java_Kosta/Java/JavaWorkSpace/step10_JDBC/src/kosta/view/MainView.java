package kosta.view;

import kosta.dao.PrepareSqlQueryDAO;
import kosta.dao.SqlQueryDAO;
import kosta.vo.Emp;

public class MainView {

	public static void main(String[] args) {

		System.out.println("1. ��ü ����̸� �˻��ϱ�");
		// SqlQueryDAO dao = new SqlQueryDAO();
		// dao.selectEname();
		PrepareSqlQueryDAO sdao = new PrepareSqlQueryDAO();
		sdao.selectEname();
		System.out.println();

		System.out.println("2. �����ȣ, �̸�, job, hiredate �˻��ϱ�");
		// dao.selectAll();
		// new MenuExam();

		sdao.selectAll();
		System.out.println();

		// 3. empno�� �μ��� �޾� empno�� �ش��ϴ� ��� �����ϱ�
		System.out.println("3. empno�� �μ��� �޾� empno�� �ش��ϴ� ��� �����ϱ�");
		// dao.delete(7900);
		// dao.delete(9000);

		sdao.delete(7566);
		sdao.delete(9000);
		System.out.println();

		// 4. empno�� �ش��ϴ� ����� ename, job, sal �����ϱ�
		// �μ� : empno, ename, job, sal �޴´�
		System.out.println("4. empno�� �ش��ϴ� ����� ename, job, sal �����ϱ�");
		// dao.update(new Emp(7566,"����","����",3000, null));
		// dao.update(new Emp(1111,"����","����",3000, null));

		sdao.update(new Emp(7654, "����", "����", 3000, null));
		sdao.update(new Emp(1000, "����", "����", 3000, null));
		System.out.println();

		// 5. empno�� �ش��ϴ� ��� �˻��ϱ�
		System.out.println("5. empno�� �ش��ϴ� ��� �˻��ϱ�");
		// dao.selectByEmpno(7566);
		// dao.selectByEmpno(1111);

		// 6. emp ���̺� ���ڵ� �߰��ϱ�
		// �߰����� : empno, enmae, job, sal, hiredate
		// * hiredate�� ���糯¥ ���
		System.out.println("6. emp ���̺� ���ڵ� �߰��ϱ�");
		// dao.insert(new Emp(1111,"����","����",3000, null));

	}

}
