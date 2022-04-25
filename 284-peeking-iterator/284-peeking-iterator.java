// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer val;
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr=iterator;
        if(this.itr.hasNext()){
            val=itr.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return val;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int ans=val;
        if(itr.hasNext()){
            val=itr.next();
        }else{
            val=null;
        }
        return ans;
	}
	
	@Override
	public boolean hasNext() {
	    if(val==null)return false;
        return true;
	}
}