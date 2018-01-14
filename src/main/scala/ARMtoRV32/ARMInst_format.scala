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
  def SLL                     = 0
  def MOVCI                   = 0
  def SRL                     = 0
  def SRA                     = 0
  def SLLV                    = 0
 
  def SRLV                    = 0
  def SRAV                    = 0
  def JR                      = 0
  def JALR                    = 0
  def MOVZ                    = 0
  def MOVN                    = 0
  def SYSCALL                 = 0
  def BREAK                   = 0
 
  def SYNC                    = 0
  def MFHI                    = 0
  def MFLO                    = 0
  def DSLLV                   = 0
 
  def DSRLV                   = 0
  def DSRAV                   = 0
  def MULT                    = 0
  def MULTU                   = 0
  def DIV                     = 0
  def DIVU                    = 0
  def DMULTU                  = 0
  def DDIV                    = 0
  def DDIVU                   = 0
  def ADD                     = 0
  def ADDU                    = 0
  def SUB                     = 0
  def SUBU                    = 0
  def AND                     = 0
  def OR                      = 0
  def XOR                     = 0
  def NOR                     = 0
 

  def SLT                     = 0
  def SLTU                    = 0
  def DADD                    = 0
  def DADDU                   = 0
  def DSUB                    = 0
  def DSUBU                   = 0
  def TGE                     = 0
  def TGEU                    = 0
  def TLT                     = 0
  def TLTU                    = 0
  def TEQ                     = 0
 
  def TNE                     = 0
  def DSLL                    = 0
 
  def DSRL                    = 0
  def DSRA                    = 0
  def DSLL32                  = 0

  def DSRL32                  = 0
  def DSRA32                  = 0

  def BLTZ                    = 0
  def BGEZ                    = 0
  def BLTZL                   = 0
  def BGEZL                   = 0




  def TGEI                    = 0
  def TGEIU                   = 0
  def TLTI                    = 0
  def TLTIU                   = 0
  def TEQI                    = 0

  def TNEI                    = 0

  def BLTZAL                  = 0
  def BGEZAL                  = 0
  def BLTZALL                 = 0
  def BGEZALL                 = 0

  def J                       = 0
  def JAL                     = 0
  def BEQ                     = 0
  def BNE                     = 0
  def BLEZ                    = 0
  def BGTZ                    = 0
  def ADDI                    = 0
  def ADDIU                   = 0
  def SLTI                    = 0
  def SLTIU                   = 0
  def ANDI                    = 0
  def ORI                     = 0
  def XORI                    = 0
  def LUI                     = 0
  def BEQL                    = 0
  def BNEL                    = 0
  def BLEZL                   = 0
  def BGTZL                   = 0
  def DADDI                   = 0
  def DADDIU                  = 0
  def LDL                     = 0
  def LDR                     = 0




  def LB                      = 0
  def LH                      = 0
  def LWL                     = 0
  def LW                      = 0
  def LBU                     = 0
  def LHU                     = 0
  def LWR                     = 0
  def LWU                     = 0
  def SB                      = 0
  def SH                      = 0
  def SWL                     = 0
  def SW                      = 0
  def SDL                     = 0
  def SDR                     = 0
  def SWR                     = 0

  def LL                      = 0


  def PREF                    = 0
  def LLD                     = 0


  def LD                      = 0
  def SC                      = 0
 


  def SCD                     = 0
  
  
  def SD                      = 0

}
