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
		li $t0, 4
		sw $t0, adr5
		# t7 is just for debugging 
		lw $t7, adr5
		# integer constant 
		li $t0, 5
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
		# integer constant 
		li $t0, 1
		sw $t0, adr8
		# t7 is just for debugging 
		lw $t7, adr8
		# print integer -> adr8 
		li $v0, 1
		la $t0, adr8
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# complete if code 
		j lbl2

lbl2:
		# else code 
lbl1:
		# integer constant 
		li $t0, 4
		sw $t0, adr9
		# t7 is just for debugging 
		lw $t7, adr9
		# integer constant 
		li $t0, 3
		sw $t0, adr10
		# t7 is just for debugging 
		lw $t7, adr10
		# binary slt expression of adr9, adr10 
		la $t0, adr9
		la $t1, adr10
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		slt $t0, $t0, $t1
		sw $t0, adr11
		# t7 is just for debugging 
		lw $t7, adr11
		# if code for Descriptor{addressName='adr11', type=INTEGER_NUMBER, isLocal=true} 
		la $t0, adr11
		lw $t1, 0($t0)
		beqz $t1, lbl3
		# integer constant 
		li $t0, 2
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
		# complete if code 
		j lbl4


		# else code 
lbl3:
		# integer constant 
		li $t0, 3
		sw $t0, adr13
		# t7 is just for debugging 
		lw $t7, adr13
		# print integer -> adr13 
		li $v0, 1
		la $t0, adr13
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# complete else code 

		# complete else code 
lbl4:
		# integer constant 
		li $t0, 9
		sw $t0, adr14
		# t7 is just for debugging 
		lw $t7, adr14
		# assignment adr1 = adr14 
		la $t0, adr1
		la $t1, adr14
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# start condition of for 
lbl5:
		# integer constant 
		li $t0, 10
		sw $t0, adr15
		# t7 is just for debugging 
		lw $t7, adr15
		# binary slt expression of adr1, adr15 
		la $t0, adr1
		la $t1, adr15
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		slt $t0, $t0, $t1
		sw $t0, adr16
		# t7 is just for debugging 
		lw $t7, adr16
		# FOR code for Descriptor{addressName='adr16', type=INTEGER_NUMBER, isLocal=true} 
		la $t0, adr16
		lw $t1, 0($t0)
		beqz $t1, lbl6
		# integer constant 
		li $t0, 1
		sw $t0, adr17
		# t7 is just for debugging 
		lw $t7, adr17
		# binary add expression of adr1, adr17 
		la $t0, adr1
		la $t1, adr17
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		add $t0, $t0, $t1
		sw $t0, adr18
		# t7 is just for debugging 
		lw $t7, adr18
		# assignment adr1 = adr18 
		la $t0, adr1
		la $t1, adr18
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# integer constant 
		li $t0, 67
		sw $t0, adr19
		# t7 is just for debugging 
		lw $t7, adr19
		# print integer -> adr19 
		li $v0, 1
		la $t0, adr19
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# end of FOR 
		j lbl7
		# step of FOR 
lbl7:
		# complete step of FOR 
		j lbl5
lbl6:
		# integer constant 
		li $t0, 69
		sw $t0, adr20
		# t7 is just for debugging 
		lw $t7, adr20
		# print integer -> adr20 
		li $v0, 1
		la $t0, adr20
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 0
		sw $t0, adr21
		# t7 is just for debugging 
		lw $t7, adr21
		# return adr21 
		li $v0, 10
		la $t0, adr21
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
		adr14: .word 0
		adr15: .word 0
		adr16: .word 0
		adr17: .word 0
		adr18: .word 0
		adr19: .word 0
		adr20: .word 0
		adr21: .word 0
