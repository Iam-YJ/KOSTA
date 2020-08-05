import java.util.Scanner;

public class MusicListMenu
{
	MusicLibraryController controller = new MusicLibraryController();

	public void ShowMenu()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("♪♪♪♪♪♪♪♪♪    노래 목록 관리    ♪♪♪♪♪♪♪♪♪ (최대 곡: " + MusicList.g_MusicMaxNum + ")");
			System.out.println("1. 노래 목록\t2. 노래 추가\t3. 노래 수정\t4. 노래 삭제\n5. 제목 검색\t6. 가수 검색\t\t\t9. 종료");
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
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
					
				default: System.out.println("없는 메뉴입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void addMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("노래 번호: ");
		int musicNo = Integer.parseInt(sc.nextLine());

		System.out.print("노래 가수: ");
		String musicArtist = sc.nextLine();

		System.out.print("노래 제목: ");
		String musicTitle = sc.nextLine();

		MusicLibrary musiclib = new MusicLibrary(musicNo, musicArtist, musicTitle);
		controller.insert(musiclib);
	}
	
	public void editMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 노래 번호: ");
		int musicNo = Integer.parseInt(sc.nextLine());

		System.out.print("수정할 노래 가수: ");
		String musicArtist = sc.nextLine();

		System.out.print("수정할 노래 제목: ");
		String musicTitle = sc.nextLine();

		MusicLibrary musiclib = new MusicLibrary(musicNo, musicArtist, musicTitle);
		controller.update(musiclib);
	}
	
	public void deleteMusic()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 노래 번호: ");
		int musicNo = sc.nextInt();

		MusicLibrary musiclib = new MusicLibrary(musicNo, null, null);
		controller.delete(musiclib);
	}
	
	public void searchMusicByTitle()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 노래 제목: ");
		String musicTitle = sc.nextLine();
		controller.searchMusicByTitle(musicTitle);
	}
	
	public void searchMusicByArtist()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 가수명: ");
		String musicArtist = sc.nextLine();
		controller.searchMusicByArtist(musicArtist);
	}
}