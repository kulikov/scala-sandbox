
import scala.actors.Actor
import java.io._
import java.net.{Socket, SocketException}

class ClientHandler (socket : Socket, clientId : Int) extends Actor
{
  
  def act 
  {

    try {

      val out = new PrintWriter( socket.getOutputStream(), true )
      val in = new BufferedReader( new InputStreamReader(socket.getInputStream()) )
      
      print( "Client connected from " + socket.getInetAddress() + ":" + socket.getPort )
      println( " assigning id " + clientId)
      
      var inputLine = in.readLine()
      while (inputLine != null && inputLine != "exit") {  
        println(clientId + ") " + inputLine)
        out.println("re: " + inputLine)
        inputLine = in.readLine()
      }
      
      socket.close()
      
      println("Client " + clientId + " exit")

    } catch {
      case e: SocketException => System.err.println(e)
      case e: IOException => System.err.println(e.getMessage)
      case e => System.err.println("Unknown error " + e)
    }
  }
}
