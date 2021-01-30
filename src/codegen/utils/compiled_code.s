.text
.globl main
main:
		# integer constant 
		li $t0, 5
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# assignment adr1 = adr5 
		la $t0, adr1
		la $t1, adr5
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
		sw $t0, adr6
		# t7 is just for debugging 
		lw $t7, adr6
null:
		li $t0, 1
		sw $t0, null
		b null
		# return adr6 
		li $v0, 10
		la $t0, adr6
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
.data
		nl: .asciiz "\n"
		strbuffer: .space 20
		stradr: .word 0
		adr1: .word 0
		adr2: .word 0
		adr3: .space 20
		adr4: .word 0
		adr5: .word 0
		adr6: .word 0
