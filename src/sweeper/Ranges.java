package sweeper;

import java.util.ArrayList;

public class Ranges 
{
    static private Coord size;
    static private ArrayList<Coord> allCoord;

    public static ArrayList<Coord> getAllCoords() 
    {
        return allCoord;
    }
    
    public static Coord getSize() 
    {
        return size;
    }

    public static void setSize(Coord size) 
    {
        Ranges.size = size;
        allCoord = new ArrayList<>();
        for (int x = 0; x < size.x; x++) 
        {
            for (int y = 0; y < size.y; y++) 
            {
                allCoord.add(new Coord(x, y));
            }            
        }
    }
    
    static public void setSize(int cols, int rows) 
    {
        Coord size = new Coord(cols, rows);
        setSize(size);
    }
            
    
}
