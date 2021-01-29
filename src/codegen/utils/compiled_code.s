.text
.globl main
main:
		# integer constant 
		li $t0, 0
		sw $t0, adr3
		# t7 is just for debugging 
		lw $t7, adr3
		# if code for Descriptor{addressName='adr3', type=INTEGER_NUMBER, isLocal=true} 
		la $t0, adr3
		lw $t1, 0($t0)
		beqz $t1, lbl1
		# integer constant 
		li $t0, 1
		sw $t0, adr4
		# t7 is just for debugging 
		lw $t7, adr4
		# print integer (adr4) 
		li $v0, 1
		la $t0, adr4
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
lbl2:
		# read real 
		li $v0, 6
		syscall 
		mov.s $f1, $f0
		la $t1, adr5
		s.s $f1, 0($t1)
		# assignment adr2 = adr5 
		la $t0, adr2
		la $t1, adr5
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr2
		# print float (adr2) 
		li $v0, 2
		la $t0, adr2
		l.s $f0, 0($t0)
		mov.s $f12, $f0
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
		strbuffer: .space 20
		stradr: .word 0
		adr1: .space 20
		adr2: .word 0
		adr3: .word 0
		adr4: .word 0
		adr5: .word 0
		adr6: .word 0
