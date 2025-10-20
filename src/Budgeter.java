public class Budgeter {
    public int getcheap(int[] devices){
        int cheap = devices[0];
        for(int i = 0; i < devices.length; i++){
            if(devices[i] < cheap){
                cheap = devices[i];
            }
        }
        return cheap;
    }

    public int getexpensive(int[] devices1, int[] devices2){
        int expensive = devices1[0];
        int[] devices = combinePrices(devices1,devices2);
        for(int i = 0; i < devices.length; i++){
            if(devices[i] > expensive){
                expensive = devices[i];
            }
        }
        return expensive;
    }

    private int[] combinePrices(int[] devices1, int[] devices2){
        int[] combined =  new int[devices1.length + devices2.length];
        for(int i = 0; i < devices1.length; i++){
            combined[i] = devices1[i];
        }
        for(int i = 0; i < devices2.length; i++){
            combined[i + devices1.length] = devices2[i];
        }
        return combined;
    }

    public int mostexpensiveDevice(int[] devices1,int budget){
        int selected_price = 0;
        for(int i = 0; i < devices1.length; i++){
            if(devices1[i] > selected_price && devices1[i] < budget){
                selected_price = devices1[i];
            }
        }
        return selected_price;
    }

    public int[] mostexpensiveCombo(int[] devices1, int[] devices2,int budget){
        int[] combo_keyboard_first = {0,0};
        boolean found_solution1 = false;
        int[] combo_keyboard_second = {0,0};
        boolean found_solution2 = false;
        mergeSort(devices1,0,devices1.length-1);
        mergeSort(devices2,0,devices2.length-1);
        for(int i = devices1.length-1; i >= 0; i--){
            for(int j = devices2.length-1; j >= 0; j--){
                if(devices1[i] + devices2[j] <= budget){
                    combo_keyboard_first[0] = devices1[i];
                    combo_keyboard_first[1] = devices2[j];
                    found_solution1 = true;
                    break;
                }
            }
            if(found_solution1){break;}
        }
//        for(int i = devices2.length-1; i >= 0; i--){
//            for(int j = devices1.length-1; j >= 0; j--){
//                if(devices2[i] + devices1[j] <= budget){
//                    combo_keyboard_second[0] = devices1[i];
//                    combo_keyboard_second[1] = devices2[j];
//                    found_solution2 = true;
//                    break;
//                }
//            }
//            if(found_solution2){break;}
//        }
//        int first_sum = combo_keyboard_first[0] + combo_keyboard_first[1];
//        int second_sum = combo_keyboard_second[0] + combo_keyboard_second[1];
//        if(first_sum >= second_sum){
//            return combo_keyboard_first;
//        }
//        else return combo_keyboard_second;
        return combo_keyboard_first;



    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }


}
