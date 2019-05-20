import java.util.Scanner;
import java.io.File;
class AutoCompleteMe {
	public static void main(String[] args) throws Exception { 
  
  String filename = args[0];
  Scanner in = new Scanner(new File(filename));
  int N = in.nextInt();
  Term[] terms = new Term[N];	
  for (int i = 0; i < N; i++) {
		long weight = in.nextLong();
		String query = in.nextLine().trim(); 
    terms[i] = new Term(query, weight);

 }
 in.close();

 int k = Integer.parseInt(args[1]);
 Autocomplete autocomplete = new Autocomplete(terms);
 Scanner stdin = new Scanner(System.in);
 while (stdin.hasNextLine()) {
  String prefix = stdin.nextLine();
  Term[] results = autocomplete.allMatches(prefix);
  for (int i = 0; i < Math.min(k, results.length); i++)
    System.out.println(results[i]); 
    }
 stdin.close(); }
 }
