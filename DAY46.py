#Module 6 - Hashing
#Problem 5 - Day46 - Two Sum - Union of Arrays with Duplicates

class Solution:
    def findUnion(self, a, b):
        union_set = set(a)
        union_set.update(b)
        
        return len(union_set)


