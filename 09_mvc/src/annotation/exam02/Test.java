package annotation.exam02;

public class Test {
	
//	@FullValue(type="abc", name="ebc", value="aaa")
//	@FullValue(type="abc", name="ebc", "aaa") //속성명이 여러개일때는 value를 생략할 수 없다.
	// default가 선언되어 있을 경우 선택적으로 값을 입력
//	@FullValue(name="ebc", value="aaa")
//	@FullValue
	@FullValue("abcd") //value에 값을 집어 넣음
	public void call() {}
}
