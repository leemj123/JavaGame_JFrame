package AimAndShot;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//게임 설명 띄우는 곳------------------------------------------------------------------------------------------
@SuppressWarnings("serial")
public class Info extends JFrame{
	private Image infoBackImg = new ImageIcon(Main.class.getResource("../images/infoBack.png")).getImage();
	private Toolkit tk = Toolkit.getDefaultToolkit();
	Info(String title){
		super(title);
		
		Dimension screenSize = tk.getScreenSize();//화면의 너비와 높이 정보를 screenSize에 대입
		this.setBounds(screenSize.width/2-150, screenSize.height/2-200, 300, 400);//프레임을 this로 호출
		this.setIconImage(new ImageIcon(Main.class.getResource("../images/icon.png")).getImage());
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.setVisible(true);
	}
	public void paint(Graphics a) {
		if(infoBackImg == null) {return;}
		a.drawImage(infoBackImg, 0, 20,300,400,this);
	}
}
