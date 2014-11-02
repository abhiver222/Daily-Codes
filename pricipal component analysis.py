#Pricipal component analysis with reduction of noise by removing unwanted sigmas

import numpy as np
import matplotlib.pyplot as pt
pt.gca().set_aspect("equal")
pt.figure(1)
pt.plot(X[0],X[1],"x")
mean = np.zeros(2)

sumx = np.sum(X[0])
sumy = np.sum(X[1])


sumx = sumx/X.shape[1]
sumy = sumy/X.shape[1]

X[0,:] = X[0,:]-sumx
X[1,:] = X[1,:]-sumy


mean[0]=sumx
mean[1]=sumy


div = ((X.shape[1]-1)**0.5)
Y=np.empty([2,3000])
Y = X/div
   

U ,sig, Vt = np.linalg.svd(Y)

sigfin = np.zeros([2,2])
sigfin = np.diag(sig)

principal_components = U.dot(sigfin)
principal_components =principal_components.T


pt.arrow(mean[0],mean[1],principal_components[0,0],principal_components[0,1],linewidth=4, zorder=10)
pt.arrow(mean[0],mean[1],principal_components[1,0],principal_components[1,1],linewidth=4, zorder=10)


sigmult = np.zeros(X.shape)
for i in range(2):
    sigmult[:,i] = sigfin[:,i]

ycur = U.dot(sigmult).dot(Vt)
up = np.linalg.norm((ycur-Y),2)
down = np.linalg.norm(Y,2)
print(up/down)

sigmult[1,1] = 0;
ydash = U.dot(sigmult).dot(Vt)

ydash = ydash*div
X_prime = np.empty([2,3000])
for i in range(3000):
    X_prime[:,i]=ydash[:,i]+mean


sumx1= np.sum(X_prime[0])/X.shape[1]
sumy1= np.sum(X_prime[1])/X.shape[1]
X2 = np.zeros(X.shape)
X2[0,:] = X_prime[0,:]-sumx1
X2[1,:] = X_prime[1,:]-sumy1
div1 = ((X.shape[1]-1)**0.5)
Y1=np.empty([2,3000])
Y1 = X2/div
   
U1 ,sig1, Vt1 = np.linalg.svd(Y1)
sigfin1 = np.zeros([2,2])
sigfin1 = np.diag(sig1)
principal_components1 = U1.dot(sigfin1)
principal_components1 =principal_components1.T

principal_components2 = U.dot(sigmult)
principal_components2 =principal_components2.T



pt.figure(2)

pt.plot(X_prime[0],X_prime[1],"x")
pt.arrow(sumx,sumy,principal_components2[0,0],principal_components2[0,1],linewidth=4, zorder=10)
pt.arrow(sumx,sumy,principal_components2[1,0],principal_components2[1,1],linewidth=4, zorder=10)

#I think we just made 1 sigma to be 0 so that we could remove the extra points which we had got from noise. 
#Doing this in a real scientific calculation would require some research on the nature of
#data though.
#The reduced data t would require somewhat lesser memory as we just eliminated the points 
#which were only there because of the noise and hence now have the more significant points.
#.The graph for these shows this as it is quite narrow.
#We reduce the dimensionality of our data that is,data is represented along the other pricipal
#components not made to be 0.
#Thia could be useful in ways of getting more precise calculations on the data as we just eliminated noise
#. Also more effecient usage of memory was achieved.