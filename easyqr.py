import numpy as np
Qs=[]
Rs=[]

def qr_by_gram_schmidt(A):
    Q = np.zeros(A.shape)
    for i in range(A.shape[1]):
        avec=A[:,i]
        q=avec
        for j in range (i):
            qprev = Q[:,j]
            q = q - qprev.dot(q)*qprev
        q=q/np.linalg.norm(q,2)
        Q[:,i]=q
    Qs.append(Q)
    R = Q.T.dot(A)
    Rs.append(R)

for i in range(len(As)):
    qr_by_gram_schmidt(As[i])