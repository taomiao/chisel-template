package ARMtoRV32

import chisel3._

object ARMtoRVRepl extends App {
	iotesters.Driver.executeFirrtlRepl(args,() => new ARMtoRV)
}
