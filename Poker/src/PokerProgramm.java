public class PokerProgramm {

	public static int[] ArrayBefüllen(int[] karten, int anzahlkarten, int anzahlFarbe) {
		for (int i = 0; i < anzahlkarten * anzahlFarbe; i++) {
			karten[i] = i;
		}
		return karten;
	}

	public static int[] Gezogenekarten(int[] karten, int[] gezogenekarten, int grenze, int anzahl) {
		for (int h = 0; h < anzahl; h++) {
			int zufall = (int) (Math.random() * grenze);
			int test = karten[grenze];
			karten[grenze] = karten[zufall];
			karten[zufall] = test;
			gezogenekarten[h] = karten[grenze];
			grenze = grenze - 1;
		}
		return gezogenekarten;
	}

	public static int[] Farbe(int[] gezogenekarten, int[] farbe) {
		for (int j = 0; j < gezogenekarten.length; j++) {
			int f = gezogenekarten[j] / 13;
			farbe[j] = f;
		}
		return farbe;
	}

	public static int[] Wert(int[] gezogenekarten, int[] wert) {
		for (int j = 0; j < gezogenekarten.length; j++) {
			int w = gezogenekarten[j] % 13;
			wert[j] = w;
		}
		return wert;
	}
	
	public static void main(String[] args) {
		int anzahlFarbe = 4;
		int anzahlkarten = 13;
		int grenze = 51;
		int anzahl = 5;
		int[] karten = new int[anzahlkarten * anzahlFarbe];
		int[] gezogenekarten = new int[anzahl];
		int[] werte = new int[anzahl];
		int[] farbe = new int[anzahl];
	
		ArrayBefüllen(karten, anzahlkarten, anzahlFarbe);
		Gezogenekarten(karten, gezogenekarten, grenze, anzahl);
		Farbe(gezogenekarten, farbe);
		Wert(gezogenekarten, werte);
	}
}