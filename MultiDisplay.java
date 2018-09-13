import java.awt.*;
import java.applet.Applet;

public class MultiDisplay extends Applet{
	
	Image duke;//자료형 Image인 변수 정의 해주기 
	int width;
	int height;
	
	public void init() {
		setSize(400, 213);
		duke = getImage(getCodeBase(), "duke.jpg");//getImage메소드는 Image객체 얻어주는 메소드, 파일 확장자 적어주기 
		width = getSize().width;//duke이미지의 가로사이즈를 얻는다 
		height = getSize().height;//duke이미지의 세로사이즈를 얻는다 
		
	}
	
	public void paint(Graphics g) {
		
		for(int row = 0; row < 3; row++) {//듀크 3마리 세로로 
			for(int col = 0; col < 4; col++) {//듀크 4마리 가로로 
				g.drawImage(duke, col * 100, row * 71, this);//이미지 크기 지정해주는 메소드 
			}
		}
	}
}

//img는 bin폴더에 저장하기 
/*
<APPLET code = "MultiDisplay.class" width = "400" height = "213">
</APPLET>
*/