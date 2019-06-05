package com.example.algorithm.longest_palindromic_substring

import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalArgumentException

class Solution {

    /**
     *  Given a string s, find the longest palindromic substring in s.
     *  You may assume that the maximum length of s is 1000.
     *
     *  @see palindrome 회문(回文) 또는 팰린드롬(palindrome)은 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말이다.
     *  보통 낱말 사이에 있는 띄어쓰기나 문장 부호는 무시한다.
     *
     *  @sample 기러기
     */
    fun longestPalindrome(s: String): String {
        if(s.length > 1000) throw IllegalArgumentException("You may assume that the maximum length of s is 1000.")

        var result = ""

        s.forEachIndexed { index, c ->
            (index + 1 .. s.length).forEach {
                val str = s.substring(index, it)

                if(isPalindrome(str)) {
                    if(result.length < str.length) {
                        result = str
                    }
                }
            }
        }

        return result
    }

    fun isPalindrome(s: String) : Boolean {

        val isEven = s.length % 2 == 0

        if(isEven) {
            (0 until s.length / 2).forEach {
                if(s[it] != s[s.length - it - 1]) return false
            }
        } else { // Odd
            (0 until (s.length - 1) / 2 ).forEach {
                if(s[it] != s[s.length - it - 1]) return false
            }
        }

        return true
    }

    @Test fun isPalindromeTest1() = assertTrue(isPalindrome("aba"))

    @Test fun isPalindromeTest2() = assertTrue(isPalindrome("a"))

    @Test fun isPalindromeTest3() = assertTrue(isPalindrome("abba"))

    @Test fun isPalindromeTest4() = assertFalse(isPalindrome("abc"))

    @Test fun isPalindromeTest5() = assertTrue(isPalindrome("abcba"))


    /**
        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
     */
    @Test
    fun testCase1() {
        val input = "babad"
        val expected = "bab"
        val expected1 = "aba"

        val output = longestPalindrome(input)

        assertTrue(expected == output || expected1 == output)
    }

    @Test
    fun testCase2() {
        val input = "cbbd"
        val expected = "bb"

        assertEquals(expected, longestPalindrome(input))
    }
}