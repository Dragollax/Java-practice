import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {

    int[][] arr = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
    mystery01(arr);
    
    
}
public static void mystery01(int[ ][ ] m)
{
	int height = m.length;
	int width = m[0].length;
	for (int c = 0; c < width; c++)
	{
		int midIndex = height / 2;
		for (int r = 0; r < midIndex; r++)
		{
			int lastIndex = m.length - 1;
			int temp = m[r][c];
			m[r][c] = m[lastIndex - r][c];
			m[lastIndex - r][c] = temp;

		}
	}
	for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 5; j++)
      {
         System.out.print( " " + m[i][j]);
      }
      System.out.println();
   }
	
	
}
}
