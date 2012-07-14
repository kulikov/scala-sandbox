package sandbox.typeclasses


class User(val name: String)

trait Comparator[T] {
  def compare(a: T, b: T): Int
}

class Test {
  def run[T : Comparator](u1: T, u2: T) {
    val us = new UserService
    val re = us.cmp(u1, u2)
    println(re)
  }
}

class UserService {
  def cmp[T](u1: T, u2: T)(implicit c: Comparator[T]) = {
    c.compare(u1, u2)
  }
}

object Main extends App {

  implicit val userComparator = new Comparator[User] {
    def compare(a: User, b: User) = a.name.compare(b.name)
  }

//  val userService = new UserService

  (new Test).run(new User("Dima"), new User("David"))

//  val res = userService.cmp(new User("Dima"), new User("David"))

//  userService.test(new User("Dima"), new User("David"))

//  println("result: " + res)
}
