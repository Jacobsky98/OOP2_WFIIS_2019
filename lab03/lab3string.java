/**
* Klasa pozwalajaca sprawdzac wlasciowosci stringow
*/
public class lab3string
{
    /**
    * Metoda zwracajaca ilosc znakow w wejsciowym Stringu
    * @param str String do obliczenia jego ilosci znakow
    * @return dlugosc String
    */
    public static int dlugosc(String str)
    {
        return str.length();
    }

    /**
    * Metoda liczaca ilosc wystapien znaku chr w Stringu str
    * @param str String do sprawdzenia
    * @param chr znak ktorego ilosc wystapien chcemy obliczyc
    * @return ilosc wystapien znaku chr w Stringu str
    */
    public static int ile_razy_literka_wystepuje(String str, char chr)
    {
        int howMany = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == chr)
                howMany++;
        }
        return howMany;
    }

    /**
    * Metoda sprawdzajaca czy wejsciowe Stringi sa takie same
    * @param str1 Pierwszy String do porownania
    * @param str2 Drugi String do porownania
    * @return true jezeli sa takie same lub false jezeli nie sa
    */
    public static boolean czy_takie_same(String str1, String str2)
    {
        return str1.equals(str2);
    }
    
    /**
    * Metoda odwracajaca Stringi
    * @param str String do odwrocenia
    * @return odwrocony String wejsciowy str
    */
    public static String wspak(String str)
    {
        char [] charTab = new char[str.length()];
        for(int i = 0; i < str.length(); i++)
        {
            charTab[i] = str.charAt(str.length()-i-1);
        }
        return new String(charTab);
    }

    /**
    * Metoda sprawdzajaca czy dany String jest plaindromem
    * @param str String do sprawdzenia
    * @return true jezeli String jest plaindromem lub false jezeli nie jest
    */
    public static boolean czy_plaindrom(String str)
    {
        return str.equals(wspak(str));
    }

    /**
    * Metoda sprawdzajaca czy wejsciowy String jest zlozony z kolejno wystepujacych po sobie znakach
    * @param str String do sprawdzenia
    * @return true jezeli String spelnia zalozenia lub false jezeli nie
    */
    public static boolean czy_abecadlowe(String str)
    {
        for(int i = 1; i < str.length(); i++)
        {
            if(str.charAt(i) != (char)((int)str.charAt(i-1) + 1))
                return false;
        }
        return true;
    }

    /**
    * Metoda kodujaca wejsciowy String za pomoca kodowania rot13
    * @param str String do zakodowania
    * @return zakodowany String
    */
    public static String rot13(String str)
    {
        char [] charTab = new char[str.length()];
        for(int i = 0; i < str.length(); i++)
        {
            if((str.charAt(i) >= 'A' && str.charAt(i) <= 'M') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'm'))
                charTab[i] = (char)((int)str.charAt(i) + 13);
            else if((str.charAt(i) >= 'N' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'n' && str.charAt(i) <= 'z'))
                charTab[i] = (char)((int)str.charAt(i) - 13);
            else 
                charTab[i] = str.charAt(i);
        }
        return new String(charTab);
    }
}
