package masinas;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Masina {
	String marka, modelis, krasa;
	int pasreizejaisAtrums;
	ImageIcon bilde;
	
	public ImageIcon iestatitBildi(String cels) {
		if(!cels.endsWith(".png"))
			cels += ".png";
		
		URL resurss = getClass().getResource("/atteli/"+cels);
		if(resurss != null)
			return new ImageIcon(new ImageIcon(resurss).getImage().
					getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		
		else {
			JOptionPane.showMessageDialog(null, 
					"Nevar atrast bildi: "+cels, "Brīdinājums", 
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	void paatrinat() {
		
	}
	
	void bremzet() {
		
	}
	
	void noparkoties() {
		
	}
	
	void noteiktAtrumu() {
		
	}
	
	void parkrasot() {
		
	}
}