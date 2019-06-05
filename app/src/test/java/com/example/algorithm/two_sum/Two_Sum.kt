package com.example.algorithm.two_sum

import org.junit.Test

import org.junit.Assert.*

class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        (0 until nums.size).forEach { i ->
            (i + 1 until nums.size).forEach { j ->
                if(nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }

        return intArrayOf()
    }

    /**
            Given nums = [2, 7, 11, 15], target = 9,
            Because nums[0] + nums[1] = 2 + 7 = 9,
            return [0, 1].
     */
    @Test
    fun testCase1() {
        val given_nums = intArrayOf(2, 7, 11, 15)
        val target = 9

        val expected = intArrayOf(0, 1)

        assertArrayEquals(expected, twoSum(given_nums, target))
    }

}