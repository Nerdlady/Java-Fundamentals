package com.company._04Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] steps;
    private int distance;

    public Lake(int... steps) {
        this.steps = steps;
        this.distance = 2;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int startIndex = 0;
            private int mulriplier = 0;
            @Override
            public boolean hasNext() {
                if (this.startIndex + (mulriplier *distance) >= steps.length && startIndex <1){
                    mulriplier =0;
                    startIndex++;
                }

                int currentPossition = this.startIndex + (mulriplier *distance);
                return currentPossition < steps.length;
            }

            @Override
            public Integer next() {
                return steps[this.startIndex + (mulriplier++ *distance)];
            }
        };
    }
}
