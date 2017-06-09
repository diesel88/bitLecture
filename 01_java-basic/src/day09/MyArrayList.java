package day09;

public class MyArrayList {
	final int INIT_SIZE = 3;
	// 입력된 정보를 저장하기 위한 배열 선언
	String[] list = new String[INIT_SIZE];
		
	// 입력될 위치 기억, 실제 저장된 데이터의 크기
	int pos = 0;
	
	public void add(String data){
		// 데이터가 꽉 찼다면 배열의 크기를 증가
		if (pos == list.length) {
			String[] temp = new String[pos * 2];
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		
		list[pos++] = data;
		
	}
	public String get(int index) {
		if (index < pos) {
			return list[index];
		}
		return null;
	}
	
	public int size() {
		return pos;
	}
	public boolean remove(int index) {
		
		
		if (index >= pos || list[index] == null) {
			return false;
		} 
		if (pos < list.length / 2) {
			String[] temp = new String[pos * 2];
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		// 삭제할 글번호가 존재할 경우
		int moveCnt = pos - index - 1;
		if (moveCnt > 0) {
			System.arraycopy(
					list, index + 1, list, index, moveCnt);
		}
		list[--pos] = null;
		return true;
	}
	public void clear() {
		list = new String[INIT_SIZE];
		pos = 0;
		
	}
	public String toString() {
		StringBuffer result = new StringBuffer("[");
		for (int i = 0; i < pos; i++) {
			result.append(list[i] + (i == pos - 1?"":", "));
		}
		result.append("]");
		return result.toString();
	}
}
