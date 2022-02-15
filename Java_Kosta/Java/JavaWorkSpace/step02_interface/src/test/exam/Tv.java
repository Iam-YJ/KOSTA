package test.exam;

public class Tv extends Elec implements ElecFunction {

	private int channel;

	public Tv() {
	}

	public Tv(int channel) {
		super();
		this.channel = channel;
	}

	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel = channel;
	}

	@Override
	public void start() {
		toString();
	}

	@Override
	public void stop() {

	}

	@Override
	public void display() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getCode()+"��ǰ ");
		builder.append(super.getClass().getSimpleName()+"�� ");
		//super.getClass().getSimpleName() -> Ŭ���� �̸� �������� 
		builder.append(channel+"�� ����.");
		return builder.toString();
	}

}
