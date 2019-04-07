package sweeper;

public class Coord 
{
    public int x;
    public int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Coord)){
            return super.equals(object);
        }
        Coord to = (Coord) object;
        return to.x == x && to.y ==y;
    }
}
