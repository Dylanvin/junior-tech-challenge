package com.example.challenge.restservice;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.DoubleUnaryOperator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.challenge.bisection.BisectionMethod;

@RestController
public class BisectionController {

    private static final String template = "The root is: %s!";
    private final AtomicLong counter = new AtomicLong();
    private DoubleUnaryOperator f = (x) -> Math.pow(x, 3) - x - 2;
    private double tolerance = 1e-6;
    private int maxIterations = 30;

    @GetMapping("/bisection")
    public Bisection bisection(@RequestParam(value = "a", defaultValue = "1") int a,
                               @RequestParam(value = "b", defaultValue = "2") int b) {


        double root = BisectionMethod.findRoot(f, a, b, tolerance, maxIterations);
        return new Bisection(counter.incrementAndGet(), root);

    }
}