import java.util.ArrayList;

public abstract class Piece {
    private char couleur;
    private Position position;

    //Un constructeur par défaut qui créera un pion blanc en A2
    public Piece()
    {
        this.couleur='B';
        this.position= new Position("A1");
    }

    //Un constructeur par copie
    public Piece(Piece p )
    {
        this.couleur=p.couleur;
        this.position= p.position;
    }
    
    /* Un constructeur prenant en paramètre le type de la pièce, une couleur et une position
    sous la forme de deux entiers.*/
    public Piece(char c, int posx , int posy)
    {
        this.couleur=c;
        this.position=new Position(posx,posy);
    }

    /*Un constructeur prenant en paramètre le type de la pièce, une couleur et une position
    sous la forme d’un objet de type Position*/
    public Piece(char c, Position pos)
    {
        this.couleur=c;
        this.position=pos;
    }

    /*Un constructeur prenant en paramètre le type de la pièce, une couleur et une position
    sous la forme d’une chaine de caractère identifiant une case à la manière d’un échiquier*/
    public Piece(char c, String pos)
    {
        this.couleur=c;
        this.position = new Position(pos);
    }

    //La méthode Getter de Couleur
    public char getCouleur()
    {
        return this.couleur;
    }

    //La méthode Getter de Position
    public Position getPosition()
    {
        return this.position;
    }

    //La méthode Getter de Type
    public abstract String getType();
    
    //La méthode Setter de Couleur 
    public char setCouleur(char c)
    {
        return this.couleur=c;
    }

    //La méthode Setter de Position 
    public Position setPosition(Position p)
    {
        return this.position=p;
    }

    public String getNomCourt()
    {
        String typecourt;
        typecourt = "zzzz";
        if (getType()=="pion")
        {
            typecourt="Pi";
        }
        else if (getType()=="cavalier")
        {
            typecourt="Ca";
        }
        else if (getType()=="tour")
        {
            typecourt="To";
        }
        else if (getType()=="fou")
        {
            typecourt="Fo";
        }
        else if (getType()=="dame")
        {
            typecourt="Da";
        }
        else if (getType()=="roi")
        {
            typecourt="Ro";
        }
        return (typecourt+this.couleur);
    }

    public String getNomLong()
    {
        return (getType()+'_'+this.couleur);
    }

    // La méthode equals prenant un Object en paramètre
    public boolean equals(Position position)
    {
        return (this.couleur==getCouleur() && this.position==getPosition());
    }


    public String toString()
    {   
        String couleurlong;
        if (this.couleur=='N')
        {
            couleurlong="noir";
        }
        else
        {
            couleurlong="blanc";
        }
        String affichage = getType()+" "+couleurlong + " en " +this.position ;
        return affichage;
    }

    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);

    public abstract ArrayList<Position> getDeplacementPossibleEchec(Plateau p);
}
