import java.util.ArrayList;

public class Fou extends Piece{

    public Fou()
    {
        setCouleur('B');
        setPosition(new Position("A1"));
    }

    public Fou(char c , String pos)
    {
        setCouleur(c);
        setPosition(new Position(pos));
    }

    public String getType()
    {
        return "fou";
    }
    public ArrayList<Position> getDeplacementPossible(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        tab.add(new Position(8,9));
        int i = getPosition().getX();
        int j = getPosition().getY();
        int compt = 0;
        j = j + 1;
        i = i + 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt  ==  0 && j<9 && i<9 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j + 1;
            i = i + 1;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j - 1 ;
        i = i - 1 ;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j>0 && i>0 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j - 1 ;
            i = i - 1 ;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j - 1 ;
        i = i + 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j>0 && i<9 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j - 1 ;
            i = i + 1 ;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j + 1 ;
        i = i - 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j<9 && i>0 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j + 1 ;
            i = i - 1 ;
        }
        return tab;
    }

    public ArrayList<Position> getDeplacementPossibleEchec(Plateau p) 
    {
        ArrayList <Position> tab = new ArrayList<Position>();
        int i = getPosition().getX();
        int j = getPosition().getY();
        int compt = 0;
        j = j + 1;
        i = i + 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt  ==  0 && j<9 && i<9 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j + 1;
            i = i + 1;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j - 1 ;
        i = i - 1 ;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j>0 && i>0 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j - 1 ;
            i = i - 1 ;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j - 1 ;
        i = i + 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j>0 && i<9 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j - 1 ;
            i = i + 1 ;
        }
        i = getPosition().getX();
        j = getPosition().getY();
        compt = 0;
        j = j + 1 ;
        i = i - 1;
        while((p.getCase(i,j) == null || p.getCase(i,j).getCouleur()!= getCouleur()) && compt == 0 && j<9 && i>0 )
        {
            if(p.getCase(i,j) != null && p.getCase(i,j).getCouleur()!= getCouleur())
            {
                compt = 1;
            }
            tab.add(new Position(i,j));
            j = j + 1 ;
            i = i - 1 ;
        }
        return tab;
    }
}
