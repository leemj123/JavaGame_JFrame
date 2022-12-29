package AimAndShot;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

// 원반 관련 =======================================================================================
public class FlyDisk extends Thread{
	private Image disk1 = new ImageIcon(Main.class.getResource("../images/disk1.png")).getImage();
	private Image disk2 = new ImageIcon(Main.class.getResource("../images/disk2.png")).getImage();
	private Image disk3 = new ImageIcon(Main.class.getResource("../images/disk3.png")).getImage();
	private int diskX,diskY,choseDisk,limitLeft,limitRight;
	private int clickPointX, clickPointY = -100;
	private int score =0;
	private ArrayList<Image> diskList = new ArrayList<>();
	
	public FlyDisk(int limitLeft,int limitRight){
		this.limitLeft = limitLeft;this.limitRight = limitRight; // 원반이 사라지고 나타날 곳 지정
		diskList.add(disk1);diskList.add(disk2);diskList.add(disk3);
	}
	
	public Image getDisk() {
		return diskList.get(this.choseDisk);
	}
	// 원반 움직이기------------------------------------------------------------------------------------------
	public void run() {
		this.choseDisk =(int)(Math.random()*3);//0,1,2를 뽑도록
		diskY = (int)(Math.random()*170+90);//나타날때 랜덤 y 값
		
		if(0 == (int)(Math.random()*2)) {// 왼쪽이냐 오른쪽이냐
			diskX = this.limitLeft;
			
			while(diskX < this.limitRight) {// 왼쪽에서 출발할때
				if(diskX-10 <= clickPointX && clickPointX <= diskX+80 // 원반의 크기 안에 클릭하면
						&& diskY-5 <= clickPointY && clickPointY <= diskY+35) {
					setClickPoint(-100,-100); // 클릭했던 에임을 리셋해줌
					this.score += 1;
					return;
				}
				//원반 움직임 제어------------------------------------------------------------------------------------------
				if(diskX <400) {
					try {
						Thread.sleep(30);
					}catch(Exception e) {}
					diskX += 10;
					diskY -= 1;
				}else {
					try {
						
						Thread.sleep(30);
					}catch(Exception e) {}
					diskX += 10;
					diskY += 1;
				}
				
			}
			diskX =-1;
			/////////////////////////////////////////
		}else {
			diskX = this.limitRight;
			
			while(diskX > this.limitLeft) { // 오른쪽에서 출발할때
				//원반 크기를 이미지 크기로 바꾸자
				if(diskX-10 <= clickPointX && clickPointX <= diskX+80 // 원반의 크기 안에 클릭하면
						&& diskY-5 <= clickPointY && clickPointY <= diskY+35) {
					setClickPoint(-100,-100); // 클릭했던 에임을 리셋해줌
					this.score +=1;
					return;
				}
				// 원반 움직임 제어------------------------------------------------------------------------------------------
				if(diskX >400) {
					try {
						
						Thread.sleep(30);
					}catch(Exception e) {}
					diskX -= 10;
					diskY -= 1;
					
				}else {
					try {
						Thread.sleep(30);
					}catch(Exception e) {}
					diskX -= 10;
					diskY += 1;
				}
			}
			diskX =-1;
		}
		
	}
	//shotshot으로 넘거주는 부분------------------------------------------------------------------------------------------
	public void drawDisk(Graphics g) {
		if(diskX != -1) {
		g.drawImage(getDisk(),diskX,diskY,70,30,null);
		}
	}
	//마우스 클릭 위치 받아서 원반 이미지와 맞으면 없어지게!
	public void setClickPoint(int x, int y ) {
		this.clickPointX = x; this.clickPointY = y;
	}
	public int getScore() {
		return this.score;
	}

}
