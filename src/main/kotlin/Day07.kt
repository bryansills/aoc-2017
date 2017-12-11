import utils.splitNewlines
import utils.splitWhitespace

object Day07 {

    fun part1(input: String): String {
        val splitInput = input.splitNewlines().map { it.splitWhitespace() }

        val nodes = createNodes(splitInput)
        val rootNode = linkNodes(nodes)

        return rootNode.name
    }

    fun part2(input: String): Int {
        val splitInput = input.splitNewlines().map { it.splitWhitespace() }

        val nodes = createNodes(splitInput)
        val rootNode = linkNodes(nodes)

        val weirdNode = findNode(rootNode)
        val expectedWeight = getExpectedWeight(weirdNode)

        return expectedWeight - weirdNode.children.sumBy { it.totalWeight() }
    }

    private fun createNodes(input: List<List<String>>): List<Node> {
        val result = mutableListOf<Node>()

        input.forEach {
            val name = it[0]
            val rawWeight = it[1]

            var childrenStr: List<String>? = null
            if (it.size >= 4) {
                childrenStr = it.subList(3, it.lastIndex + 1).map { it.replace(",", "") }
            }

            result.add(Node(name = name, weight = rawWeight.substring(1, rawWeight.lastIndex).toInt(), childrenStr = childrenStr))
        }

        return result
    }

    private fun linkNodes(input: List<Node>): Node {
        input.forEach {
            parentNode -> parentNode.childrenStr?.forEach {
                childName ->
                    val child = input.first {
                        it.name == childName
                    }

                    child.parent = parentNode
                    parentNode.children.add(child)
            }
        }

        var result = input[0]

        while (result.parent != null) {
            result = result.parent!!
        }

        return result
    }

    private fun findNode(node: Node): Node {
        when {
            node.children.size > 2 -> {
                val minNode = node.children.minBy { it.totalWeight() }
                val maxNode = node.children.maxBy { it.totalWeight() }

                val minWeight = minNode?.totalWeight() ?: throw IllegalStateException("no min?")
                val maxWeight = maxNode?.totalWeight() ?: throw IllegalStateException("no max?")

                if (node.children.find { minNode.name != it.name && minWeight == it.totalWeight() } == null) {
                    return findNode(minNode)
                }

                if (node.children.find { maxNode.name != it.name && maxWeight == it.totalWeight() } == null) {
                    return findNode(maxNode)
                }

                return node
            }
            node.children.size == 2 -> {
                if (node.children[0].totalWeight() != node.children[1].totalWeight()) {
                    val minNode = node.children.minBy { it.totalWeight() } ?: throw IllegalStateException("wtf happened")
                    val maxNode = node.children.maxBy { it.totalWeight() } ?: throw IllegalStateException("wtf happened")

                    val expectedWeight = getExpectedWeight(node)
                    return when {
                        expectedWeight > node.totalWeight() -> findNode(minNode)
                        expectedWeight < node.totalWeight() -> findNode(maxNode)
                        else -> throw IllegalStateException("siblings shouldn't weigh the same if children don't weigh the same")
                    }
                }

                return node
            }
            node.children.size == 1 -> return findNode(node.children[0])
            else -> return node
        }
    }

    private fun getExpectedWeight(node: Node): Int {
        val parent = node.parent
        val sibling = parent?.children?.find { node != it }

        sibling?.let { return it.totalWeight() }
        parent?.let { return getExpectedWeight(parent) - it.weight }

        throw IllegalStateException("ambiguous situation")
    }
}

data class Node (val name: String,
                 val weight: Int,
                 var parent: Node? = null,
                 var children: MutableList<Node> = mutableListOf(),
                 val childrenStr: List<String>?) {
    fun totalWeight(): Int {
        return weight + children.sumBy { it.totalWeight() }
    }
}