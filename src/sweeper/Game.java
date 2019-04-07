package sweeper;

public class Game 
{    
    private Bomb bomb;
    
    public Game(int cols, int rows, int bombs) 
    {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
    }     
    
    public void Start()
    {
        bomb.Start();
    }
    
    public Box getBox (Coord coord)
    {
        return bomb.get(coord);
    }
    
    
}
