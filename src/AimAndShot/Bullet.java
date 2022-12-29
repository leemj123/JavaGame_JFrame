package AimAndShot;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

//잔여 총알 구현할 부분=====================================================================================
public class Bullet{
	private Image bullet = new ImageIcon(Main.class.getResource("../images/bullet.png")).getImage();
	//이미지를 저장할 리스트
	ArrayList<Image> bullets = new ArrayList<>();
	
	private int leftBullet = 8; //가지고 시작할 탄환 수
	private int bulletX = 700; //
	private int bulletY = 700;
	Bullet(){
		for(int i =0; i< 8; i++) {
		bullets.add(bullet);
		}
	}
	public void drawBullet(Graphics g) {
		int y= bulletY; // 이미지를 겹치지 않기 위해
		for (int i =0; i < leftBullet; i++) {
			g.drawImage(bullets.get(i),bulletX,y,50,20,null);
			y -= 30;// 이미지가 위에서부터 줄어들 수 있도록
		}
	}
	public int getLeftBullet() {
		return leftBullet;
	}
	public void decreaseBullet() {
		this.leftBullet -= 1;
	}
}
