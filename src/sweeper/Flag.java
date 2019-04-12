package sweeper;

class Flag 
{
    private Matrix flagMap;
    
    private int totalFlagged;
    private int totalClosed;
    
    void start()
    {
        flagMap = new Matrix(Box.CLOSED);    
        totalFlagged = 0;
        totalClosed = Ranges.getSquare();
    }

    int getTotalFlagged() 
    {
        return totalFlagged;
    }

    int getTotalClosed() 
    {
        return totalClosed;
    }
    
    Box get (Coord coord)
    {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) 
    {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    private void setFlagedToBox(Coord coord) 
    {
        flagMap.set(coord, Box.FLAGED);
        totalFlagged++;
    }
    
    private void setClosedBox(Coord coord) 
    {
        flagMap.set(coord, Box.CLOSED);
        totalFlagged--;
    }

    void togleFlagedToBox(Coord coord) 
    {
       switch (flagMap.get(coord))
       {
           case FLAGED : setClosedBox(coord); break;
           case CLOSED : setFlagedToBox(coord); break;
       }
    }

    void setFlagedToLastClosedBoxes() 
    {
        for (Coord coord : Ranges.getAllCoords()) 
        {
            if (Box.CLOSED == flagMap.get(coord))
            {
                setFlagedToBox(coord);
            }            
        }
                
    }

    void setBombedToBox(Coord coord) 
    {
        flagMap.set(coord, Box.BOMBED);
    }

    void setOpenedToClosedBox(Coord coord) 
    {
        if (Box.CLOSED == flagMap.get(coord))
        {
            flagMap.set(coord, Box.OPENED);
        }
        
    }

    void setNoBombToFlagedBox(Coord coord) 
    {
        if (Box.FLAGED == flagMap.get(coord))
        {
            flagMap.set(coord, Box.NOBOMB);
            
        }
        
    }

    int getCountFlagedBoxesAround(Coord coord) 
    {
        int count = 0;
        for (Coord around : Ranges.getCoordArround(coord)) 
        {
            if (Box.FLAGED == flagMap.get(around))
            {
                count++;
            }             
        }
        return count;
    }

    
}
