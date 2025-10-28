package main;

public abstract class Jeu {
    Player player;


    void retirer_argent(double mise){
        player.setMonaie(player.getMonaie()-mise);
    }

    void ajout_argent(double mise){
        player.setMonaie(player.getMonaie()+mise);
    }

    abstract void ajout_xp();

    
}
