#Problem - Integer to Words

class Solution:
    def convertToWords(self, n):
        if n == 0:
            return "Zero"

        # Define mappings
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]

        def three_digits_to_words(num):
            result = []
            if num >= 100:
                result.append(below_20[num // 100] + " Hundred")
                num %= 100
            if num >= 20:
                result.append(tens[num // 10])
                num %= 10
            if num > 0:
                result.append(below_20[num])
            return " ".join(result)

        # Process the number in groups of three digits
        result = []
        group_index = 0

        while n > 0:
            group = n % 1000
            if group > 0:
                result.append(three_digits_to_words(group) + (" " + thousands[group_index] if thousands[group_index] else ""))
            n //= 1000
            group_index += 1

        return " ".join(reversed(result)).strip()
