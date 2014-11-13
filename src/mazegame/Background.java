package mazegame;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Background extends JPanel implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int lives = 100;
	static int level = 1;
	static JFrame f = new JFrame("Jacob's Ladder");
	static JLabel Up = new JLabel(new ImageIcon("uparrow.png"));
	static JLabel Down = new JLabel(new ImageIcon("downarrow.png"));
	static JLabel Left = new JLabel(new ImageIcon("leftarrow.png"));
	static JLabel Right = new JLabel(new ImageIcon("rightarrow.png"));
	static JLabel Lives = new JLabel("Lives: "+ lives, JLabel.LEFT);
	static JLabel Level = new JLabel("Level: "+ level, JLabel.RIGHT);
	static JLabel GameOver = new JLabel("", JLabel.CENTER);
	public JFrame background() throws InterruptedException{ 
		  Color newcolor = new Color (13, 128, 26);
		  f.getContentPane().setBackground(newcolor);
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  f.setExtendedState(Frame.MAXIMIZED_BOTH); 
		  //f.setSize(500, 500);
		  JLabel Welcome = new JLabel("Welcome To Jacob's Ladder", JLabel.CENTER);
		  Welcome.setFont(new Font("Arial", Font.BOLD, 85));
		  Welcome.setForeground(Color.white);
		  JLabel Direct1 = new JLabel("Use The Arrow Keys To Find Your Way", JLabel.CENTER);
		  Direct1.setFont(new Font("Arial", Font.BOLD, 35));
		  Direct1.setForeground(Color.white);
		  Lives.setFont(new Font("Arial", Font.BOLD, 50));
		  Lives.setForeground(Color.white);
		  Lives.setVerticalAlignment(JLabel.TOP);
		  
		  Level.setFont(new Font("Arial", Font.BOLD, 50));
		  Level.setForeground(Color.white);
		  Level.setVerticalAlignment(JLabel.TOP);
		  
		  GameOver.setFont(new Font("Arial", Font.BOLD, 100));
		  GameOver.setForeground(Color.white);
		  GameOver.setVerticalAlignment(JLabel.TOP);
			
		  
		  f.add(Welcome);
		  f.setUndecorated(true);  
		  f.setVisible(true);
		  f.addKeyListener(this);
		  Event.play("Welcome.wav");
		  Thread.sleep(3000);
		  f.remove(Welcome);
		  f.add(Direct1);
		  f.setVisible(true);
		  Event.play("ArrowKeys.wav");
		  
		  Thread.sleep(3000);
		  Event.play("Correct.wav");
		  Direct1.setText("A Correct Move Will Sound Like This");
		  Thread.sleep(4000);
		  Event.play("Maze Game Walk.wav");
		  Thread.sleep(2000);
		  
		  Event.play("Incorrect.wav");
		  Direct1.setText("An Incorrect Move Returns You To The Level Start");
		  Thread.sleep(5000);
		  
		  Event.play("Sounds.wav");
		  Direct1.setText("It Sounds Like This");
		  Thread.sleep(3000);
		  Event.play("Maze Game Wall.wav");
		  Thread.sleep(2000);
		  
		  Event.play("Complete.wav");
		  Direct1.setText("Completing The Level Sounds Like This");
		  Thread.sleep(4000);
		  Event.play("Maze Game Level Success.wav");
		  Thread.sleep(3000);
		  
  		  Event.play("Finish.wav");
		  Direct1.setText("Finish As Many As You Can Before Your Lives Run Out");
		  
		  Thread.sleep(5000);
		  f.remove(Direct1);
		  
		  Event.loop("Background.wav");
		  f.add(Lives);
		  f.setVisible(true);
		  f.add(Level);
		  f.setVisible(true);
		  f.add(GameOver);
		  f.setVisible(true);
		  Event.play("100 lives.wav");
		  return f;
		}
	public static JFrame arrow(int x){
		f.remove(Up);
		f.remove(Down);
		f.remove(Left);
		f.remove(Right);
		if (x == 1){	
			f.add(Up);
			f.setVisible(true);
		}
		else if (x == 2){
			f.add(Down);
			f.setVisible(true);
		}
		else if (x == 3){
			f.add(Left);
			f.setVisible(true);
		}
		else{
			f.add(Right);
			f.setVisible(true);
		}
		return f;
	}
	public static JFrame Lives(int remaininglife) {
		if (remaininglife >= 0){
		Lives.setText("Lives: " +remaininglife);
		}
		else{
			Lives.setText("Lives: 0");	
		}
		if (remaininglife == 100) Event.play("100 lives.wav");
		else if (remaininglife == 75) Event.play("75 lives.wav");
		else if (remaininglife == 50) Event.play("50 lives.wav");
		else if (remaininglife == 25) Event.play("25 lives.wav");
		else if (remaininglife == 10) Event.play("10 lives.wav");
		else if (remaininglife == 5) Event.play("5 lives.wav");
		else if (remaininglife == 1) Event.play("1 life.wav");
		return f;
	}
	public static JFrame Level(int level) throws InterruptedException{
		Level.setText("Level: " +level);
		return f;
	}
	public static void PlayLevel(){
		if (level == 1) Event.play("Level 1.wav");
		else if (level == 2) Event.play("Level 2.wav");
		else if (level == 3) Event.play("Level 3.wav");
		else if (level == 4) Event.play("Level 4.wav");
		else if (level == 5) Event.play("Level 5.wav");
		else if (level == 6) Event.play("Level 6.wav");
		else if (level == 7) Event.play("Level 7.wav");
		else if (level == 8) Event.play("Level 8.wav");
		else if (level == 9) Event.play("Level 9.wav");
		else if (level == 10) Event.play("Level 10.wav");
		else if (level == 11) Event.play("Level 11.wav");
		else if (level == 12) Event.play("Level 12.wav");
		else if (level == 13) Event.play("Level 13.wav");
		else if (level == 14) Event.play("Level 14.wav");
		else Event.play("Level 145.wav");
	}
	public static JFrame GameOver() throws InterruptedException{
		GameOver.setText("Game Over");
		Event.play("GameOver.wav");
		Thread.sleep(2000);
		Event.play("FinalScore.wav");
		Thread.sleep(2800);
		PlayLevel();
		Thread.sleep(1800);
		GameOver.setText("Restarting In 5");
		Event.play("Restart.wav");
		Thread.sleep(1500);
		GameOver.setText("Restarting In 4");
		Thread.sleep(1500);
		GameOver.setText("Restarting In 3");
		Thread.sleep(1500);
		GameOver.setText("Restarting In 2");
		Thread.sleep(1500);
		GameOver.setText("Restarting In 1");
		Thread.sleep(1500);
		GameOver.setText("");
		return f;
	}
		public static Color newcolor(){
			int R = (int)(Math.random() * (256));
			int G = (int)(Math.random() * (256));
			int B = (int)(Math.random() * (256));
			Color newcolor = new Color (R, G, B);
			return newcolor;

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int a = e.getKeyCode();
		Maze.currentNode = Maze.currentNode.run(a);
		if(Maze.currentNode == null){
			Event.play("Maze Game Wall.wav");
			lives--;
			Background.Lives(lives);
			Maze.currentNode = Maze.nodeList[0];//restarting the maze
		}
		else if(Maze.currentNode.getEndingNode()){
			Event.play("Maze Game Level Success.wav"); 
			level++;
			try {
				Background.Level(level);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Maze.coolBoolean2 = false;
		}
		else{
			Event.play("Maze Game Walk.wav");
		}
		Maze.F.getContentPane().setBackground(Background.newcolor());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}