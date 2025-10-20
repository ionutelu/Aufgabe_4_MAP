public class Budgeter {
    public int getcheap(int[] devices){
        int cheap = -1;
        for(int i = 0; i < devices.length; i++){
            if(devices[i] < cheap){
                cheap = devices[i];
            }
        }
        if(cheap != -1) {
            return cheap;
        }
        return -1;
    }
}
