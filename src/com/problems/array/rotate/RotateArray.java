package com.problems.array.rotate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RotateArray {
	
	public static void main(String[] args) {
		List<long[]> res = new ArrayList<>();
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int testCases;
		try {
			testCases = Integer.parseInt(sc.readLine());
		
		while (testCases-- != 0) {
			String[] sizeAndLimit = sc.readLine().split(" ");
			int n = Integer.parseInt(sizeAndLimit[0]);
			int d = Integer.parseInt(sizeAndLimit[1]);
			long[] arr = new long[n];
			String[] numbers = sc.readLine().split(" ");
			for(int i = 0; i < n; i++) 
				arr[i] = Long.parseLong(numbers[i]);
			long[] rotatedArr = getRotatedArray(arr, d);
			res.add(rotatedArr);
		}
		
		res.forEach(r -> {
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " ");
				if(i == r.length-1)
				    System.out.print("\n");
			}
		});
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static long[] getRotatedArray(long[] arr, int breakPoint) {
		long[] arrToRotate = new long[arr.length - breakPoint];
		long[] arrRemained = new long[breakPoint];
		for (int i = 0; i < arr.length; i++) {
			if (i < breakPoint) {
				arrRemained[i] = arr[i];
			} else {
				arrToRotate[i-breakPoint] = arr[i];
			}
		}
		long[] finalArr = new long[arr.length];
		
		
		for (int i = 0; i < arrToRotate.length; i++) {
			finalArr[i] = arrToRotate[i];
		}
			
		for (int i = (arrToRotate.length); i < (arrRemained.length + arrToRotate.length); i++) {
				finalArr[i] = arrRemained[i-arrToRotate.length];
		}
		return finalArr;
	}
}
