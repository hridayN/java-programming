package DataUsage;

import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class CalculateDataUsage {

    public static void main(String []args) throws IOException {

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\projects\\java-programming\\ExcitelUsage\\June-30-2021.txt")));
        } catch(FileNotFoundException e){
            System.out.println("Some Error Has Occurred!!!");
        }

        String readLine = reader.readLine();
        StringTokenizer st;
        double time = 0.0;
        double mb = 0.0;
        while(readLine!=null){
            st = new StringTokenizer(readLine);
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            time = time + Double.parseDouble(st.nextToken());
            mb = mb + Double.parseDouble(st.nextToken());
            readLine = reader.readLine();
        }

        DecimalFormat df = new DecimalFormat("#.##");
        time = Double.parseDouble(df.format(time/60));
        mb = Double.parseDouble(df.format(mb /1024));

        System.out.println("Time => " + time + " hours");
        System.out.println("Usage => " + mb + " GB(s)");

        if(reader!=null){
            reader.close();
        }
    }
}
