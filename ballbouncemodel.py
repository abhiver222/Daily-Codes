import numpy as np
import matplotlib.pyplot as pt
from pylab import *

nev=np.empty([2,2])
nev[:,0]=p1
nev[:,1]=p2

arr=np.random.rand(2,100)
arr[1,:]=1-arr[0,:]
arrf=np.einsum("ij,jk->ik",nev,arr)

tan=p2-p1
nom=np.empty(2)
nom[0]=p1[1]-p2[1]
nom[1]=p2[0]-p1[0]
print(nom)

ncap=nom/np.linalg.norm(nom,2)

t_hit = (ncap.dot(p1)+r-x0.dot(ncap))/(v*ncap.dot(d))

print(t_hit)
positions = np.zeros([2,30])

pom=tan/np.linalg.norm(tan,2)
print(pom)

pt.plot(arrf[0,:],arrf[1,:])

d1=(d.dot(pom)*pom)-(d.dot(ncap)*ncap)
xhit = x0 + t_hit*v*d
print(d1)

for i in range(30):
    if i<t_hit:
        positions[:,i]=(x0 + i*v*d)
    else:
        positions[:,i]=(xhit+(i-t_hit)*v*d1)       
print(positions)
pt.gca().set_aspect("equal")
for i in range (30):
    a=positions[0,i]
    b=positions[1,i]
    circles(a,b,.2)
circles(xhit[0],xhit[1],.2)

xlim(-5,12)
ylim(-5,12)

pt.show()