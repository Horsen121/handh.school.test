package creatures

class Player(name: String, attack: Int, defence: Int, xp: Int, minDamage: Int, maxDamage: Int) :
    Creature(name, attack, defence, xp, minDamage, maxDamage)
{
    var healCount = 4

    fun heal(): String {
        if (healCount >=0) {
            this.healCount -=1
            return this.changeXp((this.getMaxXP()*0.3).toInt() )
        } else
            return "${this.getName()} has no way to heal"
    }
}