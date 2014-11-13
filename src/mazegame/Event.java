package mazegame;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.*;

public class Event {

	String correctDirection;

	public Event() {
		Random r = new Random();
		int temp = r.nextInt(4);
		if (temp == 0) {
			correctDirection = "top";
		}
		if (temp == 1) {
			correctDirection = "bottom";
		}
		if (temp == 2) {
			correctDirection = "left";
		}
		if (temp == 3) {
			correctDirection = "right";
		}
	}

	public String getCorrectDirection() {
		return correctDirection;
	}

	public String go(int a) {
		if (a == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (a == KeyEvent.VK_UP) {
			Background.arrow(1);
			return "top";
		}
		if (a == KeyEvent.VK_DOWN) {
			Background.arrow(2);
			return "bottom";
		}
		if (a == KeyEvent.VK_LEFT) {
			Background.arrow(3);
			return "left";
		}
		if (a == KeyEvent.VK_RIGHT) {
			Background.arrow(4);
			return "right";
		} else {
			return null;
		}
	}

	public static synchronized void play(final String fileName)

	{
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(new File(fileName));
					
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage()
							+ " for " + fileName);
				}
			}
		}).start();
		
	}
	public static synchronized void loop(final String fileName)

	{
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(new File(fileName));
					
					clip.open(inputStream);
					clip.loop(100);
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage()
							+ " for " + fileName);
				}
			}
		}).start();
		
	}
}