package tum0r.algorithm;

import java.lang.reflect.Array;

public class MergeSort<E extends Comparable<E>> {
	private Class<E> type;
	public MergeSort(Class<E> type) {
		this.type = type;
	}
	public E[] sort(E[] array,boolean positiveSequence) {
		if(array.length==1) {
			return array;
		}
		int length = array.length;
		E[] result = (E[]) Array.newInstance(type, length);
		int split1 = length/2;
		int split2 = length-split1;
		E[] arr1 = (E[]) Array.newInstance(type, split1);
		E[] arr2 = (E[]) Array.newInstance(type, split2);
		for(int count = 0;count<split1;count++) {
			arr1[count] = array[count];
		}
		for(int count = split1;count<length;count++) {
			arr2[count-split1] = array[count];
		}
		arr1 = sort(arr1, positiveSequence);
		arr2 = sort(arr2, positiveSequence);
		int size = split1>split2?split2:split1;
		int now1 = 0;
		int now2 = 0;
		if(positiveSequence) {
			for(int count=0;count<length;count++) {
				if(now1<split1&&now2<split2) {
					if(arr1[now1].compareTo(arr2[now2])<0) {
						result[count]=arr1[now1];
						now1++;
					}else {
						result[count]=arr2[now2];
						now2++;
					}
				}else if (now1<split1&&now2>=split2) {
					result[count] = arr1[now1];
					now1++;
				}else if (now1>=split1&&now2<split2) {
					result[count] = arr2[now2];
					now2++;
				}
			}
		}else {
			for(int count=0;count<length;count++) {
				if(now1<split1&&now2<split2) {
					if(arr1[now1].compareTo(arr2[now2])>0) {
						result[count]=arr1[now1];
						now1++;
					}else {
						result[count]=arr2[now2];
						now2++;
					}
				}else if (now1<split1&&now2>=split2) {
					result[count] = arr1[now1];
					now1++;
				}else if (now1>=split1&&now2<split2) {
					result[count] = arr2[now2];
					now2++;
				}
			}
			
		}
		return result;
	}
}
