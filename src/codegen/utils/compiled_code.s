.text
.globl main
main:
		# integer constant 
		li $t0, 4
		sw $t0, adr2
		# t7 is just for debugging 
		lw $t7, adr2
		# integer constant 
		li $t0, 0
		sw $t0, adr3
		# t7 is just for debugging 
		lw $t7, adr3
		# return adr3 
		li $v0, 10
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
.data
		nl: .asciiz "\n"
		strbuffer: .space 20
		stradr: .word 0
		adr1: .word 0
		adr2: .word 0
		adr3: .word 0
