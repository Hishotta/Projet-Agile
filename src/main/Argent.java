package main;

public class Argent {

    private double montant;

    public Argent(double montant) {
        this.montant = montant;
    }

    public Argent() {
        this.montant = 100;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void AppliquerBonus(double bonus) {
        this.setMontant(this.getMontant() + bonus);
    }

    public void AppliquerMalus(double malus) {
        this.setMontant(this.getMontant() - malus);
    }

    @Override
    public String toString() {
        return "Argent{" +
                "montant=" + montant +
                '}';
    }
}