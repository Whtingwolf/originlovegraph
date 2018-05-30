package dao;

import java.io.*;

public class Counter {
    private BufferedReader bufferedReader = null;
    public Counter(){

    }
    public synchronized String readFile(String path){
        String currentRecord=null;
        String returnString = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            currentRecord = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(currentRecord==null){
            returnString ="文件为空";
        }
        else {
            returnString=currentRecord;
        }
        return returnString;
    }
    public synchronized void writeFile(String path,String count){
        int writeCount = -1;
        writeCount= Integer.parseInt(count);
        PrintWriter pw=null;
        try {
            pw = new PrintWriter(new FileOutputStream(path));
            pw.println(writeCount);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            pw.close();
        }

    }
}
