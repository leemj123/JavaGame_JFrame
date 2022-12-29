package AimAndShot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameMain extends JFrame implements MouseMotionListener, MouseListener{
	//이중 버퍼링 시도4
	private Image screenImg;
	private Graphics screenG;
	private Image backGround = new ImageIcon(Main.class.getResource("../images/background.jpeg")).getImage();
	private int pressX,pressY;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	//클래스 가져오기
	public static Gun gun = new Gun();
	public static GunEffect GE = new GunEffect();
	public static FlyDisk FD = new FlyDisk(0,Main.FrameW);
	public static Bullet bullet = new Bullet();
	public GameMain() {
		super("Aim_On_Shot!");
		//윈도우 창의 가운데에 프레임 띄우기
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-(Main.FrameW/2), screenSize.height/2-(Main.FrameY/2),Main.FrameW,Main.FrameY);
		//프레임 크기조절 불가
		this.setResizable(false);
		//안전한 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//귀여운 아이콘 설정
		this.setIconImage(new ImageIcon(Main.class.getResource("../images/icon.png")).getImage());
		//메뉴바 넣기
		this.setMenuBar(Menu());
		
		gun.SetPoint(500);//초기의 총이 바라볼 방향
		customcursor();//커서 추가
		this.addMouseMotionListener(this);//마우스 움직임 감지
		this.addMouseListener(this);//마우스 눌림 감지
		
		this.setVisible(true);
		start();
		
	}
	// 게임 동작==============================================================================================
	public void start() {
		try {
			for(int i =0; i< 8; i++) {
				FD.run();
			}
		}catch(Exception e) {
			
		}finally {
			new GameOver();
		}
	}
	//이미지 구현==============================================================================================
	public void paint(Graphics g) {
		//오픈 스크린 생성 => repaint 때 마다 깜빡임을 잡아주는 부분
		screenImg = createImage(Main.FrameW,Main.FrameY);
		screenG = screenImg.getGraphics();
		screenDraw(screenG);
		g.drawImage(screenImg,0,0,null);
	}
	public void screenDraw(Graphics g) {
		//밑의 이미지는 메모리에 그려지고 위의 페인트 함수에서 한꺼번에 그려진다..!
		g.drawImage(backGround,0,0,null);
		g.drawImage(gun.getGun(),260,500,300,400,null);
		bullet.drawBullet(g);
		GE.drawEffect(g);
		FD.drawDisk(g);
		this.repaint();
	}
	// 커스텀 커서 만들기------------------------------------------------------------------------------------------
	public void customcursor(){
		/*커서만드는중*/
		Image cursorimage= new ImageIcon(Main.class.getResource("../images/aim.png")).getImage();
		Point point=new Point(50,50);//커서 크기 지정
		Cursor cursor=tk.createCustomCursor(cursorimage, point, "hi");
		setCursor(cursor); 
	}

	// 마우스 움직임 감지------------------------------------------------------------------------------------------
		@Override
	public void mouseMoved(MouseEvent e) {
		gun.SetPoint(e.getX());
	}
		
	//마우스 클릭 감지--------------------------------------------------------------------------------------------
	@Override
	public void mousePressed(MouseEvent e1) {
		// 남은 탄환이 있을때 작동
		if(bullet.getLeftBullet() != 0) { 
			GE.setShotXY(e1.getX()-20, e1.getY()-20); // 에임 이미지 맞추기 위해서 -20
			FD.setClickPoint(e1.getX(), e1.getY()); // 플라잉 디스크에 넘겨주기
			bullet.decreaseBullet();
		}
	}
	
	//메뉴바 설정-----------------------------------------------------------------------------------------------
	public MenuBar Menu() {
		MenuBar mainBar = new MenuBar();
		mainBar.setFont(new Font("monospaced",Font.BOLD,20));
		Menu File = new Menu("File");
		Menu Help = new Menu("Help");
		
		MenuItem Save = new MenuItem("Save");
		MenuItem Exit = new MenuItem("Exit"); // 종료버튼
		
		
		File.addSeparator();//메뉴에 선긋기
		File.add(Save);
		File.addSeparator();
		File.add(Exit);
		File.addSeparator();
		
		MenuItem GameInfo = new MenuItem("Game Info");
		Help.addSeparator();Help.add(GameInfo);Help.addSeparator();
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GameInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Info("Game Info");
			}});
		
		
		mainBar.add(File);mainBar.add(Help);
		return mainBar;
	}
		
		
		
		
		
		
		
	public void mouseClicked(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	
}
