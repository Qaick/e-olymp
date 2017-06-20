package my.eolymp;

public class EOlymp {
    public static void main(String[] args) {
        System.out.println("Hello Bitbucket.org!");
        erastofen();
//        spiral();
//        testMemory();
    }

    static int[] arr = new int[Integer.MAX_VALUE/20];
    //prostoe chislo, resheto erastofena
    static void erastofen(){
        int n=1000;
        int[] S = new int[n+1];
        S[1] = 0;
        for(int k=2; k<=n; k++)
            S[k]=1;

        for(int k=2; k*k<=n; k++){
            if(S[k]==1){
                for(int l=k*k; l<=n; l+=k){
                    S[l]=0;
                }
            }
        }
        int idx=0;
        for(int i=3;i<=n;i++)
            if(S[i]==1){
                System.out.println(i+" ");
                arr[idx]=i;
                idx++;
            }
    }

    static int spiral() {
        int n=6;
        if (n == 1) {
            System.out.println(1);
            return 0;
        }

        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) arr[i] = new int[n];
        int number = 1;
        //counting number of circus
        for (int j = 0; j < (n + 1) / 2; j++)
        {
            for (int i = n - j - 1; i > j; i--) {
                arr[i][j] = number++;
            }
            for (int i = j; i < n - j; i++) {
                arr[j][i] = number++;
            }
            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = number++;
            }
            for (int i = n - j - 2; i > j; i--) {
                arr[n - j - 1][i] = number++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }
        return 0;
    }

    public static void testMemory() {
        Runtime rt = Runtime.getRuntime();
        long prevTotal = 1_0;
        long prevFree = rt.freeMemory();
        System.out.println("Used Memory   :  " + humanReadableByteCount(rt.totalMemory() - rt.freeMemory(), false));
        System.out.println("Free Memory   : " + humanReadableByteCount(rt.freeMemory(), false));
        System.out.println("Total Memory  : " + humanReadableByteCount(rt.totalMemory(), false));
        System.out.println("Max Memory    : " + humanReadableByteCount(rt.maxMemory(), false));

        System.setProperty("Xmx", "10m");
        rt.gc();
        System.out.println("Used Memory   :  " + humanReadableByteCount(rt.totalMemory() - rt.freeMemory(), false));
        System.out.println(System.getProperty("Xmx") + " Max Memory    : " + humanReadableByteCount(rt.maxMemory(), false));
        for (int i = 0; i < 2_000_000; i++) {
            long total = rt.totalMemory();
            long free = rt.freeMemory();
            if (total != prevTotal || free != prevFree) {
                System.out.println(
                        String.format("#%s, Total: %s, Free: %s, Diff: %s",
                                i,
                                total,
                                free,
                                prevFree - free));
                prevTotal = total;
                prevFree = free;
            }
        }
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

}
