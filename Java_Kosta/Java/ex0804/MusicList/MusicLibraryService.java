class MusicLibraryService
{
	private static MusicLibraryService instance = new MusicLibraryService();
    private MusicLibrary[] musicArr = new MusicLibrary[MusicList.g_MusicMaxNum];

    public static int musicCount; //현재 배열에 몇개의 MusicLibrary가 저장되었는지 체크하는 변수

    //전자제품 초기치 데이터
	String [][] initData = new String [][]
	{
		// musicNo, musicArtist, musicTitle
		{"1", "싹쓰리 (유두래곤, 린다G, 비룡)", "다시 여기 바닷가"},
		{"2", "화사 (Hwa Sa)", "마리아 (Maria)"},
		{"3", "BLACKPINK", "How You Like That",},
		{"4", "싹쓰리 (유두래곤, 린다G, 비룡)", "그 여름 틀어줘"},
		{"5" ,"아이유","에잇(Prod.&Feat. SUGA of BTS)"},
		{"6" ,"이하이","홀로"},
		{"7" ,"선미","보라빛 밤 (pporappippam)"},
		{"8" ,"오마이걸","살짝 설렜어 (Nonstop)"},
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

		//찾았다...-> 수정해주자.
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