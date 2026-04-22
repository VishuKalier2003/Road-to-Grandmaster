package codeforces.newbie.rating800;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

// https://codeforces.com/problemset/problem/148/A
public class Insomnia {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static int nextInt() throws IOException {
        int c, x = 0;
        do {c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {x = x * 10 + (c - '0');} while((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush();}
    public static void main(String[] args) throws IOException {
        int a = nextInt(), b = nextInt(), c = nextInt(), d = nextInt(), n = nextInt();
        println(solve(new int[]{a,b,c,d}, new int[n+1]));
        flush();
    }

    public static long solve(int x[], int nums[]) {
        for(int i : x) {
            if(i >= nums.length)
                continue;
            nums[i]++;
            for(int j = 2*i; j < nums.length; j += i)
                nums[j]++;
        }
        return Arrays.stream(nums).filter(a -> a > 0).count();
    }
}
