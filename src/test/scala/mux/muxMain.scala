package mux

import chisel3._

object muxMain extends App {
	iotesters.Driver.execute(args,()=>new Mux2){
		c => new mux2UnitTester(c)
	}
}
object muxRepl extends App {
	iotesters.Driver.executeFirrtlRepl(args, ()=> new Mux2)
}
