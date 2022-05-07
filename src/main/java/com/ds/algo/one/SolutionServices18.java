package com.ds.algo.one;

public class SolutionServices18 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String str = preOrder(root);
            str = str.substring(0, str.length()-1);
            str += "#"+inOrder(root).substring(0, str.length());
            System.out.println(":"+str+":");
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] travs = data.split("#");
            String[] preOrder = travs[0].split(",");
            String[] inOrder = travs[1].split(",");
            TreeNode head = deserialize(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
            return head;
        }

        public TreeNode deserialize(String[] preOrder, String[] inOrder, int preS, int preE, int inS, int inE) {

            if(preS >= 0 && preE <= preOrder.length-1 && preS == preE) {
                return new TreeNode(Integer.parseInt(preOrder[preS]));
            }

            int index = -1;
            for(int j = inS; j  <= inE; j++) {
                for(int i = inS; i <= inE; i++) {
                    if(inOrder[i].equals(preOrder[j])) {
                        index = i;
                        break;
                    }
                }
                if(index != -1) {
                    break;
                }
            }

            TreeNode head = new TreeNode(Integer.parseInt(inOrder[index]));

            head.left = deserialize(preOrder, inOrder, preS+1, preE, inS, index-1);
            head.right = deserialize(preOrder, inOrder, preS+1, preE, index+1, inE);
            return head;
        }

        private String inOrder(TreeNode root) {
            String str = "";
            if(root == null) {
                return "";
            }
            str+=inOrder(root.left);
            str+=root.val+",";
            str+=inOrder(root.right);
            return str;
        }

        private String preOrder(TreeNode root) {
            String str = "";
            if(root == null) {
                return "";
            }
            str+=root.val+",";
            str+=preOrder(root.left);
            str+=preOrder(root.right);
            return str;
        }
    }
}
