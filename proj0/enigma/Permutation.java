package enigma;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author
 */
public class Permutation {

<<<<<<<HEAD
    /**
     * Set this Permutation to that specified by CYCLES, a string in the
     * form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     * is interpreted as a permutation in cycle notation.  Characters in the
     * alphabet that are not included in any cycle map to themselves.
     * Whitespace is ignored.
     */
    private Alphabet alphabet;
    private String cycles;

    Permutation(String cycles, Alphabet alphabet) {
        this.alphabet = alphabet;
        this.cycles = cycles;
        // FIXME - Assign any additional instance variables.
    }

    /**
     * Return the value of P modulo the size of this permutation.
     */
    private final int wrap(int p) {
=======
        /** Set this Permutation to that specified by CYCLES, a string in the
         *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
         *  is interpreted as a permutation in cycle notation.  Characters in the
         *  alphabet that are not included in any cycle map to themselves.
         *  Whitespace is ignored. */
    public Permutation(String cycles, Alphabet alphabet) {
            _alphabet = alphabet;
            // FIXME - Assign any additional instance variables.
        }

        /** Return the value of P modulo the size of this permutation. */
        final int wrap ( int p){
>>>>>>>43e a2f46b4ca435c2dd816136bc9946bee998f18
            int r = p % size();
            if (r < 0) {
                r += size();
            }
            return r;
        }

        /**
         * Returns the size of the alphabet I permute.
         */
        public int size () {
            return this.alphabet.size();
            // FIXME - How do we ask the alphabet for its size?
        }

        /**
         * Return the index result of applying this permutation to the character
         * at index P in ALPHABET.
         */
        public int permute ( int p){
            // NOTE: it might be beneficial to have one permute() method always call the other
            char charAlpha = this.alphabet.toChar(p);
            return this.cycles.indexOf(permute(charAlpha));  // FIXME - How do we use our instance variables to get the index that P permutes to?
        }

        /**
         * Return the index result of applying the inverse of this permutation
         * to the character at index C in ALPHABET.
         */
        public int invert ( int c){
            // NOTE: it might be beneficial to have one invert() method always call the other
            char charAlpha = this.alphabet.toChar(c);
            return this.cycles.indexOf(invert(charAlpha));  // FIXME - How do we use our instance variables to get the index that C inverts to?
        }

        /**
         * Return the character result of applying this permutation to the index
         * of character P in ALPHABET.
         */
        public char permute ( char p){
            char openPar = '(';
            char closedPar = ')';
            if (this.cycles.indexOf(p) == -1) {
                return p;
            } else if ((this.cycles.charAt(this.cycles.indexOf(p) + 1)) == closedPar) {
                for (int i = this.cycles.indexOf(closedPar); i == this.cycles.indexOf(openPar); i--) {
                    return this.cycles.charAt(i + 1);
                }
                // NOTE: it might be beneficial to have one permute() method always call the other
            } else {
                return this.cycles.charAt(this.cycles.indexOf(p + 1));
                ;  // FIXME - How do we use our instance variables to get the character that P permutes to?
            }
        }


        /** Return the character result of applying the inverse of this permutation
         * to the index of character P in ALPHABET. */
        public char invert ( char c){
            // NOTE: it might be beneficial to have one invert() method always call the other
            char openPar = '(';
            char closedPar = ')';
            if (this.cycles.indexOf(c) == -1) {
                return c;
            } else if ((this.cycles.charAt(this.cycles.indexOf(c) - 1)) == openPar) {
                for (int i = this.cycles.indexOf(openPar); i == this.cycles.indexOf(closedPar); i++) {
                    return this.cycles.charAt(i - 1);
                }
            } else {
                return this.cycles.charAt(this.cycles.indexOf(p - 1));
            }
        }
        // FIXME - How do we use our instance variables to get the character that C inverts to

        /** Return the alphabet used to initialize this Permutation. */
        public Alphabet alphabet () {
            return _alphabet;
        }
    }
    }

    /** Alphabet of this permutation. */

    // FIXME - How do we store which letter permutes/inverts to which?

    // FIXME: ADDITIONAL FIELDS HERE, AS NEEDED

    // Some starter code for unit tests. Feel free to change these up!
    // To run this through command line, from the proj0 directory, run the following:
    // javac enigma/Permutation.java enigma/Alphabet.java enigma/CharacterRange.java enigma/EnigmaException.java
    // java enigma/Permutation
    public static void main(String[] args) {
        Permutation perm = new Permutation("(ABCDEFGHIJKLMNOPQRSTUVWXYZ)", new CharacterRange('A', 'Z'));
        System.out.println(perm.size() == 26);
        System.out.println(perm.permute('A') == 'B');
        System.out.println(perm.invert('B') == 'A');
        System.out.println(perm.permute(0) == 1);
        System.out.println(perm.invert(1) == 0);
    }

