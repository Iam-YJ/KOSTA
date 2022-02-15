class MusicLibraryService
{
	private static MusicLibraryService instance = new MusicLibraryService();
    private MusicLibrary[] musicArr = new MusicLibrary[MusicList.g_MusicMaxNum];

    public static int musicCount; //���� �迭�� ��� MusicLibrary�� ����Ǿ����� üũ�ϴ� ����

    //������ǰ �ʱ�ġ ������
	String [][] initData = new String [][]
	{
		// musicNo, musicArtist, musicTitle
		{"1", "�Ͼ��� (���η���, ����G, ���)", "�ٽ� ���� �ٴ尡"},
		{"2", "ȭ�� (Hwa Sa)", "������ (Maria)"},
		{"3", "BLACKPINK", "How You Like That",},
		{"4", "�Ͼ��� (���η���, ����G, ���)", "�� ���� Ʋ����"},
		{"5" ,"������","����(Prod.&Feat. SUGA of BTS)"},
		{"6" ,"������","Ȧ��"},
		{"7" ,"����","����� �� (pporappippam)"},
		{"8" ,"�����̰�","��¦ ������ (Nonstop)"},
		{"9" ,"Maroon 5","Memories"},
	};

   private MusicLibraryService()
   {
		for (int i = 0; i< initData.length; i++)
		{
			musicArr[musicCount++] = new MusicLibrary(Integer.parseInt(initData[i][0]), initData[i][1], initData[i][2]);
		}
   }

   public static MusicLibraryService getInstance(){
        return instance;
   }

    public MusicLibrary[] selectAll(){
        return musicArr;
	}

   public boolean insert(MusicLibrary musiclib){
	   if(musicArr.length == musicCount){
           return false;
	   }

       musicArr[musicCount++] = musiclib;
       return true;
   }

   public MusicLibrary searchByMusicNo(int musicNo)
   {
		for (int i=0; i < MusicLibraryService.musicCount; i++)
		{
			if (musicArr[i].getMusicNo() == musicNo)
			{
				return musicArr[i];
			}
		}
		return null;
   }
   
   public boolean update(MusicLibrary musiclib){
        MusicLibrary  searchMusic =  this.searchByMusicNo( musiclib.getMusicNo() );

		if (searchMusic == null) return false;

		//ã�Ҵ�...-> ����������.
        searchMusic.setMusicArtist( musiclib.getMusicArtist() );
        searchMusic.setMusicTitle( musiclib.getMusicTitle() );
        return true;
   }
   
   public boolean delete(MusicLibrary musiclib)
   {
        MusicLibrary  searchMusic =  this.searchByMusicNo( musiclib.getMusicNo() );

		if (searchMusic == null) return false;

        searchMusic.setMusicNo( -1 );
        searchMusic.setMusicArtist( null );
        searchMusic.setMusicTitle( null );
		musicCount--;
        return true;
   }
}