#Problem - Longest Prefix Suffix

class Solution:
    def longestPrefixSuffix(self, s):
        n = len(s)
        lps = [0] * n  # LPS array
        length = 0  # Length of the previous longest prefix suffix
        i = 1  # Start from the second character

        while i < n:
            if s[i] == s[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]  # Go back to the previous possible prefix
                else:
                    lps[i] = 0
                    i += 1

        return lps[-1]  # The last value in the LPS array

