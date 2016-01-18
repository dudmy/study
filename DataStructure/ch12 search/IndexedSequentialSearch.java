package chapter12;

/*
 *  12.6 색인 순차 탐색
 */
public class IndexedSequentialSearch {

	final static int INDEX_SIZE = 3;
	int[] list = {3, 9, 15, 22, 31, 55, 67, 88, 91};
	itable[] index_list = new itable[INDEX_SIZE];
	
	public IndexedSequentialSearch() {
		int n = list.length / INDEX_SIZE;
		for (int i = 0; i < INDEX_SIZE; i++) {
			index_list[i] = new itable(list[i * n], i * n);
		}
	}
	
	// 인덱스 테이블 클래스
	class itable {
		
		int key;
		int index;
		
		public itable(int key, int index) {
			this.key = key;
			this.index = index;
		}
		
	}
	
	// INDEX_SIZE는 인덱스 테이블의 크기, n은 전체 데이터의 수
	int search_index(int key) {
		int i, low, high;
		
		// 키 값이 리스트 범위 내의 값이 아니면 탐색 종료
		if (key < list[0] || key > list[list.length-1])
			return -1;
		
		//인덱스 테이블을 조사하여 해당 키의 구간 결정
		for (i = 0; i < INDEX_SIZE; i++)
			if (index_list[i].key <= key && index_list[i+1].key > key)
				break;
		
		if (i == INDEX_SIZE) { // 인덱스 테이블의 끝이면
			low = index_list[i-1].index;
			high = list.length - 1;
		} else {
			low = index_list[i].index;
			high = index_list[i+1].index - 1;
		}
		
		// 예상되는 범위만 순차 탐색
		return seq_search(key, low, high);
	}
	
	// 순차 탐색
	int seq_search(int key, int low, int high) {
		for (int i = low; i <= high; i++)
			if (list[i] == key)
				return i;	// 탐색에 성공하면 키 값의 인덱스 반환
		return -1;			// 탐색에 실패하면 -1 반환
	}
	
	public static void main(String[] args) {
		IndexedSequentialSearch s = new IndexedSequentialSearch();

		System.out.println(s.search_index(22));
	}
	
}
