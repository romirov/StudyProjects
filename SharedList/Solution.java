import java.util.*;

/* 
Общий список
*/

public class Solution implements List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }
    
    public synchronized boolean add(Long e){
        return original.add(e);
    }
    
    public synchronized void add(int index, Long element){
        original.add(index, element);
    }
    
    public synchronized boolean addAll(Collection<? extends Long> c){
        return original.addAll(c);
    }

    public synchronized boolean addAll(int index, Collection<? extends Long> c){
        return original.addAll(index, c);
    }

	public synchronized void clear(){
	    original.clear();
	}
	
	public synchronized boolean	contains(Object o){
	    return original.contains(o);
	}
	
	public synchronized boolean	containsAll(Collection<?> c){
	    return original.containsAll(c);
	}
	
	public synchronized boolean	equals(Object o){
	    return original.equals(o);
	}
	
	public synchronized Long get(int index){
	    return original.get(index);
	}
	
	public synchronized int hashCode(){
	    return original.hashCode();
	}

    public synchronized int indexOf(Object o){
        return original.indexOf(o);        
    }

    public synchronized boolean isEmpty(){
        return original.isEmpty();
    }

    public synchronized Iterator<Long> iterator(){
        return original.iterator();
    }

    public synchronized int lastIndexOf(Object o){
        return original.lastIndexOf(o);
    }

    public synchronized ListIterator<Long> listIterator(){
        return original.listIterator();
    }

    public synchronized ListIterator<Long> listIterator(int index){
        return original.listIterator(index);
    }

    public synchronized Long remove(int index){
        return original.remove(index);
    }

    public synchronized boolean remove(Object o){
        return original.remove(o);
    }

    public synchronized boolean removeAll(Collection<?> c){
        return original.removeAll(c);
    }

    public synchronized boolean retainAll(Collection<?> c){
        return original.retainAll(c);
    }

    public synchronized Long set(int index, Long element){
        return original.set(index, element);
    }

    public synchronized int size(){
        return original.size();
    }

    public synchronized List<Long> subList(int fromIndex, int toIndex){
        return original.subList(fromIndex, toIndex);
    }

    public synchronized Object[] toArray(){
        return original.toArray();
    }

    public synchronized <Object> Object[] toArray(Object[] a){
        return original.toArray(a);
    }
}
