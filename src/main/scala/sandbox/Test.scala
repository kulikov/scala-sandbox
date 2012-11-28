
trait A {
  def receive: String
}


trait B extends A {
  val myname = "Dima!"
  abstract override def receive = super.receive + " updated!"
}


class My extends A {
  this: B ⇒

  def receive = "My super 1 " + myname
}


//println((new My with B).receive)



case class Doc(id: Option[Int], n: Double = math.random)

val docs = Map(Doc(Some(1)) → 12, Doc(Some(3)) → 13, Doc(Some(1)) → 22, Doc(Some(43)) → 1)

println("\n | " + docs.filterNot(_._1.id == Some(1)) + "\n |\n")
