public class Test {
	public static void main(String[] args) {
		Board gboard = new Board();
		gboard.setStart(0, 0);
		gboard.setEnd(0, 7);
		gboard.setBlock(1, 1);
		gboard.setBlock(3, 0);
		gboard.setBlock(3, 1);
		gboard.output();
	}
}