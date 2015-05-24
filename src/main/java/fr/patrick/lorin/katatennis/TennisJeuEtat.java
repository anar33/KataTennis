package fr.patrick.lorin.katatennis;

abstract class TennisJeuEtat
{
    protected TennisJeu jeu;
    
    public TennisJeuEtat(TennisJeu jeu)
    {
        this.jeu=jeu;
    }
    
    public abstract String getScore();

    public abstract void joueur1Marque();
    
    public abstract void joueur2Marque();
}
