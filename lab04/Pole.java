
public class Pole
{
    int numOfNeighbors = 0;
    char poleCharacter = '.';
    


    public void setPoleChar(char poleCharacter)
    {
        this.poleCharacter = poleCharacter;
    }

    public char getPoleChar()
    {
        return poleCharacter;
    }


    public void setNumOfNeighbors(int numOfNeighbors)
    {
        this.numOfNeighbors = numOfNeighbors;
    }

    public int getNumOfNeighbors()
    {
        return numOfNeighbors;
    }
}

