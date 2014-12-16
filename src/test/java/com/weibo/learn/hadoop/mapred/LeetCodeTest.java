

package com.weibo.learn.hadoop.mapred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * LeetCodeTest.java V1.1
 * @Author:June
 * @Date: 2014年8月24日 下午11:21:29
 * @Description:TODO
 */
public class LeetCodeTest {
	
	@Test
	public void run() {
		Long hell = null;
		String notNull = Long.toString(hell);
		System.out.println(notNull);
		
		
		List<String> strList = null;
		for (String string : strList) {
			
		}
		
//		return;
		
		int[] A = {1,5,6,7};
		int[] B = {2,3,4,8,9,10};
		//System.out.println("the median is: " + findMedianSortedArrays(A, B));
		
		String s = "abcabcbb";
		//System.out.println("the longest substring of <" + s + "> is " + lengthOfLongestSubstring(s));
		
		BlockingQueue<Map<String, String>> intQueue = new LinkedBlockingDeque<Map<String, String>>(10000);
		
		
		
		Map<String, String> map = new HashMap<String, String>(200);
		map.put("key1", "1234");
		map.put("key2", "5678");
		try {
			intQueue.put(map);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		//map.clear();
		try {
			for(Entry entry: intQueue.take().entrySet()) {
				System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}

		Lock lock = new ReentrantLock();
		
		String strLine = "657374207465737420e4bda0e5a5bde4bda0e5a5bd20efbc81efbc812e2e6d6d<img src=></img>asdf<img src=></img>asdf";
		
		Pattern p =Pattern.compile("<img\\s[^<>]*></img>");
		Matcher matcher = p.matcher(strLine);
		while(matcher.find()) {
			System.out.println(matcher.group());
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
		}
		
		return;
		
	}
	
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") {
        	return 0;
        }
        
        int longestSubstrLen = 0;
        int idxStart = -1; //the index before substring start
        int[] locs = new int[256]; 
        Arrays.fill(locs, -1);
        
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	
        	if (locs[ch] > idxStart) {
        		idxStart = locs[ch];
        	}
        	
        	if (i - idxStart > longestSubstrLen) {
        		longestSubstrLen = i - idxStart;
        	}
        	
        	locs[ch] = i;
        }
        
        return longestSubstrLen;
        
    }
	
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int idxMedianA = A.length / 2;
        int idxMedianB = B.length / 2;
        
        if (A.length == 0) {
        	if (B.length % 2 == 0) {
        		return (B[idxMedianB-1] + B[idxMedianB])*1.0/2;
        	}
        	else {
        		return B[idxMedianB];
        	}
        }
        
        if (B.length == 0) {
        	if (A.length % 2 == 0) {
        		return (A[idxMedianA-1] + A[idxMedianA])*1.0/2;
        	}
        	else {
        		return A[idxMedianA];
        	}
        }
        
        
        int dropLen = (idxMedianA <= idxMedianB)?(idxMedianA-1):(idxMedianB-1);
        
        int len = A.length + B.length;
        if (B.length <= 3 || A.length <= 3) {
        	int idxA = 0;
        	int idxB = 0;
        	int cnt  = 0;
        	int[] AB = new int[len];
        	while(idxA != A.length && idxB != B.length && cnt != (len/2+1)) {
        		if (A[idxA] <= B[idxB]) {
        			AB[cnt++] = A[idxA++];
        		}
        		else {
        			AB[cnt++] = B[idxB++];
        		}
        	}
        	
        	if (idxA == A.length) {
        		while(idxB != B.length && cnt != (len/2+1)) {
        			AB[cnt++] = B[idxB++];
        		}
        	}
        	
        	if (idxB == B.length) {
        		while(idxA != A.length && cnt != (len/2+1)) {
        			AB[cnt++] = A[idxA++];
        		}
        	}
        	
        	
        	if (len % 2 == 0) {
        		//get len/2-1 len/2 
        		return (AB[len/2-1] + AB[len/2])*1.0/2;
        	}
        	else {
        		//get len/2
        		return AB[len/2];
        	}
        }
        
        if (A[idxMedianA] < B[idxMedianB]) {
//        	if (A.length >= B.length && B.length % 2 == 0) {
//        		dropLen--;
//        	}
        	int[] subA = Arrays.copyOfRange(A, dropLen, A.length);
        	int[] subB = Arrays.copyOfRange(B, 0, B.length - dropLen);
        	return findMedianSortedArrays(subA, subB);
        }
        else if (A[idxMedianA] > B[idxMedianB]) {
//        	if (A.length <= B.length && A.length % 2 == 0) {
//        		dropLen--;
//        	}
        	int[] subA = Arrays.copyOfRange(A, 0, A.length - dropLen);
        	int[] subB = Arrays.copyOfRange(B, dropLen, B.length);
        	return findMedianSortedArrays(subA, subB);
        }
        else {
        	if (A.length % 2 == 0 && B.length % 2 == 0) {
        		return ((A[idxMedianA-1] >= B[idxMedianB-1]?A[idxMedianA-1]:B[idxMedianB-1]) + A[idxMedianA])*1.0/2;
        	}
        	else {
        		return A[idxMedianA];
        	}
        }
    }
	
	//@Test
	public void twoSumTest() {
		int[] numbers = {3, 2, 4};
		int target = 6;
		
        int[] backup = numbers.clone();
        int arrLen = numbers.length;
        
        Arrays.sort(numbers);
        int idx1 = -1;
        int idx2 = -1;
        boolean fdFlag = false;
        for (int i = 0, j = arrLen - 1; i < j;) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
            else if (numbers[i] + numbers[j] > target) {
                j--;
            }
            else {
                idx1 = i;
                idx2 = j;
                fdFlag = true;
                break;
            }
        }
        System.out.println(idx1 + "," + idx2);
        int[] index = {0, 0};
        if (fdFlag && idx1 >= 0 && idx2 >= 0) {
            for (int i = 0,j = 0; i < arrLen; i++) {
                if (backup[i] == numbers[idx1] || backup[i] == numbers[idx2]) {
                   index[j++] = i+1; 
                }
            }
        }
        System.out.println("index1 = " + index[0] + ", index2 = " + index[1]);
        return ;
	}
}

