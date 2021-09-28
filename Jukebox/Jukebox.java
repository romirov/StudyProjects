package Jukebox;
import java.util.*;
import java.io.*;

/**
 * Тестовый класс для проверки сортировок в ArrayList
 * Сортировать будем песни по названию и автору
 * Для сортировки используем методы sort() из Collections:
 * sort(List<T> list) - порядок сортировки определяют методы compareTo() каждого элемента
 * По этой причине элементы списка должны реализовать интерфейс Comparable 
 *
 * sort(List<T> list, Comparator<? super T> c) - методы compareTo(), принадлежащие элементам списка вызываться не будут
 * Вместо этого будет задействован метод compare() из Comparator и в этом случае элементы списка не должны 
 * реализовывать интерфейс Comparable
 */

class Song implements Comparable<Song>{///Нужно реализовать класс Comparable,
  //чтобы отработало Collection.sort(принимает только объекты Comparable)
  private String title;
  private String artist;
  private String rating;
  private String bpm; 

  //единственный метод из Comparable, который необходимо реализовать
  //он сравнивает песни по названию
  //Метод Collections.sort() передает объект Song в compareTo
  //чтобы увидеть, как тот соотносится с экземпляром Song, из которого вызван метод
  public int compareTo(Song s){
    return title.compareTo(s.getTitle());
  }

  Song(String title, String artist, String rating, String bpm){
    this.title = title;
    this.artist = artist;
    this.rating = rating;
    this.bpm = bpm;
  }
  /* возвращает название песни */
  public String getTitle(){
    return title;
  }
  /* возвращает автора песни */
  public String getArtist(){
    return artist;
  }
  /* возвращает рейтинг песни */
  public String getRating(){
    return rating;
  }
  /* возвращает кол-во ударов в минуту */
  public String getBpm(){
    return bpm;
  }
  
  public String toString(){
    return title;
  }
}

public class Jukebox{
  
  ArrayList<Song> songList = new ArrayList<Song>(); 

  public static void main(String[] args){
    new Jukebox.go();
  }
  /*
   * Вложенный класс, реализующий Comparator(тип параметра совпадает с типом),
   * который собираемся сравнивать - Song
   */
  class ArtistCompare implements Comparator<Song>{
    public int compare(Song one, Song two){
      /*
       * one.getArtist() - возращает имя исполнителя(строка)
       * compareTo() - перекладывание работы по сравнению на строковые объекты,
       * так как они уже умеют сортироватья в алфавитном порядке
       */
      return one.getArtist().compareTo(two.getArtist());
    }
  }
  public void go(){
    getSong();
    System.out.println(songList);
    Collections.sort(songList);
    System.out.println(songList);
  }

  public void getSong(){
    try{
      File file = new File("SongList.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while((line = reader.readLine()) != null){
        addSong(line);
      }
    }catch(IOException ex){
      ex.printStackTrace();
    }
  }

  void addSong(String lineToParse){
    String[] tokens = lineToParse.split("/");
    Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
    songList.add(nextSong);
  }
}
