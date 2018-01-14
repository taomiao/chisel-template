package ARMtoRV32

import chisel3._

object ARManalysisRepl extends App {
	iotesters.Driver.executeFirrtlRepl(args,() => new ARManalysis)
}

object RV32generatorRepl extends App {
	iotesters.Driver.executeFirrtlRepl(args,() => new RV32generator)
}

object ARMtoRVRepl extends App {
	iotesters.Driver.executeFirrtlRepl(args,() => new ARMtoRV)
}
