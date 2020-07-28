#Answer to the question no 1 of Bongo’s Android Developer written test.

#Problem
Write a function that detects if two strings are anagram e.g. ‘bleat’ and ‘table’ are
anagrams but ‘eat’ and ‘tar’ are not.

#Write a function for checking two string are anagram.

 private static boolean areAnagram(char[] str1, char[] str2) 
    { 
        // Get lenghts of both strings 
        int n1 = str1.length; 
        int n2 = str2.length; 
  
        // If length of both strings is not same, 
        // then they cannot be anagram 
        if (n1 != n2) 
            return false; 
  
        // Sort both strings 
        Arrays.sort(str1); 
        Arrays.sort(str2); 
  
        // Compare sorted strings 
        for (int i = 0; i < n1; i++) 
            if (str1[i] != str2[i]) 
                return false; 
  
        return true; 
    } 

#Write a main function for checking two string are anagram.
public static void main(String[] args) {
        // TODO code application logic here
       Scanner myObj = new Scanner(System.in);
       
       System.out.println("Enter First String");
       
         String input1 = myObj.nextLine(); 
         System.out.println("Enter Second String");
         String input2 =myObj.nextLine() ; 
  
        // convert String to character array 
        // by using toCharArray 
       
         char str1[] =input1.toCharArray(); 
        char str2[] =input2.toCharArray() ; 
        if (areAnagram(str1, str2)) 
            System.out.println("The two strings are anagram of each other"); 
        else
            System.out.println("The two strings are not anagram of each other"); 
    }

#Unit test Of function.

//Test of main method, of class StringAngram.

     
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StringAngram.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
//Test of areAnagram method, of class StringAngram.

     
    @Test
    public void testAreAnagram() {
        System.out.println("areAnagram");
        char[] str1 = null;
        char[] str2 = null;
        boolean expResult = false;
        boolean result = StringAngram.areAnagram(str1, str2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

