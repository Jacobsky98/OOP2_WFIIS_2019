import java.io.*;
 
public class lab8 {
    public static void main(String[] args) {
        try 
        {
            if(args.length != 2) 
                throw new Exception();
        } 
        catch (Exception e) 
        {
            System.out.println("Zly sposob uruchomienia. Uruchom program poleceniem: java lab8 'dane.txt' 'wynik.txt'");
            return;
        }

        double average = 0.0;
        boolean foundError = false;

        try 
        {
            BufferedReader dataFile = new BufferedReader(new FileReader(args[0]) );
            String line = dataFile.readLine();
            int numOfLines = 0;
            while(line != null) 
            {
                average += Double.parseDouble(line);
                numOfLines++;
                line = dataFile.readLine();
            }
           
            if(numOfLines == 0) 
                throw new NumberFormatException();
            
            average /= numOfLines;
 
            if((average == Double.POSITIVE_INFINITY) || (average == Double.NEGATIVE_INFINITY))
                throw new ArithmeticException();
 
        }
        catch(FileNotFoundException e) 
        {
            System.out.println("Brak pliku " + args[0]);
            foundError = true;
        }
        catch(IOException e) 
        {
            System.out.println("Blad wczytywania pliku" + args[0]);
            foundError = true;
        }
        catch(NumberFormatException e) 
        {
            System.out.println("Zly format danych wejsciowych");
            foundError = true;
        } 
        catch(ArithmeticException e) 
        {
            System.out.println("Blad arytmetyczny dzialan");
            foundError = true;
        }
        catch(Exception e) 
        {
            System.out.println("Znaleziono inny, nieznany blad");
            foundError = true;
        }

        if(foundError)
        {
            System.out.println("Z powodu wystapienia bledow program nie zostanie wykonany");
            return;
        }

        FileWriter fileToSave = null;
        try
        {
            fileToSave = new FileWriter(new File(args[1]));
            fileToSave.write(String.valueOf(average));
        }
        catch(IOException e)
        {
            System.out.println("Blad zapisu do pliku " + args[1]);
        }
        finally
        {
            try
            {
                fileToSave.close();
            }
            catch(IOException e)
            {
                System.out.println("Blad zamykania pliku");
            }
        }
  
    }
}