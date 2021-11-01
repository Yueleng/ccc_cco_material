import java.util.*;
import java.io.*;

public class CCC21S3 {
  static class AudienceInfo {
    public int p;
    public int w;
    public int d;

    AudienceInfo(int p, int w, int d) {
      this.p = p;
      this.w = w;
      this.d = d;
    }
  }

  // static class AudienceInfoComparator implements Comparator<AudienceInfo> {
  //   @Override
  //   public int compare(AudienceInfo audience1, AudienceInfo audience2) {
  //     return audience1.p - audience2.p;
  //   }
  // }

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  // static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    int audience = readInt();
    // long[] sums = new long[audience];
    Map<Integer, Long> sums = new HashMap<>();
    Set<Integer> candidatesX = new HashSet<Integer>();
    ArrayList<AudienceInfo> audiences = new ArrayList<AudienceInfo>();
    for (int i = 0; i < audience; i++) {
      int p = readInt();
      int w = readInt();
      int d = readInt();
      AudienceInfo audienceInfo = new AudienceInfo(p, w, d);
      audiences.add(audienceInfo);
      candidatesX.add(p - d);
      candidatesX.add(p + d);
    }
    // Collections.sort(audiences, new AudienceInfoComparator());

    int[] candPos = new int[candidatesX.size()];
    Iterator<Integer> it = candidatesX.iterator();
    int i = 0;
    while (it.hasNext()) {
      candPos[i] = it.next();
      i++;
    }
    Arrays.sort(candPos);

    // passed
    // for (int i = 0; i < audience; i++) {
    // System.out.println(audiences.get(i).p);
    // }

    // Binary Search
    System.out.println(binarySearch(sums, audiences, candPos, 0, candPos.length - 1));

  }

  static int timeOneAudience(int x, int p, int d, int w) {
    if (x < p - d)
      return w * (p - d - x);
    else if (x > p + d)
      return w * (x - p - d);
    else
      return 0;
  }

  static long timeAllAudience(int x, ArrayList<AudienceInfo> audiences) {
    int n = audiences.size();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += timeOneAudience(x, audiences.get(i).p, audiences.get(i).d, audiences.get(i).w);
    }
    return sum;
  }

  static long binarySearch(Map<Integer, Long> sums, ArrayList<AudienceInfo> audiences, int[] candPos, int l, int r) {
    if (r >= l) {
      int midIdx = l + (r - l) / 2;

      if (!sums.containsKey(candPos[midIdx]))
        sums.put(candPos[midIdx], timeAllAudience(candPos[midIdx], audiences));
      if (midIdx - 1 >= 0 && !sums.containsKey(candPos[midIdx - 1]))
        sums.put(candPos[midIdx - 1], timeAllAudience(candPos[midIdx - 1], audiences));
      if (midIdx + 1 <= candPos.length - 1 && !sums.containsKey(candPos[midIdx + 1]))
        sums.put(candPos[midIdx + 1], timeAllAudience(candPos[midIdx + 1], audiences));

      if (midIdx == 0)
        // return sums.get(candPos[midIdx]) <= sums.get(candPos[r]) ? sums.get(candPos[midIdx]) : sums.get(candPos[r]);
        return sums.get(candPos[midIdx]);
      if (midIdx == candPos.length - 1)
        return sums.get(candPos[midIdx]);

      // if find two adjacent point equals to each other, you find the optimal index.
      if ((midIdx - 1 >= 0 && sums.get(candPos[midIdx - 1]) == sums.get(candPos[midIdx]))
          || (midIdx + 1 <= candPos.length - 1 && sums.get(candPos[midIdx + 1]) == sums.get(candPos[midIdx])))
        return sums.get(candPos[midIdx]);

        
      if (sums.get(candPos[midIdx]) < sums.get(candPos[midIdx - 1])
          && sums.get(candPos[midIdx]) < sums.get(candPos[midIdx + 1]))
        return sums.get(candPos[midIdx]);

      if (sums.get(candPos[midIdx - 1]) < sums.get(candPos[midIdx])
          && sums.get(candPos[midIdx]) < sums.get(candPos[midIdx + 1]))
        r = midIdx;
      if (sums.get(candPos[midIdx - 1]) > sums.get(candPos[midIdx])
          && sums.get(candPos[midIdx]) > sums.get(candPos[midIdx + 1]))
        l = midIdx;
      return binarySearch(sums, audiences, candPos, l, r);
    }

    // We reach here when element is not
    // present in array
    return -1;
  }

  static String next() throws IOException {
    while (st == null || !st.hasMoreTokens())
      st = new StringTokenizer(br.readLine().trim());
    return st.nextToken();
  }

  static long readLong() throws IOException {
    return Long.parseLong(next());
  }

  static int readInt() throws IOException {
    return Integer.parseInt(next());
  }

  static double readDouble() throws IOException {
    return Double.parseDouble(next());
  }

  static String readLine() throws IOException {
    return br.readLine().trim();
  }
}
