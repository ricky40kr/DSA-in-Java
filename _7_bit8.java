// Subarray with given XOR

import java.util.ArrayList;
import java.util.HashMap;

public class _7_bit8 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(2);
        A.add(2);
        A.add(6);
        A.add(4);

        int B = 6;

        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int ans = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            xor ^= i;
            if (xor == B)
                ans++;

            if (map.containsKey(xor ^ B)) {
                ans += map.get(xor ^ B);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return ans;
    }

}
