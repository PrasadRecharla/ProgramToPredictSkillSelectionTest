package com.hr.skills;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JInternalFrame;

public class SkillSelctionPage_BatchInput {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputs=new String[200];
		
		int idx=0;
		int position=0;
		for(int i=0;i<20;i++){
			if(i < 10){
				for(int j=0;j<10;j++){
					if(j==idx){
						inputs[position]="Y";
					}else{
						inputs[position]="N";
					}
					position++;
				}
				idx++;
			}else{
				for(int j=0;j<10;j++){
					if(j==idx){
						inputs[position]="N";
					}else{
						inputs[position]="Y";
					}
					position++;
				}
				idx++;
			}
			if(i==10){
				idx=0;
			}
		}
		System.out.println("Input size:"+inputs.length);
		
		System.out.println("size:"+Arrays.toString(inputs));
		
		Map<Integer,String> inputMapping=new LinkedHashMap<Integer,String>();
		Map<Integer,LinkedHashMap<Integer,String>> inputBatchMapping=new LinkedHashMap<Integer, LinkedHashMap<Integer,String>>();
		
		int index=0;
		int cnt=0;
		int batchId=0;
		for(int i=0;i<inputs.length;i++){
			if(cnt==10){
				cnt=0;
				index=0;
				inputBatchMapping.put(batchId++, (LinkedHashMap<Integer, String>) inputMapping);
				//inputMapping.clear();
				inputMapping=new LinkedHashMap<Integer,String>();
			}
			inputMapping.put(++index,inputs[i]);
			cnt++;
		}
		
		System.out.println("Input Mapping:"+inputMapping);
		System.out.println("Input batch Mapping:"+inputBatchMapping);
		
		for(Entry<Integer, LinkedHashMap<Integer, String>> entryInputMapping: inputBatchMapping.entrySet()){
			Map<List<Integer>,String> inputMap=new LinkedHashMap<List<Integer>,String>();
			inputMap.put(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "95%");
			inputMap.put(Arrays.asList(2,6,7,8,9), "80%");
			inputMap.put(Arrays.asList(2,6), "60%");
			inputMap.put(Arrays.asList(2,7), "60%");
			inputMap.put(Arrays.asList(2,8), "60%");
			inputMap.put(Arrays.asList(2,8), "60%");
			inputMap.put(Arrays.asList(1,2,3,4,6), "60%");

			boolean flag=false;
			for(List<Integer> list:inputMap.keySet()){
				for(Integer key:list){
					if(!"Y".equalsIgnoreCase(entryInputMapping.getValue().get(key))){
						flag=false;
						break;
					}else{
						flag=true;
					}
				}
				if(flag){
					String result= inputMap.get(list);
					System.out.println("input:"+entryInputMapping.getValue());
					System.out.println("categorized under :"+list);
					System.out.println("YOU ARE "+result+" ELIGIBLE FOR GETTING JOB");
					break;
				}
			}
		}
		
	}
}