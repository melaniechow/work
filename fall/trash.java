/*
Melanie Chow
APCS1 pd4
HW55 -- His Toe Grammar
2017-01-05
*/

/***
    An AP-style question, for practice...

    Write the StatPrinter class below. The StatPrinter Object receives an
    ArrayList of nonnegative integers, then builds a frequency ArrayList where
    the index values are the data and the entry at the index is the frequency.
    For example, if the received data is : 2,3,2,5,1,3 then the frequency 
    list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
    2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
    the maximum value of the data.

    A capability of the class is to calculate local modes from the frequency 
    list. A local mode is a value that is greater than the value at index - 1 
    and greater than the value at index + 1. A local mode is never at the end
    points of the list. For example if the frequency list is [1,2,1,4,2,3,5] 
    then the local modes are: 2 and 4.



    This class is also capable of printing a histogram of the frequencies, using
    ‘*’ to indicate a frequency amount. To print a histogram, the user specifies
    the longest sequence of ‘*’s used and then all other values are printed in 
    proportion to this value. For example, if longest bar is 10 and the frequency
    list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

    0 : **
    1 : ****
    2 : **
    3 : ********
    4 : ****
    5 : ******
    6 : **********

    For each method, state the run time efficiencies using Big O notation.
    =======================================
    Tip:
    * Develop 1 fxn at a time, test it, then move to next.
    * Look over all, think a bit, decide which to tackle first.
    ( Simplest?  Prerequisite? . . . )
    * Coding today, what extra code do you need to get past Mr. Compiler?
    ***/

import java.util.ArrayList;

public class StatPrinter 
{

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    public StatPrinter( ArrayList <Integer> data ) 
    { 
	ArrayList<Integer> printer=new ArrayList<Integer>(max(data)+1);
	int freq;
	int num;
	for (int i=0; i<max(data)+1; i++){
	    freq=0;
	    for (int j=0; j<data.size(); j++){
		if (data.get(j)==i){
		    freq+=1;
		}
	    }
	    printer.add(freq);
	}
	_frequency=printer;
    }
    //O(n^2) because 2 for loops, each are linear. (n x n)

    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    public Integer max( ArrayList <Integer> data ) 
    { 
	int max=0;
	for (int i=0; i<data.size(); i++){
	    if (data.get(i)>max){
		max=data.get(i);
	    }
	}
	return max;   
    }
    //O(n) - for loop


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) 
    { 
	return (i>0 && i < _frequency.size()-1
	    && _frequency.get(i-1)<_frequency.get(i)
		&& _frequency.get(i+1)<_frequency.get(i));
    }
    //O(1) because boolean


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    public ArrayList <Integer> getLocalModes() 
    {
	ArrayList<Integer> localmodes=new ArrayList<Integer> ();
	for (int i=0; i<_frequency.size(); i++){
	    if (isLocalMode(i)){
	        localmodes.add(_frequency.get(i));
	    }   
	}
	return localmodes;
    }
    //O(n) - linear. Single for loop


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    public void printHistogram( int longestBar ) 
    { 
	String hist="";
	int star;
	if (longestBar/(max(_frequency))==0){
	    star=1;
	}
	else {
	    star=longestBar/(max(_frequency));
	}
	for (int i=0; i<_frequency.size();i++){
	    for (int print=0; print<star*_frequency.get(i); print++){
		hist+="*";
	    }
	    hist+="\n";
	}
	System.out.println(hist);
	System.out.println("key: "+star+"*(s) = 1 unit");
    }//O(n^2) because 2 for loops (n x n)

    public static ArrayList<Integer> populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    public static void main(String[] arg){
	ArrayList<Integer> hi=new ArrayList<Integer>();
	hi=populate(7,0,3);
	System.out.println(hi);
	StatPrinter m=new StatPrinter(hi); 
	System.out.println(m._frequency);//Q.1&2
	System.out.println(m.getLocalModes());//Q.3&4
	m.printHistogram(10); //Q.5
    }
	
}//end class StatPrinter
