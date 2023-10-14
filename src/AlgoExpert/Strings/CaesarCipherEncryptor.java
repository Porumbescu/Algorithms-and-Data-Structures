package AlgoExpert.Strings;

// Caesar Cipher Encryptor
// Difficulty: Easy     Category: Strings

// Given a non-empty string of lowercase letters and a non-negative integer
// representing a key, write a function that returns a new string obtained by
// shifting every letter in the input string by k positions in the alphabet,
// where k is the key.

// Note that letters should "wrap" around the alphabet; in other words, the
// letter 'z' shifted by one should return the letter 'a'.

public class CaesarCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int newKey = key % 26;
        char[] chars = str.toCharArray();
        for(char c : chars){
            int nr = alphabet.indexOf(c) + newKey;
            if(nr <= 25){
                result.append(alphabet.charAt(nr));
            }
            else{
                result.append(alphabet.charAt(nr - 26));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String test = "xyz";
        int shift = 2;

        System.out.println("Original: " + test);
        System.out.println("Encrypted: " + caesarCypherEncryptor(test, shift));
    }
}
