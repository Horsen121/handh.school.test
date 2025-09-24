package creatures

/**
 * The Player class
 *
 * @property name Player's name
 * @property attack Player's value of the attack param
 * @property defence Player's value of the defence param
 * @property maxHp Player's value of the max hit points
 * @property minDamage Value of the min damage that the Player can deal
 * @property maxDamage Value of the max damage that the Player can deal
 */
class Player(name: String, attack: Int, defence: Int, xp: Int, minDamage: Int, maxDamage: Int) :
    Creature(name, attack, defence, xp, minDamage, maxDamage)
{
    private var healCount = 4

    /**
     * Trying to heal themselves
     *
     * @return A string describing the result of healing
     */
    fun heal(): String {
        if (healCount >=0) {
            this.healCount -=1
            val hp = this.changeHp((this.getMaxXP()*0.3).toInt() )
            return "${this.getName()} get healed -> $hp"
        } else
            return "${this.getName()} has no way to heal"
    }
}