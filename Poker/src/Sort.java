public class Sort {
	public static int[] Sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int z = array[i];
			int klz = z;
			int posKlz = i;
			for (int j = i; j < array.length; j++) {
				if (klz > array[j]) {
					klz = array[j];
					posKlz = j;
				}
			}
			array[i] = klz;
			array[posKlz] = z;
		}
		return array;
	}

	public static void main(String[] args) {	
	}   
}
