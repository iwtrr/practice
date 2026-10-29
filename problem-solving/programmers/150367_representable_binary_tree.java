// https://school.programmers.co.kr/learn/courses/30/lessons/150367

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = canBeRepresentedAsBinaryTree(numbers[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean canBeRepresentedAsBinaryTree(long number) {
        String binary = Long.toBinaryString(number);
        String paddedBinary = padToFullBinaryTreeSize(binary);

        return isValidBinaryTree(paddedBinary, 0, paddedBinary.length() - 1, true);
    }

    private String padToFullBinaryTreeSize(String binary) {
        int treeSize = 1;
        int binaryLength = binary.length();

        while (treeSize < binaryLength) {
            treeSize = treeSize * 2 + 1;
        }
        return "0".repeat(treeSize - binaryLength) + binary;
    }

    private boolean isValidBinaryTree(String binary, int left, int right, boolean parentExists) {
        int mid = left + (right - left) / 2;
        boolean currentExists = binary.charAt(mid) == '1';

        if (!parentExists && currentExists) {
            return false;
        }

        if (left == right) {
            return true;
        }

        return isValidBinaryTree(binary, left, mid - 1, currentExists)
                && isValidBinaryTree(binary, mid + 1, right, currentExists);
    }
}