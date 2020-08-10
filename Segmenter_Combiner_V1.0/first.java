import java.io.*;
class first{
    public static void main(String []x){
        //file path is passed through command line arguement 
        String input=x[0];
        String out=x[1];
        try{
            InputStream inp=new FileInputStream(input);
            OutputStream op=new FileOutputStream(out);
           
            //getting the size of the file 
            long fileSize = new File(input).length();
            //a byte of the size and reading the while file at a time 
            byte[] array = new byte[(int) fileSize];
 

                inp.read(array);
                op.write(array);
   
        }catch(IOException e){
            System.out.println("Somethig went wrong");
            System.out.println(e.getStackTrace());
        }
    }
}
