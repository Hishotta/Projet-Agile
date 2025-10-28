import java.util.Scanner;

public class mastermind {

    private int[] code;
    private int attempts;
    private int max_attempts;
    private boolean isSolved;
    private int miseTotale=100;
    private int mise;
    private int gain;


    public int[] generateCode() {
        code = new int[4];
        for (int i = 0; i < 4; i++) {
            code[i] = (int)(Math.random() * 9) + 1;
        }
        return code;
    }
    
    public mastermind() {
        this.code=generateCode();
        attempts = 0;
        isSolved = false;
    }
    
    
    public String returnUserCode() {
        try {
            System.out.println("entrez un code à 4 chiffres");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            while(input.length() != 4 || !input.matches("[1-9]{4}")) {
                if(input.length() != 4) {
                    System.out.println("Merci d'entrez un code à 4 chiffres");
                    input = scanner.nextLine();
                }
                else if(!input.matches("[1-9]{4}")){
                    System.out.println("Merci d'entrez un code à 4 chiffres entre 1 et 9");
                    input = scanner.nextLine();
                }
            }
            attempts++;
            return input;
        } catch (Exception e){
            System.out.println("Veuillez entrer un code correct");
            return "";
        }
    }


    public String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num);
        }
        return sb.toString();
    }

    public int bienPlaces (String codeUser) {
        String[] arrayCodeUser = codeUser.split("");
        String[] arrayCodeBot = arrayToString(code).split("");
        int nbBienPlaces = 0;
        for (int i=0; i<code.length; i++) {
            if (arrayCodeBot[i].equals(arrayCodeUser[i])) {
                nbBienPlaces++;
            }
        }
        return nbBienPlaces;
    }

    /*public int pasBienPlace (String codeUser) {
        String[] arrayCodeUser = codeUser.split("");
        String[] arrayCodeBot = arrayToString(code).split("");
        int nbpasbienPlaces = 0;
        for (int i=0; i<code.length; i++) {
            if (!arrayCodeBot[i].equals(arrayCodeUser[i])) {
                nbpasbienPlaces++;
            }
        }
        return nbpasbienPlaces;
    }*/


    public void play() {
        try{
            System.out.println("Combien voulez-vous miser ?");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input <= miseTotale){
                mise = input;
            } else {
                throw new IllegalArgumentException("La mise jouée doit être inférieure ou égale à votre mise totale. Pour rappel, votre mise totale est de: "+ miseTotale+ " €");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
     
        try{
            System.out.println("Combien de tentatives voulez-vous faire ?(1/5/10)");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1 || input == 5 || input == 10){
                max_attempts = input;
            } else {
                max_attempts = 5; 
                throw new IllegalArgumentException("Le nombre de tentatives doit être 1, 5 ou 10.");

            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
        
        String codeUser = "";
        while (attempts < max_attempts && !isSolved) {
            codeUser = returnUserCode();
            System.out.println("Chiffres bien placés: " + bienPlaces(codeUser));
            System.out.println("Tentative " + attempts + ": " + codeUser);
            if (codeUser.equals(arrayToString(code))) {
                isSolved = true;
                System.out.println("Félicitations! Vous avez trouvé le code.");
                if(attempts == 1){
                    gain = mise * 10;
                } else if (attempts <= 5){
                    gain = mise * 5;
                } else {
                    gain = mise;
                }
                //Joueur.addArgent(gain);
            } else {
                System.out.println("Code incorrect. Essayez encore.");
            }
        }
        System.out.println("Le code était: " + arrayToString(code));
    }
    public static void main(String[] args) {
        mastermind game = new mastermind();
        game.play();
    }
}
