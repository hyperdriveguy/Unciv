package com.unciv.models.ruleset

import com.unciv.models.ruleset.unique.Unique
import com.unciv.models.ruleset.unique.UniqueTarget
import com.unciv.models.ruleset.unique.UniqueType

class GlobalUniques: RulesetObject() {
    override fun getUniqueTarget() = UniqueTarget.Global
    override fun makeLink() = "" // No own category on Civilopedia screen

    companion object {
        fun getUniqueSourceDescription(unique: Unique): String {
            if (unique.conditionals.none())
                return "Global Effect"

            return when (unique.conditionals.first().type) {
                UniqueType.ConditionalGoldenAge -> "Golden Age"
                UniqueType.ConditionalHappy -> "Happiness"
                UniqueType.ConditionalBetweenHappiness, UniqueType.ConditionalBelowHappiness -> "Unhappiness"
                else -> "Global Effect"
            }
        }
    }
}