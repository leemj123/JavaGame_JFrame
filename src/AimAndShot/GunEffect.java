package AimAndShot;

import java.awt.*;

import javax.swing.*;

public class GunEffect extends Thread{
	private Image Effect = new ImageIcon(Main.class.getResource("../images/gunEffect.png")).getImage();
	private int shotX,shotY;
	
	//GameMain에서 좌표 받아오는 함수
	public void setShotXY(int x, int y) {
		this.shotX = x;
		this.shotY = y;
	}
	public int getShotX() {
		return this.shotX;
	}
	public int getShotY() {
		return this.shotY;
	}
	public Image getEffect() {
		return this.Effect;
	}
	//마우스 좌표에 따라 그리는 부분------------------------------------------------------------------------------------------
	public void drawEffect(Graphics g) {
		try {
		g.drawImage(Effect,shotX-10,shotY-10,50,50,null);//이미지가 에임의 중앙에 위치하도록
		//나타났다 사라지게
		Thread.sleep(20);
		this.shotX = -100;
		this.shotY = -100;
		}catch(Exception e) {};
	}
}
