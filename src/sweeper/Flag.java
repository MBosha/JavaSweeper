package sweeper;

class Flag 
{
    private Matrix flagMap;
    
    void start()
    {
        flagMap = new Matrix(Box.CLOSED);      
    }
    
    Box get (Coord coord)
    {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) 
    {
        flagMap.set(coord, Box.OPENED);
    }

    private void setFlagedToBox(Coord coord) 
    {
        flagMap.set(coord, Box.FLAGED);
    }
    
    private void setClosedBox(Coord coord) 
    {
        flagMap.set(coord, Box.CLOSED);
    }

    void togleFlagedToBox(Coord coord) 
    {
       switch (flagMap.get(coord))
       {
           case FLAGED : setClosedBox(coord); break;
           case CLOSED : setFlagedToBox(coord); break;
       }
    }

    
}
