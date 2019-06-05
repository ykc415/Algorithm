package com.example.algorithm.median_of_two_sorted_arrays

import org.junit.Test

import org.junit.Assert.*

/**
 *
 *
 *      어렵다 ㅈㅈ
 *
        There are two sorted arrays nums1 and nums2 of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

        median = (max(left_part) + min(right_part)) / 2

        You may assume nums1 and nums2 cannot be both empty.
 *
 */
class Solution {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {


        return 0.0
    }




    @Test
    fun testCase1() {
        val num1 = intArrayOf(1, 3)
        val num2 = intArrayOf(2)

        assertEquals(2.0, findMedianSortedArrays(num1, num2),0.01)
    }

    @Test
    fun testCase2() {
        val num1 = intArrayOf(1, 2)
        val num2 = intArrayOf(3, 4)

        assertEquals(2.5, findMedianSortedArrays(num1, num2), 0.01)
    }

    @Test
    fun testCase3() {
        val num1 = intArrayOf()
        val num2 = intArrayOf(1)

        assertEquals(1.0, findMedianSortedArrays(num1, num2), 0.01)
    }

    @Test
    fun testCase4() {
        val num1 = intArrayOf(3)
        val num2 = intArrayOf(-2, -1)

        assertEquals(-1.0, findMedianSortedArrays(num1, num2), 0.01)
    }

}