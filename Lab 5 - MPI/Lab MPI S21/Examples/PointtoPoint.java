/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dina Tantawy
 */
import com.sun.net.httpserver.Authenticator;
import mpi.*;

import static mpi.MPI.*;

public class PointtoPoint {

    public static void main(String[] args) {
         Init(args) ;
//		 try {
//			Thread.sleep(1000);                 //1000 milliseconds is one second.
//		 } catch(InterruptedException ex) {
//			Thread.currentThread().interrupt();
//		 }
		 int myrank = COMM_WORLD.Rank() ;
                 System.out.println("My Rank: "+myrank);
		 if(myrank == 0) {
			 char[] message = "Hello, there".toCharArray() ;
			 System.out.println("will send:" + new String(message) + ":") ;

//			 try {
//			Thread.sleep(3000);                 //1000 milliseconds is one second.
//		 	}
//			 catch(InterruptedException ex) {
//			Thread.currentThread().interrupt();
//		 	}
//                         COMM_WORLD.Send(message, 0, message.length, CHAR, 1, 99) ;
//                         COMM_WORLD.Ssend(message, 0, message.length, CHAR, 1, 99) ;

			 Request r = COMM_WORLD.Isend(message, 0, message.length, CHAR, 1, 99) ;


		 }
		 else {
			 char[] message = new char [20] ;
			 System.out.println("will receive:" + new String(message) ) ;
			 Request req = COMM_WORLD.Irecv(message, 0, 20, MPI.CHAR, 0, 99) ;
//			 COMM_WORLD.Recv(message, 0, 20, CHAR, 0, 99) ;
			 System.out.println("received:" + new String(message)) ;
                         req.Wait();
						 System.out.println("My Rank: "+myrank+" and I received after waiting:" + new String(message) ) ;
		 }
//		 MPI.COMM_WORLD.Barrier();
		 Finalize() ;
    }
}
