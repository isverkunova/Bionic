package homework2;

public class BinarySearch {

	private int[] mass;

	public BinarySearch(int[] mass) {
		this.mass = mass;
	}

	public int finder(int a) {
		int min = 0;
		int max = 0;

		if (mass != null && mass.length > 1) {
			max = mass.length - 1;
			while (min < max) {
				int mid = min + (max - min) / 2;

				if (a < mass[mid]) {
					max = mid - 1;
				} else if (a > mass[mid]) {
					min = mid + 1;
				} else {
					return mass[mid];
				}
			}
		}
		return mass[min];
	}
}