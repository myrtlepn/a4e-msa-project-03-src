package bymin4.share.utils;

public class Pair<A, B> {

	public final A left;
	public final B right;

	public Pair(A left, B right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return "Pair[" + left + "," + right + "]";
	}

	public static <A, B> Pair<A, B> of(A a, B b) {
		return new Pair<A, B>(a, b);
	}
}
