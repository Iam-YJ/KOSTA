package test.exam;

public class Audio extends Elec implements ElecFunction {

	private int volumn;

	public Audio() {
	}

	public Audio(int volumn) {
		super();
		this.volumn = volumn;
	}

	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn = volumn;
	}

	public void start() {
		toString();
	}

	public void stop() {

	}
	
	public void display() {
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getCode()+"제품 ");
		builder.append(super.getClass().getSimpleName()+"를 ");
		builder.append(volumn+"으로 듣는다.");
		return builder.toString();
	}
	
	

	
}
