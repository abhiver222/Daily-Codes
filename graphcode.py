import matplotlib.pyplot as pt
import numpy as np
from mpl_toolkits.mplot3d import Axes3D

fig = pt.figure()
ax = fig.add_subplot(111, projection='3d')
A=np.arange(100,122,.04)
A.resize(10,10,3)
A[:,:,2]=A[:,:,2].T
A[:,:,0]=1

A[:,:,2]*=.1
A[:,:,1]*=.1
vecfora=np.array([[3,-1,1],[7,-4,0],[4,-3,-2]])

afinal=np.einsum("ijk,qk->ijq",A,vecfora)

l=afinal[:,:,0]
m=afinal[:,:,1]
n=afinal[:,:,2]
ax.plot_wireframe(l,m,n)


B=np.random.rand(10,10,3)
sumoffirsttwo=np.sum(B[:,:,:2],axis=2)
B[:,:,2]=1-sumoffirsttwo

vecforb=np.array([[3,2,4],[7,3,7],[4,1,2]])
bfinal=np.einsum("ijk,qk->ijq",B,vecforb)
p=bfinal[:,:,0]
q=bfinal[:,:,1]
r=bfinal[:,:,2]
ax.plot_wireframe(p,q,r)

pt.show()
