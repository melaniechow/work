/*
Melanie Chow
APCS2 pd4
HW14 -- So So Fast
2017-03-08
*/

public class FastSelect{
    public static void swap(int[] arr, int i, int j){
	int first=arr[i];
	int second=arr[j];
	arr[i]=second;
	arr[j]=first;
    }

    public static void printarray(int [] a){
	String retStr="[";
	for (int i=0; i<a.length; i++){
	    retStr+=" "+a[i];
	}
	System.out.println( retStr+=" ]");
    }

    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal=arr[pvtPos];
	swap(arr,pvtPos,right);
	int storePos=left;
	for (int i=left; i<right-1; i++){
	    if (arr[i]<=pvtVal){
		swap (arr,storePos,i);
		storePos+=1;
	    }
	}
	swap(arr,right,storePos);
	//printarray(arr);
	return storePos;
	}
   
    public static int ymin(int[] a, int y,int start, int end){
	if (start>=end){
	    return a[start]; 
	}
	else{
	    int status=partition(a,start,end,(start+end)/2);
	    if (status==y-1){
		return a[(start+end)/2];
	    }
	    else if (status>y-1){
		return ymin(a,y,start,status-1);
	    }
	    else{
		return ymin(a,y,status+1,end);
	    }
	}
    }

    public static void main(String[] args){
	int[] a=new int[] {5,4,17,9000,6};
	System.out.println(ymin(a,1,0,4)); 
	System.out.println(ymin(a,2,0,4));
	System.out.println(ymin(a,3,0,4));
	System.out.println(ymin(a,4,0,4));

	int[] b=new int[] {2,6,8,9,1,0};
	System.out.println(ymin(b,1,0,5));
	System.out.println(ymin(b,2,0,5));
	System.out.println(ymin(b,3,0,5));
	System.out.println(ymin(b,4,0,5));
	System.out.println(ymin(b,5,0,5));
    }
}
