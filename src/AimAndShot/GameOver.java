package AimAndShot;


import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
// 게임 종료시 뜰 화면========================================================================================
public class GameOver extends JFrame{
	static Toolkit tk = Toolkit.getDefaultToolkit();
	private Image gameover = new ImageIcon(Main.class.getResource("../images/gameover.png")).getImage();
	private Label scoreLabel = new Label();
	GameOver(){
		super("Aim_On_Shot!");
		//윈도우 창의 가운데에 프레임 띄우기
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-(400/2), screenSize.height/2-(400/2),400,400);
		//프레임 크기조절 불가
		this.setResizable(false);
		//안전한 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		//귀여운 아이콘 설정
		this.setIconImage(new ImageIcon(Main.class.getResource("../images/icon.png")).getImage());
		
		//라벨 구현------------------------------------------------------------------------------------------
		scoreLabel.setFont(new Font("Serif",Font.BOLD,40));
		scoreLabel.setForeground(new Color(243,203,173));
		scoreLabel.setBackground(new Color(89,89,89));
		scoreLabel.setText("Your Score is "+"< "+GameMain.FD.getScore()+" >");
		
		scoreLabel.setBounds(25,200,340,100);
		this.getContentPane().add(scoreLabel);
		this.setVisible(true);
	}
	public void paint(Graphics g) {
		g.drawImage(gameover,6,28,388,367,null);
	}
}
