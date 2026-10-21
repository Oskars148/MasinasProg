package masinas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class DarbsArFailu {
	static void saglabat(Masina runcis, String failaNosaukums) {
		try {
			FileWriter fw = new FileWriter(failaNosaukums, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(runcis.nolasitAtributus());
			pw.println("+".repeat(100));
			pw.close();
			JOptionPane.showMessageDialog(null,
					"Ieraksts saglabāts "+failaNosaukums);
			
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null,
			"Radās kļūda ierakstot failā!", "Kļūda", 
			JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void nolasit(String failaNosaukums) {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(failaNosaukums);
			BufferedReader br = new BufferedReader(fr);
			while((teksts = br.readLine()) != null) {
				str += teksts + "\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null, str, 
					"Faila saturs", JOptionPane.INFORMATION_MESSAGE);
			
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu!", 
					"Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
}