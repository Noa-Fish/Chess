public class Position
{
    private int x ;
    private int y ;
    
    //Un constructeur par défaut qui intialisera les attributs à 0.
    public Position()
    {
        this.x = 0;
        this.y = 0;
    }

    //Un constructeur prenant deux entiers en paramètres.
    public Position(int abscisse, int ordonnee)
    {
        if(x<0 | y<0 | x>7 | y>7)
        {
            System.out.println("valeur incohérente (0 >= x,y <= 7)");
        }

        else
        {
            this.x = abscisse;
            this.y = ordonnee;
        }
    }

    //Un constructeur par copie.
    public Position (Position p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    /*Un constructeur prenant une chaine de caractère en paramètre. La chaine de caractère
    en paramètre sera de la forme : lettre en majuscule suivie d’un chiffre (identification
    d’une case comme sur un échiquier).*/
    public Position(String pos)
    {
        int ligne =Integer.parseInt(String.valueOf(pos.charAt(1))); 
        this.y=ligne;
        String chaine = new String(" ABCDEFGH");
        this.x=(chaine.indexOf(pos.charAt(0)));
    }

    //La méthode getter
    public int getX() 
    {
        return this.x;
    }

    //La méthode getter
    public int getY() 
    {
        return this.y;
    }

    //La méthode setter
    public int setX(int abscisse)
    { 
        if(abscisse<0| abscisse>7)
        {
            System.out.println("valeur incohérente");
        }

        else
        {
             this.x = abscisse ;
        }
        return this.x;
    }

    //La méthode setter
    public int setY(int ordonnee)
    {
        if(ordonnee<0| ordonnee>7)
        {
            System.out.println("valeur incohérente");
        }

        else
        {
             this.y = ordonnee ;
        }
        return this.y;
    }

    // La méthode equals prenant un Object en paramètre
    public boolean equals(Position position)
    {
        return (this.x==position.getX() && this.y==position.getY());
    }

    //La méthode toString retournant la position sous la forme de du repérage échiquier
    public String toString()
    {
        String chaine = new String(" ABCDEFGH");
        String affichage = chaine.substring(this.x , (this.x+1)) + (this.y);
        return affichage;
    }

    public static void main(String[] args) {
        Position p = new Position();
        System.out.println(p) ;

        p = new Position("A2");
        System.out.println(p) ;

        p.setX(1);
        p.setY(1);
        System.out.println(p.getX()) ;
        System.out.println(p.getY()) ;
        System.out.println(p) ;
    }
    
}  