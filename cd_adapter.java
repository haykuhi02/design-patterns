// CD Playerclass CDPlayer {
    void playCD(String song) {        System.out.println("Playing song " + song + " from CD.");
    }
}
// Digital Music Playerclass DigitalMusicPlayer {
    void playDigitalFormat(String song) {        System.out.println("Playing song " + song + " in DigitalFormat.");
    }}
// Adapter for Digital Music Player
class PlayerAdapter {
    private DigitalMusicPlayer digitalPlayer;
    public PlayerAdapter(DigitalMusicPlayer digitalPlayer) {        this.digitalPlayer = digitalPlayer;
    }
    void play(String song) {        // Assume we convert the song to DigitalFormat if needed
        digitalPlayer.playDigitalFormat(song);    }
}
// Usagepublic class AdapterPatternNoInterfaceExample {
    public static void main(String[] args) {        // Create a CD Player
        CDPlayer cdPlayer = new CDPlayer();
        // Create a Digital Music Player        DigitalMusicPlayer digitalPlayer = new DigitalMusicPlayer();
        // Create an adapter for the Digital Music Player
        PlayerAdapter adapter = new PlayerAdapter(digitalPlayer);
        // Play a song using the CD Player with the adapter        String song = "MyFavoriteSong";
        cdPlayer.playCD(song); // Without adapter, this would only work for CDs        adapter.play(song);   // With adapter, CD Player can play songs from Digital Music Player
    }}
