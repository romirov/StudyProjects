/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
    
    public synchronized int compareTo(Beach anotherBeach) {
       int countA = 0;
        int countB = 0;
        if(this.getDistance() > anotherBeach.getDistance()){
            countB += 1;
        }else if(this.getDistance() < anotherBeach.getDistance()){
            countA += 1;
        }
        
        if(this.getQuality() > anotherBeach.getQuality()){
            countA += 1;
        }else if(this.getQuality() < anotherBeach.getQuality()){
            countB += 1;
        }
        
        if(countA > countB){
            return 1;
        }else if(countA < countB){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}

