package mux

import chisel3.iotesters
import chisel3.iotesters.{Driver, PeekPokeTester}

class mux2UnitTester(c: Mux2) extends PeekPokeTester(c) {
	private val Mux2 = c
	
	poke(Mux2.io.sel,0)
	poke(Mux2.io.in0,0)
	poke(Mux2.io.in1,1)
	step(1)
	expect(Mux2.io.out,0)
	
	poke(Mux2.io.sel,0)
        poke(Mux2.io.in0,1)
        poke(Mux2.io.in1,0)
        step(1)
        expect(Mux2.io.out,1)

	poke(Mux2.io.sel,1)
        poke(Mux2.io.in0,0)
        poke(Mux2.io.in1,1)
        step(1)
        expect(Mux2.io.out,1)
}

