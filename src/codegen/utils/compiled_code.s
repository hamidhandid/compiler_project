.text
.globl main
main:
		# integer constant 
		li $t0, 2
		sw $t0, adr3
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
		li $t0, 6
		sw $t0, adr4
		# t7 is just for debugging 
		lw $t7, adr4
		# assignment adr2 = adr4 
		la $t0, adr2
		la $t1, adr4
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr2
		# integer constant 
		li $t0, 5
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# integer constant 
		li $t0, 4
		sw $t0, adr6
		# t7 is just for debugging 
		lw $t7, adr6
		# binary slt expression of adr5, adr6 
		la $t0, adr5
		la $t1, adr6
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		slt $t0, $t0, $t1
		sw $t0, adr7
		# t7 is just for debugging 
		lw $t7, adr7
		# if code for Descriptor{addressName='adr7', type=INTEGER_NUMBER, isLocal=true} 
		la $t0, adr7
		lw $t1, 0($t0)
		beqz $t1, lbl1
		# print integer -> adr1 
		li $v0, 1
		la $t0, adr1
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# complete if code 
		j lbl2
lbl1:
		# else code 
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
		# complete else code 
lbl2:
		# start condition of while 
lbl3:
		# binary slt expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		slt $t0, $t0, $t1
		sw $t0, adr8
		# t7 is just for debugging 
		lw $t7, adr8
		# while code for Descriptor{addressName='adr8', type=INTEGER_NUMBER, isLocal=true} 
		la $t0, adr8
		lw $t1, 0($t0)
		beqz $t1, lbl4
		# integer constant 
		li $t0, 68
		sw $t0, adr9
		# t7 is just for debugging 
		lw $t7, adr9
		# print integer -> adr9 
		li $v0, 1
		la $t0, adr9
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 1
		sw $t0, adr10
		# t7 is just for debugging 
		lw $t7, adr10
		# binary add expression of adr10, adr1 
		la $t0, adr10
		la $t1, adr1
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		add $t0, $t0, $t1
		sw $t0, adr11
		# t7 is just for debugging 
		lw $t7, adr11
		# assignment adr1 = adr11 
		la $t0, adr1
		la $t1, adr11
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# end of while 
		j lbl3
lbl4:
		# integer constant 
		li $t0, 69
		sw $t0, adr12
		# t7 is just for debugging 
		lw $t7, adr12
		# print integer -> adr12 
		li $v0, 1
		la $t0, adr12
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 0
		sw $t0, adr13
		# t7 is just for debugging 
		lw $t7, adr13
		# return adr13 
		li $v0, 10
		la $t0, adr13
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
		adr7: .word 0
		adr8: .word 0
		adr9: .word 0
		adr10: .word 0
		adr11: .word 0
		adr12: .word 0
		adr13: .word 0
