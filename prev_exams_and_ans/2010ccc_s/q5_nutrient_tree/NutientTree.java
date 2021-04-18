import java.io.*;

public class NutientTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeNode root = createTreeNode(br.readLine());

        int growth = Integer.parseInt(br.readLine());
        maxFlow(root, growth);
        System.out.println(root.maxNutrients[growth]);
    }

    public static TreeNode createTreeNode(String s) {
        s = s.trim();
        if (!s.startsWith("("))
            return new TreeNode(Integer.parseInt(s));
        else {
            s = s.substring(1, s.length() - 1).trim();
            int i;
    
            // find the index that split the treeNode
            if (s.startsWith("(")) {
                int count = 1;
                i = 1;
                while (count > 0) {
                    if (s.charAt(i) == '(')
                        count++;
                    else if (s.charAt(i) == ')')
                        count--;
                    i++;
                }
                
            } else i = s.indexOf(" ");
    
            // create new node
            return new TreeNode(
                createTreeNode(s.substring(0, i)), 
                createTreeNode(s.substring(i+1))
            );
        }
    }

    public static void maxFlow(TreeNode node, int growth) {
        if (node.left == null || node.right == null) {
            // leaf node 
            TreeNode leaf = node;
            leaf.maxNutrients = new int[growth + 1];
            for (int i = 0; i <= growth; i++)
                leaf.maxNutrients[i] = leaf.value + i;
        } else {
            // branch node
            TreeNode n = node;
            
            int max, tmp;


            maxFlow(n.left, growth);
            int[] optL = new int[growth + 1];
            for (int i = 0; i <= growth; i++) {
                max = 0;
                for (int j = 0; j <= i; j++) {
                    tmp = Math.min((1+j)*(1+j), n.left.maxNutrients[i - j]);
                    if (tmp > max)
                        max = tmp;
                }
                optL[i] = max;
            }


            maxFlow (n.right, growth);
            int[] optR = new int [growth + 1];
            for (int i = 0 ; i <= growth ; i++) {
                max = 0;
                for (int j = 0 ; j <= i ; j++) {
                    tmp = Math.min ((1 + j) * (1 + j), n.right.maxNutrients [i - j]);
                    if (tmp > max) 
                        max = tmp;
                }
                optR [i] = max;
            }

            n.maxNutrients = new int [growth + 1];

	        for (int i = 0 ; i <= growth ; i++) {
		        max = 0;
		        for (int j = 0 ; j <= i ; j++) {
		            tmp = optL [j] + optR [i - j];
		            if (tmp > max)
			            max = tmp;
		            }
		        n.maxNutrients [i] = max;
	        }
        }
    }
}



class TreeNode {
    public int[] maxNutrients;
    public int value; // only leaf node has value
    public TreeNode left, right;

    public TreeNode(TreeNode l, TreeNode r) {
        value = 0;
        left = l;
        right = r;
    }

    public TreeNode(int v) {
        value = v;
        left = null;
        right = null;
    }
}