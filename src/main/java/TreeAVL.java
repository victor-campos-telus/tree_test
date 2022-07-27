public class TreeAVL {
	TreeAVL node_left, node_right;
	int value;
	int height;

	public TreeAVL(int newValue) {
		value = newValue;
		height = 1;
		node_left = node_right = null;
	}

	private int height(TreeAVL node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public TreeAVL insertIntoTreAVL(TreeAVL node,int newValue) {
		if (node == null) {
			node = new TreeAVL(newValue);
		} else if (newValue < node.value) {
			node.node_left = insertIntoTreAVL(node.node_left, newValue);
			if (height(node.node_left) - height(node.node_right) == 2) {
				if (newValue < node.node_left.value) {
					node = rotateLeft(node);
				} else {
					node.node_left = rotateRight(node.node_left);
					rotateLeft(node);
				}
			}
		} else if (newValue > node.value) {
			node.node_right = insertIntoTreAVL(node.node_right, newValue);
			if (height(node.node_right) - height(node.node_left) == 2) {
				if (newValue > node.node_right.value) {
					node = rotateRight(node);
				} else {
					node.node_right = rotateLeft(node.node_right);
					node = rotateRight(node);
				}
			}
		}else{
			node.height= Math.max(height(node.node_left), height(node.node_right))+1;
		}

		return node;
	}

	public TreeAVL rotateLeft(TreeAVL y) {
		TreeAVL x = y.node_left;
		y.node_left = x.node_right;
		x.node_right = y;
		y.height = Math.max(height(y.node_left), height(y.node_right)) + 1;
		x.height = Math.max(height(x.node_left), height(x.node_right)) + 1;
		return x;
	}

	public TreeAVL rotateRight(TreeAVL x) {
		TreeAVL y = x.node_right;
		x.node_right = y.node_left;
		y.node_left = x;
		x.height = Math.max(height(x.node_left), height(x.node_right)) + 1;
		y.height = Math.max(height(y.node_left), height(y.node_right)) + 1;
		return y;
	}

	public void getHeight(){
		height = 1;
		if (node_left != null) {
			height += node_left.height;
		}
		if (node_right != null) {
			height += node_right.height;
		}
	}
    public void preOrder(TreeAVL node){
	  if (node == null){
			return;
		}
		System.out.println(node.value);
		preOrder(node.node_left);
		preOrder(node.node_right);
	}
	public void postOrder(TreeAVL node){
		if (node == null){
			return;
		}
		postOrder(node.node_left);
		postOrder(node.node_right);
		System.out.println(node.value);
	}

	public void inOrder(TreeAVL node){
		if (node == null){
			return;
		}
		inOrder(node.node_left);
		System.out.println(node.value+ " ");
		inOrder(node.node_right);
	}

	public int getBalance(){
		int balance =0;
		if (node_left != null) {
			balance += node_left.height;
		}
		if (node_right != null) {
			balance -= node_right.height;
		}
		return balance;
	}
	public TreeAVL balance(){
		getHeight();
		int balance = getBalance();
		if (balance> 1) {
			if(node_left.getBalance()<0) {
				node_left = rotateLeft(node_left);
			}
			return rotateRight(this);
		}else if (balance < -1) {
			if(node_right.getBalance()>0) {
				node_right = rotateRight(node_right);
			}
			return rotateLeft(this);
		}
		return this;
	}

}
