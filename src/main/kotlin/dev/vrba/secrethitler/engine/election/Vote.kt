package dev.vrba.secrethitler.engine.election

enum class Vote(val value: Int) {
    Ja(1),
    Nein(-1),
    Hidden(0),
    None(0)
}