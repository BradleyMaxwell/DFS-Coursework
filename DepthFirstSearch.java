import java.util.*;

public class DepthFirstSearch {
	
	public int aSize;
	public int bSize;
	public int cSize;
	
	public Set<State> visitedStates;
	public Stack<State> stack;
	
	public DepthFirstSearch (int aSize,int bSize,int cSize) {
		this.aSize = aSize;
		this.bSize = bSize;
		this.cSize = cSize;
		
		this.visitedStates = new HashSet<State>();
		this.stack = new Stack<State>();
		
		State startState =  new State(0,0,0);
		stack.push(startState);
		search();
		output();
	}
	
	public void search () { // look at this again
		while (!stack.isEmpty()) {
			State currentState = stack.peek();
			visitedStates.add(currentState);
			
			boolean maxDepth = true;
			ArrayList<State> nextStates = findNextStates(currentState);
			for (State nextState : nextStates) {
				if (!visited(nextState)) {
					stack.push(nextState);
					maxDepth = false;
					break;
				}
				
			}
			
			if (maxDepth) {
				stack.pop();
			}
			
			}
	}
	
	public boolean visited (State state)  {
		for (State s : visitedStates) {
			if (s.equals(state))  {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<State> findNextStates (State state) { //works 
		ArrayList<State> nextStates = new ArrayList<State>();
		
		// how to find every possible next stage in one move?
		
		//1. pour water into a jug. Can only pour water into a jug that is not full and the amount you pour cannot overflow the jug.
		if (state.a < this.aSize) {
			for (int x = 1; x <= (this.aSize - state.a); x++) {
				State newState = new State(state.a + x,state.b,state.c);
				nextStates.add(newState);
			}
		}
		
		if (state.b < this.bSize) {
			for (int x = 1; x <= (this.bSize - state.b); x++) {
				State newState = new State(state.a,state.b + x,state.c);
				nextStates.add(newState);
			}
		}
		
		if (state.c < this.cSize) {
			for (int x = 1; x <= (this.cSize - state.c); x++) {
				State newState = new State(state.a,state.b,state.c + x);
				nextStates.add(newState);
			}
		}
		
		//2. pouring water out of a jug. Can either go into another jug or onto the floor. Cannot pour out an empty jug and pouring into another jug must not overflow it.
		if (state.a > 0) {
			for (int x = 1; x <= state.a; x++) {
				State newState = new State(state.a - x,state.b,state.c); //pouring onto the floor
				nextStates.add(newState);
				if (state.b + x <= this.bSize) { //pouring water from a into b
					State newState_b = new State(state.a - x,state.b + x,state.c);
					nextStates.add(newState_b);
				}
				if (state.c + x <= this.cSize) { //pouring water from a into c
					State newState_c = new State(state.a - x,state.b,state.c + x);
					nextStates.add(newState_c);
				}
			}
		}
		
		if (state.b > 0) {
			for (int x = 1; x <= state.b; x++) {
				State newState = new State(state.a,state.b - x,state.c); //pouring onto the floor
				nextStates.add(newState);
				if (state.a + x <= this.aSize) { //pouring water from b into a
					State newState_a = new State(state.a + x,state.b - x,state.c);
					nextStates.add(newState_a);
				}
				if (state.c + x <= this.cSize) { //pouring water from b into c
					State newState_c = new State(state.a,state.b - x,state.c + x);
					nextStates.add(newState_c);
				}
			}
		}
		
		if (state.c > 0) {
			for (int x = 1; x <= state.c; x++) {
				State newState = new State(state.a,state.b,state.c - x); //pouring onto the floor
				nextStates.add(newState);
				if (state.a + x <= this.aSize) { //pouring water from c into a
					State newState_a = new State(state.a + x,state.b,state.c - x);
					nextStates.add(newState_a);
				}
				if (state.b + x <= this.bSize) { //pouring water from c into b
					State newState_b = new State(state.a,state.b + x,state.c - x);
					nextStates.add(newState_b);
				}
			}
		}
		
		return nextStates;
	}
	
	public void output () {
		List v = new ArrayList<State>();
		v.addAll(visitedStates);
		Collections.sort(v);
		System.out.println(v);
		System.out.println("Total Possible States: " + v.size());
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a =  input.nextInt();
		int b =  input.nextInt();
		int c =  input.nextInt();
		
		DepthFirstSearch dfs = new DepthFirstSearch(a,b,c);
		
	}
	
	
}
