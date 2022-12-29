package AimAndShot;

import java.awt.Image;

import javax.swing.ImageIcon;
//총 움직임 구현===============================================================================
public class Gun {
	private Image gunRight = new ImageIcon(Main.class.getResource("../images/gunRight.png")).getImage();
	private Image gunLeft = new ImageIcon(Main.class.getResource("../images/gunLeft.png")).getImage();
	private int pointX;

	public Image getGun() {
		//x좌표 400을 기준으로 좌,우 설정------------------------------------------------------------------------------------------
		if (pointX >=400) {
			return gunRight;
		} else if(pointX <400) {
			return gunLeft;
		}
		return null;
	}
	public void SetPoint(int x) {
		this.pointX = x;
	}
	public int getPoint() {
		return this.pointX;
	}
}
