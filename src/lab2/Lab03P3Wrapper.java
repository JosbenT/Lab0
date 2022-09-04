package lab2;

public class Lab03P3Wrapper {
	
	public static boolean isValidSudoku(char[][] board) {
        /*ADD YOUR CODE HERE*/
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				for(int k = 0; k < 9; k++) {
					if(k == j || k == i)
						continue;
					if(board[i][k] == board[i][j]) {
						return false;
					}
					if(board[k][j] == board[i][j]) {
						return false;
					}
				}
				
			}
		}
		return true;
    }
	
	public static void main(String[] args) {

		char[][] test = {{'5','3','.','.','7','.','.','.','.'},
						 {'6','.','.','1','9','5','.','.','.'},
						 {'.','9','8','.','.','.','.','6','.'},
						 {'8','.','.','.','6','.','.','.','3'},
						 {'4','.','.','8','.','3','.','.','1'},
						 {'7','.','.','.','2','.','.','.','6'},
						 {'.','6','.','.','.','.','2','8','.'},
						 {'.','.','.','4','1','9','.','.','5'},
						 {'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println(isValidSudoku(test));
	}

}
