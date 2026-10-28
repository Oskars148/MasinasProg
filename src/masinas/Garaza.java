
package masinas;

import javax.swing.JOptionPane;

public class Garaza {

    public static void main(String[] args) {

        Masina masina = null;
        String izvelne;

        String[] darbibas = {
            "Izveidot mašīnu",
            "Izsaukt metodi",
            "Aizvērt"
        };

        do {
            izvelne = (String) JOptionPane.showInputDialog(
                    null,
                    "Izvēlies darbību:",
                    "Garāža",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    darbibas,
                    darbibas[0]);

            if (izvelne == null) {
                izvelne = "Aizvērt";
            }

            switch (izvelne) {

                case "Izveidot mašīnu":
                    String marka = JOptionPane.showInputDialog(
                            "Ievadi mašīnas marku:", "BMW");

                    if (marka == null || marka.trim().isEmpty()) {
                        break;
                    }

                    String modelis = JOptionPane.showInputDialog(
                            "Ievadi mašīnas modeli:", "F90");

                    if (modelis == null || modelis.trim().isEmpty()) {
                        break;
                    }

                    String krasa = JOptionPane.showInputDialog(
                            "Ievadi mašīnas krāsu:", "Melna");

                    if (krasa == null || krasa.trim().isEmpty()) {
                        break;
                    }

                    String atrums = JOptionPane.showInputDialog(
                            "Ievadi pašreizējo ātrumu (km/h):", "170");

                    if (atrums == null) {
                        break;
                    }

                    int atrumsSkaitlis = Integer.parseInt(atrums);

                    if (atrumsSkaitlis < 0) {
                        JOptionPane.showMessageDialog(null,
                                "Ātrums nevar būt negatīvs!");
                        break;
                    }

                    masina = new Masina(marka, modelis, krasa, atrumsSkaitlis);

                    JOptionPane.showMessageDialog(null, "Mašīna izveidota!");
                    
                    break;

                case "Izsaukt metodi":
                    if (masina == null) {
                        JOptionPane.showMessageDialog(null,
                                "Vispirms izveido mašīnu!");
                        break;
                    }

                    String[] metodes = {
                        "Paātrināt",
                        "Bremzēt",
                        "Noparkoties",
                        "Noteikt ātrumu",
                        "Pārkrāsot"
                    };

                    String metode = (String) JOptionPane.showInputDialog(
                            null,
                            "Izvēlies metodi:",
                            "Metodes",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            metodes,
                            metodes[0]);

                    if (metode == null) {
                        break;
                    }

                    switch (metode) {
                        case "Paātrināt":
                            masina.paatrinat();
                            break;

                        case "Bremzēt":
                            masina.bremzet();
                            break;

                        case "Noparkoties":
                            masina.noparkoties();
                            break;

                        case "Noteikt ātrumu":
                            masina.noteiktAtrumu();
                            break;

                        case "Pārkrāsot":
                            masina.parkrasot();
                            break;
                    }

                    break;

                case "Aizvērt":
                    JOptionPane.showMessageDialog(null,
                            "Programma apturēta!");
                    break;
            }

        } while (!izvelne.equals("Aizvērt"));
    }
}
