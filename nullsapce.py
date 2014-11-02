import numpy as np
import scipy as sc
from scipy.linalg import lu, inv
print(epsilon)
Ns=[]
Rs=[]
Atildes=[]
xs=[]
for i in range(0,len(As)):
    a=As[i]
    PT, L, U =lu(a.T)
    P=PT.T
    col=[]
    tran=U.T
    sha=tran.shape
    for j in range (sha[1]):
        if epsilon*np.linalg.norm(U) > np.linalg.norm(U[j],2):
            col.append(j)
    
    Nulla=np.eye(sha[1])[:,col[0]:]
    N=P.T.dot(np.linalg.inv(L.T)).dot(Nulla)
    Ns.append(N)
   
    R=np.random.rand(sha[1],len(col))
    Rs.append(R)
    A=a+R.dot(N.T)
    Atildes.append(A)
    x=np.linalg.solve(A,bs[i])
    xs.append(x)
    