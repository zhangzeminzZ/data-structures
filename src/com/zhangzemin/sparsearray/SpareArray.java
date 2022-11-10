package com.zhangzemin.sparsearray;

public class SpareArray {
    private static final int ROW_LENGTH = 11;
    private static final int COL_LENGTH = 11;

    public static void main(String[] args) {
        //原始二维数组
        int[][] chessArr1 = new int[ROW_LENGTH][COL_LENGTH];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("chessArr1 start print......");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("chessArr1 end print......");

        // 将二维数组转为稀疏数组
        int sum = 0;
        for (int i = 0; i < ROW_LENGTH; i++) {
            for (int j = 0; j < COL_LENGTH; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparsArr = new int[sum + 1][3];
        sparsArr[0][0] = ROW_LENGTH;
        sparsArr[0][1] = COL_LENGTH;
        sparsArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < ROW_LENGTH; i++) {
            for (int j = 0; j < COL_LENGTH; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparsArr[count][0] = i;
                    sparsArr[count][1] = j;
                    sparsArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("sparsArr start print......");
        for (int i = 0; i < sparsArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparsArr[i][j]);
            }
            System.out.println();
        }
        System.out.println("sparsArr start end......");

        //将稀疏数组转为二维数组
        int[][] chessArr2 = new int[sparsArr[0][0]][sparsArr[0][1]];
        for (int i = 1; i < sparsArr.length; i++) {
            chessArr2[sparsArr[i][0]][sparsArr[i][1]] = sparsArr[i][2];
        }

        System.out.println("chessArr2 start print......");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("chessArr2 end print......");
    }
}
