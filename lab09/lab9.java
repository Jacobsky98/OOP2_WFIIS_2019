import java.io.*;
 
public class lab9 {
    public static void main(String[] args) {
        int width = 0, height = 0; 
        String fileName = "";
        int numOfPoints = 0;
        int points[][];
        double eps = 0.1;
        points = new int[2][2];

        try 
        {
            BufferedReader dataFile = new BufferedReader(new FileReader(args[0]) );
            String line = dataFile.readLine();
            fileName = line.split(" ")[2];
            width = Integer.parseInt(line.split(" ")[0]);
            height = Integer.parseInt(line.split(" ")[1]);
            // System.out.println(fileName);
            // System.out.println(width);
            // System.out.println(height);
            line = dataFile.readLine();
            numOfPoints = Integer.parseInt(line);
            // System.out.println(numOfPoints);
            
            points = new int[numOfPoints][2];
            for(int i = 0; i < numOfPoints; i++)
            {
                line = dataFile.readLine();
                points[i][0] = Integer.parseInt(line.split(",")[0]);
                points[i][1] = Integer.parseInt(line.split(",")[1]);
                // System.out.println(points[i][0] + "  " + points[i][1]);
            }
               
        
 
        }
        
        catch(FileNotFoundException e) 
        {
            System.out.println("Brak pliku " + args[0]);
        }
        catch(IOException e)
        {
            System.out.println("Blad odczytu pliku " + args[0]);
        }
        
        FileWriter fileToSave = null;
        try
        {
            fileToSave = new FileWriter(new File(fileName));
        
            fileToSave.write("P3\n#Jakub Salamon\n" + String.valueOf(width) + " " + String.valueOf(height) + "\n255\n");
            boolean userPoint = false;
            for(int y = 0; y < height; y++)
            {
                for(int x = 0; x < width; x++)
                {
                    double l2 = eps+999.8;
                    for(int i = 0; i < numOfPoints - 1; i++)
                    {
                        for(int j = 0; j < numOfPoints; j++)
                        {
                            if(j != i)
                            {
                                double l2_1 = Math.pow(points[i][0]-x,2.0) + Math.pow(points[i][1]-y,2.0);
                                double l2_2 = Math.pow(points[j][0]-x,2.0) + Math.pow(points[j][1]-y,2.0);
                                double l2_tmp = Math.abs(l2_1 - l2_2);
                                if(l2_tmp < l2)
                                    l2 = l2_tmp;
                            }
                        }
                    }
                    for(int i = 0; i < numOfPoints; i++)
                    {
                        userPoint = false;
                        if((x == points[i][0]) && (y == points[i][1]))
                        {
                            fileToSave.write("255 0 0 ");
                            userPoint = true;
                            break;
                        }
                    }
                    if(!userPoint)
                    {
                        if(l2 < Math.pow(eps,2.0))
                            fileToSave.write("0 0 0 ");
                        else
                            fileToSave.write("255 255 255 ");
                    }
            
                }
            }
            
        }
        catch(IOException e)
        {
            System.out.println("Blad zapisu do pliku " + fileName);
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