import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CDPlayerTest {
    private CDPlayer cdPlayer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        cdPlayer = new CDPlayer();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPlayCD() {
        String song = "MyFavoriteSong";
        cdPlayer.playCD(song);
        assertEquals("Playing song MyFavoriteSong from CD.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}

class DigitalMusicPlayerTest {
    private DigitalMusicPlayer digitalPlayer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        digitalPlayer = new DigitalMusicPlayer();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPlayDigitalFormat() {
        String song = "MyFavoriteSong";
        digitalPlayer.playDigitalFormat(song);
        assertEquals("Playing song MyFavoriteSong in DigitalFormat.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}

class PlayerAdapterTest {
    private PlayerAdapter adapter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        DigitalMusicPlayer digitalPlayer = new DigitalMusicPlayer();
        adapter = new PlayerAdapter(digitalPlayer);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPlay() {
        String song = "MyFavoriteSong";
        adapter.play(song);
        assertEquals("Playing song MyFavoriteSong in DigitalFormat.\n", outContent.toString());
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
