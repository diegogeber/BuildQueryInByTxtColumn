import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		BufferedReader br = new BufferedReader(new FileReader("C:/input.txt"));
		String line;
		int elements = 0;
		bw.write("select * from funcionario f inner join usuario u on u.id_func=f.id where u.cod_usu in ( ");
		while ((line = br.readLine()) != null) {
			if(elements == 0){
				bw.newLine();
				bw.write("'" + line + "',");
				bw.newLine();
				elements++;
				continue;
			}
			
			if(elements != 1 && elements != 999){
				bw.write("'" + line + "',");
				bw.newLine();
			}else if(elements == 1){
				bw.write("or u.cod_usu in ('" + line + "',");
				bw.newLine();
	    	}else{
	    		bw.write("'" + line + "')");
				bw.newLine();
				elements = 1;
	    		continue;
		    }	 
			elements++;
		}
		bw.close();
	    br.close();
	}
}
