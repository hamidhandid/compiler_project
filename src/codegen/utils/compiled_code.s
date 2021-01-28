.text
.globl main
main:
		# read integer 
		li $v0, 5
		syscall 
		move $t0, $v0
		la $t1, adr3
		sw $t0, 0($t1)
		# t7 is just for debugging 
		lw $t7, adr3
		# assignment adr1 = adr3 
		la $t0, adr1
		la $t1, adr3
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# integer constant 
		li $t0, 3
		sw $t0, adr4
		# t7 is just for debugging 
		lw $t7, adr4
		# binary add expression of adr1, adr4 
		la $t0, adr1
		la $t1, adr4
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		add $t0, $t0, $t1
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# assignment adr2 = adr5 
		la $t0, adr2
		la $t1, adr5
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr2
		# print integer -> adr2 
		li $v0, 1
		la $t0, adr2
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
		# return adr6 
		li $v0, 10
		la $t0, adr6
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
.data
		nl: .asciiz "\n"
		adr1: .word 0
		adr2: .word 0
		adr3: .word 0
		adr4: .word 0
		adr5: .word 0
		adr6: .word 0
