public class PokerProgramm {
	static int anzahlFarbe = 4;
	static int anzahlKarten = 13;
	static int grenze = 52;
	static int anzahl = 5;
	static int oben = 51;
	static int[] karten = new int[anzahlKarten * anzahlFarbe];
	static int[] gezogenekarten = new int[anzahl];
	static int[] werte = new int[anzahl];
	static int[] farbe = new int[anzahl];
	static int versuche = 10000000;
	static int anzahlVierling = 0;
	static int anzahlDrilling = 0;
	static int anzahlFlush = 0;
	static int anzahlStreight = 0;
	static int anzahlStreightFlush = 0;
	static int anzahlRoyalFlush = 0;
	static int anzahlPair = 0;
	static int anzahlTwoPair = 0;
	static int anzahlFullHouse = 0;
	static int anzahlHighCard = 0;

	public static int[] ArrayBefüllen() {
		for (int i = 0; i < anzahlKarten * anzahlFarbe; i++) {
			karten[i] = i;
		}
		return karten;
	}

	public static int[] Gezogenekarten(int oben, int grenze) {
		for (int h = 0; h < anzahl; h++) {
			int zufall = (int) (Math.random() * grenze);
			int test = karten[oben];
			karten[oben] = karten[zufall];
			karten[zufall] = test;
			gezogenekarten[h] = karten[oben];
			grenze--;
			oben--;
		}
		Sort.Sort(gezogenekarten);
		return gezogenekarten;
	}

	public static int[] Farbe() {
		for (int j = 0; j < gezogenekarten.length; j++) {
			int f = gezogenekarten[j] / anzahlKarten;
			farbe[j] = f;
		}
		return farbe;
	}

	public static int[] Wert() {
		for (int j = 0; j < gezogenekarten.length; j++) {
			int w = gezogenekarten[j] % anzahlKarten;
			werte[j] = w;
		}
		return werte;
	}

	public static boolean vierling() {
		int zähler = 0;
		for (int i = 0; i < werte.length; i++) {
			for (int j = 0; j < werte.length; j++) {
				if (werte[i] == werte[j]) {
					zähler++;
				}
			}
			if (zähler == 4) {
				return true;
			}
			zähler = 0;
		}
		return false;
	}

	public static boolean drilling() {
		int zähler = 0;
		for (int i = 0; i < werte.length; i++) {
			for (int j = 0; j < werte.length; j++) {
				if (werte[i] == werte[j]) {
					zähler++;
				}
			}
			if (zähler == 3) {
				return true;
			}
			zähler = 0;
		}
		return false;
	}

	public static boolean flush() {
		int zähler = 0;
		for (int i = 0; i < farbe.length; i++) {
			for (int j = 0; j < farbe.length; j++) {
				if (farbe[i] == farbe[j]) {
					zähler++;
				}
			}
			if (zähler == 5) {
				return true;
			}
			zähler = 0;
		}
		return false;
	}

	public static boolean streight() {
		for (int i = 0; i < werte.length - 1; i++) {
			if ((werte[i + 1] - werte[i]) != 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean streightFlush() {
		boolean st = streight();
		boolean f = flush();
		if (f && st) {
			return true;
		}
		return false;
	}

	public static boolean roaylFlush() {
		if (streightFlush() && werte[werte.length - 1] == anzahlKarten - 1) {
			return true;
		}
		return false;
	}

	public static boolean twoPair() {
		int zähler = 0;
		for (int i = 0; i < werte.length-1; i++) {
			if (werte[i] == werte[i + 1]) {
				zähler++;
			}
			if (zähler == 2 && !drilling()) {
				return true;
			}
		}
		return false;
	}

	public static boolean pair() {
		int zähler = 0;
		for (int j = 0; j < werte.length; j++) {
			for (int i = 0; i < werte.length; i++) {
				if (werte[i] == werte[j]) {
					zähler++;
				}
			}
			if (zähler == 2 && !twoPair()) {
				return true;
			}
			zähler = 0;
		}
		return false;
	}

	public static boolean fullHouse() {
		if (drilling() && pair()) {
			return true;
		}
		return false;
	}

	public static boolean highCard() {
		if (pair() || twoPair() || flush() || streight() || vierling() || drilling()) {
			return false;
		}
		return true;
	}

	public static void berechnug() {
		if (vierling()) {
			anzahlVierling++;
		}
		if (drilling()) {
			anzahlDrilling++;
		}
		if (flush()) {
			anzahlFlush++;
		}
		if (streight()) {
			anzahlStreight++;
		}
		if (streightFlush()) {
			anzahlStreightFlush++;
		}
		if (roaylFlush()) {
			anzahlRoyalFlush++;
		}
		if (twoPair()) {
			anzahlTwoPair++;
		}
		if (pair()) {
			anzahlPair++;
		}
		if (fullHouse()) {
			anzahlFullHouse++;
		}
		if (highCard()) {
			anzahlHighCard++;
		}
	}

	public static void auswertung() {
		double prozentVierling = anzahlVierling * 100.0 / versuche;
		double prozentDrilling = anzahlDrilling * 100.0 / versuche;
		double prozentFlush = anzahlFlush * 100.0 / versuche;
		double prozentStreight = anzahlStreight * 100.0 / versuche;
		double prozentStreightFlush = anzahlStreightFlush * 100.0 / versuche;
		double prozentRoyalFlush = anzahlRoyalFlush * 100.0 / versuche;
		double prozentPair = anzahlPair * 100.0 / versuche;
		double prozentTwoPair = anzahlTwoPair * 100.0 / versuche;
		double prozentFullHouse = anzahlFullHouse * 100.0 / versuche;
		double prozentHighCard = anzahlHighCard * 100.0 / versuche;
		System.out.printf("Anzahl Vierling: %d bei %d Versuchen --> Wahrscheinlichkeit Vierling: %f %s%n", anzahlVierling,
				versuche, prozentVierling, "%");
		System.out.printf("Anzahl Drilling: %d bei %d Versuchen --> Wahrscheinlichkeit Drilling: %f %s%n", anzahlDrilling,
				versuche, prozentDrilling, "%");
		System.out.printf("Anzahl Sreigth: %d bei %d Versuchen --> Wahrscheinlichkeit Streight: %f %s%n", anzahlStreight,
				versuche, prozentStreight, "%");
		System.out.printf("Anzahl Flush: %d bei %d Versuchen --> Wahrscheinlichkeit Flush: %f %s%n", anzahlFlush,
				versuche, prozentFlush, "%");
		System.out.printf("Anzahl Streight Flush: %d bei %d Versuchen --> Wahrscheinlichkeit Streight Flush: %f %s%n",
				anzahlStreightFlush, versuche, prozentStreightFlush, "%");
		System.out.printf("Anzahl Royal Flush: %d bei %d Versuchen --> Wahrscheinlichkeit Royal Flush: %f %s%n",
				anzahlRoyalFlush, versuche, prozentRoyalFlush, "%");
		System.out.printf("Anzahl Pair: %d bei %d Versuchen --> Wahrscheinlichkeit Pair: %f %s%n", anzahlPair, versuche,
				prozentPair, "%");
		System.out.printf("Anzahl Two Pair: %d bei %d Versuchen --> Wahrscheinlichkeit Two Pair: %f %s%n", anzahlTwoPair,
				versuche, prozentTwoPair, "%");
		System.out.printf("Anzahl Full House: %d bei %d Versuchen --> Wahrscheinlichkeit Full House: %f %s%n",
				anzahlFullHouse, versuche, prozentFullHouse, "%");
		System.out.printf("Anzahl High Card: %d bei %d Versuchen --> Wahrscheinlichkeit High Card: %f %s%n",
				anzahlHighCard, versuche, prozentHighCard, "%");
	}

	public static void main(String[] args) {

		for (int zähler = 0; zähler < versuche; zähler++) {
			ArrayBefüllen();
			Gezogenekarten(oben, grenze);
			Wert();
			Farbe();
			Sort.Sort(werte);
			Sort.Sort(farbe);
			berechnug();
		}
		auswertung();
	}
}