package 基础班.第七节课;

public class Code01_TrieTree {

	public static class TrieNode {
		public int path; //所有字符串中  经过当前这个结点的数量
		public int end; //所有字符串中  当前节点作为结尾结点的数量 （根节点的值  相当于加入多少空串 ""）
		public TrieNode[] nexts; //26个字母  所以这个数组的长度为26
		//现在只是26条路 如果路很多怎么办？ 改用 哈希表 的结构  HashMap<Char,TriNode>

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26]; //初始时根节点出发 到达a-z是没有路的  初始化都是null
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if(word == null){
				return;
			}
			TrieNode node = root;
			node.path++; //每次刚来到根节点 path就要加加
			int index = 0;
			for (int i = 0; i < word.length() ; i++) {//遍历字符串
				index = word.charAt(i) - 'a';
				if(node.nexts[index] == null){ //查看当前结点是否已经有往index延伸出来的路
					node.nexts[index] = new TrieNode(); //如果没有就新建
				}
				node = node.nexts[index]; //将node指向刚才处理过的结点
				node.path++;
			}
			node.end++; //到最后了  那最后的这个节点肯定就是结尾结点  end就需要加加
		}


		/**
		 * 其实就是删除word字符串在前缀树中的信息
		 * @param word
		 */
		public void delete(String word) {
			if (search(word) != 0) { //确定前缀树中加入过word才会去删除
				char[] chs = word.toCharArray();
				TrieNode node = root;
				node.path--;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					//如果当前节点往下走的路只有一条 那就直接设为null  后面的内容也不用遍历和操作了
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

		/**
		 * word这个字符串之前加入过几次
		 * 其实就是按照word这个字符串往下找链路 然后最后一个节点的end就是所要的结果
		 * @param word
		 * @return  没有的话就返回0 有的话就返回word这个字符串之前加入过几次
		 */
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) { //发现没有往下走的路了  但是word还没有遍历完
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		/**
		 * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
		 * @param pre
		 * @return
		 */
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
