import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][] {
            {'f', 'd', 'e', 'r', 'l', 'k'},
            {'u', 's', 'a', 'm', 'e', 'o'},
            {'l', 'n', 'g', 'r', 'o', 'v'},
            {'m', 'l', 'p', 'r', 'r', 'h'},
            {'p', 'o', 'e', 'e', 'j', 'j'},
            {'f', 'e', 'e', 'e', 'l', 'e'},
            {'u', 's', 'n', 'n', 'n', 'o'},
            {'l', 'e', 'n', 'o', 'n', 'e'},
            {'m', 'm', 'n', 'n', 'n', 'h'},
            {'p', 'e', 'e', 'e', 'j', 'e'}
    };
    detectAllWords(crossword, "home",
    "same", 
    "emas",
    "ll",
    "l",
    "rr",
    "sf",
    "one",
    "nn"
    );
        /*int[][] crossword = new int[][]{
            {'f', 'd', 'e', 'r', 'l', 'k'},
            {'u', 's', 'a', 'm', 'e', 'o'},
            {'l', 'n', 'g', 'r', 'o', 'v'},
            {'m', 'l', 'p', 'r', 'r', 'h'},
            {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword,  "home","same");//origin
        //detectAllWords(crossword,  "ham");//origin
        /*detectAllWords(crossword,  "rr");//search to the right
        detectAllWords(crossword,  "emas");//search to the left
        detectAllWords(crossword,  "dsnlo");//search to the bottom
        detectAllWords(crossword,  "epgae");//search to the top
        detectAllWords(crossword,  "emoh");//diagonal search to the bottom
        detectAllWords(crossword,  "unpe");//diagonal search to the bottom
        detectAllWords(crossword,  "ranm");//diagonal search to the bottom
        detectAllWords(crossword,  "oore");//diagonal search to the bottom
        detectAllWords(crossword,  "home");//diagonal search to the top
        detectAllWords(crossword,  "epnu");//diagonal search to the top
        detectAllWords(crossword,  "mnar");//diagonal search to the top
        detectAllWords(crossword,  "eroo");//diagonal search to the top*/
        /*
Ожидаемый результат
home - (3, 5) - (0, 2)
same - (1, 1) - (1, 4)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int i = 0;
        int startX = 0; int startY = 0;
        int endX = 0; int endY = 0;
        List<Word> resultList = new ArrayList<>();
        boolean find = false;
        for(String word : words) {
            //System.out.println(word);
            char[] characters = word.toCharArray();
            for(int x = 0; x < crossword.length; x++){
                for(int y = 0; y < crossword[x].length; y++){
                    if(i < characters.length) {
                        if(crossword[x][y] == (int)characters[i]) {
                            startX = x; startY = y;
                            i++;
                            if(i < characters.length){
                                //search to the left
                                if((y - 1) > 0 ) {
                                    for(int yy = y - 1; yy >= 0; yy--){
                                        if(crossword[x][yy] == (int)characters[i]) {
                                            i++;
                                        } else break;
                                        if(i == characters.length) {
                                            endX = x; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                    }
                                }
                                //search to the rigth
                                //if(find) break;
                                if((y + 1) < crossword[x].length ) {
                                    for(int yy = y + 1 ; yy < crossword[x].length; yy++){
                                        if(crossword[x][yy] == (int)characters[i]) {
                                            i++;
                                        } else break;
                                        if(i == characters.length) {
                                            endX = x; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                    }
                                }
                                //search to the bottom
                                //if(find) break;
                                if((x + 1) < crossword.length ) {
                                    for(int xx = x + 1; xx < crossword.length; xx++){
                                        if(crossword[xx][y] == (int)characters[i]) {
                                            i++;
                                        } else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = y;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                    }
                                }
                                //search to the top
                                //if(find) break;
                                if((x - 1) > 0 ) {
                                    for(int xx = x - 1; xx >= 0; xx--){
                                        if(crossword[xx][y] == (int)characters[i]) {
                                            i++;
                                        }  else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = y;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                    }
                                }
                                //diagonal search to the bottom
                                //if(find) break;
                                if((x + 1) < crossword.length) {
                                    int yy = y + 1;
                                    for(int xx = x + 1; xx < crossword.length; xx++){
                                        //System.out.println((char)crossword[xx][yy]);
                                        if(yy == crossword[x].length) break;
                                        if(crossword[xx][yy] == (int)characters[i]) {
                                            i++;
                                        }  else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                        yy++;
                                    }
                                }
                                //if(find) break;
                                if((x + 1) < crossword.length) {
                                    int yy = y - 1;
                                    for(int xx = x + 1; xx < crossword.length; xx++){
                                        //System.out.println((char)crossword[xx][yy]);
                                        if(yy < 0) break;
                                        if(crossword[xx][yy] == (int)characters[i]) {
                                            i++;
                                        }  else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                        yy--;
                                    }
                                }
                                //search to the diagonal to top
                                //if(find) break;
                                if((x - 1) > 0) {
                                    int yy = y - 1;
                                    for(int xx = x - 1; xx >= 0; xx--){
                                        //System.out.println((char)crossword[xx][yy]);
                                        if(yy < 0) break;
                                        if(crossword[xx][yy] == (int)characters[i]) {
                                            i++;
                                        }  else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                        yy--;
                                    }
                                }
                                //if(find) break;
                                if((x - 1) > 0) {
                                    int yy = y + 1;
                                    for(int xx = x - 1; xx >= 0; xx--){
                                        //System.out.println(xx + "   " + yy);
                                        //System.out.println((char)crossword[xx][yy]);
                                        if(yy == crossword[x].length) break;
                                        if(crossword[xx][yy] == (int)characters[i]) {
                                            i++;
                                        } else break;
                                        if(i == characters.length) {
                                            endX = xx; endY = yy;
                                            Word newWord = new Word(word);
                                            newWord.setStartPoint(startX, startY);
                                            newWord.setEndPoint(endX, endY);
                                            resultList.add(newWord);
                                            i = 1;
                                            find = true;
                                            break;
                                        }
                                        yy++;
                                    }
                                }
                            } else {
                                endX = x; endY = y;
                                Word newWord = new Word(word);
                                newWord.setStartPoint(startX, startY);
                                newWord.setEndPoint(endX, endY);
                                resultList.add(newWord);
                                find = true;
                            }
                            i = 0;
                        } //if(find) break;
                    } else break;
                    //if(find) break;
                }//if(find) break;
            }
            find = false;
            i = 0;
        }

        resultList.forEach(System.out::println);

        return resultList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
