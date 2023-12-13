package course.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i< n;i++){
            s.append('.');
        };
        for(int i = 0; i < n; i++){
            board.add(s);
        }
        helper(0, res, board, n);
        return res;
    }

    private void helper(int col, List<List<String>> res, List<StringBuilder> board, int n){
        if(col == n){
            String b = board.toString();
            res.add(Collections.singletonList(b));
        }
        for(int row = 0; row < n; row++){
            if(isValid(row, col, board, n)){
                board.get(row).setCharAt(col, 'Q');
                helper(col+1, res, board, n);
                board.get(row).setCharAt(col, '.');
            }
        }
    }

    private boolean isValid(int row, int col, List<StringBuilder> board, int n) {
        for(int c = col; c >= 0; c--){
            if(board.get(row).charAt(c) == 'Q') return false;
        }
        for(int r= row, c = col; r>=0 && c>=0; r--, c--){
            if(board.get(r).charAt(c) == 'Q') return false;
        }
        for(int r= row, c = col; r<n && c>=0; r++, c--){
            if(board.get(r).charAt(c) == 'Q') return false;
        }
        return true;
    }
}
