
package masinas;

import javax.swing.JOptionPane;

public class Masina {

    String marka;
    String modelis;
    String krasa;
    int pasreizejaisAtrums;

    public Masina(String marka, String modelis,
                  String krasa, int pasreizejaisAtrums) {

        this.marka = marka;
        this.modelis = modelis;
        this.krasa = krasa;
        this.pasreizejaisAtrums = pasreizejaisAtrums;
    }

    void paatrinat() {
        pasreizejaisAtrums += 10;

        JOptionPane.showMessageDialog(null,
                "Mašīna paātrinājās!\nĀtrums: "
                + pasreizejaisAtrums + " km/h");
    }

    void bremzet() {
        pasreizejaisAtrums -= 10;

        if (pasreizejaisAtrums < 0) {
            pasreizejaisAtrums = 0;
        }

        JOptionPane.showMessageDialog(null,
                "Mašīna bremzē!\nĀtrums: "
                + pasreizejaisAtrums + " km/h");
    }

    void noparkoties() {
        pasreizejaisAtrums = 0;

        JOptionPane.showMessageDialog(null,
                "Mašīna ir noparkota!");
    }

    void noteiktAtrumu() {
        JOptionPane.showMessageDialog(null,
                "Marka: " + marka
                + "\nModelis: " + modelis
                + "\nKrāsa: " + krasa
                + "\nĀtrums: " + pasreizejaisAtrums + " km/h");
    }

    void parkrasot() {
        String jaunaKrasa = JOptionPane.showInputDialog(
                "Ievadi jauno krāsu:", krasa);

        if (jaunaKrasa != null && !jaunaKrasa.trim().isEmpty()) {
            krasa = jaunaKrasa.trim();

            JOptionPane.showMessageDialog(null,
                    "Jaunā mašīnas krāsa: " + krasa);
        }
    }
}
