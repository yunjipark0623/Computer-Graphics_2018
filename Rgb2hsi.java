import javax.swing.JOptionPane; 

public class Rgb2hsi {
	double r, g, b;
	double[] hsi = new double[3];
	String rString, gString, bString;
	
	public static void main(String[] args) {
		Rgb2hsi app = new Rgb2hsi();
		app.inputRGB();
		app.displayHSI();
	}
	
	public void inputRGB() {
		rString = JOptionPane.showInputDialog("Enter the normalized R(ed) value: ");
		gString = JOptionPane.showInputDialog("Enter the normalized G(reed) value: ");
		bString = JOptionPane.showInputDialog("Enter the normalized B(lue) value: ");
		
		r = Double.parseDouble(rString);
		g = Double.parseDouble(gString);
		b = Double.parseDouble(bString);
		
		hsi = rgb2hsi(r, g, b);
	}
	public void displayHSI() {
		String result = "";
		
		result += "Hue in degrees : " + hsi[0] + "\n";
		result += "nomalized Saturation : " + hsi[1] + "\n";
		result += "nomalized Intensity : " + hsi[2] + "\n";
		JOptionPane.showMessageDialog(null, result, "RGB2HSI 결과", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public double[] rgb2hsi(double r, double g, double b) {
		double min;
		double angle;
		double[] hsi = new double[3];
		double h, i, s;
		
		for (int x = 0; x < 3; x++) {
			hsi[x] = 0.0;
		}
		
		min = Math.min(r, Math.min(g, b));
		
		i = (r + g + b)/3.0;
		
		if ((r == g) && (g == b)) {
			s = 0.0;
			h = 0.0;
			
			hsi[0] = h;
			hsi[1] = s;
			return hsi;
		} else {
			s = 1.0 - (3.0/(r + g + b)) * min;
			angle = (r - 0.5 * g - 0.5 * b)/Math.sqrt((r - g) * (r - g) + (r - b) * (g - b));
			h = Math.acos(angle);
			
			h *= 57.29577951;
		}
		
		if (b > g) {
			h = 360.0 - h;
		}
		
		hsi[0] = h;
		hsi[1] = s;
		hsi[2] = i;
		return hsi;
	}
}

/*채도는 0에서 1까지의 값으로 표현한다.
 */

