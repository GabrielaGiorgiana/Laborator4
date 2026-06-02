package lab4;

import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        String fisierStudenti = "studenti_in.txt";
        String fisierNote = "note_anon.txt";


        Map<Integer, Student> mapaStudenti = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(fisierStudenti))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                if (linie.trim().isEmpty()) continue;
                String[] date = linie.split(",");
                int matricol = Integer.parseInt(date[0].trim());
                String prenume = date[1].trim();
                String nume = date[2].trim();
                String grupa = date[3].trim();

                Student s = new Student(matricol, prenume, nume, grupa);
                mapaStudenti.put(matricol, s);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea studenților: " + e.getMessage());
            return;
        }


        try (BufferedReader br = new BufferedReader(new FileReader(fisierNote))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                if (linie.trim().isEmpty()) continue;
                String[] date = linie.split(",");
                int matricol = Integer.parseInt(date[0].trim());
                double notaObtinuta = Double.parseDouble(date[1].trim());

                Student studentGasit = mapaStudenti.get(matricol);
                if (studentGasit != null) {
                    studentGasit.setNota(notaObtinuta);
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea notelor: " + e.getMessage());
            return;
        }


        System.out.println("--- Testare cautare nota in O(1) ---");

        float notaM = gasesteNota("Bianca", "Popescu", mapaStudenti);
        System.out.println("notaM pentru Bianca Popescu = " + notaM);


        float notaN = gasesteNota("Ioan", "Popa", mapaStudenti);
        System.out.println("notaN pentru Ioan Popa = " + notaN);
    }



    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> tineri) {

        Map<String, Student> mapaNume = new HashMap<>();


        for (Student s : tineri.values()) {

            String cheieUnica = (s.getPrenume() + "-" + s.getNume()).toLowerCase();
            mapaNume.put(cheieUnica, s);
        }


        String cheieCautata = (prenume + "-" + nume).toLowerCase();


        Student studentGasit = mapaNume.get(cheieCautata);


        if (studentGasit != null) {
            return (float) studentGasit.getNota();
        }

        return 0.0f;
    }
}