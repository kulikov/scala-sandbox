package sandbox.mapunion


object Main extends App {

  def deepSum[K, V](m1: Map[K, V], m2: Map[K, V]): Map[K, V] =
    m1 ++ m2.map({
      case (k, v: Map[_, _]) ⇒ k → deepSum(m1.getOrElse(k, Map.empty).asInstanceOf[Map[Any, Any]], v.asInstanceOf[Map[Any, Any]])
      case (k, v: Int) ⇒ k → plusNum(m1.get(k), v)
      case (k, v: Long) ⇒ k → plusNum(m1.get(k), v)
      case (k, v: Double) ⇒ k → plusNum(m1.get(k), v)
    }).asInstanceOf[Map[K, V]]

  def plusNum[N](n1: Option[Any], n2: N)(implicit num: Numeric[N]) =
    num.plus(n1.asInstanceOf[Option[N]].getOrElse(num.zero), n2)


  val m1 = Map("a" → Map("A" → 1, "B" → 4), "b" → Map("A" → 2, "C" → 3, "D" → 1))
  val m2 = Map("a" → Map("A" → 4, "D" → 2), "b" → Map("A" → 1, "C" → 1, "B" → 2))

  println("\n | " + deepSum(m1, m2) + "\n |\n")

  println("\n | " + deepSum(Map(1 → Map(1 → Map('a → 1))), Map(1 → Map(1 → Map('a → 2, 'b → 3)))) + "\n |\n")

}
