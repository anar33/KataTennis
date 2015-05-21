package fr.patrick.lorin.katatennis;

/**
 *
 * @author Patrick
 */
public class TennisJeu
{
    private int scoreJoueur1 = 0;
    private int scoreJoueur2 = 0;
    private String nomJoueur1 = "";
    private String nomJoueur2= "";
    
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
        return traduitScore(scoreJoueur1)+" - "+traduitScore(scoreJoueur2);
    }

    public void joueur1Marque()
    {
        scoreJoueur1++;
    }
    
    public void joueur2Marque()
    {
        scoreJoueur2++;
    }
    
    public boolean aUnGagnant()
    {
        if(scoreJoueur1 >= 4 && scoreJoueur1 >= scoreJoueur2 + 2 )
        {
            return true;
        }
        if(scoreJoueur2 >= 4 && scoreJoueur2 >= scoreJoueur1 + 2 )
        {
            return true;
        }
        return false;
    }
    
    public boolean aAvantage()
    {
        if(scoreJoueur1>=3 && scoreJoueur2==scoreJoueur1+1)
        {
            return true;
        }
        if(scoreJoueur2>=3 && scoreJoueur1==scoreJoueur2+1)
        {
            return true;
        }
        return false;
    }
    
    public boolean estEnEgalite()
    {
        if(scoreJoueur1 == scoreJoueur2 && scoreJoueur1 >= 3)
        {
            return true;
        }
        return false;
    }
    
    public String joueurAvecLePlusHautScore()
    {
        return scoreJoueur1>scoreJoueur2?nomJoueur1:nomJoueur2;
    }
    
    private String traduitScore(int score)
    {
        switch(score)
        {
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
        }
        return "0";
    }
}
