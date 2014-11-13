package mazegame;

import javax.swing.*;

public class Maze {
	public static JFrame F;
	static boolean inGame = true;
	public static Node currentNode;
	public static int max;
	public static Node[] nodeList;
	public static int number = 0; // index variable for creation of nodeList
	static boolean coolBoolean1 = true;
	static boolean coolBoolean2 = true;
	
	public static void main(String[] args) throws InterruptedException {
		
		max = 3;
		Background bg = new Background();
		F = bg.background();
		while (coolBoolean1) {
			coolBoolean2 = true;
			number = 0;
			initializeMaze();
			currentNode = nodeList[0];
			while(coolBoolean2){
				Thread.sleep(1);
				if (Background.lives <= 0) {
					Background.GameOver();
				
					max = 2;
					Background.lives = 100;
					Background.level = 1;
					Background.Lives(Background.lives);
					Background.Level(Background.level);
					coolBoolean2 = false;
				}
			}
			max++;
			}
	}

	public static void initializeMaze() {
		nodeList = new Node[max];
		nodeList[number] = new Node(new Event());
		while (number < (nodeList.length - 1)) {
			String tempy = nodeList[number].getCorrectDirection();
			if (tempy.equals("top")) {
				nodeList[number].setTop(new Node(new Event()));
				number++;
				nodeList[number] = nodeList[number - 1].getTop();
			} else if (tempy.equals("bottom")) {
				nodeList[number].setBottom(new Node(new Event()));
				number++;
				nodeList[number] = nodeList[number - 1].getBottom();
			} else if (tempy.equals("left")) {
				nodeList[number].setLeft(new Node(new Event()));
				number++;
				nodeList[number] = nodeList[number - 1].getLeft();
			} else {// right
				nodeList[number].setRight(new Node(new Event()));
				number++;
				nodeList[number] = nodeList[number - 1].getRight();
			}
		}
		nodeList[number].setEndingNode(true);

	}
}