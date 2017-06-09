package day13.quiz;

public class StudentVO implements Comparable<StudentVO>{
	private String name;
	private int[] scores;
	private int totScore;
	public StudentVO (int[] scores, String name) {
		this.scores = scores;
		this.name = name;
		for (int i=0; i < scores.length; i++) {
			totScore += scores[i];
		}
	}
	public String getName() {
		return name;
	}
	public int getTotScore() {
		return totScore;
	}
	@Override
	public int compareTo(StudentVO o) {
		// TODO Auto-generated method stub
		if (totScore == o.totScore) return 0;
		return totScore > o.totScore ? -1 : 1;
	}
	
	
}
