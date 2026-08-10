class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        int noTask = 0;
        int work = Math.max(h[0], l[0]);
        for (int i = 1; i < n; i++) {
            int newNoTask = Math.max(noTask, work);
            int newWork = Math.max(
                Math.max(noTask, work) + l[i],
                noTask + h[i]
            );
            noTask = newNoTask;
            work = newWork;
        }
        return Math.max(noTask, work);
    }
}
