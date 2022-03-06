package com.ds.algo.one;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionService2 {

	public static void main(String[] args) {

		TrieTree tree = new TrieTree();
		tree.addWord("Null");
		tree.addWord("Nully");
		tree.addWord("Kuch");
		tree.addWord("Kuich");
		System.out.println("Is word Exists: "+tree.ifWordExists("Null"));
		System.out.println("Is word Exists: "+tree.ifWordExists("Nully"));
		System.out.println("Is word Exists: "+tree.ifWordExists("Kuch"));
		System.out.println("Is word Exists: "+tree.ifWordExists("Kuich"));
		System.out.println("Is word Exists: "+tree.ifWordExists("Nulli"));
		System.out.println("Is word Exists: "+tree.ifWordExists("Nuill"));
	}

	public static class TrieTree {

		private Node head = null;

		public void addWord(String word) {

			Node tempNode = head;

			char[] chars = word.toCharArray();

			int length = chars.length;

			for (int i = 0; i < length; i++) {
				if (tempNode == null) {
					tempNode = new Node();
					Node nextNode = new Node();
					nextNode.setNodeVal(new HashMap<Character, Node>());
					if (i == length - 1) {
						nextNode.setEndOfWord(true);
					}
					Map<Character, Node> nodeVal = new HashMap<>();
					nodeVal.put(chars[i], nextNode);
					tempNode.setNodeVal(nodeVal);
					head = tempNode;
					tempNode = nextNode;
				} else {
					if (tempNode.nodeVal.containsKey(chars[i])) {
						tempNode = tempNode.nodeVal.get(chars[i]);
					} else {
						Node nextNode = new Node();
						nextNode.setNodeVal(new HashMap<Character, Node>());
						if (i == length - 1) {
							nextNode.setEndOfWord(true);
						}
						tempNode.nodeVal.put(chars[i], nextNode);
						tempNode = nextNode;
					}
				}
			}

		}

		public boolean ifWordExists(String word) {
			
			if(head == null && word == null) {
				return true;
			}
			
			if(head == null && word.length()==0) {
				return true;
			}
			
			Node tempNode = head;

			char[] chars = word.toCharArray();

			int length = chars.length;
			
			boolean flag = true;
			
			for(int i = 0; i < length; i++) {
				if (tempNode.nodeVal.containsKey(chars[i])) {
					tempNode = tempNode.nodeVal.get(chars[i]);
					flag = tempNode.isEndOfWord();
				} else {
					flag = false;
					break;
				}
			}
			
			return flag;
		}

		public boolean deletedWord(String word) {
			return false;
		}

		public List<String> wordSuggestion(String str) {
			return null;
		}

	}

	public static class Node {

		private Map<Character, Node> nodeVal;

		private boolean endOfWord;

		public Map<Character, Node> getNodeVal() {
			return nodeVal;
		}

		public void setNodeVal(Map<Character, Node> nodeVal) {
			this.nodeVal = nodeVal;
		}

		public boolean isEndOfWord() {
			return endOfWord;
		}

		public void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}

	}

}
