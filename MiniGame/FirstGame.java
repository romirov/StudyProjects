package com.javarush.games.minigames.mini02;
/*
Попробуем отрисовать простую фигуру на игровом поле. Тебе нужно переопределить метод initialize() класса Game, и в этом методе задать размер игрового поля (5х7) с помощью метода setScreenSize(int, int). Также нужно вызвать метод showShip(), который отрисовывает корабль.
*/
import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

public class FigureView extends Game {
    private static final int WIDTH = 64; 
    public static final int[][] SHIP = new int[][]{
            {0, 0, 7, 0, 0},
            {0, 7, 7, 7, 0},
            {0, 7, 0, 7, 0},
            {0, 7, 7, 7, 0},
            {0, 7, 0, 7, 0},
            {7, 7, 7, 7, 7},
            {7, 0, 7, 0, 7},
    };

    public void showShip() {
        for (int i = 0; i < SHIP.length; i++) {
            for (int j = 0; j < SHIP[0].length; j++) {
                setCellColor(j, i, Color.values()[SHIP[i][j]]);
            }
        }
    }
    
    @Override
    public void initialize() {
        // Тут выполняем все действия по инициализации игры и ее объектов
        setScreenSize(5, 7);
        showShip();
    }
}

