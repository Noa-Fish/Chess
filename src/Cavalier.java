import java.util.ArrayList;

public class Cavalier extends Piece{

    public Cavalier()
    {
        setCouleur('B');
        setPosition(new Position("A1"));
    }

    public Cavalier(char c , String pos)
    {
        setCouleur(c);
        setPosition(new Position(pos));
    }

    public String getType()
    {
        return "cavalier";
    }

    public ArrayList<Position>getDeplacementPossible(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        int i=getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i+2,j+1)==null || p.getCase(i+2,j+1).getCouleur()!= getCouleur())&&i+2<9&&j+1<9)
            {
                tab.add(new Position(i+2,j+1));
            }
        if ((p.getCase(i+2,j-1)==null || p.getCase(i+2,j-1).getCouleur()!= getCouleur())&&i+2<9&&j-1>0)
            {
                tab.add(new Position(i+2,j-1));
            }
        if ((p.getCase(i-2,j-1)==null || p.getCase(i-2,j-1).getCouleur()!= getCouleur())&&i-2>0&&j-1>0)
            {
                tab.add(new Position(i-2,j-1));
            }
        if ((p.getCase(i-2,j+1)==null || p.getCase(i-2,j+1).getCouleur()!= getCouleur())&&i-2>0&&j+1<9)
            {
                tab.add(new Position(i-2,j+1));
            }

        if ((p.getCase(i+1,j+2)==null || p.getCase(i+1,j+2).getCouleur()!= getCouleur())&&i+1<9&&j+2<9)
            {
                tab.add(new Position(i+1,j+2));
            }

        if ((p.getCase(i+1,j-2)==null || p.getCase(i+1,j-2).getCouleur()!= getCouleur())&&i+1<9&&j-2>0)
            {
                tab.add(new Position(i+1,j-2));
            }
        if ((p.getCase(i-1,j-2)==null || p.getCase(i-1,j-2).getCouleur()!= getCouleur())&&i-1>0&&j-2>0)
            {
                tab.add(new Position(i-1,j-2));
            }
        if ((p.getCase(i-1,j+2)==null || p.getCase(i-1,j+2).getCouleur()!= getCouleur())&&i-1>0&&j+2<9)
            {
                tab.add(new Position(i-1,j+2));
            }
        return tab;
    }

    public ArrayList<Position>getDeplacementPossibleEchec(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        int i=getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i+2,j+1)==null || p.getCase(i+2,j+1).getCouleur()!= getCouleur())&&i+2<9&&j+1<9)
            {
                tab.add(new Position(i+2,j+1));
            }
        if ((p.getCase(i+2,j-1)==null || p.getCase(i+2,j-1).getCouleur()!= getCouleur())&&i+2<9&&j-1>0)
            {
                tab.add(new Position(i+2,j-1));
            }
        if ((p.getCase(i-2,j-1)==null || p.getCase(i-2,j-1).getCouleur()!= getCouleur())&&i-2>0&&j-1>0)
            {
                tab.add(new Position(i-2,j-1));
            }
        if ((p.getCase(i-2,j+1)==null || p.getCase(i-2,j+1).getCouleur()!= getCouleur())&&i-2>0&&j+1<9)
            {
                tab.add(new Position(i-2,j+1));
            }

        if ((p.getCase(i+1,j+2)==null || p.getCase(i+1,j+2).getCouleur()!= getCouleur())&&i+1<9&&j+2<9)
            {
                tab.add(new Position(i+1,j+2));
            }

        if ((p.getCase(i+1,j-2)==null || p.getCase(i+1,j-2).getCouleur()!= getCouleur())&&i+1<9&&j-2>0)
            {
                tab.add(new Position(i+1,j-2));
            }
        if ((p.getCase(i-1,j-2)==null || p.getCase(i-1,j-2).getCouleur()!= getCouleur())&&i-1>0&&j-2>0)
            {
                tab.add(new Position(i-1,j-2));
            }
        if ((p.getCase(i-1,j+2)==null || p.getCase(i-1,j+2).getCouleur()!= getCouleur())&&i-1>0&&j+2<9)
            {
                tab.add(new Position(i-1,j+2));
            }
        return tab;
    }
}
