package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании

*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int i = 0;
        int j = 0;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for(j = 0; j < 4; j++){
            for(i = 0; i < 4; i++){
                if(a[i][j] == 1){
                    if(i + 1 < 4){
                        y1 = j;
                        for(x1 = i + 1; x1 < 4; x1++){
                            //обходим по горинтали в поисках 0 для уточнения длинны прямоугольника
                            x2 = x1;
                            if(a[x1][y1] == 0){
                                break;
                            }
                        }
                    }else x2 = i;

                    if(j + 1 < 4){
                        x1 = i;
                        for(y1 = j + 1; y1 < 4; y1++){
                            //обходим по вертикали в поисках 0 для уточнения ширины прямоугольника
                            y2 = y1;
                            if(a[x1][y1] == 0){
                                break;
                            }
                        }
                    }else y2 = j;
                }
                
                
                    //заполняем фигуру 0 и заново обходим
                    if(x2 > 0 || y2 > 0){
                        count++;
                        for(x1 = i ; x1 < x2 + 1; x1++){
                            for(y1 = j; y1 < y2 + 1; y1++){
                                a[x1][y1] = 0;
                            }
                        }
                        i = 0;
                        j = 0;
                        x1 = 0;
                        y1 = 0;
                        x2 = 0;
                        y2 = 0;
                    }
            }
        }
        return count;
    }

}

