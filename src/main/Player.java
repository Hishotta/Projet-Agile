package main;

public class Player {

    private String name;
    private Argent argent;

    public Player(String name) {
        this.name = name;
        this.argent = new Argent();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Argent getMonaie() {
        return argent;
    }

    public void setMonaie(Argent argent) {
        this.argent = argent;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", argent=" + argent +
                '}';
    }

}
