
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
		System.out.println("Ungeordnetes Array:");
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		return array;
	}

	public static void main(String[] args) {
		int[] a = new int[20];
		for (int i = 0; i < a.length; i++) {
			int zufall = (int) (Math.random() * 50);
			a[i] = zufall;
		}
		System.out.println("ungeordnete Array");
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		Sort(a);
		
	}   
}