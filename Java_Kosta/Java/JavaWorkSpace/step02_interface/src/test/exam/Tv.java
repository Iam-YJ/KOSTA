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
		builder.append(super.getCode()+"제품 ");
		builder.append(super.getClass().getSimpleName()+"를 ");
		//super.getClass().getSimpleName() -> 클래스 이름 가져오기 
		builder.append(channel+"을 본다.");
		return builder.toString();
	}

}
