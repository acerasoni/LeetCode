/* You start at index 0 in an array with length 'h'. At each step, you can move to the left, move to the right, or stay in the same place(Note! Stay in the same place also takes one step). How many possible ways are you still at index 0 after you have walked 'n' step?

Example： n = 3
1. right->left->stay
2. right->stay->left
3. stay->right->left
4. stay->stay->stay

Source: https://leetcode.com/discuss/interview-question/416381/google-phone-interview-question-dp
*/

public class Solution {
static Integer numWays = 0;

public static int calculateWays(int h, int n) {
    recur(n, h, 0);
    return numWays;
}

private static void recur(int n, int h, int position) {
    if(n == 0) {
        if(position == 0) numWays++;
        return;
    }

    if(position > 0) recur(n-1, h, position-1);
    if(position < h-1) recur(n-1, h,  position+1);

    recur(n-1, h, position);
}

public static void main(String... args) {
    int result = calculateWays(3, 3);
    System.out.println(result);
  }
}
