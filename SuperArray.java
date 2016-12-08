/*
Team EM- Melanie Chow and Eric Li
APCS pd.4
HW42 -- Array of Grade 316
2016-12-08
*/

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray()
    { 
	_data=new int[10];
	_lastPos=-1;
	_size=0;
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	if (_size==0){
	    return "[]";
	}
	String retStr="[";
	for (int index=0; index<_size-1 ; index+=1){
	    retStr+=_data[index]+",";
	}
	return retStr+=_data[_size-1]+"]"; 
    }
    
    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	int[]b=new int[_data.length*2]; //doubles the length of existing array
	for (int i=0; i<_data.length; i++){
	    b[i]=_data[i];
	}
	_data=b;
    }      

    //accessor method -- return value at specified index
    public int get( int index ) 
    {
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
	int old=_data[index];
	_data[index]=newVal;
	return old;
    }

    //adds an item after the last item
    public void add( int newVal ) 
    {
	if (_lastPos == _data.length-1){
	    this.expand();
	}
        _data[_lastPos+1]=newVal;
	_lastPos+=1;
	_size+=1;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) 
    {
	int[]b=new int[_data.length+1]; // length of existing array
	for (int i=0; i<b.length; i++){
	    if (i<index) {
		b[i]=_data[i];
	    }
	    else if (i==index){
		b[i]=newVal;
	    }
	    else{
		b[i]=_data[i-1];
	    }
	}
	_data=b;
	_size+=1;
	_lastPos+=1;
	
    }
    /*
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    {
	/* YOUR IMPLEMENTATION HERE
    }

    //return number of meaningful items in _data
    public int size() 
    {
	/* YOUR IMPLEMENTATION HERE
    }
    `*/
    //main method for testing
    public static void main( String[] args ) 
    {

	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	 	/*===========================================
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	/*===========================================*/
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	/* ===========================================*/
    }//end main()

}//end class SuperArray
