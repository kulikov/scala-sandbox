package sandbox.rabbit

import com.libitec.sce.util.amqp.{AmqpClient, AmqpSettings}
import com.typesafe.config.ConfigFactory


object Main extends App {

  val amqp1 = new AmqpClient(
    new AmqpSettings(ConfigFactory.parseString(
      """
        |host = "range.megoplan.ru"
        |port = 5672
        |username = guest
        |password = guest
        |exchange = sce_test
        |queue = "test_q"
        |virtualHost = /
        |heartbeatInterval = 60
      """.stripMargin))
  )

  val amqp2 = new AmqpClient(
    new AmqpSettings(ConfigFactory.parseString(
      """
        |host = "range.megoplan.ru"
        |port = 5672
        |username = guest
        |password = guest
        |exchange = sce_test2
        |queue = "test_q"
        |virtualHost = /
        |heartbeatInterval = 60
      """.stripMargin))
  )


  amqp1.subscribe("test.message") { (msg, _, _) ⇒
    println("amqp1: ")
    println(new String(msg))
  }

  amqp2.subscribe("test.message") { (msg, _, _) ⇒
    println("amqp2: AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!! ")
    println(new String(msg))
  }

  for (i ← 1 to 100) {
    amqp1.publish("test.message", ("hello " + i).getBytes)
  }
}
