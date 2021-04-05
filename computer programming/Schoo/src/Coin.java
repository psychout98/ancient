public class Coin {
	private final int HEADS = 0;
	private enum State {Heads,Tails};
	State face;

	public Coin() {
		flip();
	}

	public void flip() {
		face = ((int) (Math.random() * 2)==0?State.Heads:State.Tails);
	}

	public boolean isHeads() {
		return (face==State.Heads);
	}

	public String toString() {
		return (face==State.Heads) ? "Heads" : "Tails";
	}
}
