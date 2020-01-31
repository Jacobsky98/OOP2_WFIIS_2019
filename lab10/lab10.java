import java.io.*;
import java.util.*;
 
public class lab10 {
	public static void main(String[] args) {
		String nazwaPliku = "slownik.txt";
		boolean saveOpened = false;

		try 
		{
			if(args.length < 1) 
				throw new Exception();
		} 
		catch (Exception e) 
		{
			System.out.println("Zly sposob uruchomienia. Uruchom program poleceniem: java lab8 add slowo1 slowo2 lub slowo1 lub del slowo1");
			return;
		}
		BufferedWriter saveData = null;
		ArrayList <String> data = new ArrayList<String>();
		try
		{
			BufferedReader dataFile = new BufferedReader(new FileReader(nazwaPliku) );
			String line = dataFile.readLine();
			while(line != null) 
			{
				data.add(line);
				line = dataFile.readLine();
			}
		}
		catch(FileNotFoundException e) 
		{
			try
			{
				saveData = new BufferedWriter(new FileWriter(nazwaPliku));
				saveOpened = true;
			}
			catch(IOException er) 
			{
				System.out.println("Blad wczytywania pliku" + nazwaPliku);
			}
		}
		catch(IOException e) 
		{
			System.out.println("Blad wczytywania pliku" + nazwaPliku);
		}

		if(saveOpened == false)
		{
			try
			{
				saveData = new BufferedWriter(new FileWriter(nazwaPliku));
				saveOpened = true;
			}
			catch(IOException er) 
			{
				System.out.println("Blad wczytywania pliku" + nazwaPliku);
			}
		}

		if(args[0].toString().equals("add"))
		{
			int wordIndex = -1;
			String line = args[1] + "," + args[2] + ";";
			for(int i = 0; i < data.size(); i++)
			{
				if(data.get(i).contains(args[1]))
					wordIndex = i;
			}

			if(wordIndex != -1)
				System.out.println("Takie slowo jest juz w slowniku");
			else
				data.add(line);
			
		}
		else if(args[0].toString().equals("del"))
		{
			int wordIndex = -1;
			for(int i = 0; i < data.size(); i++)
			{
				if(data.get(i).contains(args[1]))
					wordIndex = i;
			}

			if(wordIndex != -1)
			{
				data.remove(wordIndex);
				System.out.println("Usunieto slowo " + args[1].toString() + " w slowniku");
			}
			else
				System.out.println("Nie znaleziono slowa " + args[1].toString() + " w slowniku");

		}
		else
		{
			int wordIndex = -1;
			for(int i = 0; i < data.size(); i++)
			{
				if(data.get(i).contains(args[0]))
					wordIndex = i;
			}

			if(wordIndex != -1)
			{	
				String line = data.get(wordIndex);
				if(line.substring(0, line.indexOf(',')).equals(args[0]))
					System.out.println(line.substring(line.indexOf(',')+1, line.indexOf(';')));
				else
					System.out.println(line.substring(0, line.indexOf(',')));
			}
			else
				System.out.println("Nie znaleziono slowa " + args[0].toString() + " w slowniku");
		}

		try
		{
			for(int i = 0; i < data.size(); i++)
			{
				saveData.write(data.get(i));
				saveData.newLine();
			}
		}
		catch(IOException e)
		{
			System.out.println("Blad zapisu do pliku " + nazwaPliku);
		}
		finally
		{
			try
			{
				saveData.close();
			}
			catch(IOException e)
			{
				System.out.println("Blad zamykania pliku");
			}
		}
			

	
}
}