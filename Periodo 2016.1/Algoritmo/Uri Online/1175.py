#coding:utf-8
def main():
    N = []
    Y = []
    
    for i in range(20):
        N.append(input())
        
    for i in range(19,-1,-1):
        Y.append(N[i])      

    for i in range(20):
        print 'N[%d] = %d' % (i, Y[i])
          
if __name__ == "__main__":
    main()
