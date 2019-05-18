package com.lee.again;

import java.util.Arrays;

public class PourWater755 {

	public static void main(String[] args) {
		PourWater755 obj = new PourWater755();
//		System.out.println("Result  " + Arrays.toString(obj.pourWater(new int[] { 1,2,3,4,3,2,1,2,3,4,3,2,1}, 10, 2)));
		System.out.println("Result  " + Arrays.toString(obj.pourWater(new int[] { 1,2,3,4,3,2,1,2,3,4,3,2,1}, 10, 5)));
	}
	
    public int[] pourWater(int[] H, int V, int K) {
        while (V-- > 0) droplet: {
            for (int d = -1; d <= 1; d += 2) {
                int i = K, best = K;
                while (0 <= i+d && i+d < H.length && H[i+d] <= H[i]) {
                    if (H[i+d] < H[i]) best = i + d;
                    i += d;
                }
                if (H[best] < H[K]) {
                    H[best]++;
                    break droplet;
                }
            }
            H[K]++;
        }
        return H;
    }

	public int[] pourWater123(int[] heights, int V, int K) {

		while (V > 0) {
			System.out.println(Arrays.toString(heights));
			V--;
			if(V==6){
				System.out.println("123");
			}
			int l = K - 1;
			int r = K + 1;
			
//			if ((l >= 0 && heights[l] > heights[K] && r < heights.length && heights[r] > heights[K])
//					|| (l < 0 && r < heights.length && heights[r] > heights[K])
//					|| (l >= 0 && heights[l] > heights[K] && r >= heights.length)) {
//				heights[K]++;
//				continue;
//			}

			int minL = l;
			int minLV = heights[K];

			int minR = r;
			int minRV = heights[K];
			while (true) {
				if (minLV == heights[K] && minRV == heights[K]) {
					while (l >= 0 && heights[l] == heights[K]) {
						l--;
					}
					while (r < heights.length && heights[r] == heights[K]) {
						r++;
					}
				}
				boolean findCadinate = false;
				while (l >= 0 && heights[l] < heights[K]) {
					if (heights[l] < minLV) {
						minLV = heights[l];
						minL = l;
						findCadinate = true;
					}
					l--;
				}
				while (r < heights.length && heights[r] < heights[K]) {
					if (heights[r] < minRV) {
						minRV = heights[r];
						minR = r;
						findCadinate = true;
					}
					r++;
				}
				
				if(findCadinate){
					break;
				}

				if (minLV == heights[K] && minRV == heights[K]) {
					while (l >= 0 && heights[l] == heights[K]) {
						l--;
					}
					while (r < heights.length && heights[r] == heights[K]) {
						r++;
					}
				}
				if ((l < 0 || heights[l] >= heights[K]) && (r >= heights.length || heights[r] >= heights[K])) {
					break;
				}
				
			}
			if (minLV >= heights[K] && minRV >= heights[K]) {
				heights[K]++;
				continue;
			}
			if (minLV <= minRV) {
				heights[minL]++;
			} else {
				heights[minR]++;
			}
		}
		return heights;
	}

}
