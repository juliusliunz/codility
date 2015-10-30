package com.github.juliusliunz.codility.Lesson1;

/*
 * https://codility.com/demo/results/trainingRHQP7X-RX3/
 */
public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(FrogJmp.solution(10, 85, 30));
    }
    public static int solution(int X, int Y, int D) {
        return (Y - X) / D + ((Y - X) % D == 0 ? 0 : 1);
    }
}
