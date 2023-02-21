import MG2D. * ;
import MG2D.geometrie. *;
import java.awt.Font;
import java.util.ArrayList;

class MainGraphique 
{

    public static void afficheDepPossible(Fenetre f, ArrayList<Position> l){
        for(Position p : l){
            int indiceX = p.getX();
            int indiceY = p.getY();
            f.ajouter(new Cercle(Couleur.ROUGE,new Point(indiceX*100-50, indiceY*100-50), (int)(100*0.45), false));
        }
    }

    public static void dessinerPlateau(Fenetre f, Plateau p, char c )
    {
        f.effacer();
        //dessin du menu
        f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point (800,0),300,800,true )) ;
        f.ajouter(new Rectangle(Couleur.NOIR, new Point (800,0),10,800,true )) ;
        f.ajouter(new Rectangle(Couleur.GRIS_FONCE, new Point (870,550),160,160,true )) ;

        f.ajouter(new Rectangle(Couleur.BLEU, new Point (875,555),150,150,true )) ;
        f.ajouter(new Cercle(Couleur.BLANC, new Point (950,555),50,true )) ;
        f.ajouter(new Rectangle(Couleur.GRIS_FONCE, new Point (870,550),150,5,true )) ;
        f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point (870,400),150,150,true )) ;
        f.ajouter(new Cercle(Couleur.BLANC, new Point (950,625),30,true )) ;
        f.ajouter(new Texte ( Couleur.NOIR, "Joueur 1", new Font("Calibri", Font.TYPE1_FONT, 32),  new Point(950,675), Texte.CENTRE));

        f.ajouter(new Rectangle(Couleur.GRIS_FONCE, new Point (870,150),160,160,true )) ;
        f.ajouter(new Rectangle(Couleur.ROUGE, new Point (875,155),150,150,true )) ;
        f.ajouter(new Cercle(Couleur.BLANC, new Point (950,155),50,true )) ;
        f.ajouter(new Rectangle(Couleur.GRIS_FONCE, new Point (870,150),150,5,true )) ;
        f.ajouter(new Rectangle(Couleur.GRIS_CLAIR, new Point (870,0),150,150,true )) ;
        f.ajouter(new Cercle(Couleur.BLANC, new Point (950,225),30,true )) ;
        f.ajouter(new Texte ( Couleur.NOIR, "Joueur 2", new Font("Calibri", Font.TYPE1_FONT, 32),  new Point(950,275), Texte.CENTRE));

        f.ajouter(new Rectangle(new Rectangle(Couleur.NOIR, new Point (810,500),300,5,true )));
        f.ajouter(new Rectangle(new Rectangle(Couleur.NOIR, new Point (810,350),300,5,true )));
        f.ajouter(new Texte ( Couleur.NOIR, "Au Blanc de jouer", new Font("Calibri", Font.TYPE1_FONT, 32),  new Point(950,425), Texte.CENTRE));
        
        // Dessin des cases
        for(int i = 0 ; i < 8 ; i++)
            for(int j = 0; j < 8 ; j++){
                if( (i+j)%2 == 1){
                    f.ajouter(new Carre(Couleur.BLANC,new Point(i*100,j*100), 100, true));
                }
                else{
                    f.ajouter(new Carre(Couleur.GRIS_FONCE,new Point(i*100,j*100), 100, true));
                }
            }
        // Dessin des pièces
        for (Piece piece : p.getPiecesBlanches()){
            f.ajouter(new Texture("./images/"+piece.getNomLong()+".png",new Point(piece.getPosition().getX()*100-100,piece.getPosition().getY()*100-100),100,100));            
        }
        for (Piece piece : p.getPiecesNoires()){
            f.ajouter(new Texture("./images/"+piece.getNomLong()+".png",new Point(piece.getPosition().getX()*100-100,piece.getPosition().getY()*100-100),100,100));            
        }
    }
    public static void main(String[] args){
        ArrayList<Position> rien = new ArrayList<Position>();
        rien.add(new Position("H9"));
        Position from=new Position();
        int compt2=0;
        char c ;
        Plateau p = new Plateau();
        Fenetre f = new Fenetre ( "Chess" , 1100 , 800 ) ;
        f.ajouter(new Rectangle(Couleur.GRIS_FONCE, new Point (0,0),800,800,true )) ;

        dessinerPlateau(f, p, 'B');

        
        

        Souris souris = f.getSouris();
       
            f.rafraichir();
            c='B';
            while (p.estEchec(p,c)==false)
            { 
               //si clique droit alors on affiche les déplacements possibles de la pièce la case
               if (souris.getBoutonDroitEnfonce()==true){
                     int x=souris.getPosition().getX();
                     int y=souris.getPosition().getY();
                     ArrayList<Position> depPossible = new ArrayList<Position>();
                     x=x/100+1;
                     y=y/100+1;
                     if (p.getCase(x, y)!=null){
                        for(Position pos :p.getCase(x, y).getDeplacementPossible(p)){
                            depPossible.add(pos);
                        }
                     }
                     afficheDepPossible(f,depPossible);
                    f.rafraichir();
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch ( Exception e ){}
                    dessinerPlateau(f, p, c);
               }
               //si clique gauche alors on déplace la pièce si c'est possible 
                if (souris.getClicGauche()==true)
                {  
                    int x=souris.getPosition().getX();
                    int y=souris.getPosition().getY();
                    x=x/100+1;
                    y=y/100+1;
                    Carre carre = new Carre(Couleur.VERT,new Point(x*100-100,y*100-100),100, true);
                    if(compt2==0 && p.getCase(x,y)!=null && p.getCase(x,y).getCouleur()==c)
                    {
                        from= new Position(x,y);
                        x=x/100+1;
                        y=y/100+1;
                        compt2 =1;
                        f.ajouter(carre);
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch ( Exception e ){}
                        x=x*100+1;
                        y=y*100+1;
                        f.supprimer(carre);
                    }
                    else if(compt2==1)
                    {
                        int xto=souris.getPosition().getX();
                        int yto=souris.getPosition().getY();
                        xto=xto/100+1;
                        yto=yto/100+1;
                        f.ajouter(carre);
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch ( Exception e ){}
                        x=x*100+1;
                        y=y*100+1;
                        f.supprimer(carre);
                        compt2=0;
                        Position to=new Position(xto,yto);
                        Boolean test = p.deplacer(from, to);
                        if(test)
                        {
                            Piece piece = p.getCase(from);
                            if ( piece!=(null))
                            {
                                piece.setPosition(to);
                                x=piece.getPosition().getX();
                                y=piece.getPosition().getY();
                                dessinerPlateau(f, p ,c);
                                if (c=='B')
                                    {
                                        c='N';
                                    }
                                else
                                    {
                                        c='B';
                                    }
                                
                            }
                        }
                    }
                }
                f.rafraichir();
            }
        //affiche le message de fin de partie
        f.ajouter(new Rectangle(Couleur.NOIR, new Point (200,300),400,250,true ));
        f.ajouter(new Texte ( Couleur.ROUGE, "Échec", new Font("Calibri", Font.TYPE1_FONT, 100),  new Point(275,425), Texte.GAUCHE));
        f.rafraichir();
    }
}

