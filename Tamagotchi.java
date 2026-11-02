import java.util.Random;

public class Tamagotchi {
    // Attributs privés
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    // 1. Constructeur
    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        
        Random rand = new Random();
        // dureeDeVie entre 9 et 14 (inclus) -> rand.nextInt(6) donne 0 à 5, + 9 donne 9 à 14
        this.dureeDeVie = rand.nextInt(6) + 9;
        
        // maxEnergie entre 5 et 9 (inclus) -> rand.nextInt(5) donne 0 à 4, + 5 donne 5 à 9
        this.maxEnergie = rand.nextInt(5) + 5;
        
        // energie entre 3 et maxEnergie (inclus)
        this.energie = rand.nextInt(this.maxEnergie - 3 + 1) + 3;
    }

    // Getter pour le nom (utile pour l'affichage)
    public String getNom() {
        return nom;
    }

    // 2. Méthode parler()
    public void parler() {
        if (energie > 5) {
            System.out.println(nom + " tout va bien !"); // ou "heureux" selon la logique de l'exemple d'exécution
        } else {
            System.out.println(nom + " je suis affamé !");
        }
    }

    // 3. Méthode manger()
    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " je n'ai pas faim !!");
        } else {
            Random rand = new Random();
            int gain = rand.nextInt(3) + 1; // entre 1 et 3
            energie += gain;
            if (energie > maxEnergie) {
                energie = maxEnergie; // Ne pas dépasser maxEnergie
            }
            System.out.println(nom + " Merci !");
        }
    }

    // 4. Méthode ageLimite()
    public boolean ageLimite() {
        return age >= dureeDeVie;
    }

    // 5. Méthode vivre()
    public boolean vivre() {
        // (a) Si l'âge a déjà atteint ou dépassé la durée de vie, ne fait rien et retourne true
        if (age >= dureeDeVie) {
            return true;
        }

        // (b) Si l'énergie est épuisée
        if (energie <= 0) {
            System.out.println(nom + " je meurs... Arrrggh !");
            return false;
        }

        // (c) Si l'énergie est > 0
        age++;
        energie--;

        if (age >= dureeDeVie) {
            System.out.println(nom + " c'est gagné pour moi !");
        } else {
            parler();
        }
        return true;
    }
}