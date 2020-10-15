package com.kunal.binaryTree;

import java.io.*;
import java.util.StringTokenizer;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrMaxSum {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
//        int t = in.nextInt();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }

        public int splitArray(int[] nums, int m) {
            int max = 0;
            int sum = 0;
            for (int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }
            int low = max;
            int high = sum;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int pieces = split(nums, mid);
                if (pieces > m) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private int split(int[] nums, int sum) {
            int s = 0;
            int count = 1;
            for (int num : nums) {
                if (s + num > sum) {
                    s = num;
                    count++;
                } else {
                    s += num;
                }
            }
            return count;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
