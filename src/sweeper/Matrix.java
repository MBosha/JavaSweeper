package sweeper;

class Matrix 
{
    private final Box[][] matrix;    

    Matrix(Box box) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        Ranges.getAllCoords().forEach((coord) -> {
            this.matrix[coord.x][coord.y] = box;
        });
    }

    Box get(Coord coord) {
        if (Ranges.isRange(coord))
        {
            return matrix[coord.x][coord.y];
        }
        return null;        
    }

    void set(Coord coord, Box box) {
        if (Ranges.isRange(coord))
        {
            matrix[coord.x][coord.y]= box;
        }
    }
}
