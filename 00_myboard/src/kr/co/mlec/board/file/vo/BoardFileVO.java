package kr.co.mlec.board.file.vo;

public class BoardFileVO {
	private int fileNo;
	private int no;
	private String oriName;
	private String systemName;
	private String filePath;
	private long fileSize;
	
	public int getFileNO() {
		return fileNo;
	}
	public void setFileNO(int fileNO) {
		this.fileNo = fileNO;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	
}
