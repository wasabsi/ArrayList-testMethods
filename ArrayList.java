package edu.cofc.csci230;

/**
 * ArrayList Data Structure
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private AnyType[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
        
        array = (AnyType[]) new Comparable[ capacity ];
        
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        if ( size >= capacity )
            grow();
        
        array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
       
    	if(index >= 0 && index <= size){
    		//Checks if the index is in front of the list
    		if(size >= capacity){
    			grow();
    		}
    		//Start at the end of the array and replace the index[i] with the prior index 
    		//until you reach the index inputed by the user
    		//shifts indexes down while searching for the index
    		
    		for (int i = size; i > index; i--){
    			array[i]= array[i-1];
    		}
    		size++;
    		//replace the index inputed with the value of t
    		array[index]=t;
    	
    	//If index is not in range
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
    	
        
        
        
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
      
    	if(index < 0 || index >= size){
    		throw new IndexOutOfBoundsException();
    	}
    	array[index]=t;
     
        
         
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
         
       
    	AnyType temp;
    	if(index >= 0 && index <= size-1){ //<= size
    		//Checks if the index is in front of the list
    		temp = array[index];
    		for (int i = index; i<size-1;i++){
        		array[i]= array[i+1];
    		}
    		
    		
    		
    		size--;
    		//(capacity/2)-1 leaves one index open after the shrink
    		if(size == (capacity/2)-1 && capacity > 10){
    			shrink();
    		}
    	}else{
    		throw new IndexOutOfBoundsException();
    	}
    	return temp;
         
        
         
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
         
      
    	if(index < 0 || index >= size){
    		throw new IndexOutOfBoundsException();
    	}
    	return array[index];
       
         
         
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
         
     
    	//set all previous indexes to null
    	for(int i=0; i<size;i++){
    		array[i]= null;
    	}
    	//capacity and size revert to original 
    	capacity = INITIAL_CAPACITY;
    	size = 0;
    	
    	System.out.println("New Capacity - Clear: " + capacity);
        
         
         
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
        
    
    	AnyType[] newArray = (AnyType[]) new Comparable [capacity * 2];
    	
    	//copies new old array to new array object
    		for(int i=0; i<size; i++){
    			newArray[i]= array[i];
    		
    		}
    	
    	
    		capacity = capacity * 2;
  
    		array = newArray;
        
    		System.out.println("New Capacity - Grow: " + capacity);
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
        
       
    	AnyType[] newArray = (AnyType[]) new Comparable [capacity / 2];
    	
    	for(int i=0; i<size; i++){
    		newArray[i]= array[i];
    		
    	}
    	
    	
    	capacity = capacity / 2;
    	array = newArray;
    	System.out.println("New Capacity - Shrink: " + capacity);
    } // end shrink() method
    
    
   //testing
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", array[i] ) );    
            }
            
            buffer.append( String.format( "%d ]", array[size-1] ) );
            
        } else {
            
            buffer.append( "] " );
        }
        
        return buffer.toString();
        
    } // end toString()
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
      
    	ArrayList<Integer> test = new ArrayList<Integer>();   
    	
    	//TEST ADD 
    	test.add(4);
    	test.add(0,3);
    	test.add(2,7);
    	test.add(2);
    	test.add(0,2);
    	test.add(5,0);
    	test.add(0,1);
    	test.add(4,4);
    	test.add(6,7);
    	test.add(10);
    	test.add(5);
    	//test.add(0,0);
    	//test.add(-1,1);
    	//test.add(13,14);
   
    	
    	
    	//TEST SET
    	test.set(0, 10);
    	test.set(10, 10);
    	test.set(2, 9);
//    	test.set(9, 11);
//    	test.set(6, 6);
    	//test.set(-1, 0);
    	
    	
    	
    	//TEST GET 
//    	System.out.println(test.get(0));
//    	System.out.println(test.get(5));
//    	System.out.println(test.get(2));
//    	System.out.println(test.get(3));
//    	System.out.println(test.get(9));
    	//System.out.println(test.get(11));
    	//System.out.println(test.get(10));
    	//System.out.println(test.get(-1));
    	
    	
    	
    	//TEST REMOVE
    	test.remove(3);
    	test.remove(0);
    	test.remove(0);
    	//test.remove(-1);
    	//test.remove(20);
    	test.remove(1);
    	test.remove(0);
    	test.remove(4);
    	
//    	test.remove(10);
//    	test.remove(1);
//    	test.add(11);
//    	test.add(11);
    	
    	
    	
    	//TEST CLEAR 
    	test.clear();
    	
    	
    	
    	
    	
    	
    	System.out.println(test.toString());
    	
    } // end main() method
  
} // end ArrayList class definition

