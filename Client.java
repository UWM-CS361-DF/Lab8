import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Client {

	public static void main(String[] args) {
		try {
			System.out.println("in the client");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/sendresults");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());

			// build a string that contains JSON from console
			String content = "";
			content = getJSON();

			// write out string to output buffer for message
			out.writeBytes(content);
			out.flush();
			out.close();

			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getJSON() {

		ArrayList<Employee> em = new ArrayList<Employee>();
		em.add(new Employee("Katie", "Krowsky", "Computer Science", "1"));
		em.add(new Employee("Justin", "Jacobson", "Computer Science", "2"));
		em.add(new Employee("Junichi", "Iida", "Baz", "3"));
		em.add(new Employee("Shuxin", "Dong", "Disney Animals", "4"));
		Gson g = new Gson();
		String json = g.toJson(em);
		return json;
	}

}
