package dev.vrba.secrethitler

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("dev.vrba.secrethitler")
		.start()
}

