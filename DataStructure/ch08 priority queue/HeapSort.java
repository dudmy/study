package chapter08;

/*
 * 8.4 히프 정렬 프로그램
 */
public class HeapSort extends MaxHeap {

	// 최대 히프 트리 코드는
	// HeapTree.java 파일의 MaxHeap class 사용
	
	// 우선순위 큐인 히프를 이용한 정렬
	void heap_sort(int a[], int n) {
		for (int i = 0; i < n; i++) { // 값이 감소되는 순서로 정렬
			insert(a[i]);
		}
		for (int i = n-1; i >= 0; i--) { // 값이 증가되는 순서로 정렬
			a[i] = delete();
		}
	}
	
	public static void main(String[] args) {	
		int[] a = {5, 1, 9, 24, 33, 4, 11};
		
		HeapSort h = new HeapSort();
		h.heap_sort(a, a.length);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
