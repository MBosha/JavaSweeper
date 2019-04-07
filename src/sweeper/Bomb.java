package sweeper;

class Bomb 
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) 
    {
        this.totalBombs = totalBombs;
        fixBombCount();
    }
    
    int getTotalBombs()
    {
        return totalBombs;
    }
    
    void Start()
    {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    } 
    
    Box get(Coord coord)
    {
        return bombMap.get(coord);
    }
    
    private void fixBombCount()
    {
        int maxBomb = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBomb) 
        {
            totalBombs = maxBomb;
        }
    }
    
    private void placeBomb()
    {
        while (true) 
        {
            Coord coord = Ranges.getRamdonCoord();
            if (Box.BOMB == bombMap.get(coord))
            {
                continue;
            }
            bombMap.set(coord, Box.BOMB);
            incNumbersAroundBombs(coord);  
            break;
        }        
    }

    private void incNumbersAroundBombs(Coord coord) 
    {
        for (Coord around: Ranges.getCoordArround(coord))
        {
            if (Box.BOMB != bombMap.get(around))
            {
                bombMap.set(around, bombMap.get(around).nextNumberBox());
            }
        }
    }
    
    
    
}