#coding:utf-8
def main():
    N = []
    X = float(input())
    for i in range(100):
        N.append(X)
        X = (X/2)
        

    for x in range(100):
        print 'N[%d] = %.4f' % (x, N[x])


if __name__ == "__main__":
    main()
