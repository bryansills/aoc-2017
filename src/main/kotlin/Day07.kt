import utils.splitNewlines
import utils.splitWhitespace
import java.lang.Comparable

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

        var weirdNode = findNode(rootNode)

        val sisterNode = weirdNode.parent?.children?.find { it.name != weirdNode.name } ?: throw IllegalStateException("no sis node?")

        return sisterNode.totalWeight() - weirdNode.children.sumBy { it.totalWeight() }
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
        if (node.children.size > 2) {
            var minNode = node.children.minBy { it.totalWeight() }
            var maxNode = node.children.maxBy { it.totalWeight() }

            var minWeight = minNode?.totalWeight() ?: throw IllegalStateException("no min?")
            var maxWeight = maxNode?.totalWeight() ?: throw IllegalStateException("no max?")

            if (node.children.find { minNode.name != it.name && minWeight == it.totalWeight() } == null) {
                return findNode(maxNode)
            }

            if (node.children.find { maxNode.name != it.name && maxWeight == it.totalWeight() } == null) {
                return findNode(minNode)
            }

            return node
        } else if (node.children.size == 2) {
            // TODO: FINISH HERE
            return node
        } else {
            return node
        }
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