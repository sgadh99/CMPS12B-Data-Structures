public class Dictionary implements DictionaryInterface {


   private class Node {
      Pair item;
      Node left;
      Node right;

      Node(Pair x) {
         item = x;
         left = null;
         right = null;
      }
   }

 
   private class Pair {
      String key;
      String value;

      Pair(String k, String v) {
         key = k;
         value = v;
      }
   }

 
   private Node root;
   private int numItems;


   public Dictionary() {
      root = null;
      numItems = 0;
   }

   
   private Node findKey(Node R, String k) {
      if (R == null || R.item.key.equals(k)) return R;
      if (R.item.key.compareToIgnoreCase(k) > 0)
         return findKey(R.left, k);
      else return findKey(R.right, k);
   }

   Node findParent(Node N, Node R) {
      Node P = null;
      if (N != R) {
         P = R;
         while(P.left != N && P.right != N) {
            if (N.item.key.compareToIgnoreCase(P.item.key) < 0)
               P = P.left;
            else
               P = P.right;
         }
      }
      return P;
   }

   Node findLeftmost(Node R) {
      Node L = R;
      if (L != null)
         for ( ; L.left != null; L = L.left);
            return L;
      }

   void printInOrder(Node R) {
      if (R != null) {
         printInOrder(R.left);
         System.out.println(R.item.key + " " + R.item.value);
         printInOrder(R.right);
      }
   }

   void deleteAll(Node N) {
      if (N != null) {
         deleteAll(N.left);
         deleteAll(N.right);
      }
   }

  
   public boolean isEmpty() {
      return (numItems == 0);
   }

   public int size() {
      return numItems;
   }

   public String lookup(String key) {
      Node N;
      N = findKey(root, key);
      return (N == null ? null : N.item.value);
   }

 
   public void insert(String key, String value) throws DuplicateKeyException{
      Node N, A, B;
      if(findKey(root, key)!=null){
         throw new DuplicateKeyException("Dictionary Error: insert() cannot insert duplicate keys");
      }
      N = new Node(new Pair(key, value));
      B = null;
      A = root;
      while( A != null ){
         B = A;
         if(A.item.key.compareToIgnoreCase(key)>0) A = A.left;
         else A = A.right;
      }

      if( B == null ) root = N;
      else if(B.item.key.compareToIgnoreCase(key)>0) B.left = N;
      else B.right = N;
      numItems++;
   }

   
   public void delete(String key) throws KeyNotFoundException{
      Node N, P, S;
      if(findKey(root, key)==null){
         throw new KeyNotFoundException("Dictionary Error: delete() cannot delete non-existent key");
      }
      N = findKey(root, key);
      if( N.left == null && N.right == null ){
         if( N == root ){
            root = null;
         }else{
            P = findParent(N, root);
            if( P.right == N ) P.right = null;
            else P.left = null;
         }
      }else if( N.right == null ){
         if( N == root ){
            root = N.left;
         }else{
            P = findParent(N, root);
            if( P.right == N ) P.right = N.left;
            else P.left = N.left;
         }
      }else if( N.left == null ){
         if( N == root ){
            root = N.right;
         }else{
            P = findParent(N, root);
            if( P.right == N ) P.right = N.right;
            else P.left = N.right;
         }
      }else{  
         S = findLeftmost(N.right);
         N.item.key = S.item.key;
         N.item.value = S.item.value;
         P = findParent(S, N);
         if( P.right == S ) P.right = S.right;
         else P.left = S.right;
      }
      numItems--;
   }

   public void makeEmpty(){
      deleteAll(root);
      root = null;
      numItems = 0;
   }

   public String toString(){
      printInOrder(root);
      return "";
   }
}
