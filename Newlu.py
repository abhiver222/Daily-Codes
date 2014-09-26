#!/usr/bin/python
# -*- coding:utf-8 -*-

from fractions import Fraction
import numpy as np
#	Show Matrix


#	LU decomposition by Crout algorithm [usage: L, U = ludec(A)]
def ludec(A):
	L = [[0.0 for i in range(len(A))] for j in range(len(A))]
	U = [[0.0 for i in range(len(A))] for j in range(len(A))]
	try:
		for i in range(0, len(A)):
			L[i][0] = A[i][0]			#	L:deside 1 column.
			U[0][i] = A[0][i]/A[0][0]	#	U:deside 1 row.
		for k in range(1, len(A)):
			for i in range(0, k):
				L[i][k] = U[k][i] = 0.0	#	initialize the element to be updated.
			for i in range(k, len(A)):
				L[i][k] = A[i][k]
				for m in range(0, k):
					L[i][k] -= L[i][m] * U[m][k]
			U[k][k] = 1.0				#	U:diagonal element is 1
			for i in range(k + 1, len(A)):
				U[k][i] = A[k][i]
				for m in range(0, k):
					U[k][i] -= L[k][m] * U[m][i]
				U[k][i] /= L[k][k]
	except ZeroDivisionError:
		print "This matrix can't do LU Decomposition."
	return L, U
A=np.array([[2,2,1],[4,4,2],[0,1,5]])
L, U = ludec(A)
L=np.array(L).reshape(3,3)
U=np.array(U).reshape(3,3)
print(A)
print(L)
print(U)
print(L.dot(U))