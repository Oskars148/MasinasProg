package masinas;

import java.io.File;
import java.time.Year;

import javax.swing.JOptionPane;


public class Garaza {

	public static void main(String[] args) {
		String izvelne, failaNosaukums = 
				System.getProperty("user.home") + File.separator + 
				"Desktop" + File.separator + "minkas.txt";
				String[] darbibuSaraksts = {"Izveidot kaķi", "Izsaukt metodi", 
						"Saglabāt failā", "Apskatīt failā saglabātos kaķus", 
						"Aizvērt"};
				
				do {
					izvelne = (String) JOptionPane.showInputDialog(null, 
							"Izvēlies darbību", "Darbību izvēle", 
							JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, 
							darbibuSaraksts[0]);
					
					if(izvelne == null)
						izvelne = "Aizvērt";
					
					switch(izvelne) {
					case "Izveidot kaķi":
						String minkasVards, skirne, spalvasKrasa, saimnieks,
						cels;
						int dzGads = 0;
						boolean siksnina;
						
						minkasVards = 
								virknesParbaude("Ievadi kaķa vārdu", "Rudis");
						skirne = 
								virknesParbaude("Norādi kaķa šķirni", "Meinkūns");
						spalvasKrasa =
								virknesParbaude("Kāda ir kaķa kažoka krāsa?", "Pelēka");
						saimnieks =
								virknesParbaude("Kā sauc "+ minkasVards + " saimnieku?", 
										"Mirdza");
						cels = 
								virknesParbaude("Ievadi bildes nosaukumu", "rudis");
						
						dzGads = 
								skaitlaParbaude("Norādi kaķa dzimšanas gadu", 
								(Year.now().getValue())- 19, (Year.now().getValue()));
						
						int poga = JOptionPane.showConfirmDialog(null,
								"Vai kaķim ir siksniņa?", "Siksniņa", 
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(poga == -1)
							break;
						
						siksnina = (poga == 0) ? true : false;
						runcis = new Minka(minkasVards, skirne, 
								spalvasKrasa, saimnieks, dzGads, siksnina, cels);
						break;
						
					case "Izsaukt metodi":
						if(runcis != null) {
							String[] metozuSaraksts = {"Paglaudīt", 
							"Nolasīt atribūtus", "Pabarot", "Nolikt gulēt",
							"Palielināt vecumu", "Apskatīt vecumu", "Medīt"};
							
							String metode = (String) JOptionPane.showInputDialog(null, 
									"Izvēlies metodi", "Metodes izvēle",
									JOptionPane.QUESTION_MESSAGE, null, 
									metozuSaraksts, metozuSaraksts[0]);
							
							if(metode == null)
								break;
							
							switch(metode) {
							case "Paglaudīt":
								runcis.murrat();
								break;
								
							case "Nolasīt atribūtus":
								JOptionPane.showMessageDialog(null,
										runcis.nolasitAtributus(), "Informācija", 
										JOptionPane.INFORMATION_MESSAGE);
								break;
								
							case "Pabarot":
								String atbilde = runcis.pabarot(virknesParbaude(
										"Ar ko pabarosi kaķi?", "Desu"));
								JOptionPane.showMessageDialog(null, "Kaķis atgriež "
								+ atbilde, "Informācija",
								JOptionPane.INFORMATION_MESSAGE);
								break;
								
							case "Nolikt gulēt":
								String prieksmets = virknesParbaude(
										"Ko dosi kaķim līdzi uz gultiņu?", "Spilvens");
								if(prieksmets == null || prieksmets.isEmpty())
									runcis.gulet();
								
								else
									runcis.gulet(prieksmets);
								break;
								
							case "Palielināt vecumu":
								runcis.palielinatVecumu();
								break;
								
							case "Apskatīt vecumu":
								runcis.nolasitVecumu();
								break;
								
							case "Medīt":
								runcis.medit();
								break;
							}
							
						} else 
							JOptionPane.showMessageDialog(null,
									"Vispirms izveido kaķi!", "Brīdinājums", 
									JOptionPane.WARNING_MESSAGE);
						break;
						
					case "Saglabāt failā":
						if(runcis != null)
							DarbsArFailu.saglabat(runcis, failaNosaukums);
						
						else
							JOptionPane.showMessageDialog(null,
							"Vispirms izveido kaķi!", "Brīdinājums", 
							JOptionPane.WARNING_MESSAGE);
						break;
						
					case "Apskatīt failā saglabātos kaķus":
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