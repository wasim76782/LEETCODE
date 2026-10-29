class Solution {
    int n;
    int[] t;

    void update(int p, int val) {
        p += n;
        t[p] = val;
        while (p > 1) {
            p >>= 1;
            t[p] = t[2 * p] ^ t[2 * p + 1];
        }
    }

    int query(int l, int r) {
        int res = 0;
        for (l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res ^= t[l++];
            if ((r & 1) == 1) res ^= t[--r];
        }
        return res;
    }
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] par = new int[n];
        int[] depth = new int[n];
        int[] order = new int[n];
        Arrays.fill(par, -1);
        int qh = 0, qt = 0;
        order[qt++] = 0;
        while (qh < qt) {
            int node = order[qh++];
            for (int nei : adj[node]) {
                if (nei == par[node]) continue;
                par[nei] = node;
                depth[nei] = depth[node] + 1;
                order[qt++] = nei;
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            size[par[node]] += size[node];
        }


        int[] heavy = new int[n];
        Arrays.fill(heavy, -1);
        for (int node = 0; node < n; node++) {
            int largest = 0;
            for (int nei : adj[node]) {
                if (nei == par[node]) continue;
                if (size[nei] > largest) {
                    largest = size[nei];
                    heavy[node] = nei;
                }
            }
        }

        int[] head = new int[n];
        int[] pos = new int[n];
        int curr = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int h = stack.pop();
            for (int v = h; v != -1; v = heavy[v]) {
                head[v] = h;
                pos[v] = curr++;
                for (int nei : adj[v]) {
                    if (nei == par[v] || nei == heavy[v]) continue;
                    stack.push(nei); 
                }
            }
        }

        t = new int[2 * n];
        for (int node = 0; node < n; node++) {
            t[n + pos[node]] = 1 << (s.charAt(node) - 'a');
        }
        for (int i = n - 1; i >= 1; i--) {
            t[i] = t[2 * i] ^ t[2 * i + 1];
        }

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                update(pos[node], 1 << (c - 'a'));
            } else {
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);
                int xor = 0;
                while (head[a] != head[b]) {
                    if (depth[head[a]] < depth[head[b]]) {
                        int tmp = a; a = b; b = tmp;
                    }
                    xor ^= query(pos[head[a]], pos[a]);
                    a = par[head[a]];
                }
                if (depth[a] > depth[b]) {
                    int tmp = a; a = b; b = tmp;
                }
                xor ^= query(pos[a], pos[b]);
                res.add((xor & (xor - 1)) == 0);
            }
        }
        return res;
    }
}