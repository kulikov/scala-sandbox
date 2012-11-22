
trait A {
 def receive: String
}

trait B extends A {
 abstract override def receive = super.receive + " updated!"
}

class My extends A {
 def receive = "My super 1"
}

println((new My with B).receive)
