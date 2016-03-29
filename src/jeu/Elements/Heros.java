/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.Elements;

import jeu.exception.moralInfZero;
import jeu.exception.vieInfZero;

/**
 *
 * @author Baptiste
 */
public class Heros {

    /**
     * Le nom du héros
     */
    private String nom;
    /**
     * Les points de vie du héros, de 0 à 100
     */
    private int vie;
    /**
     * les points de moral du héros, de 0 à 100
     */
    private int moral;
    /**
     * La description du héros
     */
    private String description;

    /**
     * Constructeur de la classe heros
     *
     * @param nom contient le nom du héros
     * @param description contient la description du héros
     */
    public Heros(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    /**
     * Permet d'afficher le héros
     *
     * @return Retourne une chaine de caractère correspondant au héros
     */
    public String toString() {
        String str;
        str = "Nom : ";
        str += this.nom;
        str += "\n";
        str += "Description : ";
        str += this.description;
        return str;

    }

    /**
     * Permet d'enlever de la vie au héros. si ses pv sont à 0 ou moins, il
     * meurt.
     *
     * @param quantité la quantité de vie à enlever
     */
    public void enleverPv(int quantité) {
        try {
            this.setVie(quantité);
        } catch (vieInfZero e) {
            this.mourir();
        }
    }

    /**
     * Permet au héros de reposer en paix...
     */
    public void mourir() {
        this.vie = 0;
        this.description = this.nom;
        this.description += " Ce héros est mort.";
    }

    /**
     * Permet de modifier la vie du héros.
     *
     * @param vie La nouvelle quantité de vie.
     * @throws vieInfZero jette une exception si la vie descend à 0 ou moins.
     */
    public void setVie(int vie) throws vieInfZero {
        if (this.getVie() - vie <= 0) {
            throw new vieInfZero();
        } else {
            this.vie = vie;
        }
    }

    /**
     * permet de modifier le moral du héros
     *
     * @param moral la nouvelle valeur du moral
     */
    public void setMoral(int moral) throws moralInfZero {
        if (this.moral - moral <= 0) {
            throw new moralInfZero();
        }
        this.moral = moral;
    }

    /**
     * Permet d'obtenir la quantité de vie du héros
     *
     * @return Retourne la quantité de vie
     */
    public int getVie() {
        return vie;
    }

    /**
     * Permet d'obtenir le moral du héros
     *
     * @return Retourne la quantité de moral.
     */
    public int getMoral() {
        return moral;
    }
}
