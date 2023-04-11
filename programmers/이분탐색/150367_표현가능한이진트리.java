class Solution {
    
    static int treeDepth;

    static int isZeroTree(String subTree) {
        if(subTree.length() == 0)
            return 1;

        int mid = subTree.length() / 2;

        if(subTree.charAt(mid) == '1')
            return 0;

        String leftTree = subTree.substring(0, mid);
        String rightTree = subTree.substring(mid + 1);

        return isZeroTree(leftTree) * isZeroTree(rightTree);
    }
    
    static int canMakeTree(int mid, int currentDepth, String tree) {
        if(currentDepth == treeDepth)
            return 1;

        String leftTree = tree.substring(0, mid);
        String rightTree = tree.substring(mid + 1);
        int subTreeMid = leftTree.length() / 2;

        if(tree.charAt(mid) == '0')
            return isZeroTree(leftTree) * isZeroTree(rightTree);
        
        int leftResult = canMakeTree(subTreeMid, currentDepth + 1, leftTree);
        int rightResult = canMakeTree(subTreeMid, currentDepth + 1, rightTree);

        return leftResult * rightResult;
    }
    
    static int getTreeDepth(int treeLength) {
        
        int i = 1;
        int depth = 0;
        while(true) {
            if(treeLength <= i)
                return depth;
            
            i *= 2;
            depth++;
        }
    }

    static String getOriginalBinary(String binary) {
        StringBuilder sb = new StringBuilder();
        
        int layer = 1;
        int length = binary.length();
        int originalLength = 1;
    
        while(length > originalLength) {
            layer *= 2;
            originalLength += layer;
        }
        
        for(int i = 0 ; i < (originalLength - length) ; i++)
            sb.append("0");
        
        sb.append(binary);
        
        return sb.toString();
    }

    
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        int i = 0;
        for(long number : numbers) {
            String binaryNumber = getOriginalBinary(Long.toBinaryString(number));
            
            if(binaryNumber.length() == 1) {
                answer[i++] = 1;
                continue;
            }
            
            treeDepth = getTreeDepth(binaryNumber.length());

            if(binaryNumber.charAt(binaryNumber.length() / 2) == '0')
                answer[i++] = 0;
            else
                answer[i++] = canMakeTree(binaryNumber.length() / 2, 1, binaryNumber);
        }
        
        return answer;
    }
}