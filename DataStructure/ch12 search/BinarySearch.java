package chapter12;

/*
 * 12.4 재귀 호출을 이용한 이진 탐색 & 12.5 반복을 이용한 이진 탐색
 */
public class BinarySearch {

	int[] list = {1, 3, 5, 6, 7, 9, 11, 20, 30};
	
	// 재귀 호출을 이용
	int search_binary(int key, int low, int high) {
		int middle;
		if (low <= high) {					// 아직 숫자들이 남아 있으면
			middle = (low + high) / 2;
			
			if (key == list[middle])		// 탐색 성공
				return middle;
			else if (key < list[middle])	// 왼쪽 부분 리스트 탐색
				return search_binary(key, low, middle-1);
			else							// 오른쪽 부분 리스트 탐색
				return search_binary(key, middle+1, high);
		}
		return -1; // 탐색 실패
	}
	
	// 반복을 이용
	int search_binary2(int key, int low, int high) {
		int middle;
		while (low <= high) {				// 아직 	숫자들이 남아 있으면
			middle = (low + high) / 2;
			if (key == list[middle])		// 탐색 성공
				return middle;
			else if (key < list[middle])	// 왼쪽 부분 리스트 탐색
				high = middle - 1;
			else							// 오른쪽 부분 리스트 탐색
				low = middle + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		BinarySearch s = new BinarySearch();
		
		System.out.println(s.search_binary(3, 0, s.list.length));
		System.out.println(s.search_binary2(22, 0, s.list.length));
	}
	
}
