package creatures

/**
 * The base class for all type of Monsters in the game
 *
 * @property name Monster's type name
 * @property attack Monster type's value of the attack param
 * @property defence Monster type's value of the defence param
 * @property maxHp Monster type's value of the max hit points
 * @property minDamage Value of the min damage that the Monster type's can deal
 * @property maxDamage Value of the max damage that the Monster type's can deal
 */
class Monster(name: String, attack: Int=5, defence: Int=5, xp: Int=10, minDamage: Int=1, maxDamage: Int=3):
    Creature(name, attack, defence, xp, minDamage, maxDamage)
{

}