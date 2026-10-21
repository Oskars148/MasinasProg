package masinas;

import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class Garaza {
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim();			
		} while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}

	public static void main(String[] args) {
		String izvelne, failaNosaukums = 
				System.getProperty("user.home") + File.separator + 
				"Desktop" + File.separator + "minkas.txt";
				String[] darbibuSaraksts = {"Izveidot mašīnu", "Izsaukt metodi", 
						"Saglabāt failā", "Apskatīt failā saglabātās mašīnas", 
						"Aizvērt"};
				
				do {
					izvelne = (String) JOptionPane.showInputDialog(null, 
							"Izvēlies darbību", "Darbību izvēle", 
							JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, 
							darbibuSaraksts[0]);
					
					if(izvelne == null)
						izvelne = "Aizvērt";
					
					switch(izvelne) {
					case "Izveidot mašinu":
						String marka, modelis, krasa, pasreizejiasAtrumus,
						cels;
						
						marka = 
								virknesParbaude("Ievadi mašīnas  marku", "BMW");
						modelis = 
								virknesParbaude("Norādi mašīnas modeli", "f90");
						krasa =
								virknesParbaude("Kāda ir mašīnas krāsa krāsa?", "Melna");
						pasreizejiasAtrumus =
								virknesParbaude("Kāds ir mašinas pašreizējais ātrums?", 
										"170 km/h");
						cels = 
								virknesParbaude("Ievadi bildes nosaukumu", "");
						
						Masina = new Masina(marka, modelis, 
								krasa, pasreizejiasAtrumus, cels);
						break;
						
					case "Izsaukt metodi":
						if(Masina != null) {
							String[] metozuSaraksts = {"paātrināt", 
							"bremzēt", "noparkoties", "noteikt ātrumu",
							"pārkrāsot"};
							
							String metode = (String) JOptionPane.showInputDialog(null, 
									"Izvēlies metodi", "Metodes izvēle",
									JOptionPane.QUESTION_MESSAGE, null, 
									metozuSaraksts, metozuSaraksts[0]);
							
							if(metode == null)
								break;
							
							switch(metode) {
							case "paātrināt":
								Masina.paatrinat();
								break;
								
							case "bremzēt":
								Masina.bremzet();
								break;
								
							case "noparkoties":
								Masina.noparkoties();
								break;
								
							case "noteikt ātrumu":
								Masina.noteiktAtrumu();
								break;
								
							case "pārkrāsot":
								Masina.parkrasot();
								break;
							}
							
						} else 
							JOptionPane.showMessageDialog(null,
									"Vispirms izveido mašīnu!", "Brīdinājums", 
									JOptionPane.WARNING_MESSAGE);
						break;
						
					case "Saglabāt failā":
						if(Masina != null)
							DarbsArFailu.saglabat(Masina, failaNosaukums);
						
						else
							JOptionPane.showMessageDialog(null,
							"Vispirms izveido Mašīnu!", "Brīdinājums", 
							JOptionPane.WARNING_MESSAGE);
						break;
						
					case "Apskatīt failā saglabātās mašīnas":
						DarbsArFailu.nolasit(failaNosaukums);
						break;
						
					case "Aizvērt":
						JOptionPane.showMessageDialog(null,
						"Programma apturēta!", "Paziņojums", 
						JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					
				} while(!izvelne.equals("Aizvērt"));
	}
}