package Assignment;

public class LogicQuestion {

	public static int[][] multiply(int[][] A, int[][] B) {
		int[][] result = new int[A.length][B[0].length];
		int x = A.length, y = A[0].length, z = B[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < z; k++) {
						result[i][j] += A[i][j] * B[j][k];
					}
				}
			}
		}
		return result;
	}
	public int[] diStringMatch(String S) {
         int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
  }
	
