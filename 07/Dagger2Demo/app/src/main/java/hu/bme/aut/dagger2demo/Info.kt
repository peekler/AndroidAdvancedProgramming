package hu.bme.aut.dagger2demo

import javax.inject.Inject

class Info @Inject constructor(private val detail: Detail) {
    val text = "Hello Info ${detail.detailText}"
}

class Detail(private val nr: Int) {
    val detailText = "the Detail $nr"
}