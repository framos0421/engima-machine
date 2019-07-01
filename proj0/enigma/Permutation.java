package enigma;
import java.util.*;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author
 */
public class Permutation {

    /** Alphabet of this permutation. */
    private Alphabet _alphabet;
    private String _cycles; // A string to store the permutation cycle.


    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters in the
     *  alphabet that are not included in any cycle map to themselves.
     *  Whitespace is ignored. */
    public Permutation(String cycles, Alphabet alphabet) {
        _alphabet = alphabet;
        _cycles = cycles;
        
        /* Step 1: Save cycles to instance variable _cycles. */
    }

    /** Return the value of P modulo the size of this permutation. */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /** Returns the size of the alphabet I permute. */
    public int size() {
        return _alphabet.size();
        /* Step 2: Return the size of _alphabet. Look at Alphabet.java
           to find function. */
    }

    /** Return the character result of applying this permutation to the index
     * of character P in ALPHABET. */
    public char permute(char p) {
        /* Step 3a: Find where char p is in _cycles.
           HINT: use _cycles.indexOf() to find the index of this character. */
        int index = _cycles.indexOf(p);
        if (index == -1) {
            return p;
        }
        /* Step 3b: if character p is not in string, return p.
                    HINT: what does indexOf return? */

        /* Step 3c: Find the next character.
           HINT: use _cycles.charAt() to find the character at a given index.*/
        char nextChar = _cycles.charAt(index + 1);

        /* Step 3d: Check if next character is inside the alphabet.
           HINT: use _alphabet.contains() to check this. */
        boolean inAlphabet = _alphabet.contains(nextChar);

        if (inAlphabet == true) {
            return nextChar; /* Step 3e: return the next character. */
        } else {
            while (_alphabet.contains(_cycles.charAt(index)) == true) {
                index--;
            }
            return _cycles.charAt(index + 1);
        }
    }
            /* Step 3f: Iterate index backwards until you see a '('.
               Return the character following that '('.

               HINT: While charAt(index) is still in the alphabet...
                     continue searching */

    /** Return the index result of applying this permutation to the character
     *  at index P in ALPHABET. */
    public int permute(int p) {
        char atIndex = _alphabet.toChar(wrap(p));
        return _alphabet.toInt(permute(atIndex));
    	/* Step 4: find a way to use permute(char p) to permute our input int. */
    }

    /** Return the character result of applying the inverse of this permutation
     * to the index of character P in ALPHABET. */
    public char invert(char c) {
        /* Step 5a: Find where char c is in _cycles.
           HINT: use _cycles.indexOf() to find the index of this character.*/
        int index = _cycles.indexOf(c);

 	/* Step 5b: if character c is not in string, return c.
                    HINT: what does indexOf return? */
 	    if (index == -1){
 	        return c;
        }

        /* Step 5c: Find the prevous character.
           HINT: use _cycles.charAt() to find the character at a given index.*/
        char prevChar = _cycles.charAt(index - 1);

        /* Step 5d: Check if previous character is inside the alphabet.
           HINT: use _alphabet.contains() to check this. */
        boolean inAlphabet = _alphabet.contains(prevChar);

        if (inAlphabet == true) {
            return prevChar;/* Step 5e: return the previous character. */
        } else {
            //while (inAlphabet == true){
            while (_alphabet.contains(_cycles.charAt(index)) == true){
                index++;
            }
            return _cycles.charAt(index - 1);/* Step 5f: Iterate index forwards until you see a ')'.
               Return the character preceding that ')'.

               HINT: While charAt(index) is still in the alphabet...
                     continue searching */
        }
    }

    /** Return the index result of applying the inverse of this permutation
     *  to the character at index C in ALPHABET. */
    public int invert(int c) {
        char atIndex = _alphabet.toChar(wrap(c));
        return _alphabet.toInt(invert(atIndex));
    	/* Step 6: find a way to use invert(char c) to invert our input int. */
    }

    /** Return the alphabet used to initialize this Permutation. */
    public Alphabet alphabet() {
        return _alphabet;
    }

    // Some starter code for unit tests. Feel free to change these up!
    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Permutation
    public static void main(String[] args) {
        Permutation perm = new Permutation("(ABCDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        System.out.println(perm.size() == 26);
        System.out.println(perm.permute('Z'));
        System.out.println(perm.invert('A'));
        System.out.println(perm.permute(0) == 1);
        System.out.println(perm.invert(1) == 0);
    }
}
