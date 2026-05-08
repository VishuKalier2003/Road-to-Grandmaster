package codeforces.newbie.rating1100;

import java.io.*;
import java.util.*;

public class P2070B {
    public static class FastReader {
        public BufferedReader buffer;
        public StringTokenizer tokenizer;

        public FastReader() {this.buffer = new BufferedReader(new InputStreamReader(System.in));}

        public String next() {
            while(tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {tokenizer = new StringTokenizer(buffer.readLine());}
                catch(IOException e) {e.printStackTrace();}
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            StringBuilder builder = new StringBuilder();
            try {tokenizer = null; builder.append(buffer.readLine());}
            catch(IOException e) {e.printStackTrace();}
            return builder.toString();
        }

        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
    }
    public record Robot(int n, int x, long k, String s) {}
    public static void main(String args[]) {
        FastReader fastReader = new FastReader();
        Robot robots[] = new Robot[fastReader.nextInt()];
        for(int i = 0; i < robots.length; i++)
            robots[i] = new Robot(fastReader.nextInt(), fastReader.nextInt(), fastReader.nextLong(), fastReader.next());
        Arrays.stream(robots).forEach(robot -> System.out.println(countResetTime(robot.n, robot.x, robot.k, robot.s)));
    }

    public static long firstPhase, secondPhase;
    public static long countResetTime(int n, int x, long k, String s) {
        firstPhase = -1;
        for(int i = 0; i < n; i++) {
            x = s.charAt(i) == 'L' ? x-1 : x+1;
            if(x == 0) {
                firstPhase = i+1;
                break;
            }
        }
        return firstPhase == -1 ? 0 : simulateSecondPhase(n, k, s);
    }

    public static long simulateSecondPhase(int n, long k, String s) {
        secondPhase = -1;
        int x = 0;
        for(int i = 0; i < n; i++) {
            x = s.charAt(i) == 'L' ? x-1 : x+1;
            if(x == 0) {
                secondPhase = i+1;
                break;
            }
        }
        return secondPhase == -1 ? 1 : ((k-firstPhase)/secondPhase)+1;
    }
}