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
		builder.append(super.getCode()+"��ǰ ");
		builder.append(super.getClass().getSimpleName()+"�� ");
		builder.append(volumn+"���� ��´�.");
		return builder.toString();
	}
	
	

	
}
