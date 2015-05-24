/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.patrick.lorin.katatennis;

/**
 *
 * @author Patrick
 */
public class TennisJeuEtatEgalite extends TennisJeuEtat
{

    public TennisJeuEtatEgalite(TennisJeu jeu)
    {
        super(jeu);
    }

    @Override
    public String getScore()
    {
        return "Egalité";
    }

    @Override
    public void joueur1Marque()
    {
        this.jeu.setEtat(new TennisJeuEtatAvantage(this.jeu,this.jeu.getNomJoueur1()));
    }

    @Override
    public void joueur2Marque()
    {
        this.jeu.setEtat(new TennisJeuEtatAvantage(this.jeu,this.jeu.getNomJoueur2()));
    }
}
