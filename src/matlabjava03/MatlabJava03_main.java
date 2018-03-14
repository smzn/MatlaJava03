package matlabjava03;

import java.util.Arrays;

public class MatlabJava03_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a[][] = { {2, 1, 1}, { -1, 1, -1}, {1, 2, 3} };
		double b[][] = { {2}, {3}, {-10} };
		MatlabJava03_lib mlib = new MatlabJava03_lib(a,b);
		System.out.println("x = "+Arrays.toString(mlib.getLinsolve()));
		System.out.println("x = "+Arrays.toString(mlib.getSolution()));
	}

}
