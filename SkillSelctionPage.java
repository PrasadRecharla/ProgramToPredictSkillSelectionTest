package com.hr.skills;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JInternalFrame;

public class SkillSelctionPage {


	public static void main(String[] args) {

		String[] inputs=new String[]{"Y","N","Y","Y","Y","Y","N","N","N","N"};

		System.out.println("size:"+Arrays.toString(inputs));

		Map<Integer,String> inputMapping=new HashMap<Integer,String>();
		int index=0;
		for(String str:inputs){
			inputMapping.put(++index,str);
		}

		System.out.println("Input Mapping:"+inputMapping);

		Map<List<Integer>,String> inputMap=new LinkedHashMap<List<Integer>,String>();
		inputMap.put(Arrays.asList(1,2,3,4,5,6,7,8,9,10), "95%");
		inputMap.put(Arrays.asList(2,6,7,8,9), "80%");
		inputMap.put(Arrays.asList(2,6), "60%");
		inputMap.put(Arrays.asList(2,7), "60%");
		inputMap.put(Arrays.asList(2,8), "60%");
		inputMap.put(Arrays.asList(1,2,3,4,6), "60%");

		System.out.println("Input Map:"+inputMap);
		boolean flag=false;
		for(List<Integer> list:inputMap.keySet()){
			for(Integer key:list){
				if(!"Y".equalsIgnoreCase(inputMapping.get(key))){
					flag=false;
					break;
				}else{
					flag=true;
				}
			}
			if(flag){
				String result= inputMap.get(list);
				System.out.println("categorized under :"+list);
				System.out.println("YOU ARE "+result+" ELIGIBLE FOR GETTING JOB");
				break;
			}
		}
		if(!flag){
			System.out.println("Conditons not matched");
		}
	}
}