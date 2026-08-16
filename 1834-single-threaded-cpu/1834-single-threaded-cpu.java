class Solution {
    public int[] getOrder(int[][] tasks) {
       
        int n = tasks.length;

        // Wasim Raja 2420499
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        //  Wasim Raja 2420499
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);
            }
        );
        // Wasim Raja 2420499

        int[] answer = new int[n];

        long time = 0;
        int i = 0;
        int index = 0;
        // Wasim Raja 2420499
        while (i < n || !pq.isEmpty()) {

            // If no task is available, jump to next task
            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            // Wasim Raja 2420499
            while (i < n && arr[i][0] <= time) {
                pq.offer(new int[]{arr[i][1], arr[i][2]});
                i++;
            }

            //  Wasim Raja 2420499
            int[] current = pq.poll();

            int processingTime = current[0];
            int originalIndex = current[1];

            answer[index++] = originalIndex;

            //  Wasim Raja 2420499
            time += processingTime;
        }

        return answer;
    }
}
       // Wasim Raja 2420499
    