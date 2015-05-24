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
public class TennisJeuEtatAvantage extends TennisJeuEtat
{
    private String joueurAvecAvantage;
    
    public TennisJeuEtatAvantage(TennisJeu jeu, String joueurAvecAvantage)
    {
        super(jeu);
        this.joueurAvecAvantage=joueurAvecAvantage;
    }

    @Override
    public String getScore()
    {
        return "Avantage " + joueurAvecAvantage;
    }

    @Override
    public void joueur1Marque()
    {
        if(joueurAvecAvantage.equals(jeu.getNomJoueur1()))
        {
            jeu.setEtat(new TennisJeuEtatFin(jeu,jeu.getNomJoueur1()));
        }
        else
        {
            jeu.setEtat(new TennisJeuEtatEgalite(jeu));
        }
    }

    @Override
    public void joueur2Marque()
    {
        if(joueurAvecAvantage.equals(jeu.getNomJoueur2()))
        {
            jeu.setEtat(new TennisJeuEtatFin(jeu,jeu.getNomJoueur2()));
        }
        else
        {
            jeu.setEtat(new TennisJeuEtatEgalite(jeu));
        }
    }
    
}
