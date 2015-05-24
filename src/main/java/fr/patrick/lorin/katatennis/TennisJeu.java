package fr.patrick.lorin.katatennis;

import java.util.ArrayList;
import java.util.Arrays;

public class TennisJeu
{
    private String nomJoueur1 = "";
    private String nomJoueur2= "";
    private TennisJeuEtat etat = new TennisJeuEtatNormal(this);
    
    public TennisJeu(String nomJ1, String nomJ2)
    {
        nomJoueur1 = nomJ1;
        nomJoueur2 = nomJ2;
    }
    
    public String getScore()
    {
        return etat.getScore();
    }

    public void joueur1Marque()
    {
        etat.joueur1Marque();
    }
    
    public void joueur2Marque()
    {
        etat.joueur2Marque();
    }
    
    public String getNomJoueur1()
    {
        return nomJoueur1;
    }
    
    public String getNomJoueur2()
    {
        return nomJoueur2;
    }
    
    void setEtat(TennisJeuEtat etat)
    {
        this.etat = etat;
    }
}
