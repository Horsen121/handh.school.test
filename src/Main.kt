import creatures.Monster
import creatures.Player

fun main() {
    val player = Player("Player",8, 8, 10, 1, 6)
    val m1 = Monster("Monster1")
    val m2 = Monster("Monster2")

    println("START\n")
    println("${player.printStats()}\n")
    println("${m1.printStats()}\n")
    println("${m2.printStats()}\n\n")
    while (m1.isAlive or m2.isAlive) {
        if (m1.isAlive) {
            println(player.dealDamage(m1))
            println(m1.dealDamage(player))
        }
        if (m2.isAlive) {
            println(player.dealDamage(m2))
            println(m2.dealDamage(player))
        }

        if (player.getXP() <= (player.getMaxXP()*0.7).toInt())
            println(player.heal())
        println()

        if (!player.isAlive)
            break
    }
    println("\nFINISH")
}