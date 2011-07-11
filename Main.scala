
import java.io._
import java.net.{ServerSocket}
import scala.actors.Actor
import scala.actors.Actor._

object Main 
{
	def main(args : Array[String]) = {
		
		val port = 7777

		try {

	      val listener = new ServerSocket(port)
	      var numClients = 1
	      
	      println("Listening on port " + port)
	      
	      while (true) {
	        new ClientHandler(listener.accept(), numClients).start()
	        numClients += 1
	      }
	      
	      listener.close()

	    } catch {
	      case e: IOException =>
	        System.err.println( "Could not listen on port: " + port + "." )
	        System.exit(-1)
	    }

	}
}
