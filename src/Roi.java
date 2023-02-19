import java.util.ArrayList;

public class Roi extends Piece{

    public Roi()
    {
        setCouleur('B');
        setPosition(new Position("A1"));
    }

    public Roi(char c , String pos)
    {
        setCouleur(c);
        setPosition(new Position(pos));
    }
    public String getType()
    {
        return "roi";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        tab.add(new Position(8,9));
        int i=getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i+1,j+1)==null || p.getCase(i+1,j+1).getCouleur()!= getCouleur())&& i+1<9 && j+1<9)
            {
                tab.add(new Position(i+1,j+1));
            }
            
        if ((p.getCase(i+1,j)==null || p.getCase(i+1,j).getCouleur()!= getCouleur())&&i+1<9)
            {
                tab.add(new Position(i+1,j));
            }
        if ((p.getCase(i+1,j-1)==null || p.getCase(i+1,j-1).getCouleur()!= getCouleur())&&i+1<9&&j-1>0)
            {
                tab.add(new Position(i+1,j-1));
            }
        if ((p.getCase(i,j-1)==null || p.getCase(i,j-1).getCouleur()!= getCouleur())&&j-1>0)
            {
                tab.add(new Position(i,j-1));
            }
        if ((p.getCase(i,j+1)==null || p.getCase(i,j+1).getCouleur()!= getCouleur())&&j+1<9)
            {
                tab.add(new Position(i,j+1));
            }
            if ((p.getCase(i-1,j+1)==null || p.getCase(i-1,j+1).getCouleur()!= getCouleur())&&j+1<9&&i-1>0)
            {
                tab.add(new Position(i-1,j+1));
            }
        if ((p.getCase(i-1,j)==null || p.getCase(i-1,j).getCouleur()!= getCouleur())&&i-1>0)
            {
                tab.add(new Position(i-1,j));
            }
        if ((p.getCase(i-1,j-1)==null || p.getCase(i-1,j-1).getCouleur()!= getCouleur())&&i-1>0&&j-1>0)
            {
                tab.add(new Position(i-1,j-1));
            }
        return tab;
    }


    public ArrayList<Position> getDeplacementPossibleEchec(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        int i=getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i+1,j+1)==null || p.getCase(i+1,j+1).getCouleur()!= getCouleur())&& i+1<9 && j+1<9)
            {
                tab.add(new Position(i+1,j+1));
            }
            
        if ((p.getCase(i+1,j)==null || p.getCase(i+1,j).getCouleur()!= getCouleur())&&i+1<9)
            {
                tab.add(new Position(i+1,j));
            }
        if ((p.getCase(i+1,j-1)==null || p.getCase(i+1,j-1).getCouleur()!= getCouleur())&&i+1<9&&j-1>0)
            {
                tab.add(new Position(i+1,j-1));
            }
        if ((p.getCase(i,j-1)==null || p.getCase(i,j-1).getCouleur()!= getCouleur())&&j-1>0)
            {
                tab.add(new Position(i,j-1));
            }
        if ((p.getCase(i,j+1)==null || p.getCase(i,j+1).getCouleur()!= getCouleur())&&j+1<9)
            {
                tab.add(new Position(i,j+1));
            }
            if ((p.getCase(i-1,j+1)==null || p.getCase(i-1,j+1).getCouleur()!= getCouleur())&&j+1<9&&i-1>0)
            {
                tab.add(new Position(i-1,j+1));
            }
        if ((p.getCase(i-1,j)==null || p.getCase(i-1,j).getCouleur()!= getCouleur())&&i-1>0)
            {
                tab.add(new Position(i-1,j));
            }
        if ((p.getCase(i-1,j-1)==null || p.getCase(i-1,j-1).getCouleur()!= getCouleur())&&i-1>0&&j-1>0)
            {
                tab.add(new Position(i-1,j-1));
            }
        return tab;
    }
}
