.text
.globl main
main:
		# integer constant 
		li $t0, 20
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# integer constant 
		li $t0, 3
		sw $t0, adr6
		# t7 is just for debugging 
		lw $t7, adr6
		# array access with name adr1 at 3 
		la $t0, adr1
		li $t4, 4
		li $t1, 3
		mul $t1, $t1, $t4
		add $t0, $t0, $t1
		lw $t0, 0($t0)
		sw $t0, adr7
		# integer constant 
		li $t0, 4
		sw $t0, adr8
		# t7 is just for debugging 
		lw $t7, adr8
		# left array assignment 
		li $t1, 3
		la $t2, adr1
		li $t4, 4
		mul $t1, $t1, $t4
		add $t1, $t1, $t2
		la $t3, adr8
		lw $t3, 0($t3)
		sw $t3, 0($t1)
		# t7 is just for debugging 
		lw $t7, 0($t1)
		# array access with name adr1 at 3 
		la $t0, adr1
		li $t4, 4
		li $t1, 3
		mul $t1, $t1, $t4
		add $t0, $t0, $t1
		lw $t0, 0($t0)
		sw $t0, adr9
		# assignment adr2 = adr9 
		la $t0, adr2
		la $t1, adr9
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr2
		# integer constant 
		li $t0, 2
		sw $t0, adr10
		# t7 is just for debugging 
		lw $t7, adr10
		# array access with name adr1 at 2 
		la $t0, adr1
		li $t4, 4
		li $t1, 2
		mul $t1, $t1, $t4
		add $t0, $t0, $t1
		lw $t0, 0($t0)
		sw $t0, adr11
		# integer constant 
		li $t0, 5
		sw $t0, adr12
		# t7 is just for debugging 
		lw $t7, adr12
		# left array assignment 
		li $t1, 2
		la $t2, adr1
		li $t4, 4
		mul $t1, $t1, $t4
		add $t1, $t1, $t2
		la $t3, adr12
		lw $t3, 0($t3)
		sw $t3, 0($t1)
		# t7 is just for debugging 
		lw $t7, 0($t1)
		# array access with name adr1 at 2 
		la $t0, adr1
		li $t4, 4
		li $t1, 2
		mul $t1, $t1, $t4
		add $t0, $t0, $t1
		lw $t0, 0($t0)
		sw $t0, adr13
		# assignment adr3 = adr13 
		la $t0, adr3
		la $t1, adr13
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# binary add expression of adr2, adr3 
		la $t0, adr2
		la $t1, adr3
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		add $t0, $t0, $t1
		sw $t0, adr14
		# t7 is just for debugging 
		lw $t7, adr14
		# print integer (adr14) 
		li $v0, 1
		la $t0, adr14
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 0
		sw $t0, adr15
		# t7 is just for debugging 
		lw $t7, adr15
		# return adr15 
		li $v0, 10
		la $t0, adr15
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
.data
		nl: .asciiz "\n"
		strbuffer: .space 20
		stradr: .word 0
		adr2: .word 0
		adr3: .word 0
		adr4: .word 0
		adr5: .word 0
		adr1: .space 80
		adr6: .word 0
		adr7: .word 0
		adr8: .word 0
		adr9: .word 0
		adr10: .word 0
		adr11: .word 0
		adr12: .word 0
		adr13: .word 0
		adr14: .word 0
		adr15: .word 0
