/*
java Combiner /home/roshan/Music/java_project/Combiner
*/
import java.io.*;
class Combiner{
    public static void main(String []x){
        try{
        //To combine the segmented files 
        InputStream inp;
        
        //x[0] contains the path of the directory 
        //Taking the part of files from the directory 
        File name=new File(x[0]);
 
 
        /*    for (File x1 :name.listFiles()){
            if(x1.isDirectory())
            System.out.println(x1.getName() + "Is a Directory .");
            else
            System.out.println(x1.getName()+ "Is a one of the files .");
        }    */

 
 
        //count the number of directories/files in the system
        int k = name.listFiles().length ;
        //array of size 1 byte to read  a byte of data
        byte arr[] = new byte[1];   
        System.out.println("Number of files are "+ k); //number of files 
        //array to hold the m differnenat segments 
        InputStream array[] = new FileInputStream[(int)name.listFiles().length] ;
        long fileSize = 0; //total size of the combined file size 
        
        
        for(File t :name.listFiles()) {
           if(!(t.isDirectory())){
               System.out.println(t.getName());
               inp=new FileInputStream(t.getPath()); //get name cause an error due to 
               //the .class file and segmented files are in differnent places 
               inp.read(arr);
               array[(int)(arr[0])]=inp; //storing the file in the mth location 
               fileSize+= new File(t.getPath()).length(); //size=sum of m segmented files 
           } 
        }

        fileSize-=(long)k;// reducing the first byte of data m segmented(for storing order)

       // System.out.println(fileSize);
        byte arr1[]=new byte[(int)fileSize];//array for combined file size 
        //writing the content in merged file 
        for(int i=0 ; i<(fileSize) ; i++){
            array[i%k].read(arr) ;
            arr1[i]=arr[0];
        }

        //closing the input files 
        for(int i=0;i<k;i++)
        array[i].close();

        //writing the output files and closing it
        OutputStream c=new FileOutputStream(name.listFiles()[0].getPath()+"Combined");
        c.write(arr1);
        c.close();
        }catch(Exception e){
            System.out.println("Exception occured.");
            System.out.println(e);
        }
    }
}