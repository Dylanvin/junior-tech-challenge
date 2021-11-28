package com.example.challenge.bisection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.DoubleUnaryOperator;

public class BisectionMethod {

    private static final Logger log = LoggerFactory.getLogger(BisectionMethod.class);

    private BisectionMethod() {
        throw new IllegalStateException("Class should not be instantiated");
    }

    public static double findRoot(
            DoubleUnaryOperator f,
            double a,
            double b,
            double tolerance,
            int maxIterations
    ) {
        if (f.applyAsDouble(a) >= 0 && f.applyAsDouble(b) >= 0 ||
                f.applyAsDouble(a) < 0 && f.applyAsDouble(b) < 0) {
            log.error("Error: The following condition is not met: " +
                    "f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0");
            throw new UnsupportedOperationException("Error: The following condition is not met: " +
                    "f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0");

        }

        if (a > b) {
            log.error("Error: a should not be larger or equal to b");
            throw new UnsupportedOperationException("Error: a should not be larger or equal to b");

        }

        double c;
        for (int i = 0; i <= maxIterations; i++) {
            c = (a + b) / 2.0;
            if ((f.applyAsDouble(c) == 0.0) || ((b - a) / 2.0 < tolerance)) {
                log.info("Info: Found root.");

                return c;
            }
            if ((f.applyAsDouble(c) > 0) == (f.applyAsDouble(a) > 0)) {
                a = c;
            } else {
                b = c;
            }
        }
        log.info("Info: Root not found: Returning -100.00.");
        return -100.00;
    }

}
