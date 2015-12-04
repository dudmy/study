package chapter09;

import chapter06.ArrayQueue;

/*
 * 9.10 기수 정렬 프로그램
 */
public class RadixSort {

	final static int BUCKETS = 10;
	final static int DIGITS = 4;
	
	ArrayQueue<Integer>[] q = new ArrayQueue[BUCKETS];
	
	public RadixSort() {
		for (int i = 0; i < BUCKETS; i++) // 큐들의 초기화
			q[i] = new ArrayQueue<>();
	}

	void radix_sort(int[] list, int n) {
		int i, factor = 1;
		
		for (int d = 0; d < DIGITS; d++) {
			for (i = 0; i < n; i++)
				q[(list[i]/factor) % 10].enqueue(list[i]); //데이터들을 자릿수에 따라 큐에 입력
			
			for (int b = i = 0; b < BUCKETS; b++) // 버켓에서 꺼내어 list로 합친다
				while (!q[b].is_empty())
					list[i++] = q[b].dequeue();
			factor *= 10; // 그 다음 자릿수로 간다
		}
	}
	
	public static void main(String[] args) {
		int[] list = {52, 87, 42, 77, 53, 47, 85, 72};
		RadixSort s = new RadixSort();
		s.radix_sort(list, list.length);
		
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	
}
