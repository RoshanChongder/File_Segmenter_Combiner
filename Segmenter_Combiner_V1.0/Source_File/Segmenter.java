/*
java Segmenter /home/roshan/Music/java_project/Segmenter/ASS14.pdf 
full path of the file 
*/
import java.io.*;
import java.util.*;
class Segmenter{
    //command line arguements are passed 
    //x[0] path to the file , where the fileexsts 
    //x[1] number segments to be created 
    static Scanner obj=new Scanner(System.in);
    public static void main(String []x){
        //file path is passed through command line arguement 
        try{
            System.out.println("Programme Running");
            InputStream inp = new FileInputStream(x[0]);
            

            //getting the size of the file to be segmented 
            long fileSize = new File(x[0]).length();
            //System.out.println((int)fileSize) ;  //printing the file size 


            //reading the whole file at once 
            byte[] array = new byte[(int) fileSize];
            inp.read(array);   // reading the file 
            inp.close();


            //Creation of m separate files  
            //System.out.print("Enter the number of sub-files :");
            //int m=obj.nextInt();  //number of parts
            int m = Integer.parseInt(x[1]);

            //creating a folder named Segmenter 
            new File("Segmenter").mkdir();


            //storing the main file in m number of sub-files 
            OutputStream []op=new FileOutputStream[m] ;
            String s="part";
            for(int i=0;i<m;i++){
            /*segmeted file will be sotered in a directory named 
            Segmenter just above the current directory of Segmenter.class file*/
            op[i]=new FileOutputStream("Segmenter/"+s+(i+1));
            op[i].write((byte)i) ;  //storing order number of the file 
            //in time of combining it will be used 
            }
            

            //writing the content in m separated file 
            //where the .class file is , the segments wil be stored over there 
            for(int i=0;i<fileSize;i++){ op[i%m].write(array[i]); }
            
            
            //closing the output file 
            for(int i=0;i<m;i++) op[i].close();
        }catch(IOException e){
            System.out.println("Somethig went wrong");
            System.out.println(e);
        }
    }
}