import java.awt.*;//FontMetrics클래스 포함(글꼴에 대한 정보를 얻어주는 클래스) - 문자열의 머리선, 기준선, 꼬리선, 다음줄의 머리선 표시함 
import javax.swing.*;

public class DrawString2 extends JApplet {
	Font font1;
	Font font2;
	FontMetrics fontinfo;
	
	int baseLine = 90;
	int ascent;//머리선 
	int descent;//꼬리선 
	int leading;//그 다음 줄 폰트와의 간격 
	int height;//ascent + descent + leading 
	
	public void init() {
		setSize(400, 400);
		font1 = new Font("Serif", Font.PLAIN, 60);
		font2 = new Font("Timesroman", Font.PLAIN, 60);
	}
	
	public void paint(Graphics g) {
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("Java Graphics!", 10, baseLine);//(10, baseLine = 90)위치에 문자열 출력 
		
		fontinfo = g.getFontMetrics(font1);
		ascent = fontinfo.getAscent();
		descent = fontinfo.getDescent();
		leading = fontinfo.getLeading();
		height = fontinfo.getHeight();
		
		g.setColor(Color.gray);
		g.drawLine(10, baseLine - ascent, 390, baseLine - ascent);//(10, baseLine - ascent)위치부터 (390, baseLine - ascent)까지 직선 그린다 
		g.drawLine(10, baseLine + ascent, 390, baseLine + ascent);//(10, baseLine + ascent)위치부터 (390, baseLine + ascent)까지 직선 그린다
		g.drawLine(10, baseLine + leading, 390, baseLine + leading);//(10, baseLine + leading)위치부터 (390, baseLine + leading)까지 직선 그린다
		
		g.setColor(Color.red);
		g.drawLine(10, baseLine, 390, baseLine);//(10, baseLine = 90)위치부터 (390, baseLine = 90)까지 직선 그린다
		g.drawLine(10, baseLine + height, 390, baseLine + height);//(10, baseLine + height)위치부터 (390, baseLine + height)까지 직선 그린다
		
		g.setFont(font2);
		g.setColor(Color.blue);
		g.drawString("Study!", 10, baseLine + height);//(10, baseLine + height)위치에 문자열 출력 
	}
}

/*
<APPLET code = "DrawString2.class" width = "400" height = "200">
</APPLET>
*/