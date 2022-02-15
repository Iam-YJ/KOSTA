import java.util.Scanner;

public class MusicListMenu
{
	MusicLibraryController controller = new MusicLibraryController();

	public void ShowMenu()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("�ܢܢܢܢܢܢܢܢ�    �뷡 ��� ����    �ܢܢܢܢܢܢܢܢ� (�ִ� ��: " + MusicList.g_MusicMaxNum + ")");
			System.out.println("1. �뷡 ���\t2. �뷡 �߰�\t3. �뷡 ����\t4. �뷡 ����\n5. ���� �˻�\t6. ���� �˻�\t\t\t9. ����");
			int select = sc.nextInt();
			switch(select)
			{
				case 1: controller.printMusicList(); break;
				case 2: addMusic(); break;
				case 3: editMusic(); break;
				case 4: deleteMusic(); break;
				case 5: searchMusicByTitle(); break;
				case 6: searchMusicByArtist(); break;
				
				case 9:
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
					
				default: System.out.println("���� �޴��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void addMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�뷡 ��ȣ: ");
		int musicNo = Integer.parseInt(sc.nextLine());

		System.out.print("�뷡 ����: ");
		String musicArtist = sc.nextLine();

		System.out.print("�뷡 ����: ");
		String musicTitle = sc.nextLine();

		MusicLibrary musiclib = new MusicLibrary(musicNo, musicArtist, musicTitle);
		controller.insert(musiclib);
	}
	
	public void editMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �뷡 ��ȣ: ");
		int musicNo = Integer.parseInt(sc.nextLine());

		System.out.print("������ �뷡 ����: ");
		String musicArtist = sc.nextLine();

		System.out.print("������ �뷡 ����: ");
		String musicTitle = sc.nextLine();

		MusicLibrary musiclib = new MusicLibrary(musicNo, musicArtist, musicTitle);
		controller.update(musiclib);
	}
	
	public void deleteMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �뷡 ��ȣ: ");
		int musicNo = sc.nextInt();

		MusicLibrary musiclib = new MusicLibrary(musicNo, null, null);
		controller.delete(musiclib);
	}
	
	public void searchMusicByTitle()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� �뷡 ����: ");
		String musicTitle = sc.nextLine();
		controller.searchMusicByTitle(musicTitle);
	}
	
	public void searchMusicByArtist()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ������: ");
		String musicArtist = sc.nextLine();
		controller.searchMusicByArtist(musicArtist);
	}
}