import java.util.*;

class Solution {
    
    class Missile {
        int id;
        int start;
        int end;
        
        public Missile(int id, int[] target) {
            this.id = id;
            this.start = target[0];
            this.end = target[1];
        }
    }
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        int n = targets.length;
        Missile[] ms = new Missile[n];
        
        for(int i = 0 ; i < n ; i++) {
            ms[i] = new Missile(i, targets[i]);
        }
        
        Arrays.sort(ms, new Comparator<Missile>() {
        
            @Override
            public int compare(Missile o1, Missile o2) {
                
                if(o1.end == o2.end)
                    return o1.start - o2.start;
                
                return o1.end - o2.end;
            }
        });  
        
        int e = ms[0].end;
        
        for(int i = 0 ; i < n ; i++) {
            if(e <= ms[i].start) {
                e = ms[i].end;
                answer++;
            }
        }
        
        return answer + 1;
    }
}