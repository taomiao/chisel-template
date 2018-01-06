package ARMtoRV32

import chisel3._

class ARManalysis extends Module {
	val io = IO(new Bundle {
		val inst = Input(UInt(32.W))
		val op = Output(UInt(6.W))
		val rs0 = Output(UInt(5.W))
		val rs1 = Output(UInt(5.W))
		val rs2 = Output(UInt(5.W))
		val Imm = Output(UInt(32.W))
		//contral sig
		val start_analysis = Input(Bool())
		val end_analysis = Output(Bool())
		})
	
	def analysis() = {
	
	}	
}

class RV32generator extends Module {
	val io = IO(new Bundle{
		val op = Input(UInt(6.W))
		val rs0 = Input(UInt(5.W))
		val rs1 = Input(UInt(5.W))
		val rs2 = Input(UInt(5.W))
		val Imm = Input(UInt(32.W))
		val inst = Output(UInt(32.W))
		//contral sig
		val start_gen = Input(Bool())
		val end_gen = Output(Bool())
		})
	
	when(io.start_gen){
		generate()
		io.start_gen := false.B
	}
	def generate() = {
		io.end_gen := true.B	
	}

}

class ARMfetch extends Module {
	val io = IO(new Bundle {
		val next_addr = Input(UInt(32.W))
		val fetch_addr = Output(UInt(32.W)) 
		val ready = Output(Bool())
		})
	
	val pc = Reg(UInt(32.W))
	val data = Mem(5,UInt(32.W))
	
}

class ARMtoRV extends Module {
	val io = IO(new Bundle {
		val arm_Inst = Input(UInt(32.W))
		val rv_Inst = Output(UInt(32.W))
		val inst_Splited = Output(UInt(1.W))
		})
	io.rv_Inst := io.arm_Inst
	io.inst_Splited := false.B
	printf(p"test")
	
	
} 
