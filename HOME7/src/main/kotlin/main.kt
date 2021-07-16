fun main(args: Array<String>) {
    val A = View("A")
    val B = View("B")
    val E = View("E")
    A.addView(B)
    A.addView(E)
    val C = View("C")
    B.addView(C)
    val D = View("D")
    C.addView(D)
    val F = View("F")
    E.addView(F)
    val G = View("G")
    E.addView(G)
    val H = View("H")
    G.addView(H)

    val result: View? = findMinimalParent(H, G)
    println(result.toString()) // E
}

fun findMinimalParent(view1: View, view2: View): View? {

    var parentsList1 = mutableListOf<String>()

    var v1 = view1
    var v2 = view2

    while (v1.parent != null) {
        v1 = v1.parent!!
        parentsList1.add(v1.toString())
    }

    while (true) {
        if ((v2.parent != null) && (parentsList1.contains(v2.parent.toString()))) {
            break

        } else if (v2.parent != null) {
            v2 = v2.parent!!
        }
    }
    return v2.parent
}