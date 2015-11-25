package chapter08;

/*
 * 8.3 최대 히프 트리 테스트 프로그램
 */
class MaxHeap implements PriorityQueueADT<Integer> {

	final static int MAX_ELEMENT = 200;
	HeapType h;
	
	public MaxHeap() {
		h = new HeapType();
	}
	
	class HeapType {
		
		int[] heap;
		int size; // 히프 안에 저장된 요소의 개수
		
		public HeapType() {
			heap = new int[MAX_ELEMENT];
			size = 0;
		}
		
	}
	
	@Override
	public boolean is_empty() {
		if (h.size == 0)
			return true;
		return false;
	}

	@Override
	public boolean is_full() {
		if (h.size == MAX_ELEMENT - 1)
			return true;
		return false;
	}

	@Override
	public void insert(Integer item) {
		int i = ++h.size;
		// 트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
		while(i != 1 && item > h.heap[i/2]) {
			h.heap[i] = h.heap[i/2];
			i /= 2; // 부모 노드의 위치를 가리킴
		}
		h.heap[i] = item; // 새로운 노드를 삽입
	}

	@Override
	public Integer delete() {
		int item = h.heap[1]; // 루트 노드 값 반환을 위하여 item 변수로 옮긴다
		int temp = h.heap[h.size--];
		int parent = 1;
		int child = 2; // 루트의 왼쪽 자식부터 비교
		while (child <= h.size) {
			// 현재 노드의 자식 노드 중 더 큰 자식 노드를 찾는다
			if (child < h.size && h.heap[child] < h.heap[child + 1]) // 오른쪽 자식이 더 크면
				child++;
			if (temp >= h.heap[child])
				break;
			// 한 단계 아래로 이동
			h.heap[parent] = h.heap[child];
			parent = child;
			child *= 2;
		}
		h.heap[parent] = temp;
		return item;
	}

	@Override
	public Integer find() {
		return h.heap[1];
	}
	
	@Override
	public void display() {
		for (int i = 1; i <= h.size; i++) {
			System.out.print(h.heap[i] + " ");
		}
		System.out.println();
	}
	
}

public class HeapTree {

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		
		// 삽입
		heap.insert(10);
		heap.insert(5);
		heap.insert(30);
		heap.display();
		
		// 삭제
		System.out.print("<" + heap.delete() + ">");
		System.out.print("<" + heap.delete() + ">");
		System.out.print("<" + heap.delete() + ">");
	}
	
}
