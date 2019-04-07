package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges 
{
    static private Coord size;
    static private ArrayList<Coord> allCoord;
    static private Random random = new Random();

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
    
    static boolean isRange(Coord coord)
    {
        return coord.x >= 0 && coord.x < size.x && coord.y >= 0 && coord.y < size.y;
    }
    
    static Coord getRamdonCoord ()
    {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }
    
    static ArrayList<Coord> getCoordArround (Coord coord)
    {
        Coord arround;
        ArrayList<Coord> list = new ArrayList<Coord>();
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                if (isRange(arround = new Coord(x, y)))
                {
                    if(!arround.equals(coord))
                    {
                        list.add(arround);
                    }
                }                
            }
            
        }
        return list;
    }
            
}
