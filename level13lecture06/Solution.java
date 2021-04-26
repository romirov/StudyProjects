public class Solution {

    public static void main(String[] args) {
        System.out.println(getShapeNameByCountOfCorners(3));
        System.out.println(getShapeNameByCountOfCorners(5));
        System.out.println(getShapeNameByCountOfCorners(1));
    }

    public static String getShapeNameByCountOfCorners(int countOfCorner) {
        String shape = switch (countOfCorner){
        case 3 -> {
            yield "Треугольник";
        }
        case 4 -> {
            yield "Четырехугольник";
        }
        case 5 -> {
            yield "Пятиугольник";
        }
        case 6 -> {
            yield "Шестиугольник";
        }
        case 7 -> {
           yield "Семиугольник";
        }
        case 8 -> {
            yield "Восьмиугольник";
        }
        default -> {
            yield"Другая фигура";
        }
        };
        return shape;
    }
}

