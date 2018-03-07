package com.hackerrank.worldcodesprint12;

import java.io.*;
import java.util.*;

public class MaxTransform2 {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while(c <= ' ') c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if(bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if(bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            if(din == null) return;
            din.close();
        }
    }
    public static long MOD(long a){
        if( a < 0 ){
            if( a < -MOD ){
                a+=(-a/MOD)*MOD;
                return ( a<0 ? a+MOD : a );
            }else{
                return a+MOD;
            }
        }else if( a >= MOD ){
            return a%MOD;
        }
        return a;
    }
    public static long inverse( long a ){
        long t = 0;
        long r = MOD;
        long newt = 1;
        long newr = a;
        long quotient;
        while( newr != 0 ){
            quotient = r / newr;

            t -= quotient * newt;
            r -= quotient * newr;

            if( r != 0 ){
                quotient = newr / r;
                newt -= quotient * t;
                newr -= quotient * r;
            }else{
                r = newr;
                t = newt;
                break;
            }
        }
        if( r > 1L ) return -1L;
        if( t < 0L ) t += MOD;
        return t;
    }

    public static int greedymax(int[] arr,int i,int j){
        int max = Integer.MIN_VALUE;
        for( int x = i; x <= j; x++ ){
            if( arr[x] > max ) max = arr[x];
        }
        return max;
    }
    public static int[] greedytransform( int[]arr ){
        int []SA = new int[arr.length*(arr.length+1)/2];
        int sai = 0;
        int j;
        for( int k = 0; k < arr.length; k++ ){
            for( int i = 0; i < arr.length-k; i++ ){
                j = i+k;
                SA[sai++] = greedymax(arr,i,j);
            }
        }
        return SA;
    }
    
    static int N,Nm1;
    static int MAX;
    static int A[];
    static int L[];
    static int R[];
    static int V[];
    static int MAXI[];
    static long SUMN[];
    static long NEGSUMN[];
    static int maxanchorzero[];
    static int maxanchorN[];
    public static long solvetriangle2(int l, int r,int height,long numcells){
        if( height < 1 ) return 0;
        if( A[maxanchorzero[r]] == MAX || A[maxanchorN[l]] == MAX ){
            //all
            return ((long)numcells*(long)MAX)%MOD;
        }
        
        return solvetriangle3(l,r,height);
    }
    public static long solvetriangle3(int l, int r,int height){
        if(Debug)System.out.println( "l:"+l+" r:"+r+" N:"+N+" MAX:"+MAX+" height:"+height );
        if( height < 1 ) return 0;
        
        int bottom = l-height+1;
        int maxa = A[maxanchorzero[r]];
        int maxib = maxanchorN[bottom];
        int theight;
        long res = 0;
        
        //vertical
        theight = height;
        do{
            if( maxa >= A[maxib] ){
                //add all
                if(Debug)System.out.println("vaddall maxa:"+maxa+" *height:"+theight+" *r:"+r+" = "+((((long)maxa*(long)theight)%MOD)*(long)r));
                res += (((long)maxa*(long)theight)%MOD)*(long)r;
                if( res >= MOD )res%=MOD;
                break;
            }else{
                if( maxib >= l ){
                    //all will pass
                    res += (((long)A[maxib]*(long)theight)%MOD)*(long)r;
                    if(Debug)System.out.println("vallpass maxa:"+A[maxib]+" *height:"+theight+" *r:"+r+" = "+((((long)A[maxib]*(long)theight)%MOD)*(long)r));
                    if( res >= MOD )res%=MOD;
                    break;
                }else{
                    //only up to maxib will pass
                    res += (((long)A[maxib]*(long)(maxib-bottom+1))%MOD)*(long)r;
                    if(Debug)System.out.println("vupto bottom:"+bottom+" maxib:"+maxib+" max:"+A[maxib]+" *height:"+(maxib-bottom+1)+" *r:"+r+" = "+((((long)A[maxib]*(long)(maxib-bottom+1))%MOD)*(long)r));
                    if( res >= MOD )res%=MOD;
                    bottom = maxib+1;
                    theight = l-bottom+1;
                    maxib = maxanchorN[bottom];
                }
            }
        }while(true);
        
        //diagonal
        bottom = r+height-1;
        maxa = maxanchorzero[bottom];
        maxib = A[maxanchorN[l]];
        theight = height;
        do{
            if( maxib > A[maxa] ){
                //add all
                res += (((long)maxib*(long)theight)%MOD)*(long)r;
                if(Debug)System.out.println("Daddall maxa:"+maxib+" *height:"+theight+" *r:"+r+" = "+((((long)maxib*(long)theight)%MOD)*(long)r));
                if( res >= MOD )res%=MOD;
                break;
            }else{
                if( maxa <= r ){
                    //all will pass
                    res += (((long)A[maxa]*(long)theight)%MOD)*(long)r;
                    if(Debug)System.out.println("Dallpass maxa:"+A[maxa]+" *height:"+theight+" *r:"+r+" = "+((((long)A[maxa]*(long)theight)%MOD)*(long)r));
                    if( res >= MOD )res%=MOD;
                    break;
                }else{
                    //only up to maxa will pass
                    res += (((long)A[maxa]*(long)(bottom-maxa+1))%MOD)*(long)r;
                    if(Debug)System.out.println("Dupto maxi:"+maxa+" max:"+A[maxa]+" *height:"+(bottom-maxa+1)+" *r:"+r+" = "+((((long)A[maxa]*(long)(bottom-maxa+1))%MOD)*(long)r));
                    if( res >= MOD )res%=MOD;
                    bottom = maxa-1;
                    theight = bottom-r+1;
                    maxa = maxanchorzero[bottom];
                }
            }
        }while(true);
        
        //fix double
        if(Debug)System.out.println("minus double max("+A[maxanchorN[l]]+","+A[maxanchorzero[r]]+") *r:"+r+" = "+(-(((long)Math.max(A[maxanchorN[l]],A[maxanchorzero[r]])*(long)r)%MOD)));
        res += MOD( -(((long)Math.max(A[maxanchorN[l]],A[maxanchorzero[r]])*(long)r)%MOD) );
        if( res >= MOD ) res%=MOD;
        return (res+solvetriangle3(l-1,r+1,height-2))%MOD;
    }
    public static long solvetriangle(int l,int r){
        //if the triangle is too small just do it?
        if(Debug)System.out.println("solvetriangle l:"+l+" r:"+r);
        if( r - l < 2 ){
            if( r == l ){
                if(Debug)System.out.println("single cell("+l+"): ="+A[l]);
                return A[l];
            }
            /*if( r - l == 1 )*/
            if( A[l]>A[r] ){
                if(Debug)System.out.println("single tri["+l+","+r+"]: ="+(A[l]*3+A[r]));
                return A[l]*3+A[r];
            }else{
                if(Debug)System.out.println("single tri["+l+","+r+"]: ="+(A[l]+A[r]*3));
                return A[l]+A[r]*3;
            }
        }
        
        //find the local max and its position
        int maxi = querymax(0,l,r+1);
        long v = A[maxi];
        if(Debug)System.out.println("querymax ["+l+","+r+"]: A["+maxi+"]->"+v);
        
        //split triangle by max
        long res = 0;
        if( maxi > l ){
            //first triangle
            long tri = solvetriangle(l,maxi-1);
            res += tri;
            if(Debug)System.out.println("firsttri:"+tri);
        }
        if( res >= MOD ) res%=MOD;
        if( maxi < r ){
            //secontriangle
            long tri = solvetriangle(maxi+1,r);
            res += tri;
            if(Debug)System.out.println("secondtri:"+tri);
        }
        if( res >= MOD ) res %=MOD;
        //now add maxi triangle
        //height = r-l+1-(maxi-l)
        //width = maxi-l+1
        int height,width;
        height = r-maxi+1;
        width = maxi-l+1;
        if(Debug)System.out.println("width:"+width+" height:"+height);
        if( width < height ){
            for( int i = 0; i < width; i++ ){
                if(Debug)System.out.println("SUM"+(height+i)+"="+SUMN[height+i]+" + SUM"+(i)+"="+(NEGSUMN[i]-MOD) );
                res += ( ((SUMN[height+i] + NEGSUMN[i])%MOD)*v );
                if( res >= MOD ) res %=MOD;
            }
        }else{
            for( int i = 0; i < height; i++ ){
                if(Debug)System.out.println("SUM"+(width+i)+"="+SUMN[width+i]+" + SUM"+(i)+"="+(NEGSUMN[i]-MOD) );
                res += ( ((SUMN[width+i] + NEGSUMN[i])%MOD)*v );
                if( res >= MOD ) res %=MOD;
            }
        }
        
        if(Debug)System.out.println("*"+v+" ="+res);
        if(Debug)System.out.println("end querymax ["+l+","+r+"]: A["+maxi+"]->"+v);
        
        return res;
    }
    static public int querymax(int node,int l,int r){
        if( l >= N ) return -1;
        if( l == L[node] && r == R[node] ) return MAXI[node];
        int child = node*2+1;
        /*if( child > 500000 ){
            System.out.println(" node:"+node+" l:"+l+" r:"+r+" child:"+child);
        }*/
        if( child >= 500000 ) return -1;
        if( l < R[child] ){
            if( r >= L[child+1] ){
                int ia = querymax(child,l,R[child]);
                int ib = querymax(child+1,L[child+1],r);
                if( ia == -1 ) return -1;
                if( ib == -1 ) return ia;
                if( A[ia] > A[ib] ){
                    return ia;
                }else{
                    return ib;
                }
                
            }else{
                return querymax(child,l,r);
            }
        }else{
            return querymax(child+1,l,r);
        }
    }
    static public void buildtree(int node, int l, int r){
        //if(node>461500)System.out.println(node+". ["+l+","+r+">");
        if( l >= N ){
            L[node] = l;
            R[node] = r;
            V[node] = Integer.MIN_VALUE;
            MAXI[node] = -1;
            return;
        }
        L[node] = l;
        R[node] = r;
        if( r-l == 1 ){
            V[node] = A[l];
            MAXI[node] = l;
            return;
        }
        int a = node*2+1;
        buildtree( a, l, (l+r)/2 );
        buildtree( a+1, (l+r)/2, r );
        if( V[a] > V[a+1] ){
            V[node] = V[a];
            MAXI[node] = MAXI[a];
        }else{
            V[node] = V[a+1];
            MAXI[node] = MAXI[a+1];
        }
    }
    static long MOD = 1000000007L;
    static long MODLIMIT = Long.MAX_VALUE/(MOD*10L);
    public static void main(String[] args) throws IOException {
//        long start = System.nanoTime();    
        Reader in=new Reader();
        N = in.nextInt();
        //if(Debug)N=10;
        int N1 = N+1;
        Nm1 = N-1;
        A = new int[N];
        //if(!Debug){
            for(int i = 0; i < N; i++){
                A[i] = in.nextInt();
            }
        /*}else{
            for(int i = 0; i < N; i++){
                A[i] = (int)(Math.random()*1000000.0D);
                System.out.print(A[i]+" ");
            }
            System.out.println();
        }*/


        SUMN = new long[N];
        NEGSUMN = new long[N];
        for( int i = 0; i < N; i++ ){
            SUMN[i] = (((long)(i+1)*(long)i)/2L)%MOD;
            NEGSUMN[i] = MOD(-SUMN[i]);
        }
        
        if( N < 10 ){
            A = greedytransform(greedytransform(A));
            long sum = 0;
            for( int a : A ){
                sum += (long)a;
                if( sum >= MOD ) sum %= MOD;
            }
            System.out.println(sum);
            in.close();
            return;
        }
        
/*

        max[00,11,22,33,44,55,66,77,88,99],[01,12,23,34,45,56,67,78,89],[02,13,24,35,46,57,68,79],[03,14,25,36,47,58,69],[04,15,26,37,48,59],[05,16,27,38,49],[06,17,28,39],[07,18,29],[08,19],[09] 1/15
1,1,1,1 max[01,12,23,34,45,56,67,77,88]91, [02,13,24,35,46,57,68,79]82, [03,14,25,36,47,58,69]73, [04,15,26,37,48,59]64, [05,16,27,38,49]55, [06,17,28,39]46, [07,18,29]37, [08,19]28, [09]
2,2,2   max[02,13,24,35,46,57,68,79]81,92, [03,14,25,36,47,58,69]72,83, [04,15,26,37,48,59]63,74, [05,16,27,38,49]	 [06,17,28,39]45,56, [07,18,29]36,47, [08,19]27,38, [09]
3,3,3   max[03,14,25,36,47,58,69]71,82,93, [04,15,26,37,48,59]62,73,84, [05,16,27,38,49]53,64,75, [06,17,28,39]	     	 [07,18,29]35,46,57, [08,19]26,37,48, [09]
4,4     max[04,15,26,37,48,59]61,72,83,94, [05,16,27,38,49]52,63,74,85, [06,17,28,39]	  	  [07,18,29]	       	 [08,19]25,36,47,58, [09]
5,5     max[05,16,27,38,49]51,62,73,84,95, [06,17,28,39]42,53,64,75,86, [07,18,29]		  [08,19]		 [09]
6       max[06,17,28,39]41,52,63,74,85,96, [07,18,29] 		       ,[08,19]			  [09]
7       max[07,18,29]31,42,53,64,75,86,97, [08,19]		       ,[09]
        max[08,19]    		           [09]
        max[09]


91
81    92
71    82x2  93
61    72x2  83x2  94
51    62x2  73x3  84x2  95
41    52x2  63x3  74x3  85x2  96
31    42x2  53x3  64x4  75x3  86x2  97
    max[00,11,22,33,44,55,66,77,88,99]	x1
1,1 max[01,12,23,34,45,56,67,78,89]	x2
2,2 max[02,13,24,35,46,57,68,79]	x3
3,3 max[03,14,25,36,47,58,69]		x4
4,4 max[04,15,26,37,48,59]		x5
5,5 max[05,16,27,38,49]			x6
6,6 max[06,17,28,39]			x7
7,7 max[07,18,29]			x8
    max[08,19]				x9
    max[09]
    */
        
        long lenSA = (((long)(N+1L)*(long)N)/2L)%MOD;
        long lenSSA = (((((lenSA+1L)%MOD)*lenSA)%MOD)*inverse(2))%MOD;
        
        L = new int[500000];
        R = new int[500000];
        V = new int[500000];
        MAXI = new int[500000];
        Arrays.fill(L,0,L.length,-1);
        Arrays.fill(R,0,R.length,-1);
        {
            int e = 1;
            while( e < N ) e<<=1;
            //if(Debug)System.out.println("N^2:"+e);
            buildtree(0,0,e);
        }
        
        
        long res = 0;
        maxanchorzero = new int[N];
        {
            int max = Integer.MIN_VALUE;
            int maxi = -1;
            for( int i = 0; i < N; i++ ){
                if( A[i] > max ){
                    max = A[i];
                    maxi = i;
                    if(Debug)System.out.println("[-new max:"+max+" @"+maxi);
                }
                maxanchorzero[i] = maxi;
                res += (long)max*(long)(i+1);
                if( res >= MOD ) res%=MOD;
            }
        }
        MAX = A[ maxanchorzero[N-1] ];
        maxanchorN = new int[N];
        {
            int max = Integer.MIN_VALUE;
            int maxi = -1;
            for( int i = N-1; i != -1; i-- ){
                if( A[i] > max ){
                    max = A[i];
                    maxi = i;
                    if(Debug)System.out.println("new max-]:"+max+" @"+maxi);
                }
                maxanchorN[i] = maxi;
                res += (long)max*(long)(N-i);
                if( res >= MOD ) res%=MOD;
            }
        }
        res += MOD( -( ((long)MAX*(long)N)%MOD ) );
        if( res >= MOD ) res%=MOD;
        
        /*BitSet peak = new BitSet(N);
        for( int i = 0; i < N; i++ ){
            if( A[i] == MAX ) peak.set(i);
        }*/
        /*
        int V[] = new int[N];
        int vi = 0;
        LinkedList<Integer> VALUES[] = new LinkedList<Integer>[1000001][];
        {
            System.arraycopy(A,0,V,0,N);
            Arrays.sort(V);
            int cur = -1;
            for( int i = N-1; i != -1; i-- ){
                if( V[i] != cur ){
                    V[vi++] = cur = V[i];
                }
            }
            
            for( int i = 0; i < vi; i++ ){
                VALUES[V[i]] = new LinkedList<Integer>();
            }
            for( int i = 1; i < Nm1; i++ ){
                VALUES[A[i]].add(i);
            }
        }*/
        
        
        int l = 1;
        int r = N-2;
        long res1 = solvetriangle(l,r);
        res += res1;
        if( res >= MOD ) res%=MOD;
        if(Debug)System.out.println( "tri1:"+res1 );
        if(Debug)System.out.println( "tottri1:"+res );
        
        if(Debug)System.out.println( "extras:"+lenSSA+" -> +"+((lenSSA*(long)MAX)%MOD) );
        res += (lenSSA*(long)MAX)%MOD;
        if( res >= MOD ) res%=MOD;
        
        
        long nonextracells = 0;
        int mult = 1;
        for( int i = A.length; i != 0; i-- ){
            nonextracells += ( (long)(i+1)*(long)i ) /2L;
            if( nonextracells >= MOD ) nonextracells%=MOD;
            mult++;
        }
        if(Debug)System.out.println("cells tri1: "+nonextracells);
        
        l = N-1;
        r = 1;
        int height = l-r-1;
        /*while( r+1 < l ){
            height++;
            l--;
            r++;
        }
        //81,72,63,54/*/
        
        long numcellstri2 = 0;
        int t = height;
        mult = 1;
        if(Debug)System.out.println("tri2 height: "+height);
        while( t > 0 ){
            numcellstri2 += (long)(t*2-1)*(long)mult;
            if( numcellstri2 >= MOD ) numcellstri2%=MOD;
            t-=2;
            mult++;
        }
        if(Debug)System.out.println("cells tri2: "+numcellstri2);
        long res2= solvetriangle2(N-1,1,height,numcellstri2);
        res += res2;
        if( res >= MOD ) res%=MOD;
        if(Debug)System.out.println( "tri2:"+res2 );
        
        if(Debug)System.out.println("minus over extras:"+ ((((nonextracells+numcellstri2)%MOD)*(long)MAX)%MOD)  );
        res += MOD( -((((nonextracells+numcellstri2)%MOD)*(long)MAX)%MOD)  );
        if( res >= MOD ) res%=MOD;

        
        System.out.println(res);
        in.close();
    }
    static final boolean Debug = false;
}