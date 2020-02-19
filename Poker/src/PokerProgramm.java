public class PokerProgramm {

	public static int[] ArrayBefüllen(int[] Karten, int anzahlKarten, int anzahlFarbe) {
		for (int i = 0; i < anzahlKarten * anzahlFarbe; i++) {
			Karten[i] = i;
		}
		return Karten;
	}

	public static int[] GezogeneKarten(int[] Karten, int[] gezogenekarten, int grenze, int oben, int anzahl) {
		for (int h = 0; h < anzahl; h++) {
			int zufall = (int) (Math.random() * grenze);
			int test = Karten[oben]; 
			Karten[oben] = Karten[zufall];
			Karten[zufall] = test;
			gezogenekarten[h] = Karten[oben];
			oben = oben - 1;
		}
		return gezogenekarten;
	}

	public static void main(String[] args) {
		int anzahlFarbe = 4;
		int anzahlKarten = 13;
		int grenze = 51;
		int oben = 51;
		int anzahl = 5;
		int[] Karten = new int[anzahlKarten * anzahlFarbe];
		int[] gezogenekarten = new int[anzahl];

		ArrayBefüllen(Karten, anzahlKarten, anzahlFarbe);
		GezogeneKarten(Karten,gezogenekarten, grenze, oben, anzahl);
	}
}