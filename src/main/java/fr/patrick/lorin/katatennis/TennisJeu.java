package fr.patrick.lorin.katatennis;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisJeu
{
    private int scoreJoueur1 = 0;
    private int scoreJoueur2 = 0;
    private String nomJoueur1 = "";
    private String nomJoueur2= "";
    private ArrayList<String> listScore=new ArrayList<>(Arrays.asList("0","15","30","40"));
    
    public TennisJeu(String nomJ1, String nomJ2)
    {
        nomJoueur1 = nomJ1;
        nomJoueur2 = nomJ2;
    }
    
    public String getScore()
    {
        if(aUnGagnant())
        {
            return joueurAvecLePlusHautScore() + " a gagné!!!";
        }
        if(estEnEgalite())
        {
            return "Egalité";
        }
        if(aAvantage())
        {
            return "Avantage "+joueurAvecLePlusHautScore();
        }
        return traduireScore(scoreJoueur1)+" - "+traduireScore(scoreJoueur2);
    }

    public void joueur1Marque()
    {
        scoreJoueur1++;
    }
    
    public void joueur2Marque()
    {
        scoreJoueur2++;
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
        return scoreJoueur1>scoreJoueur2?nomJoueur1:nomJoueur2;
    }
    
    private String traduireScore(int score)
    {
        return listScore.get(score);
    }
}
