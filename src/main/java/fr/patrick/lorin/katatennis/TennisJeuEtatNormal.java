/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.patrick.lorin.katatennis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Patrick
 */
public class TennisJeuEtatNormal extends TennisJeuEtat
{
    private int scoreJoueur1 = 0;
    private int scoreJoueur2 = 0;
    private ArrayList<String> listScore=new ArrayList<>(Arrays.asList("0","15","30","40"));

    public TennisJeuEtatNormal(TennisJeu jeu)
    {
        super(jeu);
    }
    
    @Override
    public String getScore()
    {
        return traduireScore(scoreJoueur1)+" - "+traduireScore(scoreJoueur2);
    }

    @Override
    public void joueur1Marque()
    {
        scoreJoueur1++;
        apresPoint();
    }

    @Override
    public void joueur2Marque()
    {
        scoreJoueur2++;
        apresPoint();
    }
    
    private void apresPoint()
    {
        if(aUnGagnant())
        {
            this.jeu.setEtat(new TennisJeuEtatFin(this.jeu,this.joueurAvecLePlusHautScore()));
        }
        else if(estEnEgalite())
        {
            this.jeu.setEtat(new TennisJeuEtatEgalite(this.jeu));
        }
        else if(aAvantage())
        {
            this.jeu.setEtat(new TennisJeuEtatAvantage(this.jeu,this.joueurAvecLePlusHautScore()));
        }
    }
    
    private String traduireScore(int score)
    {
        return listScore.get(score);
    }
    
    private boolean aUnGagnant()
    {
        return estGagnantJoueur1() || estGagnantJoueur2();
    }
    
    private boolean estGagnantJoueur1()
    {
        return scoreJoueur1 >= 4 && scoreJoueur1 >= scoreJoueur2 + 2;
    }
    
    private boolean estGagnantJoueur2()
    {
        return scoreJoueur2 >= 4 && scoreJoueur2 >= scoreJoueur1 + 2;
    }
    
    private boolean aAvantage()
    {
        return aAvantageJoueur1() || aAvantageJoueur2();
    }
    
    private boolean aAvantageJoueur2()
    {
        return scoreJoueur1>=3 && scoreJoueur2==scoreJoueur1+1;
    }
    
    private boolean aAvantageJoueur1()
    {
        return scoreJoueur2>=3 && scoreJoueur1==scoreJoueur2+1;
    }
    
    private boolean estEnEgalite()
    {
        return scoreJoueur1 == scoreJoueur2 && scoreJoueur1 >= 3;
    }
    
    private String joueurAvecLePlusHautScore()
    {
        return scoreJoueur1>scoreJoueur2?this.jeu.getNomJoueur1():this.jeu.getNomJoueur2();
    }
}
