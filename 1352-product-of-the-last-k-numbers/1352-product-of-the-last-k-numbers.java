class ProductOfNumbers {
    public List<Integer> array;
    public ProductOfNumbers() {
        array = new ArrayList<>();
        array.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            array.clear();
            array.add(1);
            return;
        }
        array.add(array.get(array.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        int last = array.size() - 1 - k;

        if (last < 0) {
            return 0;
        }

        return array.get(array.size() - 1) / array.get(last);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */