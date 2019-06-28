public class SieveOfEratosthenes {

	public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You need to enter an argument!" +
                    "\nIn IntelliJ, you can do this by clicking on the button with \n`SieveOfEratosthenes` on it" +
                    " > `Edit Configurations...` " +
                    "and provide a number in the `Program arguments` box.");
            return;
        }
		int upperBound = 0;
		boolean[] isNotPrime = new boolean[upperBound];
		for (int i = 0; i <= upperBound; i++) {
			if (isNotPrime[i] == true) {
				continue;
			} else {
				for (int j = i*i; j <= upperBound; j += i){
					isNotPrime[j] = true;
				}
			}
		}
		for (int i = 0; i <= upperBound; i++) {
			if (!isNotPrime[i]) {
				System.out.println(i + " is a prime number.");
			}
		}
	}
}
