package theguide.modules.the_union_of_philosophers.impl

import android.util.Log
import theguide.modules.autobind.annotations.AutoBind
import theguide.modules.the_union_of_philosophers.api.TheUnionOfPhilosophers
import javax.inject.Inject

@AutoBind
internal class TheUnionOfPhilosophersImpl @Inject constructor() : TheUnionOfPhilosophers {
    override suspend fun protestTheAnswerCalculator() {
        Log.w("UnionOfPhilosophers", "We demand demarcation")
    }
}
