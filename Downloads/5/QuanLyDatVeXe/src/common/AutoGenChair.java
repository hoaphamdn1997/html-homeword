package common;

import java.util.ArrayList;

import model.bean.Ghe;

public class AutoGenChair {
	
	public  ArrayList<ArrayList<Ghe>> genChair(int typeOfBus)
	{
		if(typeOfBus==1)
			return genChairFor2Floor();
		else if(typeOfBus==2) return genChairFor45Chairs();
		return null;
	}
	public ArrayList<ArrayList<Ghe>> genChairFor2Floor()
	{
		ArrayList<ArrayList<Ghe>> listGheMatrix = new ArrayList<ArrayList<Ghe>>();
		ArrayList<Ghe> listGhe = new ArrayList<Ghe>();
		int c=65;
			for(int i=1;i<=5;i++)
			{
				listGhe = new ArrayList<Ghe>();
				for(int j=1;j<=7;j++)
				{
					if(j==7&&i%2==0)
					{
						listGhe.add(new Ghe(i,j,1,1,(char)(c+2)+""+j+"D"));
					}
					else {
						int enanle=1;
						if(i%2==0&&j!=7) enanle=-1;
						listGhe.add(new Ghe(i,j,enanle,1,(char)(c)+""+j+"D"));
					}
					
				}
				if(i%2!=0) c++;
				listGheMatrix.add(listGhe);
			}
			c=65;
			for(int i=6;i<=10;i++)
			{
				listGhe = new ArrayList<Ghe>();
				for(int j=1;j<=7;j++)
				{
					if(j==7&&i%2!=0)
					{
						listGhe.add(new Ghe(i,j,1,2,(char)(c+2)+""+j+"T"));
					}
					else {
						int enanle=1;
						if(i%2!=0&&j!=7) enanle=-1;
						listGhe.add(new Ghe(i,j,enanle,2,(char)(c)+""+j+"T"));
					}
				}
				if(i%2==0) c++;
				listGheMatrix.add(listGhe);
			}
		return listGheMatrix;
	}
	
	public ArrayList<ArrayList<Ghe>> genChairFor45Chairs()
	{
		System.out.println("gen matrix");
		ArrayList<ArrayList<Ghe>> listGheMatrix = new ArrayList<ArrayList<Ghe>>();
		ArrayList<Ghe> listGhe = new ArrayList<Ghe>();
		int c = 64;
		for(int i=1;i<=5;i++)
		{
			int active = (i==3)?-1:1;
			listGhe = new ArrayList<Ghe>();
			listGhe.add(new Ghe(i,1,active,1,""+(char)(c+i)+"1"));
			listGhe.add(new Ghe(i,2,active,1,""+(char)(c+i)+"2"));
			listGhe.add(new Ghe(i,3,active,1,""+(char)(c+i)+"3"));
			listGhe.add(new Ghe(i,4,active,1,""+(char)(c+i)+"4"));
			listGhe.add(new Ghe(i,5,active,1,""+(char)(c+i)+"5"));
			listGhe.add(new Ghe(i,6,active,1,""+(char)(c+i)+"6"));
			listGhe.add(new Ghe(i,7,active,1,""+(char)(c+i)+"7"));
			listGhe.add(new Ghe(i,8,active,1,""+(char)(c+i)+"8"));
			listGhe.add(new Ghe(i,9,active,1,""+(char)(c+i)+"9"));
			listGhe.add(new Ghe(i,10,active,1,""+(char)(c+i)+"10"));
			listGhe.add(new Ghe(i,11,active,1,""+(char)(c+i)+"11"));
			listGhe.add(new Ghe(i,12,active,1,""+(char)(c+i)+"12"));
			
			listGheMatrix.add(listGhe);
		}
		
		return listGheMatrix;
	}
}
