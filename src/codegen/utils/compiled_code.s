.text
.globl main
main:
		# read integer 
		li $v0, 5
		syscall 
		move $t0, $v0
		la $t1, adr2
		sw $t0, 0($t1)
		# t7 is just for debugging 
		lw $t7, adr2
		# assignment adr1 = adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		## t7 is just for debugging 
		lw $t7, adr1
.data
		nl: .asciiz "\n"
		adr1: .word 0
		adr2: .word 0
