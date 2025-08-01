package com.multithreading;

public class SequentialMaxFind {

	public long sequentialMaxFinding(long[] nums, int highIndex) {

		long max = nums[0];

		for (int i = 0; i < highIndex; ++i)
			if (nums[i] > max)
				max = nums[i];

		return max;
	}
}
