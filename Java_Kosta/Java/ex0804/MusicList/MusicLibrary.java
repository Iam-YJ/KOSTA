class MusicLibrary
{
	private int musicNo;
	private String musicArtist;
	private String musicTitle;

	public MusicLibrary(){}
	public MusicLibrary(int musicNo, String musicArtist, String musicTitle)
	{
		this.musicNo = musicNo;
		this.musicArtist = musicArtist;
		this.musicTitle = musicTitle;
	}
	
	public void setMusicNo(int musicNo)
	{
		this.musicNo = musicNo;
	}
	
	public void setMusicArtist(String musicArtist)
	{
		this.musicArtist = musicArtist;
	}
	
	public void setMusicTitle(String musicTitle)
	{
		this.musicTitle = musicTitle;
	}
	
	public int getMusicNo()
	{
		return musicNo;
	}
	
	public String getMusicArtist()
	{
		return musicArtist;
	}
	
	public String getMusicTitle()
	{
		return musicTitle;
	}
}