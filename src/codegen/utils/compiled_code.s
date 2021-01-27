.text
.globl main
main:
		# read integer 
		li $v0, 5
		syscall 
		move $t0, $v0
		# print integer 
		li $v0, 1
		move $a0, $t0
		syscall 
		li $v0, 4
		la $a0, nl
		syscall 
		# return 
		li $v0, 10
		syscall 
.data
		nl: .asciiz "\n"
