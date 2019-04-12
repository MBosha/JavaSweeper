package sweeper;

public class Game 
{    
    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public GameState getState() 
    {
        return state;
    }
    
    public int getTotalBombs()
    {
        return bomb.getTotalBombs();
    }
    
    public int getTotalFlaged()
    {
        return flag.getTotalFlagged();
    }
    
    public Game(int cols, int rows, int bombs) 
    {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }     
    
    public void start()
    {
        bomb.Start();
        flag.start();
        state =GameState.PLAYED;
    }
    
    public Box getBox (Coord coord)
    {
        if (Box.OPENED == flag.get(coord))
        {
            return bomb.get(coord);
        }
        else
        {
            return flag.get(coord);
        }        
    }
    
    public void pressLeftButton(Coord coord)
    {
        if (isGameOver())
        {
            return;
        }
        openBox(coord);
        checkWinner();        
    }
    
    public void pressRightButton(Coord coord)
    {
        if (isGameOver())
        {
            return;
        }
        flag.togleFlagedToBox(coord);        
    }   
    
    private boolean isGameOver()
    {
        if (GameState.PLAYED != state)
        {
            start();
            return true;
        }  
        return false;
    }
    
    private void checkWinner()
    {
        if (GameState.PLAYED == state)
        {
            if (flag.getTotalClosed() == bomb.getTotalBombs())
            {
                state = GameState.WINNER;
                flag.setFlagedToLastClosedBoxes();
                
            }
        }
    }
    
    private void openBox(Coord coord)
    {
        switch (flag.get(coord))
        {
            case OPENED : setOpenedToClosedBoxesAroundNumber(coord); break;
            case FLAGED : break;
            case CLOSED : 
                switch (bomb.get(coord))
                {
                    case ZERO : openBoxsesAroundZero(coord); break;
                    case BOMB : openBombs(coord); break;
                    default : flag.setOpenedToBox(coord); break;
                }
        }
    }
    
    private void openBoxsesAroundZero(Coord coord)
    {
        flag.setOpenedToBox(coord);
        for(Coord around : Ranges.getCoordArround(coord))
        {
            openBox(around);
        }
    }

    private void openBombs(Coord bombedCoord) 
    {
        flag.setBombedToBox(bombedCoord);
        for (Coord coord : Ranges.getAllCoords()) 
        {
            if (bomb.get(coord) == Box.BOMB)
            {
                flag.setOpenedToClosedBox(coord);                
            }   
            else 
            {
                flag.setNoBombToFlagedBox(coord);
            }
        }
        
        state = GameState.BOMBED;
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) 
    {
        if (Box.BOMB != bomb.get(coord))
        {
            if (bomb.get(coord).getNumber() == flag.getCountFlagedBoxesAround(coord))
            {
                for (Coord around : Ranges.getCoordArround(coord))
                {
                    if (Box.CLOSED == flag.get(around))
                    {
                        openBox(around);
                    }                    
                }                                 
            }            
        }
    }
            
}