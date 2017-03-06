
public class ArrayMethods {
	public ArrayMethods(){
		int[][] a = {{2,1},{3,4}};
		System.out.println("Sum: " + getTotal(a));
		System.out.println("Number of elements: " + getElementCount(a));
		System.out.println("Average: " + getAverage(a));
		System.out.println("Row total: " + getRowTotal(a, 3));
		System.out.println("Column total: " + getColumnTotal(a, 0));
	}
	
	/**
	 * Sums all values
	 * @param a
	 * @return
	 */
	public int getTotal(int[][] a){
		int total = 0;
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j< a[i].length; j++){
				total += a[i][j];
			}
		}
		return total;
	}
	
	/**
	 * Get number of elements
	 * @param a
	 * @return
	 */
	public int getElementCount(int[][] a){
		int count = 0;
		for (int i = 0; i < a.length; i++){
			count += a[i].length;
		}
		return count;
	}
	
	/**
	 * Average of all values in array
	 * @param a
	 * @return
	 */
	public double getAverage(int[][] a){
		int sum = getTotal(a);
		int count = getElementCount(a);
		return sum/count;
	}
	
	/**
	 * Sum a column
	 * @param a
	 * @param column
	 * @return
	 */
	public int getColumnTotal(int[][] a, int column){
		int columnTotal = 0;
		try {
			for (int i = 0; i < a.length; i++){
				columnTotal += a[i][column];
			}
		} catch (ArrayIndexOutOfBoundsException g){
			System.out.println("Array index out of bounds.");
		}
		return columnTotal;
	}
	/**
	 * Sum a row
	 * @param a
	 * @param row
	 * @return
	 */
	public int getRowTotal(int[][] a, int row) {
		int rowTotal = 0;
		try {
			for (int i = 0; i < a[row].length; i++){
				rowTotal += a[row][i];
			}
		} catch (ArrayIndexOutOfBoundsException g){
			System.out.println("Index out of bounds.");
		}
		return rowTotal;
	}
	
	public static void main(String[] args){
		new ArrayMethods();
	}
}
