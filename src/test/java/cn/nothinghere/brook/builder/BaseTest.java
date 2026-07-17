package cn.nothinghere.brook.builder;

import java.security.SecureRandom;

public class BaseTest {
    public static final int LOOP = 100;
    protected static final SecureRandom RANDOM = new SecureRandom();

    protected static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    protected static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }
}
