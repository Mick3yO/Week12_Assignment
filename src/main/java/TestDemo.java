import java.util.Random;

public class TestDemo {
    // Adds two positive numbers together
    public int addPositive(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
        return a + b;
    }

    // Returns the square of a random number between 1 and 10
    public int randomNumberSquared() {
        return getRandomInt() * getRandomInt();
    }

    // Generates a random integer between 1 and 10
    // This method has package visibility for testing purposes
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}

