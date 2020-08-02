/*
 * @lc app=leetcode id=1244 lang=java
 *
 * [1244] Design A Leaderboard
 */

// @lc code=start
class Leaderboard {
    Map<Integer, Integer> player;
    public Leaderboard() {
        player = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        player.put(playerId, player.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<Integer, Integer> entry : player.entrySet()) {
            heap.add(entry);
        }
        
        int result = 0;
        while (K > 0 && !heap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            result += entry.getValue();
            K--;
        }
        
        return result;
    }
    
    public void reset(int playerId) {
        player.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
// @lc code=end

