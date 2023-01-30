package com.vshum.pulsetracker.domain

/**
 * Интерфейс CallBack
 * Стандартный кастомный колбек, для простоты только с одним методом,
 * в большинстве случаев его хватает полностью.
 * В случае наличия необходимости применения большего количества методов
 * лучше создать расширенный интерфейс колбека отдельно или наследуясь от данного интерфейса.
 */
interface CallBack<T> {
    fun onResult(value: T)
}