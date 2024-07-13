package theguide.modules.the_answer.impl

import kotlinx.coroutines.delay
import theguide.modules.autobind.annotations.AutoBind
import theguide.modules.the_answer.api.TheAnswerCalculator
import theguide.modules.the_union_of_philosophers.api.TheUnionOfPhilosophers
import javax.inject.Inject

@AutoBind
class DeepThought @Inject constructor(
    private val theUnionOfPhilosophers: TheUnionOfPhilosophers,
) : TheAnswerCalculator {
    override suspend fun theAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything(): Int {
        theUnionOfPhilosophers.protestTheAnswerCalculator()
        thinkDeeply()
        return 42
    }

    private suspend fun thinkDeeply(): Unit {
        delay(7)
    }
}
