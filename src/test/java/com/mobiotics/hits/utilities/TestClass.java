package com.mobiotics.hits.utilities;

public class TestClass {
	
	
	  public void checKDiffBetweenTwoDate() {
		  
		  String startDate="25_04_2019";
		  String endDate="29_05_2019";
		   int[] noOFDIM= {
				   0,
				   31,
				   28,
				   31,
				   30,
				   31,
				   30,
				   31,
				   31,
				   30,
				   31,
				   30,
				   31
				   
		   };
		   String[] strtDate1=split(startDate);
		   String[] endDate1=split(endDate);
		   int d1=Integer.parseInt(strtDate1[0]);
		   int m1=Integer.parseInt(strtDate1[1]);
		   int y1=Integer.parseInt(strtDate1[2]);
		   
		   int d2=Integer.parseInt(endDate1[0]);
		   int m2=Integer.parseInt(endDate1[1]);
		   int y2=Integer.parseInt(endDate1[2]);
		   if(y1%4==0) noOFDIM[2]=29;
		   
		   int diff = m1 == m2 && y1 == y2 ? d2 - (d1 - 1) : (noOFDIM[m1] - (d1 - 1));
		   
		   
		   for (; y1 <= y2; y1++, m1 = 1) {
			   m2 = y1 == y2 ? (m2 - 1) : 12;
			   if (y1 % 4 == 0) noOFDIM[2] = 29;
			   else noOFDIM[2] = 28;
			   if (m2 == 0) {
			    m2 = 12;
			    y2 = y2 - 1;
			   }
			   for (; m1 <= m2 && y1 <= y2; m1++) diff = diff + noOFDIM[m1];
		   }
		   System.out.print("No. of days from " + startDate + " to " + endDate + " is " + diff);
	   }
	   
	   public String[] split(String date) {
		   String retVal[]= {
				   "",
				   "",
				   ""
		   };
		   date=date+"_";
		   date=date+" ";
		   
		   for(int i=0;i<=2;i++) {
			   retVal[i]=date.substring(0, date.indexOf("_"));
			   date = date.substring((date.indexOf("_")+1), date.length());
		   }
		   
		return retVal;      
	   }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestClass ob1=new TestClass();
		ob1.checKDiffBetweenTwoDate();

	}

}
