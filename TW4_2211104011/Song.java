package Assignment;

public class Song {

    private String id;
    private String title;
    private String releaseYear;
    private String musicFileURL;
    private Genre genre = Genre.UNDEFINED; // Default value
    
    private String albumName;
    private String albumCoverURL;
    
    private String artistName;
    private String artistAlias;
    private String artistImageURL;

    // Konstanta untuk level detail
    private static final int DETAIL_SONG = 0;
    private static final int DETAIL_ARTIST = 1;
    private static final int DETAIL_ALBUM = 2;
    private static final int DETAIL_FULL = 3;
    
    public enum Genre {
        UNDEFINED, POP, ROCK, HIP_HOP, RNB, JAZZ, INSTRUMENTALS, CLOWNCORE
    }

    public Song(String id, String title, String releaseYear, String musicFileURL) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.musicFileURL = musicFileURL;
    }
    
    public void setAlbum(String albumName, String albumCoverURL) {
        this.albumName = albumName;
        this.albumCoverURL = albumCoverURL;
    }
    
    public void setArtist(String artistName, String artistAlias, String artistImageURL) {
        this.artistName = artistName;
        this.artistAlias = artistAlias;
        this.artistImageURL = artistImageURL;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void printInfo(int detailLevel) {
        System.out.println(getSongInfo());

        if (detailLevel >= DETAIL_ARTIST) {
            System.out.println(getArtistInfo());
        }
        if (detailLevel >= DETAIL_ALBUM) {
            System.out.println(getAlbumInfo());
        }
    }

    private String getSongInfo() {
        return "Song Title: " + title + "\nRelease Year: " + releaseYear + 
               (genre != Genre.UNDEFINED ? "\nGenre: " + genre : "");
    }

    private String getArtistInfo() {
        if (artistName == null || artistName.isEmpty()) return "";
        return "Artist Name: " + artistName + 
               (!artistAlias.isEmpty() ? "\nAlso known as: " + artistAlias : "");
    }

    private String getAlbumInfo() {
        if (albumName == null || albumName.isEmpty()) return "";
        return "Album Title: " + albumName;
    }
}
