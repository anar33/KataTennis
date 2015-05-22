package fr.patrick.lorin.katatennistest;

import fr.patrick.lorin.katatennis.TennisJeu;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;

public class TennisJeuTest
{
    private TennisJeu jeu;
    
    public TennisJeuTest()
    {
    }
    
    @Before
    public void avantChaqueTest()
    {
        jeu = new TennisJeu("J1","J2");
    }
    
    @Test
    public void nouveauJeuToutLeMondeAZero()
    {
        String score = jeu.getScore();
        
        Assert.assertEquals("0 - 0", score);
    }

    @Test
    public void joueur1MarqueUnPoint()
    {
        leJoueur1Marque(1);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("15 - 0", score);
    }
    
    @Test
    public void joueur2MarqueDeuxPoints()
    {
        leJoueur2Marque(2);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("0 - 30", score);
    }
    
    @Test
    public void joueur1MarqueTroisPoints()
    {
        leJoueur1Marque(3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("40 - 0", score);
    }
    
    @Test
    public void joueur1Gagne()
    {
        leJoueur1Marque(4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J1 a gagné!!!", score);
    }
    
    @Test
    public void joueur2Gagne()
    {
        leJoueur1Marque(2);
        leJoueur2Marque(4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J2 a gagné!!!", score);
    }
    
    @Test
    public void joueursEnEgalite()
    {
        leJoueur1Marque(3);
        leJoueur2Marque(3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Egalité", score);
    }
    
    @Test
    public void joueur1AAvantage()
    {
        leJoueur2Marque(3);
        leJoueur1Marque(4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Avantage J1", score);
    }
    
    @Test
    public void joueur2AAvantage()
    {
        leJoueur1Marque(3);
        leJoueur2Marque(4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Avantage J2", score);
    }
    
    @Test
    public void joueur1GagneApresAvantage()
    {
        leJoueur1Marque(3);
        leJoueur2Marque(4);
        leJoueur1Marque(3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J1 a gagné!!!", score);
    }
    
    @Test
    public void joueur2GagneApresAvantage()
    {
        leJoueur2Marque(3);
        leJoueur1Marque(4);
        leJoueur2Marque(3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J2 a gagné!!!", score);
    }
    
    public void creerPoints(int score1, int score2)
    {
        leJoueur1Marque(score1);
        leJoueur2Marque(score2);
    }
    
    public void leJoueur1Marque(int nb)
    {
        for(int i = 0; i<nb; i++)
        {
            jeu.joueur1Marque();
        }
    }
    
    public void leJoueur2Marque(int nb)
    {
        for(int i = 0; i<nb; i++)
        {
            jeu.joueur2Marque();
        }
    }
}
