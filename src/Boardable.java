/**
 * Interface of methods for Pet to implement
 *
 */
public interface Boardable {
	//month in range 1-12, day in range 1-31, year in range 2000-2016
	public void setBoardStart(int month, int day, int year);
	public void setBoardEnd(int month, int day, int year);
	//true if between start and month, or date is equal to start or end
	public boolean boarding(int month, int day, int year);
}
