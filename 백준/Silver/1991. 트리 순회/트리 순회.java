import java.io.BufferedReader;
import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    static Node[] tree;

    public static void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);

    }

    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if(tree[parentValue - 'A'] == null){
                tree[parentValue - 'A'] = new Node(parentValue);
            }

            if(leftValue != '.'){
                tree[leftValue - 'A'] = new Node(leftValue);
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];

            }

            if(rightValue != '.'){
                tree[rightValue-'A'] = new Node(rightValue);
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();

        inOrder(tree[0]);
        System.out.println();

        postOrder(tree[0]);
        System.out.println();

        


    }
    
}

