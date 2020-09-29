import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhichAlien {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int antennas = Integer.parseInt(br.readLine());
		
		int eyes = Integer.parseInt(br.readLine());
		
		if (antennas >= 3 && eyes <= 4) {
			System.out.println("TroyMartian");
		} 
		
		if (antennas <= 6 && eyes >= 2) {
			System.out.println("VladSaturnian");
		} 
		
		if (antennas <=2  && eyes <= 3) {
			System.out.println("GraemeMercurian");
		}
	}
}