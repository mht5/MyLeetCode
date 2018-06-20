package leetcode.other;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation 
 * it essentially peek() at the element that will be returned by the next call to next().
 * https://leetcode.com/problems/peeking-iterator/description/
 * @author mhts
 *
 */
public class PeekingIterator implements Iterator<Integer>{
	private Iterator<Integer> iterator;
	List<Integer> peekList=new ArrayList<Integer>();
	
	public PeekingIterator(Iterator<Integer> iterator){
		this.iterator=iterator;
	}
	
	public Integer peek(){
		if(peekList.isEmpty()){
			int num;
			if(iterator.hasNext()){
				num=iterator.next();
			}
			else{
//				no data in iterator
				num=-99;
			}
			peekList.add(num);
			return num;
		}
		else{
			return peekList.get(peekList.size()-1);
		}
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext() || !peekList.isEmpty();
	}

	@Override
	public Integer next() {
		if(peekList.isEmpty()){
			return iterator.next();
		}
		else{
			int num=peekList.get(peekList.size()-1);
			peekList.remove(peekList.size()-1);
			return num;
		}
	}

	@Override
	public void remove() {
		iterator.remove();
	}
	
	public static void main(String[] args){
		List<Integer> list1=new ArrayList<Integer>();
		for(int i=0; i<10; i++){
			list1.add(i);
		}
		PeekingIterator ite=new PeekingIterator(list1.iterator());
		for(int i=0; i<10; i++){
			System.out.println("***********");
			System.out.println(ite.next());
			System.out.println(ite.peek());
			for(int j=0; j<ite.peekList.size(); j++){
				System.out.println("peekList: "+ite.peekList.get(j));
			}
		}
	}
	
}
