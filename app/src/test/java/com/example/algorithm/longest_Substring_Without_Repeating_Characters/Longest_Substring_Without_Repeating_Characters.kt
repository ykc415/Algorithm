package com.example.algorithm.longest_Substring_Without_Repeating_Characters

import org.junit.Test

import org.junit.Assert.*


/**
 *  find the length of the longest substring without repeating characters.
 *  반복되는 글자 없는 가장 긴 서브스트링
 */

internal class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var length = 0

        s.forEachIndexed { index, c ->
            val set = linkedSetOf(c)

            (index + 1 until s.length).map {
                s[it]
            }.takeWhile {
                !set.contains(it).apply {
                    set.add(it)
                }
            }.toMutableList()
                .apply {
                    add(0, c)
                }.takeIf {
                    it.toSet().size == it.size
                }.apply {
                    val size = this?.size ?: 0
                    if (length < size) {
                        length = size
                    }
                }
        }

        return length
    }


    /**
     *    abc'abc'bb
     *    pw'wke'w
     */
    @Test
    fun testCase1() {
        val input = "abcabcbb"
        val expected_length = 3

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase2() {
        val input = "bbbbb"
        val expected_length = 1

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase3() {
        val input = "pwwkew"
        val expected_length = 3

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase4() {
        val input = " "
        val expected_length = 1

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }


    @Test
    fun testCase5() {
        val input = "c"
        val expected_length = 1

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase6() {
        val input = "aab"
        val expected_length = 2

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase7() {
        val input = "dvdf"
        val expected_length = 3

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }

    @Test
    fun testCase8() {
        val input = "cdd"
        val expected_length = 2

        assertEquals(expected_length, lengthOfLongestSubstring(input))
    }
}