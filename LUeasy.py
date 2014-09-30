
import numpy as np
A=np.random.rand(50,50) #i made a random 5x5 matrix
A.round()
B=A.copy() #i would be working with a copy of A
P=np.eye(50)
def row_swap(i,j):
    perm=np.eye(50)
    perm[i]=0
    perm[j]=0
    perm[i,j]=1
    perm[j,i]=1
    return perm
for a in range(50):  #this is for making the permutation matrices
    k=np.argmax(np.abs(B[a:,a]))
    l=row_swap(a,k+a)
    P=l.dot(P) #i am saving each matrix using dot product 
    B=l.dot(B) #i am applying the permutation matrices one by one to the main matrix
    
print(B)
M=np.eye(50)
U=B.copy() # this if one more copy of B, in which the permutation matrix has been applied

for a in range(50):
    i=a # here i is used as an index
    for b in (B[a:,a]): # i take each column which begins with the elements of the diagonals
        i=i+1
        if i<50: 
            #print(i,a) #prints the row and collumn and row which we work with 
           
            N=np.eye(50) #i create a new identity matrix each time for eliminating
            
            N[i,a]= -U[i,a]/U[a,a] #here the i,a element of the identity is changed 
            M=N.dot(M) # i save the elim matrix by multiplying to an identity 
            U=N.dot(U) #here i apply the elim matric one by one to the permutated matrix
print(U)         
L=np.linalg.inv(M)    
print(L)        
print( P.dot(A)-L.dot(U))