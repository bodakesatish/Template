package com.bodakesatish.data.mapper.base

interface Mapper<From, To> {
    fun From.mapTo(): To
    fun To.mapFrom(): From

    fun List<From>.mapTo(): List<To> {
        return map { it.mapTo() }
    }

    fun List<To>.mapFrom(): List<From> {
        return map { it.mapFrom() }
    }
}