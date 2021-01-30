.text
.globl main
main:
		# integer constant 
		li $t0, 26
		sw $t0, adr2
		# t7 is just for debugging 
		lw $t7, adr2
		# assignment adr1 = adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# integer constant 
		li $t0, 14
		sw $t0, adr3
		# t7 is just for debugging 
		lw $t7, adr3
		# binary and expression of adr1, adr3 
		la $t0, adr1
		la $t1, adr3
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		and $t0, $t0, $t1
		sw $t0, adr4
		# t7 is just for debugging 
		lw $t7, adr4
		# assignment adr1 = adr4 
		la $t0, adr1
		la $t1, adr4
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# print integer (adr1) 
		li $v0, 1
		la $t0, adr1
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 0
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# return adr5 
		li $v0, 10
		la $t0, adr5
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
		adr4: .word 0
		adr5: .word 0
