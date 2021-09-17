package com.shujujiegou;

import java.util.*;

/**
 * 初级版本冒泡排序
 */
public class Sort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化版本冒泡排序：加没有进行元素交换的标记
     */
    public static void bubbleSortFlag(int[] array) {
        boolean isSwitch = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwitch = true;
                }
            }
            if (isSwitch) {
                isSwitch = false;
            } else {
                break;
            }
        }
    }


    /**
     * 冒泡排序优化：对有序区域做标记
     */
    public static void bubbleSortIndex(int[] array) {
        int index = 0;
        int border = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < border; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    index = j;
                    isSorted = false;
                }
            }
            border = index;
            if (isSorted)
                break;
        }
    }

    /**
     * 鸡尾酒排序
     */
    public static void jiweijiu(int[] array) {
        int flag = 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            if (flag % 2 == 1) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        isSorted = false;
                    }
                }
                flag++;
            } else {
                for (int j = array.length - i - 1; j > 0; j--) {
                    if (array[j] < array[j - 1]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        isSorted = false;
                    }
                }
                flag++;
            }
            if (isSorted)
                break;
            ;
        }
    }


    public static void jiweijiu2(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
            isSorted = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }

    }

    /**
     * 双循环法实现快速排序
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return;
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 双循环法实现快速排序
     */

    public static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 单边循环快速排序
     **/
    public static void danbian(int[] array, int start, int end) {
        if (start >= end)
            return;
        int prvot = getPrvot(array, start, end);
        danbian(array, start, prvot - 1);
        danbian(array, prvot + 1, end);
    }

    public static int getPrvot(int[] array, int start, int end) {
        int prvot = array[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < prvot) {
                mark++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }
        array[start] = array[mark];
        array[mark] = prvot;
        return mark;
    }

    /**
     * 非递归实现快速排序
     */
    public static void quickSortStack(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        while (!quickSortStack.isEmpty()) {
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = getPrvot(arr, param.get("startIndex"), param.get("endIndex"));

            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
        }
    }

    public static void quickTest(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String, Integer>> quickStack = new Stack<Map<String, Integer>>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickStack.push(rootParam);
        while (!quickStack.empty()) {
            Map<String, Integer> tempParam = quickStack.pop();
            int pivot = getPrvot(arr, tempParam.get("startIndex"), tempParam.get("endIndex"));
            if (tempParam.get("startIndex") < pivot - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", tempParam.get("startIndex"));
                leftParam.put("endIndex", pivot - 1);
                quickStack.push(leftParam);
            }
            if (tempParam.get("endIndex") > pivot + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot + 1);
                rightParam.put("endIndex", tempParam.get("endIndex"));
                quickStack.push(rightParam);
            }
        }
    }


    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }

    /**
     * 计数排序
     */
    public static void jishusort(int[] array) {
        int[] tempArr = new int[11];
        for (int i = 0; i < array.length; i++) {
            tempArr[array[i]]++;
        }
        int index = 0;
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i]; j++) {
                array[index] = i;
                index++;
            }
        }
    }

    /**
     * 计数排序优化
     */

    public static void jishupaixuyouhua(int[] array) {
        //寻找最大最小值
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
            min = (array[i] < min) ? array[i] : min;
        }
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        int count = countArray[0];
        int[] countarr = new int[countArray.length];
        countarr[0] = count;
        for (int i = 1; i < countArray.length; i++) {
            countarr[i] = count + countArray[i];
            count += countArray[i];
        }
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[countarr[array[i] - min] - 1] = array[i];
            countarr[array[i] - min]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    /**
     * 桶排序
     */
    public static double[] bucketSort(double[] array) {
        double max = array[0];
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = (array[i] > max) ? array[i] : max;
            min = (array[i] < min) ? array[i] : min;
        }
        double d = max - min;
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum) / d);
            bucketList.get(num).add(array[i]);
        }
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        int[] array = new int[]{90, 99, 95, 94, 95};
        jishupaixuyouhua(array);
        System.out.println(Arrays.toString(array));
    }
}



