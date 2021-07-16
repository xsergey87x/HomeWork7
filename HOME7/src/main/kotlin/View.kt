
class View(private val id: String) {

    var parent: View? = null
    private val children = mutableListOf<View>()

    fun addView(view: View) {
        view.parent = this
        children.add(view)
    }

    override fun toString(): String {
        return id
    }
}