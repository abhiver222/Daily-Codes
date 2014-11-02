##2D projection of a 3d object on a plane given normal angle wrt positive x axis and distance of object from plane

import numpy as np
import matplotlib.pyplot as pt

nshape = len(angles_and_distances)

n = np.zeros([nshape,3])
for i in range(nshape):
    a=angles_and_distances[i][0]
    n[i,0]=-np.cos(a)
    n[i,1]=-np.sin(a)
    n[i,2]=0

plane_span = np.zeros([nshape,3,2])
for i in range (2):
    a=angles_and_distances[i][0]        
    plane_span[i,0,0]=np.sin(a)*-1
    plane_span[i,1,0]=np.cos(a)
    plane_span[i,2,1]=1

Pinit=np.zeros([2,3,3])
Pinit[:,:,:2]=plane_span
Pd1=Pinit[0,:,:]
P1 = Pinit[0,:,:].dot(Pd1.T)
Pd2=Pinit[1,:,:]
P2 = Pinit[1,:,:].dot(Pd2.T)
P=np.empty([2,3,3])
P[0,:,:]=P1
P[1,:,:]=P2

I=np.empty([2,triangles.shape[0],3,4])
for j in range (2):
    for i in range(12):
        I[j,i,:,:3] = np.einsum("pq,qn->pn",P[j,:,:],triangles[i,:3,:3])
        I[j,i,:,3] = I[j,i,:,0]       


I_screen = np.zeros([2,12,2,4])

for j in range(2):
    for i in range(12):
        for k in range(3):
            I_screen[j,i,0,k] = I[j,i,:,k].dot(plane_span[j,:,0])                
            I_screen[j,i,1,k] = I[j,i,:,k].dot(plane_span[j,:,1])
            I_screen[j,i,:,3] = I_screen[j,i,:,0]

distance = np.zeros([2,12,4])
for j in range(2):
    for i in range(12):
        for k in range(3):
            distance[j,i,k]=(triangles[i,:,k]).dot(n[j,:])+angles_and_distances[j][1]
            distance[j,i,3] = distance[j,i,0]

I_persp = np.empty([2,12,2,4])
for j in range(2):
    for i in range(12):
        for k in range(4):
            I_persp[j,i,:,k] = I_screen[j,i,:,k]/distance[j,i,k]



for i in range(12):
    
        pt.figure(1)
        pt.xlim(-0.3,0.3)
        pt.ylim(-0.3,0.3)
        
        pt.plot(I_persp[0,i,0,:],I_persp[0,i,1,:],"-",color="blue")
        
        pt.figure(2)
        pt.xlim(-0.3,0.3)
        pt.ylim(-0.3,0.3)
        
        pt.plot(I_persp[1,i,0,:],I_persp[1,i,1,:],"-",color="blue")
pt.show()