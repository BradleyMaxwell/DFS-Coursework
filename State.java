import java.util.*;

public class State {
	
	public int a, b, c;
	
	public State (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String toString () { //works
		return "(" + a + "," + b + "," + c + ")";
	}
	
	public boolean equals (State state) { //works
		if (state.a == this.a && state.b == this.b && state.c == this.c) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
