package day10;

public class LgTV implements TV{

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("lg 전원 켜다");
	}
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("lg 전원 끄다");
	}
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("lg 소리 올리다");
		
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("lg 소리 내리다");
		
	}
	@Override
	public void channelUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void channelDown() {
		// TODO Auto-generated method stub
		
	}
	
}
