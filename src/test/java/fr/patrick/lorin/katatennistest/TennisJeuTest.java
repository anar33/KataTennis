/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.patrick.lorin.katatennistest;

import fr.patrick.lorin.katatennis.TennisJeu;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author Patrick
 */
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
        jeu.joueur1Marque();
        
        String score = jeu.getScore();
        
        Assert.assertEquals("15 - 0", score);
    }
    
    @Test
    public void joueur2MarqueDeuxPoints()
    {
        jeu.joueur2Marque();
        jeu.joueur2Marque();
        
        String score = jeu.getScore();
        
        Assert.assertEquals("0 - 30", score);
    }
    
    @Test
    public void joueur1MarqueTroisPoints()
    {
        jeu.joueur1Marque();
        jeu.joueur1Marque();
        jeu.joueur1Marque();
        
        String score = jeu.getScore();
        
        Assert.assertEquals("40 - 0", score);
    }
    
    @Test
    public void joueur1Gagne()
    {
        creerPoints(4,0);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J1 a gagné!!!", score);
    }
    
    @Test
    public void joueur2Gagne()
    {
        creerPoints(2,4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J2 a gagné!!!", score);
    }
    
    @Test
    public void joueursEnEgalite()
    {
        creerPoints(3,3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Egalité", score);
    }
    
    @Test
    public void joueur1AAvantage()
    {
        creerPoints(4,3);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Avantage J1", score);
    }
    
    @Test
    public void joueur2AAvantage()
    {
        creerPoints(3,4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("Avantage J2", score);
    }
    
    @Test
    public void joueur1GagneApresAvantage()
    {
        creerPoints(6,4);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J1 a gagné!!!", score);
    }
    
    @Test
    public void joueur2GagneApresAvantage()
    {
        creerPoints(4,6);
        
        String score = jeu.getScore();
        
        Assert.assertEquals("J2 a gagné!!!", score);
    }
    
    public void creerPoints(int score1, int score2)
    {
        for(int i = 0; i<score1; i++)
        {
            jeu.joueur1Marque();
        }
        for(int i = 0; i<score2; i++)
        {
            jeu.joueur2Marque();
        }
    }
}
