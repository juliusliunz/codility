package com.github.juliusliunz.codility.Lesson4;

public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        System.out.println(NumberOfDiscIntersections.solutionA(new int[]{3, 4, 4, 6, 1, 4, 4}));
        System.out.println(NumberOfDiscIntersections.solutionA(new int[]{3, 4, 4, 6, 1, 6, 2}));
        System.out.println(NumberOfDiscIntersections.solutionA(new int[]{3, 4, 4, 6, 1, 6, 2, 3, 3}));
        System.out.println(NumberOfDiscIntersections.solutionA(new int[]{1, 2147483647, 0}));
        System.out.println(NumberOfDiscIntersections.solutionA(new int[]{1, 1, 2, 4, 0, 7, 1}));

        System.out.println(NumberOfDiscIntersections.solutionB(new int[]{3, 4, 4, 6, 1, 4, 4}));
        System.out.println(NumberOfDiscIntersections.solutionB(new int[]{3, 4, 4, 6, 1, 6, 2}));
        System.out.println(NumberOfDiscIntersections.solutionB(new int[]{3, 4, 4, 2, 1, 6, 2, 3, 3}));
        System.out.println(NumberOfDiscIntersections.solutionB(new int[]{1, 2147483647, 0}));
        System.out.println(NumberOfDiscIntersections.solutionB(new int[]{1, 1, 2, 4, 0, 7, 1}));
    }

    /*
     * https://codility.com/demo/results/trainingS5F3EZ-T62/
     * Correctness: 100
     * Performance: 62
     * Overall:     81
     */
    public static int solutionA(int[] A) {
        final int discNumber = A.length;
        int result = 0;

        for (int i = 0; i < discNumber; i++) {
            if (result > 10000000) break;
            int skipSteps = Math.min(discNumber - i - 1, A[i]);
            result += skipSteps;
            for (int j = i + 1 + skipSteps; j < discNumber; j++) {
                result += (A[i] + A[j] >= j - i) ? 1 : 0;
            }
        }
        return (result > 10000000 ? -1 : result);
    }

    /*
       https://codility.com/demo/results/training3VYR5U-47G/
       scores: 100
     */

    public static int solutionB(int[] A) {
        final int discNumber = A.length;

        int[] discStartEvents = new int[discNumber];
        int[] discEndEvents = new int[discNumber];

        for (int i = 0; i < discNumber; i++) {
            discStartEvents[Math.max(i - A[i], 0)]++;
            if (A[i] > Integer.MAX_VALUE - i) {
                discEndEvents[Math.min(Integer.MAX_VALUE, discNumber - 1)]++;
            } else {
                discEndEvents[Math.min(i + A[i], discNumber - 1)]++;
            }
        }

        int result = 0;
        int activeDiscCount = 0;
        for (int i = 0; i < discNumber; i++) {
            activeDiscCount += discStartEvents[i];

            /*
            while (discEndEvents[i] > 0) {
                result += activeDiscCount - 1;
                activeDiscCount--;
                discEndEvents[i]--;
            }

            => (activeDiscCount - 1) + (activeDiscCount - 2) +... (activeDiscCount - discEndEvents[i])
            => the formula below
            */
            int endingNumber = discEndEvents[i];
            result += activeDiscCount * endingNumber - endingNumber * (endingNumber + 1) / 2;
            activeDiscCount -= endingNumber;

            if (result > 10000000) break;
        }
        return (result > 10000000 ? -1 : result);
    }
}
