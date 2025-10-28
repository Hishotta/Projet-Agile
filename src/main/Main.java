package main;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listChoix = new ArrayList<String>();

        listChoix.add("Roulette");
        // autres jeux a rajouter

        String choix = listChoix.get(0); // choix par defaut
        boolean choixValide = false;
        
        char inputCase;

        while (!choixValide) {
            // avoir le choix
            inputCase = getinputCase(); // input pour changer de case (donc de choix de jeu)

            // monter dans la liste
            if (inputCase == 'z' && listChoix.indexOf(choix) > 0) {
                choix = listChoix.get(listChoix.indexOf(choix) - 1);
            }
            // descendre dans la liste
            else if (inputCase == 's' && listChoix.indexOf(choix) < listChoix.size() - 1) {
                choix = listChoix.get(listChoix.indexOf(choix) + 1);
            }
            // valider le choix
            else if (inputCase == 'x') {
                choixValide = true;
            }
        }

        // TODO: lancer le jeu choisi
        System.out.println("Vous avez choisi : " + choix);

    }

    public static char getinputCase() {

        char choix = ' '; // choix par defaut (qui force la boucle)
        System.out.println("Appuyez sur 'z' pour monter, 's' pour descendre, 'x' pour valider.");
        System.out.println("Votre choix : ");

        while (choix != 'z' &&
                choix != 's' &&
                choix != 'x') {

            try {
                choix = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return choix;
    }

}
