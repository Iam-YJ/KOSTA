class MusicLibraryController
{
	private MusicLibraryService service = MusicLibraryService.getInstance();

	/**
	 등록
	*/
	public void insert(MusicLibrary musiclib){
		  if (service.searchByMusicNo(musiclib.getMusicNo()) == null)
		  {
			  if (service.insert(musiclib))
			  {
				  System.out.println(musiclib.getMusicNo() + ". \"" + musiclib.getMusicArtist() + "\" - \"" + musiclib.getMusicTitle() + "\" 노래가 추가되었습니다.");
			  }
			  else
			  {
				  System.out.println("노래 목록이 가득차서 더 이상 추가할 수 없습니다. 최대 곡: " + MusicList.g_MusicMaxNum);
			  }
		  }
		  else
		  {
			System.out.print(musiclib.getMusicNo() + "는 이미 존재하는 노래 번호입니다.\n");
		  }
	}

	/**
	전체검색
	*/
	public void printMusicList()
	{
	   MusicLibrary[] musicArr = service.selectAll();
	   System.out.println("-----------------전체 노래 목록 (" + MusicLibraryService.musicCount + "/" + MusicList.g_MusicMaxNum + "개)-----------------");
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
				   System.out.println("일치하는 결과를 찾았습니다.");
				}
				System.out.print("MusicNo: " + musicArr[i].getMusicNo() + "\t");
				System.out.print("MusicArtist: " + musicArr[i].getMusicArtist() + "\t");
				System.out.print("MusicTitle: " + musicArr[i].getMusicTitle() + "\n");
		   }
		}
		
		if (!bFound) System.out.println("일치하는 결과가 없습니다.");
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
				   System.out.println("일치하는 결과를 찾았습니다.");
				}
				System.out.print("MusicNo: " + musicArr[i].getMusicNo() + "\t");
				System.out.print("MusicArtist: " + musicArr[i].getMusicArtist() + "\t");
				System.out.print("MusicTitle: " + musicArr[i].getMusicTitle() + "\n");
		   }
		}
		
		if (!bFound) System.out.println("일치하는 결과가 없습니다.");
	}

	/**
	 수정하기
	*/
	public void update(MusicLibrary musiclib)
	{
	   if (service.update(musiclib))
	   {
		   System.out.print("수정되었습니다.\n");
	   }
	   else
	   {
		   System.out.print("수정되지 않았습니다.\n");
	   }
	}
	
	public void delete(MusicLibrary musiclib)
	{
	   if (service.delete(musiclib))
	   {
		   System.out.print("삭제되었습니다.\n");
	   }
	   else
	   {
		   System.out.print("삭제할 수 없는 곡입니다.\n");
	   }
	}
}