
class Heap {
    ArrayList<Heapable> arr;
    Integer len;
    boolean isMaxHeap = true;
    
    public  void setIsMaxHeap(boolean isMaxHeap){
        this.isMaxHeap = isMaxHeap;
        heapify();
    }
    public void print(){
        StringBuilder sbr = new StringBuilder();
        for(int i=0;i<len;i++){
            sbr.append(arr.get(i)).append(", ");
        }
        System.out.println(sbr.toString());
    }
    public void heapify(){
        for (int i=len/2;i>=1;i--){
            if(isMaxHeap){
                maxHeapify(i);
            }else{
                minHeapify(i);
            }
        }
    }
    public boolean isEmpty(){
        return len==0;
    }
    
    
    public void minHeapify(int i){
        if (i>len||i<1){
            return;
        }
        int smallest = i;
        int l = i<<1;
        int r= (i<<1)+1;
        if (l<=len && arr.get(smallest-1).value()>arr.get(l-1).value()){
            smallest = l;
        }
        if (r<=len && arr.get(smallest-1).value()>arr.get(r-1).value()){
            smallest =r;
        }
        if (smallest!=i){
            Heapable temp= arr.get(smallest-1);
            arr.set(smallest-1,arr.get(i-1));
            arr.set(i-1,temp);
            minHeapify(smallest);
        }
    }
    
    public void maxHeapify(int i){
        if (i>len||i<1){
            return;
        }
        int largest = i;
        int l = i<<1;
        int r= (i<<1)+1;
        if (l<=len && arr.get(largest-1).value()<arr.get(l-1).value()){
            largest = l;
        }
        if (r<=len && arr.get(largest-1).value()<arr.get(r-1).value()){
            largest =r;
        }
        if (largest!=i){
            Heapable temp= arr.get(largest-1);
            arr.set(largest-1,arr.get(i-1));
            arr.set(i-1,temp);
            maxHeapify(largest);
        }
    }
    public Heapable firstInHeap() {
        
            Heapable temp= arr.get(0);
            arr.set(0, arr.get(len-1));
            len--;
            if(isMaxHeap){
            maxHeapify(1);
            }else{
                minHeapify(1);
            }
            return temp;
    }
    public void revHeapify(int index){
        
        if(index==1){
            return;
        }
        int parent = (index>>1);
        if(arr.get(parent-1).value()>arr.get(index-1).value()){
            Heapable temp= arr.get(parent-1);
            arr.set(parent-1,arr.get(index-1));
            arr.set(index-1,temp);
            revHeapify(parent);
        }
    }
    
    public void add(Heapable h){
        arr.set(len, h);
        int index = len;
        len++;
        revHeapify(len);
    }
    
    public Heap (ArrayList list){
        arr = new ArrayList(list);
        len = arr.size();
        init();
    }
    public void init(){
        
        heapify();
    }
}
 
interface Heapable {
    public Integer value();
}

class HeapElement<E> implements Heapable{
    E value;
    public HeapElement(E value){
        this.value = value;
    }
    @Override
    public Integer value(){
        return value.hashCode();
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
}
