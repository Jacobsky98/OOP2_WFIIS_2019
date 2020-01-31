

public class Game
{
    int size_x;
    int size_y;
    int midX;
    int midY;
    int steps;
    int startConfig;
    int alive;
    Pole [][] pole;
    
    Game(int size_x, int size_y, int steps, int startConfig)
    {
        this.size_x = size_x;
        this.size_y = size_y;
        this.steps = steps;
        this.startConfig = startConfig;
        midX = size_x/2;
        midY = size_y/2;
        this.startConfig = startConfig;

        pole = new Pole[this.size_y][this.size_x];
        

        for(int i = 0; i < size_y; i++)
        {    
            for(int j = 0; j < size_x; j++)
            {
               pole[i][j] = new Pole();
            }
        } 

        switch(startConfig)
        {
            case 0:
                
                for(int k = 0; k < size_x*size_y/4; k++)
                {   
                    int xx = (int)(Math.random() * size_x);
                    int yy = (int)(Math.random() * size_y);
                    pole[yy][xx].setPoleChar('X');
                }
                break;
            case 1:
                pole[midY-1][midX-1].setPoleChar('X');
                pole[midY-1][midX].setPoleChar('X');
                pole[midY][midX+1].setPoleChar('X');
                pole[midY][midX-1].setPoleChar('X');
                pole[midY+1][midX].setPoleChar('X');
                break;
            case 2:
                pole[midY-1][midX].setPoleChar('X');
                pole[midY][midX].setPoleChar('X');
                pole[midY+1][midX].setPoleChar('X');
                break;
            case 3:
                pole[midY-1][midX-1].setPoleChar('X');
                pole[midY-1][midX].setPoleChar('X');
                pole[midY-1][midX+1].setPoleChar('X');
                pole[midY][midX-1].setPoleChar('X');
                pole[midY+1][midX].setPoleChar('X');
                break;
            default:
                break;
        }
    }

    private void countNeighbors()
    {
        for(int i = 0; i < size_y; i++)
        {    
            for(int j = 0; j < size_x; j++)
            {
               int neighbors = 0;
               for(int k = 0; k < 9; k++)
                {
                    if(((i-1+k/3) >= 0) && ((i-1+k/3) < size_y) && ((j-1+k%3) >= 0) && ((j-1+k%3) < size_x))
                    {
                        if(pole[i-1+k/3][j-1+k%3].getPoleChar() == 'X')
                            neighbors++;
                    }
                }
                if(pole[i][j].getPoleChar() == '.')
                    pole[i][j].setNumOfNeighbors(neighbors); 
                else
                    pole[i][j].setNumOfNeighbors(neighbors-1);      
            }
        }    
    }

    public void show()
    {
        for(int i = 0; i < size_y; i++)
        {    
            for(int j = 0; j < size_x; j++)
            {
               System.out.print(pole[i][j].getPoleChar());
            }
            System.out.println("");
        }
    }

    public void showNeighbors()
    {
        countNeighbors();
        for(int i = 0; i < size_y; i++)
        {    
            for(int j = 0; j < size_x; j++)
            {
               System.out.print(pole[i][j].getNumOfNeighbors());
            }
            System.out.println("");
        }
    }

    public void countAlive()
    {
        int aliveNow = 0;
        for(int i = 0; i < size_y; i++)
        {    
            for(int j = 0; j < size_x; j++)
            {
               if(pole[i][j].getPoleChar() == 'X')
                   aliveNow++;
            }
            
        }
        alive = aliveNow;
    }

    public void run()
    {
        for(int currentStep = 0; currentStep < steps; currentStep++)
        {
            countNeighbors();
            countAlive();
            for(int k = 0; k < size_x; k++)
            {
                if(k == midX)
                    System.out.print(currentStep+1);
                else
                    System.out.print("-");
            }
            System.out.println("");
            show();
            for(int i = 0; i < size_y; i++)
            {    
                for(int j = 0; j < size_x; j++)
                {
                    if((pole[i][j].getPoleChar() == '.') && (pole[i][j].getNumOfNeighbors() == 3))
                        pole[i][j].setPoleChar('X');
                    else if((pole[i][j].getPoleChar() == 'X') && ((pole[i][j].getNumOfNeighbors() == 2) || (pole[i][j].getNumOfNeighbors() == 3))) 
                        pole[i][j].setPoleChar('X');
                    else
                        pole[i][j].setPoleChar('.');
                }
            }
            if(alive == 0)
                break;
        }
    }
    
}
