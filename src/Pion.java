import java.util.ArrayList;

public abstract class Pion extends Piece {
    public String getType()
    {
        return "pion";
    }

    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);

    public abstract ArrayList<Position> getDeplacementPossibleEchec(Plateau p);

}
