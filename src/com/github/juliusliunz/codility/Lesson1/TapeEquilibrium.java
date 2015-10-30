package com.github.juliusliunz.codility.Lesson1;

/*
 * https://codility.com/demo/results/trainingGKBSHZ-PH4/
 */

public final class TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println(TapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
    }

    public static int solution(int[] A) {
        final int N = A.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        int tailSum = sum;
        int headSum = 0;
        int diff = Integer.MAX_VALUE;
        int minDiff = diff;
        for (int p = 1; p < N; p++) {
            headSum += A[p - 1];
            tailSum -= A[p - 1];
            diff = Math.abs(headSum - tailSum);
            minDiff = diff < minDiff ? diff : minDiff;
        }
        return minDiff;
    }

}

