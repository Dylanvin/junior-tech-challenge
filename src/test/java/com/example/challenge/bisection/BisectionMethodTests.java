package com.example.challenge.bisection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.DoubleUnaryOperator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit :: Bisection :: Bisection Method")
class BisectionMethodTests {

    DoubleUnaryOperator f = (x) -> Math.pow(x, 3) - x - 2;
    double tolerance = 1e-6;
    int maxIterations = 100;

    @Test
    @DisplayName("Should find an acceptable root if interval is valid")
    void findRoot_validInterval_shouldFindAnAcceptableRoot() {
        var root = BisectionMethod.findRoot(f, 1, 2, tolerance, maxIterations);
        var root2 = BisectionMethod.findRoot(f, -1, 3, tolerance, maxIterations);
        var root3 = BisectionMethod.findRoot(f, -3, 4, tolerance, maxIterations);

        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);

        Assertions.assertThat(
                        BigDecimal.valueOf(root2)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);

        Assertions.assertThat(
                        BigDecimal.valueOf(root3)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);
    }

    @Test
    @DisplayName("Should find an acceptable root if maxIterations is large enough")
    void findRoot_enoughIterations_shouldFindAnAcceptableRoot() {
        var root = BisectionMethod.findRoot(f, -2, 4, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);

    }

    @Test
    @DisplayName("Should not find an acceptable root if maxIterations is too small")
    void findRoot_notEnoughIterations_shouldNotFindAnAcceptableRoot() {
        int maxIterations = 5;
        var root = BisectionMethod.findRoot(f, -2, 4, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isNotEqualTo(1.521d);

    }

    @Test
    @DisplayName("Should find an acceptable root if tolerance is acceptable")
    void findRoot_acceptableTolerance_shouldFindAnAcceptableRoot() {
        var root = BisectionMethod.findRoot(f, -4, 4, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);
    }

    @Test
    @DisplayName("Should not find an acceptable root if tolerance is unacceptable")
    void findRoot_unacceptableTolerance_shouldNotFindAnAcceptableRoot() {
        double tolerance = 1e-2;
        var root = BisectionMethod.findRoot(f, -4, 4, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isNotEqualTo(1.521d);
    }

    @Test
    @DisplayName("Should find an acceptable root if f is acceptable")
    void findRoot_acceptableEquation_shouldFindAnAcceptableRoot() {
        var root = BisectionMethod.findRoot(f, -8, 8, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isEqualTo(1.521d);
    }

    @Test
    @DisplayName("Should not find an acceptable root if f is unacceptable")
    void findRoot_unacceptableEquation_shouldNotFindAnAcceptableRoot() {
        DoubleUnaryOperator f = (x) -> x - 2;
        var root = BisectionMethod.findRoot(f, -4, 4, tolerance, maxIterations);
        Assertions.assertThat(
                        BigDecimal.valueOf(root)
                                .setScale(3, RoundingMode.HALF_UP)
                                .doubleValue())
                .isNotEqualTo(1.521d);
    }

    @Test
    @DisplayName("Should always return UnsupportedOperationException if interval is not valid")
    void findRoot_validInterval_shouldNotFindAnAcceptableRootAndThrowError() {

        Assertions.assertThatThrownBy(() -> BisectionMethod.findRoot(f, 1, 1, tolerance,
                        maxIterations)).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Error: The following condition is not met: " +
                        "f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0");


        Assertions.assertThatThrownBy(() -> BisectionMethod.findRoot(f, -1, -1, tolerance,
                        maxIterations)).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Error: The following condition is not met: " +
                        "f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0");
    }

    @Test
    @DisplayName("Should always return UnsupportedOperationException if a is larger or equal to b")
    void findRoot_aIsLargerOrEqualTob_shouldNotFindAnAcceptableRootAndThrowError() {

        Assertions.assertThatThrownBy(() -> BisectionMethod.findRoot(f, 2, -1, tolerance,
                        maxIterations)).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Error: a should not be larger or equal to b");

        Assertions.assertThatThrownBy(() -> BisectionMethod.findRoot(f, -2, -2, tolerance,
                        maxIterations)).isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Error: The following condition is not met: " +
                        "f(a) < 0 and f(b) > 0 or f(a) > 0 and f(b) < 0");
    }
}