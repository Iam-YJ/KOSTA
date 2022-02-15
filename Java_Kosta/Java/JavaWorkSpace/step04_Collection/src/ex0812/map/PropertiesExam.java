package ex0812.map;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.spi.ResourceBundleControlProvider;

public class PropertiesExam {

	Properties pro = new Properties();

	public PropertiesExam() {
		// ����
		pro.setProperty("id", "jang");
		pro.setProperty("age", "20");
		pro.setProperty("addr", "��⵵ �Ǳ�");

		// ������
		Set<String> keys = pro.stringPropertyNames(); // ��� key ���� set���� ��������
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = pro.getProperty(key);
			System.out.println(key + " : " + value);
		}
	}

	/**
	 * �ܺ� ~.properties ���� �ε� 1) IO�� �̿��ؼ� properties ������ �ε� 2) ResourceBundle ��ü�� �̿���
	 * �ε�
	 */

	// 1) IO�� �̿��ؼ� properties ������ �ε�
	public void test1() throws Exception {
		pro.clear(); // �����

		pro.load(new FileInputStream("src/ex0812/map/test.properties"));

		// ������
		Set<String> keys = pro.stringPropertyNames(); // ��� key ���� set���� ��������
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = pro.getProperty(key);
			System.out.println(key + " : " + value);
		}

	}

	// 2) ResourceBundle ��ü�� �̿��� �ε�
	// ResourceBundle��ü�� ~.properties ���� �ε��ϴ� ���� Ŭ����
	// ��θ� ������ �� Ȯ���ڴ� �����Ѵ�.
	// ���� ������ classes �����̴�
	public void test2() {
		ResourceBundle rb = ResourceBundle.getBundle("ex0812/map/test");

		Set<String> keys = rb.keySet();
		Iterator<String> it = keys.iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);
			System.out.println(key + " : " + value);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PropertiesExam pe = new PropertiesExam(); // �����ڿ��� ������ ����
		System.out.println("---------------------");
		// pe.test1();
		pe.test2();

	}

}
