import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher {

	public static void main(String[] args) {
		MyGame myProgram = new MyGame();
		// creates a window that is the specific size of the background and the window is tittle blackjack
        new LwjglApplication( myProgram , "Blackjack", 1136, 640 );
	}

}
