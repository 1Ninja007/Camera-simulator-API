package org.example.camera.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ShutterSpeed {
    private double value;
    private String label;

    public final ArrayList<Double> shutterValues = new ArrayList<>(Arrays.asList(
            0.00025, 0.0005, 0.001, 0.002, 0.004, 0.008, 0.016, 0.033, 0.066, 0.125, 0.25, 0.5, 1.0,
            2.0, 4.0, 8.0, 15.0, 30.0, 60.0, 120.0, 300.0, 900.0
    ));

    public ShutterSpeed(double value) {
        this.value = value;
        this.label = matchLabel(value);
    }

    public void set(double value){
        this.value = value;
        this.label = matchLabel(value);
    }

    private String matchLabel(double value) {
        String[] shutterLabels = {
                "1/4000", "1/2000", "1/1000", "1/500", "1/250", "1/125", "1/60", "1/30", "1/15", "1/8", "1/4", "1/2", "1\"",
                "2\"", "4\"", "8\"", "15\"", "30\"", "1 min", "2 min", "5 min", "15 min"
        };

        OptionalInt indexOpt = IntStream.range(0, shutterValues.size())
                .filter(i -> value == shutterValues.get(i))
                .findFirst();

        return shutterLabels[indexOpt.getAsInt()];
    }

    public double getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
