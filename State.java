import java.util.*;

public class State implements Comparable<State> {
	
	public int a, b, c;
	
	public State (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean equals (State state) { //works
		if (state.a == this.a && state.b == this.b && state.c == this.c) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString () { //works
		return "(" + a + "," + b + "," + c + ")";
	}
	
	@Override
	public int compareTo (State state) {
		return (this.a + this.b + this.c) - (state.a + state.b + state.c);
	}
	
}
