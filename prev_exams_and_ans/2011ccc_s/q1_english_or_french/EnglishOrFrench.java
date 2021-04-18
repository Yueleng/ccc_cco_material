import java.io.*;

public class EnglishOrFrench{
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
		int temp = 0;
		int french = 0;
		int english = 0;
		while(temp < a) {
			String s = br.readLine();
			String arr[] = s.split("");
			for(int i = 0; i < arr.length; i++) {
				if (arr[i].equals("s") || arr[i].equals("S"))
				    french++;
				if (arr[i].equals("t") || arr[i].equals("T"))
					english++;
			}
			temp++;
		}

	    if(french>=english)
		    System.out.println("French");

	    if(english>french)
		    System.out.println("English");
            
	}
}
