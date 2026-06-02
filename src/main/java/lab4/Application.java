package lab4;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {


        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = new HashMap<>();

        adrese.put("Ioan", "Sibiu");
        adrese.put("Maria", "Bucuresti");
        adrese.put("Victor", "Cluj");
        adrese.put("Simina", "Alba-Iulia");
        adrese.put("Marius", "Medias");
        adrese.put("Mihai", "Cisnadie");
        adrese.put("Daniela", "Sibiu");


        System.out.println("--- Varste initiale ---");
        System.out.println(varste);

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("\n--- Varste dupa adaugare (Vlad si Iulia) ---");
        System.out.println(varste);
        System.out.println("--------------------------------------------------");


        HashMap<String, Tanar> tineri = new HashMap<>();


        for (String prenume : varste.keySet()) {
            int varsta = varste.get(prenume);


            String adresa = adrese.getOrDefault(prenume, "Necunoscuta");


            Tanar tanarNou = new Tanar(prenume, varsta, adresa);


            tineri.put(prenume, tanarNou);
        }


        System.out.println("\n--- Continutul mapei 'tineri' (O(1) lookups combinat) ---");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println("Cheie: " + entry.getKey() + " -> Valoare: " + entry.getValue());
        }
    }
}