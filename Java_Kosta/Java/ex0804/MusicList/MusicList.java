import java.util.Scanner;

public class MusicList
{
	public static int g_MusicMaxNum = 10;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ִ� �� ���� �����ϼ���: ");
		g_MusicMaxNum = sc.nextInt();
		if (g_MusicMaxNum < 10)
		{
			g_MusicMaxNum = 10;
			System.out.println("�ּ� ���� ���� ���� 10 �Դϴ�.");
		}
		new MusicListMenu().ShowMenu();
	}
}