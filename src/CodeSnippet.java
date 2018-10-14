
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Chameera
 */
public class CodeSnippet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int data[] = new int[n];
        for(int i=0;i<n;i++)
        {
            data[i] = in.nextInt();
        }
        
        long tot=0;
        for(int i=0;i<n;i++){
          tot+=data[i];  
        } 
        
        Arrays.sort(data);
        
        System.out.println((float)tot/n);
        if(n%2==0)
            System.out.println(data[n/2]);
        else
            System.out.println((data[n/2]+data[n/2+1])/2.0);
        
        
    
    }
    
}
