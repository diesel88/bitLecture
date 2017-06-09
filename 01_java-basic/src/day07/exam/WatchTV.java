/*
���θ޼��带 �������� �� �Ʒ��� ���� ��µ� �� �ֵ��� �ڵ� �ۼ�

=============================================
Ƽ�� ������ �մϴ�.
����  TV  ����  :  20
����  TV  ä��  :  7
ä��  36������  ����
ä��  ����
����  TVä��  :  37
TV  ��û  ����
Ƽ�� ������ ���ϴ�.
=============================================
 */
package day07.exam;
public  class  WatchTV  {
	public  static  void  main(String[]  args)  {
		TV  tv  =  new  TV();
		tv.powerOn();
		System.out.println("����  TV  ����  :  "  +  tv.getVolume());
		System.out.println("����  TV  ä��  :  "  +  tv.getChannel());
		System.out.println("ä��  36������  ����");
		tv.setChannel(36);
		System.out.println("ä��  ����");
		tv.channelUp();
		System.out.println("����  TVä��  :  "  +  tv.getChannel());
		System.out.println("TV  ��û  ����");
		tv.powerOff();
	}
}

class TV {
	int volume;
	int channel;
	boolean power = false;
	
	public void powerOn() {
		power = true;
	}
	public void powerOff() {
		power = false;
	}
	public void channelUp() {
		channel++;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
}