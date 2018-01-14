package ARMtoRV32

import Chisel._
import scala.collection.mutable.ArrayBuffer

object ARM_R_type_format{
	val type_num = 0
	val type_field_num = 6
	val type_fields : List[String] = List("opcode","s","t","d","a","f")
	val type_fields_len : List[Int] = List(6,5,5,5,5,6)
}
object ARM_I_type_format{
	val type_num = 1
	val type_field_num = 4
	val type_fields : List[String] = List("opcode","s","t","i")
	val type_fields_len : List[Int] = List(6,5,5,16)
}
object ARM_J_type_format{
	val type_num = 2
	val type_field_num = 2
	val type_fields : List[String] = List("opcode","i")
	val type_fields_len : List[Int] = List(6,26)
}

object MIPS_Inst_type {
	val Inst_type = Map(
		   "SLL"                    -> 0,
		   "MOVCI"                  -> 0,
		   "SRL"                    -> 0,
		   "SRA"                    -> 0,
		   "SLLV"                   -> 0,
		 
		   "SRLV"                   -> 0,
		   "SRAV"                   -> 0,
		   "JR"                     -> 0,
		   "JALR"                   -> 0,
		   "MOVZ"                   -> 0,
		   "MOVN"                   -> 0,
		   "SYSCALL"                -> 0,
		   "BREAK"                  -> 0,
		 
		   "SYNC"                   -> 0,
		   "MFHI"                   -> 0,
		   "MFLO"                   -> 0,
		   "DSLLV"                  -> 0,
		 
		   "DSRLV"                  -> 0,
		   "DSRAV"                  -> 0,
		   "MULT"                   -> 0,
		   "MULTU"                  -> 0,
		   "DIV"                    -> 0,
		   "DIVU"                   -> 0,
		   "DMULTU"                 -> 0,
		   "DDIV"                   -> 0,
		   "DDIVU"                  -> 0,
		   "ADD"                    -> 0,
		   "ADDU"                   -> 0,
		   "SUB"                    -> 0,
		   "SUBU"                   -> 0,
		   "AND"                    -> 0,
		   "OR"                     -> 0,
		   "XOR"                    -> 0,
		   "NOR"                    -> 0,
		 

		   "SLT"                    -> 0,
		   "SLTU"                   -> 0,
		   "DADD"                   -> 0,
		   "DADDU"                  -> 0,
		   "DSUB"                   -> 0,
		   "DSUBU"                  -> 0,
		   "TGE"                    -> 0,
		   "TGEU"                   -> 0,
		   "TLT"                    -> 0,
		   "TLTU"                   -> 0,
		   "TEQ"                    -> 0,
		 
		   "TNE"                    -> 0,
		   "DSLL"                   -> 0,
		 
		   "DSRL"                   -> 0,
		   "DSRA"                   -> 0,
		   "DSLL32"                 -> 0,

		   "DSRL32"                 -> 0,
		   "DSRA32"                 -> 0,

		   "BLTZ"                   -> 0,
		   "BGEZ"                   -> 0,
		   "BLTZL"                  -> 0,
		   "BGEZL"                  -> 0,




		   "TGEI"                   -> 0,
		   "TGEIU"                  -> 0,
		   "TLTI"                   -> 0,
		   "TLTIU"                  -> 0,
		   "TEQI"                   -> 0,

		   "TNEI"                   -> 0,

		   "BLTZAL"                 -> 0,
		   "BGEZAL"                 -> 0,
		   "BLTZALL"                -> 0,
		   "BGEZALL"                -> 0,

		   "J"                      -> 0,
		   "JAL"                    -> 0,
		   "BEQ"                    -> 0,
		   "BNE"                    -> 0,
		   "BLEZ"                   -> 0,
		   "BGTZ"                   -> 0,
		   "ADDI"                   -> 0,
		   "ADDIU"                  -> 0,
		   "SLTI"                   -> 0,
		   "SLTIU"                  -> 0,
		   "ANDI"                   -> 0,
		   "ORI"                    -> 0,
		   "XORI"                   -> 0,
		   "LUI"                    -> 0,
		   "BEQL"                   -> 0,
		   "BNEL"                   -> 0,
		   "BLEZL"                  -> 0,
		   "BGTZL"                  -> 0,
		   "DADDI"                  -> 0,
		   "DADDIU"                 -> 0,
		   "LDL"                    -> 0,
		   "LDR"                    -> 0,




		   "LB"                     -> 0,
		   "LH"                     -> 0,
		   "LWL"                    -> 0,
		   "LW"                     -> 0,
		   "LBU"                    -> 0,
		   "LHU"                    -> 0,
		   "LWR"                    -> 0,
		   "LWU"                    -> 0,
		   "SB"                     -> 0,
		   "SH"                     -> 0,
		   "SWL"                    -> 0,
		   "SW"                     -> 0,
		   "SDL"                    -> 0,
		   "SDR"                    -> 0,
		   "SWR"                    -> 0,

		   "LL"                     -> 0,


		   "PREF"                   -> 0,
		   "LLD"                    -> 0,


		   "LD"                     -> 0,
		   "SC"                     -> 0,
		 


		   "SCD"                    -> 0,
		  
		  
		   "SD"                     -> 0
	)
}
