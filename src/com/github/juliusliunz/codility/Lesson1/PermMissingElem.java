package com.github.juliusliunz.codility.Lesson1;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(PermMissingElem.solution(new int[]{}));
        System.out.println(PermMissingElem.solution(new int[]{1}));
        System.out.println(PermMissingElem.solution(new int[]{2}));
        System.out.println(PermMissingElem.solution(new int[]{2, 3, 1, 5}));
    }

    /*
     * https://codility.com/demo/results/trainingAU72KN-BG9/
     */
    public static int solution(int[] A) {
        final int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= A[i] ^ (i + 1);
        }
        return sum ^ (n + 1);
    }

    /*
     * https://codility.com/demo/results/trainingUP2CNM-5SM/
     */
    public static int solutionB(int[] A) {
        final int n = A.length;
        long sum = (n + 2L) * (n + 1L) / 2;
        for (int i = 0; i < n; i++) {
            sum -= A[i];
        }
        return (int) sum;
    }

}
