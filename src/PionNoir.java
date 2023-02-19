import java.util.ArrayList;

public class PionNoir extends Pion {
    public PionNoir()
    {
        setCouleur('N');
        setPosition(new Position("A1"));
    }

    public PionNoir(String pos)
    {
        setCouleur('N');
        setPosition(new Position(pos));
    }

    public String getType()
    {
        return "pion";
    }

    public ArrayList<Position> getDeplacementPossibleEchec(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        tab.add(new Position(8,9));
        int i = getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i,j-1)==null )&&j-1>0)
        {
            tab.add(new Position(i,j-1));
        }
        if ((p.getCase(i,j-2)==null && p.getCase(i,j-1)==null)&&j-2>0&&j==7)
        {
            tab.add(new Position(i,j-2));
        }
        if (j-1>0&&i+1<9)
        {
                tab.add(new Position(i+1,j-1));
        }
        if (j-1>0&&i-1>0)
        {
                tab.add(new Position(i-1,j-1));
        }
        return tab;
    }
    
    public ArrayList<Position> getDeplacementPossible(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        int i = getPosition().getX();
        int j = getPosition().getY();
        if ((p.getCase(i,j-1)==null )&&j-1>0)
        {
            tab.add(new Position(i,j-1));
        }
        if ((p.getCase(i,j-2)==null && p.getCase(i,j-1)==null)&&j-2>0&&j==7)
        {
            tab.add(new Position(i,j-2));
        }
        if ((p.getCase(i+1,j-1)!=null && p.getCase(i+1,j-1).getCouleur()!=getCouleur())&&j-1>0&&i+1<9)
        {
            tab.add(new Position(i+1,j-1));
        }
        if ((p.getCase(i-1,j-1)!=null &&p.getCase(i-1,j-1).getCouleur()!=getCouleur())&&j-1>0&&i-1>0)
        {
            tab.add(new Position(i-1,j-1));
        }
        return tab;
    }

    
}
