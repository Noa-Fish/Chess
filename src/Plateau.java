import java.util.ArrayList;

public class Plateau {
    private ArrayList<Piece> plateau = new ArrayList<Piece>();
    
    public Plateau()
    {
        this.plateau.add(new Tour('B',"A1"));
        this.plateau.add(new Tour('B',"H1"));
        this.plateau.add(new Tour('N',"A8"));
        this.plateau.add(new Tour('N',"H8"));
        this.plateau.add(new Cavalier('B',"B1"));
        this.plateau.add(new Cavalier('B',"G1"));
        this.plateau.add(new Cavalier('N',"B8"));
        this.plateau.add(new Cavalier('N',"G8"));
        this.plateau.add(new Fou('B',"C1"));
        this.plateau.add(new Fou('B',"F1"));
        this.plateau.add(new Fou('N',"C8"));
        this.plateau.add(new Fou('N',"F8"));
        this.plateau.add(new Dame('B',"D1"));
        this.plateau.add(new Dame('N',"D8"));
        this.plateau.add(new Roi('B',"E1"));
        this.plateau.add(new Roi('N',"E8"));
        this.plateau.add(new PionBlanc("A2"));
        this.plateau.add(new PionBlanc("B2"));
        this.plateau.add(new PionBlanc("C2"));
        this.plateau.add(new PionBlanc("D2"));
        this.plateau.add(new PionBlanc("E2"));
        this.plateau.add(new PionBlanc("F2"));
        this.plateau.add(new PionBlanc("G2"));
        this.plateau.add(new PionBlanc("H2"));
        this.plateau.add(new PionNoir("A7"));
        this.plateau.add(new PionNoir("B7"));
        this.plateau.add(new PionNoir("C7"));
        this.plateau.add(new PionNoir("D7"));
        this.plateau.add(new PionNoir("E7"));
        this.plateau.add(new PionNoir("F7"));
        this.plateau.add(new PionNoir("G7"));
        this.plateau.add(new PionNoir("H7"));
    }

    public Piece getCase(int x , int y)
    {
        for (Piece piece : this.plateau)
        {
            if (piece.getPosition().equals(new Position(x,y)))
            {
                return piece;
            }
        }
        return null;
    }

    public Piece getCase(Position pos)
    {
        for (Piece piece : this.plateau)
        {
            if (piece.getPosition().equals(pos))
            {
                return piece;
            }
        }
        return null;
    }

    public Piece getCase(String pos)
    {
        for (Piece piece : this.plateau)
        {
            if (piece.getPosition().equals(new Position(pos)))
            {
                return piece;
            }
        }
        return null;
    }


    public String toString()
    { 
        int num;
        num=8;
        System.out.print(" |---|---|---|---|---|---|---|---|\n");
        while (num>0)
        {
            if (num !=8 )
            {
                System.out.print(" |---|---|---|---|---|---|---|---|\n");
            }
            System.out.print(num);
            for (int i=0 ; i<8 ;i++)
            {
                if(getCase(i+1,num)==null)
                {
                    System.out.print( "|   ");
                }
                else
                {
                    System.out.print( "|"+getCase(i+1,num).getNomCourt());
                }  
            }
            System.out.print( "|"+num+"\n");  
            num=num-1;
        }
        System.out.print(" |---|---|---|---|---|---|---|---|\n");
        System.out.print("  A   B   C   D   E   F   G   H\n");
        return "\n";
    }

    public ArrayList<Piece> getPiecesBlanches()
    { 
        ArrayList<Piece> tabB = new ArrayList<Piece>();
        for (Piece piece : this.plateau)
        {
            if (piece.getCouleur()=='B')
            {
                tabB.add(piece);
            }
        }
        return tabB;
    }

    public ArrayList<Piece> getPiecesNoires()
    { 
        ArrayList<Piece> tabN = new ArrayList<Piece>();
        for (Piece piece : this.plateau)
        {
            if (piece.getCouleur()=='N')
            {
                tabN.add(piece);
            }
        }
        return tabN;
    }

    

    public Boolean deplacer( Position from, Position to ){
        Piece p = getCase(from);
        ArrayList<Position> d = p.getDeplacementPossible(this);
        for (int i = 0; i < d.size(); i++){
            if (d.get(i).getX() == to.getX() && d.get(i).getY() == to.getY()){
                this.remove((this.getCase(to)));
                return true;
            }
        }
        return false;
    }

    public void remove(Piece p)
    {
        this.plateau.remove(p);
    }
    
    public ArrayList<ArrayList <Position>> getToutDeplacementPossible(Plateau p,char c)
    {
        ArrayList <ArrayList <Position>> tab = new ArrayList<ArrayList <Position>>();
        for (Piece piece : this.plateau)
        {
            if (piece.getCouleur()!=c)
            {
            tab.add(piece.getDeplacementPossibleEchec(p));
            }
        }
        return tab;
    }

    public boolean estEchec(Plateau p,char c)
    {
        for (Piece piece : this.plateau)
        {
            if (piece.getCouleur()==c && piece.getType()=="roi")
            {
                for(ArrayList<Position> list :p.getToutDeplacementPossible(p, c))
                {
                    for(Position pos : list)
                    {
                            if(pos.equals(piece.getPosition()))
                            {
                                return true;
                            }
                    }
                }
            }
        }
        return false;
    }
}



        