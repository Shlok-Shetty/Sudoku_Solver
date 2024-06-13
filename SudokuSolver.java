public class SudokuSolver {
    public static void main(String[] args) {
        int sudoku[][]={{8,0,0,0,0,7,0,9,0},
                        {0,2,9,0,0,4,0,0,6},
                        {3,0,0,2,0,0,0,0,0},
                        {0,0,0,0,0,6,5,0,0},
                        {0,1,7,4,0,0,0,3,0},
                        {2,0,0,0,0,0,0,0,0},
                        {0,9,4,1,0,0,0,7,0},
                        {0,0,8,0,0,0,0,0,0},
                        {0,0,0,0,7,0,0,0,3}};
        if((sudsolver(sudoku, 0,0))){
            for(int i =0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
                System.out.println();
            }
        }
        else{
            System.out.println("NO solution exists");
        }
    }
    public static boolean sudsolver(int sudoku[][],int row,int column){
        if(row==9){
            return true;
        }
        int nextRow = row;
        int nextColumn = column+1;
        if(nextColumn == 9){
            nextRow = row+1;
            nextColumn = 0;
        }
        if(sudoku[row][column]!= 0){
            return sudsolver(sudoku, nextRow, nextColumn);
        }
        
        
        for(int i=1;i<=9;i++){
            if(isSafe(sudoku,i,row,column)){
                sudoku[row][column] = i;
                if(sudsolver(sudoku, nextRow, nextColumn)){
                    return true;
                }
                sudoku[row][column] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int sudoku[][], int digit , int row, int column){
        //rowwise
        for(int i=0;i<9;i++){
            if(sudoku[i][column]== digit){
                return false;
            }
        }
        //columnwise
        for(int i=0;i<9;i++){
            if(sudoku[row][i]== digit){
                return false;
            }
        }
        //gridwise
        int sr = (row/3)*3;
        int sc = (column/3)*3;
        for(int i =sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
}
