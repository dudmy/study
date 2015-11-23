package chapter06;

/*
 * 추상 자료형 Deque
 */
public interface DequeADT <E> {
	
	void error(String msg); // 에러 메세지

	boolean is_empty(); // 덱이 공백 상태인지를 검사
	
	boolean is_full(); // 덱이 포화 상태인지를 검사
	
	void add_front(E item); // 덱의 앞에 요소를 추가
	
	void add_rear(E item); // 덱의 뒤에 요소를 추가
	
	E delete_front(); // 덱의 앞에 있는 요소를 반환한 다음 삭제
	
	E delete_rear(); // 덱의 뒤에 있는 요소를 반환한 다음 삭제
	
	E get_front(); // 덱의 앞에서 삭제하지 않고 앞에 있는 요소를 반환
	
	E get_rear(); // 덱의 뒤에서 삭제하지 않고 뒤에 있는 요소를 반환
	
}
