package com.github.juliusliunz.codility.Lesson2;

import java.util.Arrays;

/*
 * https://codility.com/demo/results/training6VCAJC-X66/
 *
 * (5, [3,4,4,6,1,4,4]) -> [3, 2, 2, 4, 2]
 * (5, [3,4,4,6,1,6,2]) -> [3, 4, 3, 3, 3]
 * (5, [3,4,4,6,1,6,2,3,3]) -> [3, 4, 5, 3, 3]
 * (1, [1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1] -> [21]
 * (1, [2]) -> [0]
 */
public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println(Arrays.toString(MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 6, 2})));
        System.out.println(Arrays.toString(MaxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 6, 2, 3, 3})));
        System.out.println(Arrays.toString(MaxCounters.solution(1, new int[]{1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1})));
        System.out.println(Arrays.toString(MaxCounters.solution(1, new int[]{2})));
    }

    public static int[] solution(int N, int[] A)
    {
        final int arrayLen = A.length;
        int[] counters = new int[N];

        int currentMax = 0;
        int lastMax = 0;
        for (int i = 0; i < arrayLen; i++) {
            final int idx = A[i] - 1;
            if (idx < N) {
                if (counters[idx] < lastMax) {
                    // only do a lazy-max if the counter is increased in the post-max round
                    counters[idx] = lastMax + 1;
                } else {
                    counters[idx] += 1;
                }
                currentMax = counters[idx] > currentMax ? counters[idx] : currentMax;
            } else {
                lastMax = currentMax;
            }
        }

        for (int i = 0; i < N; i++) {
            // lazy-max for the counters that untouched in the last round
            if (counters[i] < lastMax) {
                counters[i] = lastMax;
            }
        }

        return counters;
    }
}
