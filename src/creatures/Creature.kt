package creatures

import kotlin.random.Random

/**
 * The base class for all type of creatures in the game
 *
 * @property name Name of the creature type
 * @property attack Value of the attack param of the creature
 * @property defence Value of the defence param of the creature
 * @property maxHp Value of the max hit points of the creature
 * @property minDamage Value of the min damage that the creature can deal
 * @property maxDamage Value of the max damage that the creature can deal
 */
open class Creature(
    private val name: String,
    private val attack: Int,
    private val defence: Int,
    private var maxHp: Int,
    private val minDamage: Int,
    private val maxDamage: Int
) {
    private var currentHp: Int = 0
    var isAlive = true
        private set

    init {
        require(name.isNotBlank()) { "Creature must have a name" }
        require(attack in 1..30) { "Attack must be in [1,30]" }
        require(defence in 1..30) { "Defence must be in [1,30]" }
        require(maxHp >0) { "Max value of the hit points must be natural number" }
        require(minDamage >0) { "Damage must be natural number" }
        require(maxDamage  >0) { "Damage must be natural number" }

        currentHp = maxHp
    }

    /**
     * @return Name of the creature
     */
    fun getName() = this.name


    /**
     * @return Max hp value of the creature
     */
    fun getMaxXP() = this.maxHp


    /**
     * @return Current hp value of the creature
     */
    fun getXP() = this.currentHp


    /**
     * Change the current hp of the creature
     *
     * @param delta The value that the current hp will change to
     * @return A string describing the result of the change
     */
    fun changeHp(delta: Int): String {
        this.currentHp += delta
        return if(this.currentHp >0)
            "${this.name} have a ${this.currentHp} XP"
        else {
            this.isAlive = false
            "${this.name} died"
        }
    }

    /**
     * Trying to deal damage on the enemy
     *
     * @param enemy A creature that should take damage
     * @return A string describing the result of the attack
     */
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
            val res = enemy.changeHp(damage)
            return "${this.name} deal $damage to ${enemy.name} -> $res"
        } else
            return "${this.name} missed"
    }

    /**
     * @return A string describing the current stats of the creature
     */
    fun printStats(): String {
        return "${this.name} stats:\nXP - ${this.currentHp}\nAttack - ${this.attack}\nDefence - ${this.defence}\nDamage - ${this.minDamage}-${this.maxDamage}"
    }
}