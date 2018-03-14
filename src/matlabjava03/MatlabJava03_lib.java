package matlabjava03;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import com.mathworks.engine.MatlabExecutionException;
import com.mathworks.engine.MatlabSyntaxException;

public class MatlabJava03_lib {
	
	Future<MatlabEngine> eng;
	MatlabEngine ml;
	double a[][], b[][], x[];
	
	public MatlabJava03_lib(double[][] a, double[][] b) {
		this.a = a;
		this.b = b;
		eng = MatlabEngine.startMatlabAsync();
		try {
			//返された Future オブジェクトの get メソッドを使用して、MatlabEngine オブジェクトが返されるのを待ちます。
			ml = eng.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double[] getLinsolve() {
		try {
			ml.putVariableAsync("a", a);
			ml.putVariableAsync("b", b);
			ml.putVariableAsync("x", x);
			ml.eval("x = linsolve(a, b);");
			
			Future<double[]> futureEval_x = ml.getVariableAsync("x");
			x = futureEval_x.get();
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	public double[] getSolution() {
		try {
			ml.putVariableAsync("a", a);
			ml.putVariableAsync("b", b);
			ml.putVariableAsync("x", x);
			ml.eval("x = a \\ b;");
			
			Future<double[]> futureEval_x = ml.getVariableAsync("x");
			x = futureEval_x.get();
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;	
	}
}
