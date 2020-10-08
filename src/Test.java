import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		String linha;
		BufferedReader br = new BufferedReader(new FileReader("C:/amostra.txt"));
		while ((linha = br.readLine()) != null) {
		     System.out.println(linha);
		     bw.write("'" + linha + "',");
		     bw.newLine();
		}
		bw.close();
	    br.close();
	}
}
