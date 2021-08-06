import java.util.Iterator;

public class MyBasket {
	MyStack s;

	public MyBasket(MyStack s) {
		super();
		this.s = s;
	}

	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////

	public void removeKthFromTop(int k) throws Exception {
		if(s.isEmpty() || s.size() <= k || k < 0) return;
		StackArray tmp = new StackArray(s.size());
		int cnt = -1;
		while(!s.isEmpty()) {
			int pop = s.top();
			s.pop();
			if(++cnt == k) break;
			tmp.push(pop);
		}
		while(!tmp.isEmpty()) {
			s.push(tmp.top());
			tmp.pop();
		}
	}

	public void insertKthFromTop(int data, int k) throws Exception {
		if(s.size() < k || k < 0) return;
		StackArray tmp = new StackArray(s.size());
		int cnt = -1;
		while(++cnt < k) {
			tmp.push(s.top());
			s.pop();
		}
		s.push(data);
		while(!tmp.isEmpty()) {
			s.push(tmp.top());
			tmp.pop();
		}
		
	}

}
