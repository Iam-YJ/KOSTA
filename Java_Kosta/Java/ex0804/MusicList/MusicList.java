import java.util.Scanner;

public class MusicList
{
	public static int g_MusicMaxNum = 10;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 최대 곡 수를 설정하세요: ");
		g_MusicMaxNum = sc.nextInt();
		if (g_MusicMaxNum < 10)
		{
			g_MusicMaxNum = 10;
			System.out.println("최소 저장 가능 수는 10 입니다.");
		}
		new MusicListMenu().ShowMenu();
	}
}