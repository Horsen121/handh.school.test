package creatures

import kotlin.random.Random

open class Creature(
    private val name: String,
    private val attack: Int,
    private val defence: Int,
    private var maxXp: Int,
    private val minDamage: Int,
    private val maxDamage: Int
) {
    private var xp: Int = 0
        private set
    var isAlive = true
        private set

    init {
        require(name.isNotBlank()) { "creatures.Creature must have a name" }
        require(attack in 1..30) { "Attack must be in [1,30]" }
        require(defence in 1..30) { "Defence must be in [1,30]" }
        require(maxXp >0) { "Heat points must be >0" }
        require(minDamage >0) { "Defence must be natural number" }
        require(maxDamage  >0) { "Defence must be natural number" }

        xp = maxXp
    }

    fun getName() = this.name
    fun getMaxXP() = this.maxXp
    fun getXP() = this.xp

    fun changeXp(delta: Int): String {
        this.xp += delta
        return if(this.xp >0)
            "${this.name} have a ${this.xp} XP"
        else {
            this.isAlive = false
            "${this.name} died"
        }
    }

    fun dealDamage(enemy: Creature): String {
        if (!enemy.isAlive or !this.isAlive)
            return ""

        var attackModifier = this.attack - enemy.defence +1
        attackModifier = if (attackModifier <=0) 1 else attackModifier

        var isAttackSuccess = false
        for (i in 1..attackModifier) {
            if (Random.nextInt(1, 7) >= 5) {
                isAttackSuccess = true
                break
            }
        }

        if(isAttackSuccess) {
            val damage = -Random.nextInt(this.minDamage, this.maxDamage + 1)
            val res = enemy.changeXp(damage)
            return "${this.name} deal $damage to ${enemy.name} -> $res"
        } else
            return "${this.name} missed"
    }

    fun printStats(): String {
        return "${this.name} stats:\nXP - ${this.xp}\nAttack - ${this.attack}\nDefence - \n${this.defence}\nDamage - \n${this.minDamage}-\n${this.maxDamage}"
    }
}