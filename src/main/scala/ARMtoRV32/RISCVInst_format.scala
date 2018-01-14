package ARMtoRV32

import Chisel._
import scala.collection.mutable.ArrayBuffer

object RV_R_type_format{
	val type_num = 0
	val type_field_num = 6
	val type_fields : List[String] = List("funct7","rs2","rs1","funct3","rd","opcode")
	val type_fields_len : List[Int] = List(7,5,5,3,5,7)
}
object RV_I_type_format{
	val type_num = 1
	val type_field_num = 5
	val type_fields : List[String] = List("imm11_0","rs1","funct3","rd","opcode")
	val type_fields_len : List[Int] = List(12,5,3,5,7)
}
object RV_S_type_format{
	val type_num = 2
	val type_field_num = 6
	val type_fields : List[String] = List("imm11_5","rs2","rs1","funct3","imm4_0","opcode")
	val type_fields_len : List[Int] = List(7,5,5,3,5,7)
}
object RV_U_type_format{
	val type_num = 3
	val type_field_num = 3
	val type_fields : List[String] = List("imm31_12","rd","opcode")
	val type_fields_len : List[Int] = List(20,5,7)
}

/* Automatically generated by parse-opcodes */
object RV_Inst_type{
  def BEQ                = 0
  def BNE                = 0
  def BLT                = 0
  def BGE                = 0
  def BLTU               = 0
  def BGEU               = 0
  def JALR               = 0
  def JAL                = 0
  def LUI                = 0
  def AUIPC              = 0
  def ADDI               = 0
  def SLLI               = 0
  def SLTI               = 0
  def SLTIU              = 0
  def XORI               = 0
  def SRLI               = 0
  def SRAI               = 0
  def ORI                = 0
  def ANDI               = 0
  def ADD                = 0
  def SUB                = 0
  def SLL                = 0
  def SLT                = 0
  def SLTU               = 0
  def XOR                = 0
  def SRL                = 0
  def SRA                = 0
  def OR                 = 0
  def AND                = 0
  def ADDIW              = 0
  def SLLIW              = 0
  def SRLIW              = 0
  def SRAIW              = 0
  def ADDW               = 0
  def SUBW               = 0
  def SLLW               = 0
  def SRLW               = 0
  def SRAW               = 0
  def LB                 = 0
  def LH                 = 0
  def LW                 = 0
  def LD                 = 0
  def LBU                = 0
  def LHU                = 0
  def LWU                = 0
  def SB                 = 0
  def SH                 = 0
  def SW                 = 0
  def SD                 = 0
  def FENCE              = 0
  def FENCE_I            = 0
  def MUL                = 0
  def MULH               = 0
  def MULHSU             = 0
  def MULHU              = 0
  def DIV                = 0
  def DIVU               = 0
  def REM                = 0
  def REMU               = 0
  def MULW               = 0
  def DIVW               = 0
  def DIVUW              = 0
  def REMW               = 0
  def REMUW              = 0
  def AMOADD_W           = 0
  def AMOXOR_W           = 0
  def AMOOR_W            = 0
  def AMOAND_W           = 0
  def AMOMIN_W           = 0
  def AMOMAX_W           = 0
  def AMOMINU_W          = 0
  def AMOMAXU_W          = 0
  def AMOSWAP_W          = 0
  def LR_W               = 0
  def SC_W               = 0
  def AMOADD_D           = 0
  def AMOXOR_D           = 0
  def AMOOR_D            = 0
  def AMOAND_D           = 0
  def AMOMIN_D           = 0
  def AMOMAX_D           = 0
  def AMOMINU_D          = 0
  def AMOMAXU_D          = 0
  def AMOSWAP_D          = 0
  def LR_D               = 0
  def SC_D               = 0
  def ECALL              = 0
  def EBREAK             = 0
  def URET               = 0
  def SRET               = 0
  def HRET               = 0
  def MRET               = 0
  def DRET               = 0
  def SFENCE_VMA         = 0
  def WFI                = 0
  def CSRRW              = 0
  def CSRRS              = 0
  def CSRRC              = 0
  def CSRRWI             = 0
  def CSRRSI             = 0
  def CSRRCI             = 0
  def FADD_S             = 0
  def FSUB_S             = 0
  def FMUL_S             = 0
  def FDIV_S             = 0
  def FSGNJ_S            = 0
  def FSGNJN_S           = 0
  def FSGNJX_S           = 0
  def FMIN_S             = 0
  def FMAX_S             = 0
  def FSQRT_S            = 0
  def FADD_D             = 0
  def FSUB_D             = 0
  def FMUL_D             = 0
  def FDIV_D             = 0
  def FSGNJ_D            = 0
  def FSGNJN_D           = 0
  def FSGNJX_D           = 0
  def FMIN_D             = 0
  def FMAX_D             = 0
  def FCVT_S_D           = 0
  def FCVT_D_S           = 0
  def FSQRT_D            = 0
  def FLE_S              = 0
  def FLT_S              = 0
  def FEQ_S              = 0
  def FLE_D              = 0
  def FLT_D              = 0
  def FEQ_D              = 0
  def FCVT_W_S           = 0
  def FCVT_WU_S          = 0
  def FCVT_L_S           = 0
  def FCVT_LU_S          = 0
  def FMV_X_S            = 0
  def FCLASS_S           = 0
  def FCVT_W_D           = 0
  def FCVT_WU_D          = 0
  def FCVT_L_D           = 0
  def FCVT_LU_D          = 0
  def FMV_X_D            = 0
  def FCLASS_D           = 0
  def FCVT_S_W           = 0
  def FCVT_S_WU          = 0
  def FCVT_S_L           = 0
  def FCVT_S_LU          = 0
  def FMV_S_X            = 0
  def FCVT_D_W           = 0
  def FCVT_D_WU          = 0
  def FCVT_D_L           = 0
  def FCVT_D_LU          = 0
  def FMV_D_X            = 0
  def FLW                = 0
  def FLD                = 0
  def FSW                = 0
  def FSD                = 0
  def FMADD_S            = 0
  def FMSUB_S            = 0
  def FNMSUB_S           = 0
  def FNMADD_S           = 0
  def FMADD_D            = 0
  def FMSUB_D            = 0
  def FNMSUB_D           = 0
  def FNMADD_D           = 0
  def C_ADDI4SPN         = 0
  def C_FLD              = 0
  def C_LW               = 0
  def C_FLW              = 0
  def C_FSD              = 0
  def C_SW               = 0
  def C_FSW              = 0
  def C_ADDI             = 0
  def C_JAL              = 0
  def C_LI               = 0
  def C_LUI              = 0
  def C_SRLI             = 0
  def C_SRAI             = 0
  def C_ANDI             = 0
  def C_SUB              = 0
  def C_XOR              = 0
  def C_OR               = 0
  def C_AND              = 0
  def C_SUBW             = 0
  def C_ADDW             = 0
  def C_J                = 0
  def C_BEQZ             = 0
  def C_BNEZ             = 0
  def C_SLLI             = 0
  def C_FLDSP            = 0
  def C_LWSP             = 0
  def C_FLWSP            = 0
  def C_MV               = 0
  def C_ADD              = 0
  def C_FSDSP            = 0
  def C_SWSP             = 0
  def C_FSWSP            = 0
  def CUSTOM0            = 0
  def CUSTOM0_RS1        = 0
  def CUSTOM0_RS1_RS2    = 0
  def CUSTOM0_RD         = 0
  def CUSTOM0_RD_RS1     = 0
  def CUSTOM0_RD_RS1_RS2 = 0
  def CUSTOM1            = 0
  def CUSTOM1_RS1        = 0
  def CUSTOM1_RS1_RS2    = 0
  def CUSTOM1_RD         = 0
  def CUSTOM1_RD_RS1     = 0
  def CUSTOM1_RD_RS1_RS2 = 0
  def CUSTOM2            = 0
  def CUSTOM2_RS1        = 0
  def CUSTOM2_RS1_RS2    = 0
  def CUSTOM2_RD         = 0
  def CUSTOM2_RD_RS1     = 0
  def CUSTOM2_RD_RS1_RS2 = 0
  def CUSTOM3            = 0
  def CUSTOM3_RS1        = 0
  def CUSTOM3_RS1_RS2    = 0
  def CUSTOM3_RD         = 0
  def CUSTOM3_RD_RS1     = 0
  def CUSTOM3_RD_RS1_RS2 = 0
  def SLLI_RV32          = 0
  def SRLI_RV32          = 0
  def SRAI_RV32          = 0
  def FRFLAGS            = 0
  def FSFLAGS            = 0
  def FSFLAGSI           = 0
  def FRRM               = 0
  def FSRM               = 0
  def FSRMI              = 0
  def FSCSR              = 0
  def FRCSR              = 0
  def RDCYCLE            = 0
  def RDTIME             = 0
  def RDINSTRET          = 0
  def RDCYCLEH           = 0
  def RDTIMEH            = 0
  def RDINSTRETH         = 0
  def SCALL              = 0
  def SBREAK             = 0
}
