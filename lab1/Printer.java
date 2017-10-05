import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;;

public class Printer{

    public static void main(String[] args){

	//Part 1
	Printer a = new Printer();
	//a.printDistinctNumbers(10);

	//Part 2
	int[] arr = a.generateArray(100000);
	//a.compareSearches(arr);
	
	//Part 3
	a.playTicTacToe();

	//Part 4
	//System.out.println(""+a.howManyCollatzIterations(10));
    }

    public void printDistinctNumbers(int count){
	int[] arr = loadDistinctNumbers(count);
        System.out.println(Arrays.toString(arr));
    }
    
    public int[] loadDistinctNumbers(int count){
	int[] distinctNums = new int[count];
	Scanner sc = new Scanner(System.in);
	int i;
	for (int ind=0; ind<count;){ 
	    i = sc.nextInt();
	    if (containsInt(distinctNums, i)){
		distinctNums[ind]=i;
		ind++;
	    }
	}
	return distinctNums;
    }

    public boolean containsInt(int[] arr, int i){
	for (int ind=0; ind<arr.length; ind++){
	    if (arr[ind]==i){
		return false;
	    }
	}
	return true;
    }

    public int[] generateArray(int count){
	int arr[] = new int[count];
	Random rand = new Random();
	for (int i=0; i<count; i++){
	    arr[i] = rand.nextInt();
	}
	return arr;
    }
    
    public void compareSearches(int[] arr){
	System.out.println("Original (Random) Array");
	Arrays.sort(arr);
	System.out.println("Sorted Array");

	Random rand = new Random();
	int key = arr[rand.nextInt(arr.length)];
	
	System.out.println("Starting Linear Search for "+key+" in array");
	long start = getTime();
	Printer.linearSearch(arr, key);
	long end = getTime();
	System.out.println("Linear search done. Time elapsed: "+(end-start)+"ms");

	System.out.println("Starting Binary Search for "+key+" in array");
	start = getTime();
	Printer.binarySearch(arr, key);
	end = getTime();
	System.out.println("Binary search done. Time elapsed: "+(end-start)+"ms");
    }
    
    public long getTime(){
	return System.currentTimeMillis();
    }

    public void printArray(){
	
    }

    public static int linearSearch(int[] list, int key) {
	for (int i = 0; i < list.length; i++)
	    if (key == list[i])
		return i;
	return -1;
    }

    public static int binarySearch(int[] list, int key) {
	int low = 0;
	int high = list.length - 1;
	while (high >= low) {
	    int mid = (low + high) / 2;
	    if (key < list[mid])
		high = mid - 1;
	    else if (key == list[mid])
		return mid;
	    else
		low = mid + 1;
	}
	return -1 - low;
    }

    public void playTicTacToe(){
	char[][]board = new char[3][3];
	Scanner sc = new Scanner(System.in);
	printBoard(board);
	int turn=0;
	char result = checkWin(board);   
	while (result == 0){
	    int r = sc.nextInt();
	    int c = sc.nextInt();
	    if (turn%2==0){
		board[r][c]='x';
	    }else{
		board[r][c]='o';
	    }
	    printBoard(board);
	    result = checkWin(board);
	    turn++;
	}
	if (result==1){
	    System.out.println("DRAW");
	}
	else {
	    System.out.println("Winner " + (result));
	}
    }

    public void printBoard(char[][]board){
	String str = "";
	char ch;
	for (int c=0; c<board.length; c++){
	    for (int r=0; r<board[0].length; r++){
		ch = board[c][r];
		if (ch==0){
		    ch=' ';
		}
		System.out.printf(""+ch+"|");
	    }
	    System.out.println("\n------");
	}
    }
    
    public char checkWin(char[][]board){
	char a;
	a=checkBoardLine(board, 3, 0, 0, 1, 0);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 0, 0, 0, 1);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 0, 0, 1, 1);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 1, 0, 0, 1);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 0, 1, 1, 0);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 2, 0, 0, 1);
	if (a != 0){
	    return a;
	}
	a=checkBoardLine(board, 3, 0, 2, 1, 0);
	if (a != 0){
	    return a;
	}
	boolean isComplete=true;
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board[0].length;c++){
		if (board[r][c]==0){
		    isComplete = false;
		}
	    }
	}
	if (isComplete){
	    return 1;
	}
	return 0;
    }

    //Assumes square board
    public char checkBoardLine(char[][]board, int boardSize, int xStart, int yStart, int xVel, int yVel){
	char marker = board[xStart][yStart];
	if (marker != 0){
	    for (int i = 0; i<boardSize; i++){
		if (board[xStart][yStart] != marker){
		    return 0;
		}
		xStart+=xVel;
		yStart+=yVel;
	    }
	}
	return marker;
    }

    public static int howManyCollatzIterations(int n){
	int turns = 0;
	while (n!=1){
	    if (n%2==0){
		n /=2;
	    }else{
		n= n*3+1;
	    }
	    turns ++;
	}
	return turns;
    }
}
