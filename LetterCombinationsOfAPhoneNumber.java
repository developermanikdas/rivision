// 17. Letter Combinations of a Phone Number
class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String possibleLetters = KEYPAD[digits.charAt(index) - '0'];
        for (char ch : possibleLetters.toCharArray()) {
            path.append(ch);
            backtrack(result, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
}
