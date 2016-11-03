package com.sharefree.utils;

import java.util.ArrayList;
import java.util.List;

import org.nutz.json.Json;

public class Test {

	private int[] input;

	private int[] record;

	private int key;

	private int sum;

	private int index;

	public Test() {

	}

	public Test(int[] input, int key) {
		this.input = input;
		this.record = new int[input.length];
		this.key = key;
		this.sum = 0;
		this.index = 1;
	}

	public void backtrack(int n) {
		if (n == input.length) {
			return;
		} else {
			for (int i = 0; i <= 1; i++) {
				sum += i * input[n];
				record[n] = i;
				if (sum == key) {
					System.out.print("序号" + index + ":\t");
					for (int j = 0; j <= n; j++) {
						if (record[j] == 1)
							System.out.print(input[j] + "\t");
					}
					index++;
					System.out.println();
				}
				if (sum < key) {
					backtrack(n + 1);
				}
				sum -= i * input[n];
			}
		}
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 2, 2, 3, 4 };
		int key = 8;
		Test test = new Test(input, key);
		test.backtrack(0);
		List<Integer> ff = new ArrayList<Integer>();
		ff.add(1);
		ff.add(2);
		ff.add(2);
		ff.add(2);
		ff.add(3);
		ff.add(4);
		System.out.println(Json.toJson(ff));
		System.out.println(Json.toJson(ff.toArray(new Integer[ff.size()])));
	}

}
