package chapter08;

/*
 * 8.6 허프만 코드 프로그램 (최소 히프 사용)
 */
class TreeNode {
	
	int weight;
	TreeNode left_child;
	TreeNode right_child;
	
	public TreeNode(int weight, TreeNode left_child, TreeNode right_child) {
		this.weight = weight;
		this.left_child = left_child;
		this.right_child = right_child;
	}
	
}

class Element {
	
	TreeNode ptree;
	int key;
	
	public Element(TreeNode ptree, int key) {
		this.ptree = ptree;
		this.key = key;
	}

}

class HeapType {

	Element[] heap;
	int size;
	
	public HeapType() {
		heap = new Element[MinHeap.MAX_ELEMENT];
		size = 0;
	}
	
}

// 최소 히프
class MinHeap implements PriorityQueueADT <Element> {

	final static int MAX_ELEMENT = 100;
	HeapType h;
	
	public MinHeap() {
		h = new HeapType();
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

	public void insert(Element item) {
		int i = ++h.size;
		// 트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
		while(i != 1 && item.key < h.heap[i/2].key) {
			h.heap[i] = h.heap[i/2];
			i /= 2;
		}
		h.heap[i] = item; // 새로운 노드를 삽입
	}

	@Override
	public Element delete() {
		Element item = h.heap[1];
		Element temp = h.heap[h.size--];
		int parent = 1;
		int child = 2;
		
		while (child <= h.size) {
			// 현재 노드에서 자식 노드 중 더 작은 자식 노드를 찾는다
			if (child < h.size && h.heap[child].key > h.heap[child + 1].key)
				child++;
			if (temp.key <= h.heap[child].key)
				break;
			// 한단계 아래로 이동
			h.heap[parent] = h.heap[child];
			parent = child;
			child *= 2;
		}
		h.heap[parent] = temp;
		return item;
	}

	@Override
	public Element find() {
		return h.heap[1];
	}

	@Override
	public void display() {
		for (int i = 1; i <= h.size; i++) {
			System.out.print(h.heap[i].key + " ");
		}
		System.out.println();
	}
	
}

class HuffmanTree extends MinHeap {

	// 이진 트리 제거 함수
	void destroy_tree(TreeNode root) {
		if (root == null)
			return;
		destroy_tree(root.left_child);
		destroy_tree(root.right_child);
	}
	
	// 허프만 코드 생성 함수
	void make_huffman(int[] freq, int n) {
		Element e = null;
		
		// 최소 히프에 추가
		for (int i = 0; i < n; i++) {
			TreeNode node = new TreeNode(freq[i], null, null);
			e = new Element(node, freq[i]);
			insert(e);
		}
		display();
		
		// 허프만 코드로 변경
		for (int i = 1; i < n; i++) {
			// 최소값을 가지는 두 개의 노드를 삭제
			Element e1 = delete();
			Element e2 = delete();
			// 두 개의 노드를 합친다
			TreeNode x = new TreeNode(e1.key + e2.key, e1.ptree, e2.ptree);
			e = new Element(x, x.weight);
			insert(e);
			display();
		}
		
		e = delete(); // 최종 트리
		destroy_tree(e.ptree);
	}

}

public class HuffmanCodes {

	public static void main(String[] args) {
		int[] freq = {15, 12, 8, 6, 4};
		HuffmanTree h = new HuffmanTree();
		// 가장 작은 두 개의 빈도수
		h.make_huffman(freq, freq.length);
	}
	
}
