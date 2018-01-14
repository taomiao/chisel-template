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
	val arm_inst_table = MIPS_Instructions.Instructions
	val arm_inst_type = MIPS_Inst_type.Inst_type
	when(io.start_analysis){
		analysis()	
	}
	def analysis() = {
		//using switch(io.inst) maybe more efficent 
		val inst_pat = MIPS_Instructions.Instructions.values
		arm_inst_table.foreach{case (i,b) => when(b===io.inst){
						printf(p"$i--->$b--->typeofinst ${arm_inst_type(i)}")
						if(arm_inst_type(i) == 0){//R_type
							printf(p"if work")
							inst_format = ARM_R_type_format
							op = 
						}
						else if(arm_inst_type(i) == 1){


						}
						else if(arm_inst_type(i) == 2){

						}
					} 
				}
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
		val inst_op = Output(UInt(6.W))
		val start = Input(Bool())
		})
	val inst_ana = Module(new ARManalysis())
	//io.start := false.B
	inst_ana.io.inst := io.arm_Inst
	io.inst_op := inst_ana.io.op
	inst_ana.io.start_analysis := false.B	
	val arm_inst_table = MIPS_Instructions
	when(io.start){
		printf(p"hello")
		inst_ana.io.start_analysis := true.B	
		io.rv_Inst := 0.U		
	} 
	io.inst_Splited := false.B
	printf(p"test")
	
	
} 
