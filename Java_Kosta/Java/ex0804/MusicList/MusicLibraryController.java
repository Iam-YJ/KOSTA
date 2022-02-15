class MusicLibraryController
{
	private MusicLibraryService service = MusicLibraryService.getInstance();

	/**
	 ���
	*/
	public void insert(MusicLibrary musiclib){
		  if (service.searchByMusicNo(musiclib.getMusicNo()) == null)
		  {
			  if (service.insert(musiclib))
			  {
				  System.out.println(musiclib.getMusicNo() + ". \"" + musiclib.getMusicArtist() + "\" - \"" + musiclib.getMusicTitle() + "\" �뷡�� �߰��Ǿ����ϴ�.");
			  }
			  else
			  {
				  System.out.println("�뷡 ����� �������� �� �̻� �߰��� �� �����ϴ�. �ִ� ��: " + MusicList.g_MusicMaxNum);
			  }
		  }
		  else
		  {
			System.out.print(musiclib.getMusicNo() + "�� �̹� �����ϴ� �뷡 ��ȣ�Դϴ�.\n");
		  }
	}

	/**
	��ü�˻�
	*/
	public void printMusicList()
	{
	   MusicLibrary[] musicArr = service.selectAll();
	   System.out.println("-----------------��ü �뷡 ��� (" + MusicLibraryService.musicCount + "/" + MusicList.g_MusicMaxNum + "��)-----------------");
	   for (int i = 0; i < MusicList.g_MusicMaxNum; i++)
	   {
		   if (musicArr[i] != null && musicArr[i].getMusicNo() > -1)
		   {
			   System.out.print("MusicNo: " + musicArr[i].getMusicNo() + "\t");
			   System.out.print("MusicArtist: \"" + musicArr[i].getMusicArtist() + "\"\t");
			   System.out.print("MusicTitle: \"" + musicArr[i].getMusicTitle() + "\"\n");
		   }
	   }
	   System.out.println();
	}

	public void searchMusicByTitle(String searchTitle)
	{
		MusicLibrary[] musicArr = service.selectAll();
		boolean bFound = false;
		for (int i = 0; i < MusicList.g_MusicMaxNum; i++)
		{
		   if (musicArr[i] != null && musicArr[i].getMusicNo() > -1 && musicArr[i].getMusicTitle().toUpperCase().contains(searchTitle.toUpperCase()))
		   {
				if (!bFound)
				{
				   bFound = true;
				   System.out.println("��ġ�ϴ� ����� ã�ҽ��ϴ�.");
				}
				System.out.print("MusicNo: " + musicArr[i].getMusicNo() + "\t");
				System.out.print("MusicArtist: " + musicArr[i].getMusicArtist() + "\t");
				System.out.print("MusicTitle: " + musicArr[i].getMusicTitle() + "\n");
		   }
		}
		
		if (!bFound) System.out.println("��ġ�ϴ� ����� �����ϴ�.");
	}
	
	public void searchMusicByArtist(String searchArtist)
	{
		MusicLibrary[] musicArr = service.selectAll();
		boolean bFound = false;
		for (int i = 0; i < MusicList.g_MusicMaxNum; i++)
		{
		   if (musicArr[i] != null && musicArr[i].getMusicNo() > -1 && musicArr[i].getMusicArtist().toUpperCase().contains(searchArtist.toUpperCase()))
		   {
				if (!bFound)
				{
				   bFound = true;
				   System.out.println("��ġ�ϴ� ����� ã�ҽ��ϴ�.");
				}
				System.out.print("MusicNo: " + musicArr[i].getMusicNo() + "\t");
				System.out.print("MusicArtist: " + musicArr[i].getMusicArtist() + "\t");
				System.out.print("MusicTitle: " + musicArr[i].getMusicTitle() + "\n");
		   }
		}
		
		if (!bFound) System.out.println("��ġ�ϴ� ����� �����ϴ�.");
	}

	/**
	 �����ϱ�
	*/
	public void update(MusicLibrary musiclib)
	{
	   if (service.update(musiclib))
	   {
		   System.out.print("�����Ǿ����ϴ�.\n");
	   }
	   else
	   {
		   System.out.print("�������� �ʾҽ��ϴ�.\n");
	   }
	}
	
	public void delete(MusicLibrary musiclib)
	{
	   if (service.delete(musiclib))
	   {
		   System.out.print("�����Ǿ����ϴ�.\n");
	   }
	   else
	   {
		   System.out.print("������ �� ���� ���Դϴ�.\n");
	   }
	}
}