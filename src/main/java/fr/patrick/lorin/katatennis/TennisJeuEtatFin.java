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
public class TennisJeuEtatFin extends TennisJeuEtat
{
    private String nomGagnant;
    
    public TennisJeuEtatFin(TennisJeu jeu, String gagnant)
    {
        super(jeu);
        nomGagnant = gagnant;
    }
    
    @Override
    public String getScore()
    {
        return nomGagnant + " a gagné!!!";
    }

    @Override
    public void joueur1Marque()
    {
        
    }

    @Override
    public void joueur2Marque()
    {
        
    }
}
