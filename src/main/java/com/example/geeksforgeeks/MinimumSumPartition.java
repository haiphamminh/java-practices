package com.example.geeksforgeeks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MinimumSumPartition {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        Scanner scanner = null;
        try {
            inputStream = MinimumSumPartition.class.getClassLoader().getResourceAsStream(
                    "minSumPartition.txt");
            scanner = new Scanner(inputStream);
            int T = scanner.nextInt();
            for (int t = 0; t < T; t++) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                for (int n = 0; n < N; n++) {
                    A[n] = scanner.nextInt();
                }
                System.out.println(minSumPartition(N, A));
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * Reference: https://practice.geeksforgeeks.org/problems/minimum-sum-partition
     *
     * @param n
     * @param a
     * @return
     */
    private static int minSumPartition(int n, int[] a) {
        int i, j;
        int sum = 0;
        for (i = 0; i < n; i++) {
            sum = sum + a[i];
        }
        int temp = sum / 2;
        int[][] b = new int[n + 1][temp + 1];
        for (i = 0; i <= n; i++) {

            for (j = 0; j <= temp; j++) {

                if (j == 0 || i == 0) {
                    b[i][j] = 0;
                } else if (j >= a[i - 1]) {
                    b[i][j] = Math.max(b[i - 1][j], b[i - 1][j - a[i - 1]] + a[i - 1]);
                } else {
                    b[i][j] = b[i - 1][j];
                }
            }
        }
        return sum - 2 * b[n][temp];
    }
}
