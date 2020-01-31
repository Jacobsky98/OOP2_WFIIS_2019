/**
* Klasa pozwalajaca sprawdzac wlasciowosci Stringow
*/
public class lab3string
{
    /**
    * This method returns length of input String
    * @param str String to count length
    * @return length of str
    */
    public static int dlugosc(String str)
    {
        return str.length();
    }

    /**
    * This method count how many characters chr String str have
    * @param str String to check
    * @param chr character which quantity is counting
    * @return quantity of character chr in String str
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
    * This method check if both input strings are equal
    * @param str1 First string to compare
    * @param str2 Second string to compare
    * @return true if they are equal or false if not
    */
    public static boolean czy_takie_same(String str1, String str2)
    {
        return str1.equals(str2);
    }
    
    /**
    * This method reverse input string
    * @param str string to reverse
    * @return reversed input string
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
    * This method check if input string is a plaindrom
    * @param str string to check
    * @return true if input string is a plaindrom or false if not
    */
    public static boolean czy_plaindrom(String str)
    {
        return str.equals(wspak(str));
    }

    /**
    * This method check if input string is 
    * @param str string to check
    * @return true if input string 
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
    * This method code input string with rot13 encoding
    * @param str string to code
    * @return encodede string
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
