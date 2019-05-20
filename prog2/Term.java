import java.util.*;

public class Term implements Comparable<Term>{
	private String q;
	private long w;
 
	public Term(String q, long w) throws Exception{
	 if(q==null)
		throw new NullPointerException("No null queries.");
	 if(w<0)
		 throw new IllegalArgumentException("No negative weights.");
	 this.q = q;
	 this.w = w;
	 
 }
 
 public static Comparator<Term> byReverseWeightOrder(){
	 return new Comparator<Term>(){
		 public int compare(Term t1, Term t2){
			 return (int)(t2.w- t1.w);
		 }
	 };
 }

 public static Comparator<Term> byPrefixOrder(int r) throws Exception{
	 if(r<0)
		 throw new IllegalArgumentException("r is negative"); 
	 return new Comparator<Term>(){
		 public int compare(Term t1, Term t2){
			 String p1 = "";
			 String p2 = "";
			 
			 if ((t1.q.length() < r) || (t2.q.length() <r)){
				 p1 = t1.q;
				 p2 = t2.q;
			 }
			 else{
				 p1 = t1.q.substring(0,r);
				 p2 = t2.q.substring(0, r);
			 }
			 return p1.compareTo(p2);
		 }
	 };
 }


 public int compareTo(Term that){
	return this.q.compareTo(that.q);
}
 
 public String toString(){
	 return w + "\t"+ q;
 }

 public static void main(String[] args) throws Exception{
	 Term[] tms = {new Term("test", 3), new Term("case", 5), new Term("one", 10)};
	 System.out.println(Arrays.toString(tms));
	 Arrays.sort(tms);
	 System.out.println(Arrays.toString(tms));
	 Arrays.sort(tms, Term.byReverseWeightOrder());
	 System.out.println(Arrays.toString(tms));
	 System.out.println(Term.byPrefixOrder(3).compare(tms[0], tms[1]));
 }
}





