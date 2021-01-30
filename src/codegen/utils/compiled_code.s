.text
.globl main
main:
		# integer constant 
		li $t0, 5
		sw $t0, adr7
		# t7 is just for debugging 
		lw $t7, adr7
		# assignment adr2 = adr7 
		la $t0, adr2
		la $t1, adr7
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr2
		# integer constant 
		li $t0, 7
		sw $t0, adr8
		# t7 is just for debugging 
		lw $t7, adr8
		# assignment adr1 = adr8 
		la $t0, adr1
		la $t1, adr8
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr1
		# integer constant 
		li.s $f0, 2.5
		s.s $f0, adr9
		# t7 is just for debugging 
		lw $t7, adr9
		# assignment adr4 = adr9 
		la $t0, adr4
		la $t1, adr9
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr4
		# integer constant 
		li.s $f0, 1.5
		s.s $f0, adr10
		# t7 is just for debugging 
		lw $t7, adr10
		# assignment adr5 = adr10 
		la $t0, adr5
		la $t1, adr10
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr5
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
		# print integer (adr2) 
		li $v0, 1
		la $t0, adr2
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# print float (adr4) 
		li $v0, 2
		la $t0, adr4
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# print float (adr5) 
		li $v0, 2
		la $t0, adr5
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary add.s expression of adr4, adr5 
		la $t0, adr4
		la $t1, adr5
		l.s $f0, 0($t0)
		l.s $f1, 0($t1)
		add.s $f0, $f0, $f1
		s.s $f0, adr11
		# t7 is just for debugging 
		lw $t7, adr11
		# assignment adr6 = adr11 
		la $t0, adr6
		la $t1, adr11
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr6
		# print float (adr6) 
		li $v0, 2
		la $t0, adr6
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary sub.s expression of adr4, adr5 
		la $t0, adr4
		la $t1, adr5
		l.s $f0, 0($t0)
		l.s $f1, 0($t1)
		sub.s $f0, $f0, $f1
		s.s $f0, adr12
		# t7 is just for debugging 
		lw $t7, adr12
		# assignment adr6 = adr12 
		la $t0, adr6
		la $t1, adr12
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr6
		# print float (adr6) 
		li $v0, 2
		la $t0, adr6
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary mul.s expression of adr4, adr5 
		la $t0, adr4
		la $t1, adr5
		l.s $f0, 0($t0)
		l.s $f1, 0($t1)
		mul.s $f0, $f0, $f1
		mfhi $t1
		mflo $t0
		s.s $f0, adr13
		# t7 is just for debugging 
		lw $t7, adr13
		# assignment adr6 = adr13 
		la $t0, adr6
		la $t1, adr13
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr6
		# print float (adr6) 
		li $v0, 2
		la $t0, adr6
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary div.s expression of adr4, adr5 
		la $t0, adr4
		la $t1, adr5
		l.s $f0, 0($t0)
		l.s $f1, 0($t1)
		div.s $f0, $f0, $f1
		mfhi $t1
		mflo $t0
		s.s $f0, adr14
		# t7 is just for debugging 
		lw $t7, adr14
		# assignment adr6 = adr14 
		la $t0, adr6
		la $t1, adr14
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr6
		# print float (adr6) 
		li $v0, 2
		la $t0, adr6
		l.s $f0, 0($t0)
		mov.s $f12, $f0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary add expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		add $t0, $t0, $t1
		sw $t0, adr15
		# t7 is just for debugging 
		lw $t7, adr15
		# assignment adr3 = adr15 
		la $t0, adr3
		la $t1, adr15
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary sub expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		sub $t0, $t0, $t1
		sw $t0, adr16
		# t7 is just for debugging 
		lw $t7, adr16
		# assignment adr3 = adr16 
		la $t0, adr3
		la $t1, adr16
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary mul expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		mul $t0, $t0, $t1
		mfhi $t1
		mflo $t0
		sd $t0, adr17
		# t7 is just for debugging 
		lw $t7, adr17
		# assignment adr3 = adr17 
		la $t0, adr3
		la $t1, adr17
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary div expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		div $t0, $t0, $t1
		mfhi $t1
		mflo $t0
		sw $t0, adr18
		# t7 is just for debugging 
		lw $t7, adr18
		# assignment adr3 = adr18 
		la $t0, adr3
		la $t1, adr18
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary rem expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		rem $t0, $t0, $t1
		sw $t0, adr19
		# t7 is just for debugging 
		lw $t7, adr19
		# assignment adr3 = adr19 
		la $t0, adr3
		la $t1, adr19
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary and expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		and $t0, $t0, $t1
		sw $t0, adr20
		# t7 is just for debugging 
		lw $t7, adr20
		# assignment adr3 = adr20 
		la $t0, adr3
		la $t1, adr20
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# binary or expression of adr1, adr2 
		la $t0, adr1
		la $t1, adr2
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		or $t0, $t0, $t1
		sw $t0, adr21
		# t7 is just for debugging 
		lw $t7, adr21
		# assignment adr3 = adr21 
		la $t0, adr3
		la $t1, adr21
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 5
		sw $t0, adr22
		# t7 is just for debugging 
		lw $t7, adr22
		# integer constant 
		li $t0, 7
		sw $t0, adr23
		# t7 is just for debugging 
		lw $t7, adr23
		# binary xor expression of adr22, adr23 
		la $t0, adr22
		la $t1, adr23
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		xor $t0, $t0, $t1
		sw $t0, adr24
		# t7 is just for debugging 
		lw $t7, adr24
		# assignment adr3 = adr24 
		la $t0, adr3
		la $t1, adr24
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 5
		sw $t0, adr25
		# t7 is just for debugging 
		lw $t7, adr25
		# integer constant 
		li $t0, 7
		sw $t0, adr26
		# t7 is just for debugging 
		lw $t7, adr26
		# binary nor expression of adr25, adr26 
		la $t0, adr25
		la $t1, adr26
		lw $t0, 0($t0)
		lw $t1, 0($t1)
		nor $t0, $t0, $t1
		sw $t0, adr27
		# t7 is just for debugging 
		lw $t7, adr27
		# assignment adr3 = adr27 
		la $t0, adr3
		la $t1, adr27
		lw $t1, 0($t1)
		sw $t1, 0($t0)
		# t7 is just for debugging 
		lw $t7, adr3
		# print integer (adr3) 
		li $v0, 1
		la $t0, adr3
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 272
		sw $t0, adr28
		# t7 is just for debugging 
		lw $t7, adr28
		# print integer (adr28) 
		li $v0, 1
		la $t0, adr28
		lw $t0, 0($t0)
		move $a0, $t0
		syscall 
		# new line 
		li $v0, 4
		la $a0, nl
		syscall 
		# integer constant 
		li $t0, 0
		sw $t0, adr29
		# t7 is just for debugging 
		lw $t7, adr29
		# return adr29 
		li $v0, 10
		la $t0, adr29
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
		adr6: .word 0
		adr7: .word 0
		adr8: .word 0
		adr9: .word 0
		adr10: .word 0
		adr11: .word 0
		adr12: .word 0
		adr13: .space 64
		adr14: .word 0
		adr15: .word 0
		adr16: .word 0
		adr17: .space 64
		adr18: .word 0
		adr19: .word 0
		adr20: .word 0
		adr21: .word 0
		adr22: .word 0
		adr23: .word 0
		adr24: .word 0
		adr25: .word 0
		adr26: .word 0
		adr27: .word 0
		adr28: .word 0
		adr29: .word 0
