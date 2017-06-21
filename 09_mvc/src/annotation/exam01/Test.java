package annotation.exam01;

@Marker
public class Test {
	@Type1(value="test")
	@Type2(name="aaa")
	public void call() {}
	
	@Type1("test")	// 속성값이 없을때는 value 속성명이 디폴트로 value
//	@Type2("aaa") 	// 에러발생
	public void test() {}
}
